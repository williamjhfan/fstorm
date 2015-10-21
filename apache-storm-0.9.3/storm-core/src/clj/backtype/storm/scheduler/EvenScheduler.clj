;; Licensed to the Apache Software Foundation (ASF) under one
;; or more contributor license agreements.  See the NOTICE file
;; distributed with this work for additional information
;; regarding copyright ownership.  The ASF licenses this file
;; to you under the Apache License, Version 2.0 (the
;; "License"); you may not use this file except in compliance
;; with the License.  You may obtain a copy of the License at
;;
;; http://www.apache.org/licenses/LICENSE-2.0
;;
;; Unless required by applicable law or agreed to in writing, software
;; distributed under the License is distributed on an "AS IS" BASIS,
;; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
;; See the License for the specific language governing permissions and
;; limitations under the License.
(ns backtype.storm.scheduler.EvenScheduler
  (:use [backtype.storm util log config])
  (:require [clojure.set :as set])
  (:import [backtype.storm.generated Nimbus Nimbus$Processor Nimbus$Iface Nimbus$Client])
  (:import [backtype.storm.scheduler IScheduler Topologies
            Cluster TopologyDetails WorkerSlot ExecutorDetails])
  (:use compojure.core)
  (:use ring.middleware.reload)
  (:use [hiccup core page-helpers])
  (:use [backtype.storm config util log])
  (:use [backtype.storm.ui helpers])
  (:use [backtype.storm.daemon [common :only [ACKER-COMPONENT-ID ACKER-INIT-STREAM-ID
                                              ACKER-ACK-STREAM-ID ACKER-FAIL-STREAM-ID system-id?]]])
  (:use [ring.adapter.jetty :only [run-jetty]])
  (:use [clojure.string :only [trim]])
  (:import [backtype.storm.utils Utils])
  (:import [backtype.storm.generated ExecutorSpecificStats
            ExecutorStats ExecutorSummary TopologyInfo SpoutStats BoltStats
            ErrorInfo ClusterSummary SupervisorSummary TopologySummary
            Nimbus$Client StormTopology GlobalStreamId RebalanceOptions
            KillOptions])
  (:import [java.io File])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.util.response :as resp]
            [backtype.storm [thrift :as thrift]])
  (:import [org.apache.commons.lang StringEscapeUtils])
  (:gen-class
    :implements [backtype.storm.scheduler.IScheduler]))

(def ^:dynamic *STORM-CONF* (read-storm-config))

(defmacro with-nimbus
  [nimbus-sym & body]
  `(thrift/with-nimbus-connection
     [~nimbus-sym (*STORM-CONF* NIMBUS-HOST) (*STORM-CONF* NIMBUS-THRIFT-PORT)]
     ~@body))

(defn get_topologyinfo [tid]
  (with-nimbus nimbus
    (.getTopologyInfo ^Nimbus$Client nimbus tid)))

(defn sort-slots [all-slots]
  (let [split-up (sort-by count > (vals (group-by first all-slots)))]
;;    (apply interleave-all split-up)
	  (apply concat split-up)
    ))

(defn get-alive-assigned-node+port->executors [cluster topology-id]
  (let [existing-assignment (.getAssignmentById cluster topology-id)
        executor->slot (if existing-assignment
                         (.getExecutorToSlot existing-assignment)
                         {}) 
        executor->node+port (into {} (for [[^ExecutorDetails executor ^WorkerSlot slot] executor->slot
                                           :let [executor [(.getStartTask executor) (.getEndTask executor)]
                                                 node+port [(.getNodeId slot) (.getPort slot)]]]
                                       {executor node+port}))
        alive-assigned (reverse-map executor->node+port)]
    alive-assigned))

(defn- schedule-topology [^TopologyDetails topology ^Cluster cluster]
  (let [topology-id (.getId topology)
  		;topologyinfo (if (nil? nimbus) (.getTopologyInfo nimbus topology-id) nil)
        available-slots (->> (.getAvailableSlots cluster)
                             (map #(vector (.getNodeId %) (.getPort %))))
        all-executors (->> topology
                          .getExecutors
                          (map #(vector (.getStartTask %) (.getEndTask %)))
                          set)
        alive-assigned (get-alive-assigned-node+port->executors cluster topology-id)
        total-slots-to-use (min (.getNumWorkers topology)
                                (+ (count available-slots) (count alive-assigned)))
        reassign-slots (take (- total-slots-to-use (count alive-assigned))
                             (sort-slots available-slots))
        reassign-executors (sort (set/difference all-executors (set (apply concat (vals alive-assigned)))))

        reassignment (into {}
                           (map vector
                                reassign-executors
                                ;; for some reason it goes into infinite loop without limiting the repeat-seq
                                (repeat-seq (count reassign-executors) reassign-slots)))]
    (when-not (empty? reassignment)
      (log-message "Available slots: " (pr-str (take (- total-slots-to-use (count alive-assigned)) available-slots))
      ))
    reassignment))

(defn fstorm-schedule-topology [^TopologyDetails topology ^Cluster cluster]
  (let [topology-id (.getId topology)
      ;topologyinfo (if (nil? nimbus) (.getTopologyInfo nimbus topology-id) nil)
        tinfo (get_topologyinfo topology-id)
        eslist (.get_executors tinfo)
        componentId-transferred (if (= (count eslist) 0) {} 
                                (apply hash-map 
                                  (apply concat 
                                    (->> eslist
                                      (map 
                                        #(vector (.get_component_id %) (reduce + (vals (get (.get_transferred (.get_stats %)) "all-time")))))))))
        available-slots (->> (.getAvailableSlots cluster)
                             (map #(vector (.getNodeId %) (.getPort %))))

        all-executors (->> topology
                          .getExecutors
                          (map #(vector (.getStartTask %) (.getEndTask %)))
                          set)
        total-slots-to-use (/ (min (.getNumWorkers topology)
                                (count available-slots)) 2)
        step (/ (count all-executors) total-slots-to-use)
        executor-componentId (.getExecutorToComponent topology)
        executor-transferred (apply hash-map 
                                  (apply concat
                                    (->> executor-componentId 
                                      (map 
                                        #(vector (key %) (get componentId-transferred (val %)))))))
                                
        reassign-slots (take total-slots-to-use
                             (sort-slots available-slots))
        sorted-executors (if (nil? executor-transferred) [] (keys (sort-by val executor-transferred)))
        reassign-executors (->> sorted-executors
                              (map #(vector (.getStartTask %) (.getEndTask %)))
                              set)
        reassignment (into {}
                           (map vector
                                reassign-executors
                                ;; for some reason it goes into infinite loop without limiting the repeat-seq
                                (repeat-seq (count reassign-executors) reassign-slots)))]
    (when-not (empty? reassignment)
      (log-message "fstorm-reassignment: " reassignment)
      )
    reassignment))

(defn schedule-topologies-evenly [^Topologies topologies ^Cluster cluster]
  (let [needs-scheduling-topologies (.needsSchedulingTopologies cluster topologies)]
    (doseq [^TopologyDetails topology needs-scheduling-topologies
            :let [topology-id (.getId topology)
                  new-assignment (schedule-topology topology cluster)
                  node+port->executors (reverse-map new-assignment)]]
      (doseq [[node+port executors] node+port->executors
              :let [^WorkerSlot slot (WorkerSlot. (first node+port) (last node+port))
                    executors (for [[start-task end-task] executors]
                                (ExecutorDetails. start-task end-task))]]
        (.assign cluster slot topology-id executors)))))


(defn fstorm-schedule-topologies-evenly [^Topologies topologies ^Cluster cluster]
  (let [needs-scheduling-topologies (.needsSchedulingTopologies cluster topologies)]
    (doseq [^TopologyDetails topology needs-scheduling-topologies
            :let [topology-id (.getId topology)
                  new-assignment (fstorm-schedule-topology topology cluster)
                  node+port->executors (reverse-map new-assignment)]]
      (doseq [[node+port executors] node+port->executors
              :let [^WorkerSlot slot (WorkerSlot. (first node+port) (last node+port))
                    executors (for [[start-task end-task] executors]
                                (ExecutorDetails. start-task end-task))]]
        (.assign cluster slot topology-id executors)))))

(defn -prepare [this conf]
  )

(defn -schedule [this ^Topologies topologies ^Cluster cluster]
  (schedule-topologies-evenly topologies cluster))
