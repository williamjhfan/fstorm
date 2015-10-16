/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package backtype.storm.generated;

import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorStats implements org.apache.thrift.TBase<ExecutorStats, ExecutorStats._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ExecutorStats");

  private static final org.apache.thrift.protocol.TField EMITTED_FIELD_DESC = new org.apache.thrift.protocol.TField("emitted", org.apache.thrift.protocol.TType.MAP, (short)1);
  private static final org.apache.thrift.protocol.TField TRANSFERRED_FIELD_DESC = new org.apache.thrift.protocol.TField("transferred", org.apache.thrift.protocol.TType.MAP, (short)2);
  private static final org.apache.thrift.protocol.TField SPECIFIC_FIELD_DESC = new org.apache.thrift.protocol.TField("specific", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField E2E_TRANSFERRED_FIELD_DESC = new org.apache.thrift.protocol.TField("e2e_transferred", org.apache.thrift.protocol.TType.MAP, (short)5);

  private Map<String,Map<String,Long>> emitted; // required
  private Map<String,Map<String,Long>> transferred; // required
  private Map<String,Map<String,Long>> e2e_transferred; //required
  private ExecutorSpecificStats specific; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EMITTED((short)1, "emitted"),
    TRANSFERRED((short)2, "transferred"),
    SPECIFIC((short)3, "specific"),
	E2E_TRANSFERRED((short)5, "e2e_transferred");
	  
    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // EMITTED
          return EMITTED;
        case 2: // TRANSFERRED
          return TRANSFERRED;
        case 3: // SPECIFIC
          return SPECIFIC;
        case 5: //e2e_transferred
          return E2E_TRANSFERRED;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EMITTED, new org.apache.thrift.meta_data.FieldMetaData("emitted", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)))));
    tmpMap.put(_Fields.TRANSFERRED, new org.apache.thrift.meta_data.FieldMetaData("transferred", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)))));
    tmpMap.put(_Fields.E2E_TRANSFERRED, new org.apache.thrift.meta_data.FieldMetaData("e2e_transferred", org.apache.thrift.TFieldRequirementType.REQUIRED, 
            new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
                new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)))));
    
    tmpMap.put(_Fields.SPECIFIC, new org.apache.thrift.meta_data.FieldMetaData("specific", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ExecutorSpecificStats.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ExecutorStats.class, metaDataMap);
  }

  public ExecutorStats() {
  }

  public ExecutorStats(
    Map<String,Map<String,Long>> emitted,
    Map<String,Map<String,Long>> transferred,
    ExecutorSpecificStats specific,
    Map<String,Map<String,Long>> e2e_transferred)
  {
    this();
    this.emitted = emitted;
    this.transferred = transferred;
    this.specific = specific;
    this.e2e_transferred = e2e_transferred;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ExecutorStats(ExecutorStats other) {
    if (other.is_set_emitted()) {
      Map<String,Map<String,Long>> __this__emitted = new HashMap<String,Map<String,Long>>();
      for (Map.Entry<String, Map<String,Long>> other_element : other.emitted.entrySet()) {

        String other_element_key = other_element.getKey();
        Map<String,Long> other_element_value = other_element.getValue();

        String __this__emitted_copy_key = other_element_key;

        Map<String,Long> __this__emitted_copy_value = new HashMap<String,Long>();
        for (Map.Entry<String, Long> other_element_value_element : other_element_value.entrySet()) {

          String other_element_value_element_key = other_element_value_element.getKey();
          Long other_element_value_element_value = other_element_value_element.getValue();

          String __this__emitted_copy_value_copy_key = other_element_value_element_key;

          Long __this__emitted_copy_value_copy_value = other_element_value_element_value;

          __this__emitted_copy_value.put(__this__emitted_copy_value_copy_key, __this__emitted_copy_value_copy_value);
        }

        __this__emitted.put(__this__emitted_copy_key, __this__emitted_copy_value);
      }
      this.emitted = __this__emitted;
    }
    if (other.is_set_transferred()) {
      Map<String,Map<String,Long>> __this__transferred = new HashMap<String,Map<String,Long>>();
      for (Map.Entry<String, Map<String,Long>> other_element : other.transferred.entrySet()) {

        String other_element_key = other_element.getKey();
        Map<String,Long> other_element_value = other_element.getValue();

        String __this__transferred_copy_key = other_element_key;

        Map<String,Long> __this__transferred_copy_value = new HashMap<String,Long>();
        for (Map.Entry<String, Long> other_element_value_element : other_element_value.entrySet()) {

          String other_element_value_element_key = other_element_value_element.getKey();
          Long other_element_value_element_value = other_element_value_element.getValue();

          String __this__transferred_copy_value_copy_key = other_element_value_element_key;

          Long __this__transferred_copy_value_copy_value = other_element_value_element_value;

          __this__transferred_copy_value.put(__this__transferred_copy_value_copy_key, __this__transferred_copy_value_copy_value);
        }

        __this__transferred.put(__this__transferred_copy_key, __this__transferred_copy_value);
      }
      this.transferred = __this__transferred;
    }
    
    if (other.is_set_e2e_transferred()) {
        Map<String,Map<String,Long>> __this__e2e_transferred = new HashMap<String,Map<String,Long>>();
        for (Map.Entry<String, Map<String,Long>> other_element : other.e2e_transferred.entrySet()) {

          String other_element_key = other_element.getKey();
          Map<String,Long> other_element_value = other_element.getValue();

          String __this__e2e_transferred_copy_key = other_element_key;

          Map<String,Long> __this__e2e_transferred_copy_value = new HashMap<String,Long>();
          for (Map.Entry<String, Long> other_element_value_element : other_element_value.entrySet()) {

            String other_element_value_element_key = other_element_value_element.getKey();
            Long other_element_value_element_value = other_element_value_element.getValue();

            String __this__e2e_transferred_copy_value_copy_key = other_element_value_element_key;

            Long __this__e2e_transferred_copy_value_copy_value = other_element_value_element_value;

            __this__e2e_transferred_copy_value.put(__this__e2e_transferred_copy_value_copy_key, __this__e2e_transferred_copy_value_copy_value);
          }

          __this__e2e_transferred.put(__this__e2e_transferred_copy_key, __this__e2e_transferred_copy_value);
        }
        this.e2e_transferred = __this__e2e_transferred;
      }
    
    if (other.is_set_specific()) {
      this.specific = new ExecutorSpecificStats(other.specific);
    }
  }

  public ExecutorStats deepCopy() {
    return new ExecutorStats(this);
  }

  @Override
  public void clear() {
    this.emitted = null;
    this.transferred = null;
    this.specific = null;
    this.e2e_transferred=null;
  }

  public int get_emitted_size() {
    return (this.emitted == null) ? 0 : this.emitted.size();
  }

  public void put_to_emitted(String key, Map<String,Long> val) {
    if (this.emitted == null) {
      this.emitted = new HashMap<String,Map<String,Long>>();
    }
    this.emitted.put(key, val);
  }

  public Map<String,Map<String,Long>> get_emitted() {
    return this.emitted;
  }

  public void set_emitted(Map<String,Map<String,Long>> emitted) {
    this.emitted = emitted;
  }

  public void unset_emitted() {
    this.emitted = null;
  }

  /** Returns true if field emitted is set (has been assigned a value) and false otherwise */
  public boolean is_set_emitted() {
    return this.emitted != null;
  }

  public void set_emitted_isSet(boolean value) {
    if (!value) {
      this.emitted = null;
    }
  }

  public int get_transferred_size() {
    return (this.transferred == null) ? 0 : this.transferred.size();
  }

  public void put_to_transferred(String key, Map<String,Long> val) {
    if (this.transferred == null) {
      this.transferred = new HashMap<String,Map<String,Long>>();
    }
    this.transferred.put(key, val);
  }

  public Map<String,Map<String,Long>> get_transferred() {
    return this.transferred;
  }

  public void set_transferred(Map<String,Map<String,Long>> transferred) {
    this.transferred = transferred;
  }

  public void unset_transferred() {
    this.transferred = null;
  }

  /** Returns true if field transferred is set (has been assigned a value) and false otherwise */
  public boolean is_set_transferred() {
    return this.transferred != null;
  }

  public void set_transferred_isSet(boolean value) {
    if (!value) {
      this.transferred = null;
    }
  }

  public int get_e2e_transferred_size() {
	    return (this.e2e_transferred == null) ? 0 : this.e2e_transferred.size();
	  }

public void put_to_e2e_transferred(String key, Map<String,Long> val) {
	    if (this.e2e_transferred == null) {
	      this.e2e_transferred = new HashMap<String,Map<String,Long>>();
	    }
	    this.e2e_transferred.put(key, val);
	  }
	  

public Map<String, Map<String, Long>> get_e2e_transferred() {
	return e2e_transferred;
}

public void set_e2e_transferred(Map<String, Map<String, Long>> e2e_transferred) {
	this.e2e_transferred = e2e_transferred;
}

public void unset_e2e_transferred() {
  this.e2e_transferred = null;
}

/** Returns true if field transferred is set (has been assigned a value) and false otherwise */
public boolean is_set_e2e_transferred() {
  return this.e2e_transferred != null;
}

public void set_e2e_transferred_isSet(boolean value) {
  if (!value) {
    this.e2e_transferred = null;
  }
}
  
  public ExecutorSpecificStats get_specific() {
    return this.specific;
  }

  public void set_specific(ExecutorSpecificStats specific) {
    this.specific = specific;
  }

  public void unset_specific() {
    this.specific = null;
  }

  /** Returns true if field specific is set (has been assigned a value) and false otherwise */
  public boolean is_set_specific() {
    return this.specific != null;
  }

  public void set_specific_isSet(boolean value) {
    if (!value) {
      this.specific = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case EMITTED:
      if (value == null) {
        unset_emitted();
      } else {
        set_emitted((Map<String,Map<String,Long>>)value);
      }
      break;

    case TRANSFERRED:
      if (value == null) {
        unset_transferred();
      } else {
        set_transferred((Map<String,Map<String,Long>>)value);
      }
      break;

    case SPECIFIC:
      if (value == null) {
        unset_specific();
      } else {
        set_specific((ExecutorSpecificStats)value);
      }
      break;
      
    case E2E_TRANSFERRED:
        if (value == null) {
          unset_e2e_transferred();
        } else {
          set_e2e_transferred((Map<String,Map<String,Long>>)value);
        }
        break; 
    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case EMITTED:
      return get_emitted();

    case TRANSFERRED:
      return get_transferred();

    case SPECIFIC:
      return get_specific();

    case E2E_TRANSFERRED:
        return get_e2e_transferred();  
      
    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case EMITTED:
      return is_set_emitted();
    case TRANSFERRED:
      return is_set_transferred();
    case SPECIFIC:
      return is_set_specific();
    case E2E_TRANSFERRED:
        return is_set_e2e_transferred(); 
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ExecutorStats)
      return this.equals((ExecutorStats)that);
    return false;
  }

  public boolean equals(ExecutorStats that) {
    if (that == null)
      return false;

    boolean this_present_emitted = true && this.is_set_emitted();
    boolean that_present_emitted = true && that.is_set_emitted();
    if (this_present_emitted || that_present_emitted) {
      if (!(this_present_emitted && that_present_emitted))
        return false;
      if (!this.emitted.equals(that.emitted))
        return false;
    }

    boolean this_present_transferred = true && this.is_set_transferred();
    boolean that_present_transferred = true && that.is_set_transferred();
    if (this_present_transferred || that_present_transferred) {
      if (!(this_present_transferred && that_present_transferred))
        return false;
      if (!this.transferred.equals(that.transferred))
        return false;
    }

    boolean this_present_e2e_transferred = true && this.is_set_e2e_transferred();
    boolean that_present_e2e_transferred = true && that.is_set_e2e_transferred();
    if (this_present_e2e_transferred || that_present_e2e_transferred) {
      if (!(this_present_e2e_transferred && that_present_e2e_transferred))
        return false;
      if (!this.e2e_transferred.equals(that.e2e_transferred))
        return false;
    }
    
    boolean this_present_specific = true && this.is_set_specific();
    boolean that_present_specific = true && that.is_set_specific();
    if (this_present_specific || that_present_specific) {
      if (!(this_present_specific && that_present_specific))
        return false;
      if (!this.specific.equals(that.specific))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_emitted = true && (is_set_emitted());
    builder.append(present_emitted);
    if (present_emitted)
      builder.append(emitted);

    boolean present_transferred = true && (is_set_transferred());
    builder.append(present_transferred);
    if (present_transferred)
      builder.append(transferred);

    boolean present_e2e_transferred = true && (is_set_e2e_transferred());
    builder.append(present_e2e_transferred);
    if (present_e2e_transferred)
      builder.append(transferred);
    
    boolean present_specific = true && (is_set_specific());
    builder.append(present_specific);
    if (present_specific)
      builder.append(specific);

    return builder.toHashCode();
  }

  public int compareTo(ExecutorStats other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ExecutorStats typedOther = (ExecutorStats)other;

    lastComparison = Boolean.valueOf(is_set_emitted()).compareTo(typedOther.is_set_emitted());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_emitted()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.emitted, typedOther.emitted);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_transferred()).compareTo(typedOther.is_set_transferred());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_transferred()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.transferred, typedOther.transferred);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_e2e_transferred()).compareTo(other.is_set_e2e_transferred());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_e2e_transferred()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.e2e_transferred, other.e2e_transferred);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(is_set_specific()).compareTo(typedOther.is_set_specific());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_specific()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.specific, typedOther.specific);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // EMITTED
          if (field.type == org.apache.thrift.protocol.TType.MAP) {
            {
              org.apache.thrift.protocol.TMap _map125 = iprot.readMapBegin();
              this.emitted = new HashMap<String,Map<String,Long>>(2*_map125.size);
              for (int _i126 = 0; _i126 < _map125.size; ++_i126)
              {
                String _key127; // required
                Map<String,Long> _val128; // required
                _key127 = iprot.readString();
                {
                  org.apache.thrift.protocol.TMap _map129 = iprot.readMapBegin();
                  _val128 = new HashMap<String,Long>(2*_map129.size);
                  for (int _i130 = 0; _i130 < _map129.size; ++_i130)
                  {
                    String _key131; // required
                    long _val132; // required
                    _key131 = iprot.readString();
                    _val132 = iprot.readI64();
                    _val128.put(_key131, _val132);
                  }
                  iprot.readMapEnd();
                }
                this.emitted.put(_key127, _val128);
              }
              iprot.readMapEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // TRANSFERRED
          if (field.type == org.apache.thrift.protocol.TType.MAP) {
            {
              org.apache.thrift.protocol.TMap _map133 = iprot.readMapBegin();
              this.transferred = new HashMap<String,Map<String,Long>>(2*_map133.size);
              for (int _i134 = 0; _i134 < _map133.size; ++_i134)
              {
                String _key135; // required
                Map<String,Long> _val136; // required
                _key135 = iprot.readString();
                {
                  org.apache.thrift.protocol.TMap _map137 = iprot.readMapBegin();
                  _val136 = new HashMap<String,Long>(2*_map137.size);
                  for (int _i138 = 0; _i138 < _map137.size; ++_i138)
                  {
                    String _key139; // required
                    long _val140; // required
                    _key139 = iprot.readString();
                    _val140 = iprot.readI64();
                    _val136.put(_key139, _val140);
                  }
                  iprot.readMapEnd();
                }
                this.transferred.put(_key135, _val136);
              }
              iprot.readMapEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // E2E_TRANSFERRED
            if (field.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map141 = iprot.readMapBegin();
                this.transferred = new HashMap<String,Map<String,Long>>(2*_map141.size);
                for (int _i142 = 0; _i142 < _map141.size; ++_i142)
                {
                  String _key143; // required
                  Map<String,Long> _val144; // required
                  _key143 = iprot.readString();
                  {
                    org.apache.thrift.protocol.TMap _map145 = iprot.readMapBegin();
                    _val144 = new HashMap<String,Long>(2*_map145.size);
                    for (int _i146 = 0; _i146 < _map145.size; ++_i146)
                    {
                      String _key147; // required
                      long _val148; // required
                      _key147 = iprot.readString();
                      _val148 = iprot.readI64();
                      _val144.put(_key147, _val148);
                    }
                    iprot.readMapEnd();
                  }
                  this.e2e_transferred.put(_key143, _val144);
                }
                iprot.readMapEnd();
              }
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            }
            break;
        case 3: // SPECIFIC
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.specific = new ExecutorSpecificStats();
            this.specific.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.emitted != null) {
      oprot.writeFieldBegin(EMITTED_FIELD_DESC);
      {
        oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.MAP, this.emitted.size()));
        for (Map.Entry<String, Map<String,Long>> _iter141 : this.emitted.entrySet())
        {
          oprot.writeString(_iter141.getKey());
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.I64, _iter141.getValue().size()));
            for (Map.Entry<String, Long> _iter142 : _iter141.getValue().entrySet())
            {
              oprot.writeString(_iter142.getKey());
              oprot.writeI64(_iter142.getValue());
            }
            oprot.writeMapEnd();
          }
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.transferred != null) {
      oprot.writeFieldBegin(TRANSFERRED_FIELD_DESC);
      {
        oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.MAP, this.transferred.size()));
        for (Map.Entry<String, Map<String,Long>> _iter143 : this.transferred.entrySet())
        {
          oprot.writeString(_iter143.getKey());
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.I64, _iter143.getValue().size()));
            for (Map.Entry<String, Long> _iter144 : _iter143.getValue().entrySet())
            {
              oprot.writeString(_iter144.getKey());
              oprot.writeI64(_iter144.getValue());
            }
            oprot.writeMapEnd();
          }
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.e2e_transferred != null) {
        oprot.writeFieldBegin(E2E_TRANSFERRED_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.MAP, this.e2e_transferred.size()));
          for (Map.Entry<String, Map<String,Long>> _iter145 : this.e2e_transferred.entrySet())
          {
            oprot.writeString(_iter145.getKey());
            {
              oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.I64, _iter145.getValue().size()));
              for (Map.Entry<String, Long> _iter146 : _iter145.getValue().entrySet())
              {
                oprot.writeString(_iter146.getKey());
                oprot.writeI64(_iter146.getValue());
              }
              oprot.writeMapEnd();
            }
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
    if (this.specific != null) {
      oprot.writeFieldBegin(SPECIFIC_FIELD_DESC);
      this.specific.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ExecutorStats(");
    boolean first = true;

    sb.append("emitted:");
    if (this.emitted == null) {
      sb.append("null");
    } else {
      sb.append(this.emitted);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("transferred:");
    if (this.transferred == null) {
      sb.append("null");
    } else {
      sb.append(this.transferred);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("e2e_transferred:");
    if (this.e2e_transferred == null) {
      sb.append("null");
    } else {
      sb.append(this.e2e_transferred);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("specific:");
    if (this.specific == null) {
      sb.append("null");
    } else {
      sb.append(this.specific);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!is_set_emitted()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'emitted' is unset! Struct:" + toString());
    }

    if (!is_set_transferred()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'transferred' is unset! Struct:" + toString());
    }

    if (!is_set_e2e_transferred()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'e2e_transferred' is unset! Struct:" + toString());
      }
    
    if (!is_set_specific()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'specific' is unset! Struct:" + toString());
    }

  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

