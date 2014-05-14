/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.errorify.server.gen;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
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

public class CompilerResult implements org.apache.thrift.TBase<CompilerResult, CompilerResult._Fields>, java.io.Serializable, Cloneable, Comparable<CompilerResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CompilerResult");

  private static final org.apache.thrift.protocol.TField SOURCE_PROCESSED_FIELD_DESC = new org.apache.thrift.protocol.TField("sourceProcessed", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField SOURCE_MAP_FIELD_DESC = new org.apache.thrift.protocol.TField("sourceMap", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField COMPILER_ERRORS_FIELD_DESC = new org.apache.thrift.protocol.TField("compilerErrors", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField COMPILER_WARNINGS_FIELD_DESC = new org.apache.thrift.protocol.TField("compilerWarnings", org.apache.thrift.protocol.TType.LIST, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CompilerResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CompilerResultTupleSchemeFactory());
  }

  public String sourceProcessed; // required
  public String sourceMap; // required
  public List<String> compilerErrors; // required
  public List<String> compilerWarnings; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SOURCE_PROCESSED((short)1, "sourceProcessed"),
    SOURCE_MAP((short)2, "sourceMap"),
    COMPILER_ERRORS((short)4, "compilerErrors"),
    COMPILER_WARNINGS((short)5, "compilerWarnings");

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
        case 1: // SOURCE_PROCESSED
          return SOURCE_PROCESSED;
        case 2: // SOURCE_MAP
          return SOURCE_MAP;
        case 4: // COMPILER_ERRORS
          return COMPILER_ERRORS;
        case 5: // COMPILER_WARNINGS
          return COMPILER_WARNINGS;
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
    tmpMap.put(_Fields.SOURCE_PROCESSED, new org.apache.thrift.meta_data.FieldMetaData("sourceProcessed", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SOURCE_MAP, new org.apache.thrift.meta_data.FieldMetaData("sourceMap", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COMPILER_ERRORS, new org.apache.thrift.meta_data.FieldMetaData("compilerErrors", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.COMPILER_WARNINGS, new org.apache.thrift.meta_data.FieldMetaData("compilerWarnings", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CompilerResult.class, metaDataMap);
  }

  public CompilerResult() {
  }

  public CompilerResult(
    String sourceProcessed,
    String sourceMap,
    List<String> compilerErrors,
    List<String> compilerWarnings)
  {
    this();
    this.sourceProcessed = sourceProcessed;
    this.sourceMap = sourceMap;
    this.compilerErrors = compilerErrors;
    this.compilerWarnings = compilerWarnings;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CompilerResult(CompilerResult other) {
    if (other.isSetSourceProcessed()) {
      this.sourceProcessed = other.sourceProcessed;
    }
    if (other.isSetSourceMap()) {
      this.sourceMap = other.sourceMap;
    }
    if (other.isSetCompilerErrors()) {
      List<String> __this__compilerErrors = new ArrayList<String>(other.compilerErrors);
      this.compilerErrors = __this__compilerErrors;
    }
    if (other.isSetCompilerWarnings()) {
      List<String> __this__compilerWarnings = new ArrayList<String>(other.compilerWarnings);
      this.compilerWarnings = __this__compilerWarnings;
    }
  }

  public CompilerResult deepCopy() {
    return new CompilerResult(this);
  }

  @Override
  public void clear() {
    this.sourceProcessed = null;
    this.sourceMap = null;
    this.compilerErrors = null;
    this.compilerWarnings = null;
  }

  public String getSourceProcessed() {
    return this.sourceProcessed;
  }

  public CompilerResult setSourceProcessed(String sourceProcessed) {
    this.sourceProcessed = sourceProcessed;
    return this;
  }

  public void unsetSourceProcessed() {
    this.sourceProcessed = null;
  }

  /** Returns true if field sourceProcessed is set (has been assigned a value) and false otherwise */
  public boolean isSetSourceProcessed() {
    return this.sourceProcessed != null;
  }

  public void setSourceProcessedIsSet(boolean value) {
    if (!value) {
      this.sourceProcessed = null;
    }
  }

  public String getSourceMap() {
    return this.sourceMap;
  }

  public CompilerResult setSourceMap(String sourceMap) {
    this.sourceMap = sourceMap;
    return this;
  }

  public void unsetSourceMap() {
    this.sourceMap = null;
  }

  /** Returns true if field sourceMap is set (has been assigned a value) and false otherwise */
  public boolean isSetSourceMap() {
    return this.sourceMap != null;
  }

  public void setSourceMapIsSet(boolean value) {
    if (!value) {
      this.sourceMap = null;
    }
  }

  public int getCompilerErrorsSize() {
    return (this.compilerErrors == null) ? 0 : this.compilerErrors.size();
  }

  public java.util.Iterator<String> getCompilerErrorsIterator() {
    return (this.compilerErrors == null) ? null : this.compilerErrors.iterator();
  }

  public void addToCompilerErrors(String elem) {
    if (this.compilerErrors == null) {
      this.compilerErrors = new ArrayList<String>();
    }
    this.compilerErrors.add(elem);
  }

  public List<String> getCompilerErrors() {
    return this.compilerErrors;
  }

  public CompilerResult setCompilerErrors(List<String> compilerErrors) {
    this.compilerErrors = compilerErrors;
    return this;
  }

  public void unsetCompilerErrors() {
    this.compilerErrors = null;
  }

  /** Returns true if field compilerErrors is set (has been assigned a value) and false otherwise */
  public boolean isSetCompilerErrors() {
    return this.compilerErrors != null;
  }

  public void setCompilerErrorsIsSet(boolean value) {
    if (!value) {
      this.compilerErrors = null;
    }
  }

  public int getCompilerWarningsSize() {
    return (this.compilerWarnings == null) ? 0 : this.compilerWarnings.size();
  }

  public java.util.Iterator<String> getCompilerWarningsIterator() {
    return (this.compilerWarnings == null) ? null : this.compilerWarnings.iterator();
  }

  public void addToCompilerWarnings(String elem) {
    if (this.compilerWarnings == null) {
      this.compilerWarnings = new ArrayList<String>();
    }
    this.compilerWarnings.add(elem);
  }

  public List<String> getCompilerWarnings() {
    return this.compilerWarnings;
  }

  public CompilerResult setCompilerWarnings(List<String> compilerWarnings) {
    this.compilerWarnings = compilerWarnings;
    return this;
  }

  public void unsetCompilerWarnings() {
    this.compilerWarnings = null;
  }

  /** Returns true if field compilerWarnings is set (has been assigned a value) and false otherwise */
  public boolean isSetCompilerWarnings() {
    return this.compilerWarnings != null;
  }

  public void setCompilerWarningsIsSet(boolean value) {
    if (!value) {
      this.compilerWarnings = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SOURCE_PROCESSED:
      if (value == null) {
        unsetSourceProcessed();
      } else {
        setSourceProcessed((String)value);
      }
      break;

    case SOURCE_MAP:
      if (value == null) {
        unsetSourceMap();
      } else {
        setSourceMap((String)value);
      }
      break;

    case COMPILER_ERRORS:
      if (value == null) {
        unsetCompilerErrors();
      } else {
        setCompilerErrors((List<String>)value);
      }
      break;

    case COMPILER_WARNINGS:
      if (value == null) {
        unsetCompilerWarnings();
      } else {
        setCompilerWarnings((List<String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SOURCE_PROCESSED:
      return getSourceProcessed();

    case SOURCE_MAP:
      return getSourceMap();

    case COMPILER_ERRORS:
      return getCompilerErrors();

    case COMPILER_WARNINGS:
      return getCompilerWarnings();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SOURCE_PROCESSED:
      return isSetSourceProcessed();
    case SOURCE_MAP:
      return isSetSourceMap();
    case COMPILER_ERRORS:
      return isSetCompilerErrors();
    case COMPILER_WARNINGS:
      return isSetCompilerWarnings();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CompilerResult)
      return this.equals((CompilerResult)that);
    return false;
  }

  public boolean equals(CompilerResult that) {
    if (that == null)
      return false;

    boolean this_present_sourceProcessed = true && this.isSetSourceProcessed();
    boolean that_present_sourceProcessed = true && that.isSetSourceProcessed();
    if (this_present_sourceProcessed || that_present_sourceProcessed) {
      if (!(this_present_sourceProcessed && that_present_sourceProcessed))
        return false;
      if (!this.sourceProcessed.equals(that.sourceProcessed))
        return false;
    }

    boolean this_present_sourceMap = true && this.isSetSourceMap();
    boolean that_present_sourceMap = true && that.isSetSourceMap();
    if (this_present_sourceMap || that_present_sourceMap) {
      if (!(this_present_sourceMap && that_present_sourceMap))
        return false;
      if (!this.sourceMap.equals(that.sourceMap))
        return false;
    }

    boolean this_present_compilerErrors = true && this.isSetCompilerErrors();
    boolean that_present_compilerErrors = true && that.isSetCompilerErrors();
    if (this_present_compilerErrors || that_present_compilerErrors) {
      if (!(this_present_compilerErrors && that_present_compilerErrors))
        return false;
      if (!this.compilerErrors.equals(that.compilerErrors))
        return false;
    }

    boolean this_present_compilerWarnings = true && this.isSetCompilerWarnings();
    boolean that_present_compilerWarnings = true && that.isSetCompilerWarnings();
    if (this_present_compilerWarnings || that_present_compilerWarnings) {
      if (!(this_present_compilerWarnings && that_present_compilerWarnings))
        return false;
      if (!this.compilerWarnings.equals(that.compilerWarnings))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(CompilerResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSourceProcessed()).compareTo(other.isSetSourceProcessed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSourceProcessed()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sourceProcessed, other.sourceProcessed);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSourceMap()).compareTo(other.isSetSourceMap());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSourceMap()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sourceMap, other.sourceMap);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCompilerErrors()).compareTo(other.isSetCompilerErrors());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCompilerErrors()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.compilerErrors, other.compilerErrors);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCompilerWarnings()).compareTo(other.isSetCompilerWarnings());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCompilerWarnings()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.compilerWarnings, other.compilerWarnings);
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
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CompilerResult(");
    boolean first = true;

    sb.append("sourceProcessed:");
    if (this.sourceProcessed == null) {
      sb.append("null");
    } else {
      sb.append(this.sourceProcessed);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("sourceMap:");
    if (this.sourceMap == null) {
      sb.append("null");
    } else {
      sb.append(this.sourceMap);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("compilerErrors:");
    if (this.compilerErrors == null) {
      sb.append("null");
    } else {
      sb.append(this.compilerErrors);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("compilerWarnings:");
    if (this.compilerWarnings == null) {
      sb.append("null");
    } else {
      sb.append(this.compilerWarnings);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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

  private static class CompilerResultStandardSchemeFactory implements SchemeFactory {
    public CompilerResultStandardScheme getScheme() {
      return new CompilerResultStandardScheme();
    }
  }

  private static class CompilerResultStandardScheme extends StandardScheme<CompilerResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CompilerResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SOURCE_PROCESSED
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sourceProcessed = iprot.readString();
              struct.setSourceProcessedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SOURCE_MAP
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sourceMap = iprot.readString();
              struct.setSourceMapIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // COMPILER_ERRORS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.compilerErrors = new ArrayList<String>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  String _elem2;
                  _elem2 = iprot.readString();
                  struct.compilerErrors.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setCompilerErrorsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // COMPILER_WARNINGS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list3 = iprot.readListBegin();
                struct.compilerWarnings = new ArrayList<String>(_list3.size);
                for (int _i4 = 0; _i4 < _list3.size; ++_i4)
                {
                  String _elem5;
                  _elem5 = iprot.readString();
                  struct.compilerWarnings.add(_elem5);
                }
                iprot.readListEnd();
              }
              struct.setCompilerWarningsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, CompilerResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sourceProcessed != null) {
        oprot.writeFieldBegin(SOURCE_PROCESSED_FIELD_DESC);
        oprot.writeString(struct.sourceProcessed);
        oprot.writeFieldEnd();
      }
      if (struct.sourceMap != null) {
        oprot.writeFieldBegin(SOURCE_MAP_FIELD_DESC);
        oprot.writeString(struct.sourceMap);
        oprot.writeFieldEnd();
      }
      if (struct.compilerErrors != null) {
        oprot.writeFieldBegin(COMPILER_ERRORS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.compilerErrors.size()));
          for (String _iter6 : struct.compilerErrors)
          {
            oprot.writeString(_iter6);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.compilerWarnings != null) {
        oprot.writeFieldBegin(COMPILER_WARNINGS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.compilerWarnings.size()));
          for (String _iter7 : struct.compilerWarnings)
          {
            oprot.writeString(_iter7);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CompilerResultTupleSchemeFactory implements SchemeFactory {
    public CompilerResultTupleScheme getScheme() {
      return new CompilerResultTupleScheme();
    }
  }

  private static class CompilerResultTupleScheme extends TupleScheme<CompilerResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CompilerResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSourceProcessed()) {
        optionals.set(0);
      }
      if (struct.isSetSourceMap()) {
        optionals.set(1);
      }
      if (struct.isSetCompilerErrors()) {
        optionals.set(2);
      }
      if (struct.isSetCompilerWarnings()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetSourceProcessed()) {
        oprot.writeString(struct.sourceProcessed);
      }
      if (struct.isSetSourceMap()) {
        oprot.writeString(struct.sourceMap);
      }
      if (struct.isSetCompilerErrors()) {
        {
          oprot.writeI32(struct.compilerErrors.size());
          for (String _iter8 : struct.compilerErrors)
          {
            oprot.writeString(_iter8);
          }
        }
      }
      if (struct.isSetCompilerWarnings()) {
        {
          oprot.writeI32(struct.compilerWarnings.size());
          for (String _iter9 : struct.compilerWarnings)
          {
            oprot.writeString(_iter9);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CompilerResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.sourceProcessed = iprot.readString();
        struct.setSourceProcessedIsSet(true);
      }
      if (incoming.get(1)) {
        struct.sourceMap = iprot.readString();
        struct.setSourceMapIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list10 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.compilerErrors = new ArrayList<String>(_list10.size);
          for (int _i11 = 0; _i11 < _list10.size; ++_i11)
          {
            String _elem12;
            _elem12 = iprot.readString();
            struct.compilerErrors.add(_elem12);
          }
        }
        struct.setCompilerErrorsIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.compilerWarnings = new ArrayList<String>(_list13.size);
          for (int _i14 = 0; _i14 < _list13.size; ++_i14)
          {
            String _elem15;
            _elem15 = iprot.readString();
            struct.compilerWarnings.add(_elem15);
          }
        }
        struct.setCompilerWarningsIsSet(true);
      }
    }
  }

}

