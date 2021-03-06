/**
 * Autogenerated by Thrift Compiler (0.14.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.14.0)", date = "2019-11-06")
public class Room implements org.apache.thrift.TBase<Room, Room._Fields>, java.io.Serializable, Cloneable, Comparable<Room> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Room");

  private static final org.apache.thrift.protocol.TField MID_FIELD_DESC = new org.apache.thrift.protocol.TField("mid", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CREATED_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("createdTime", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField CONTACTS_FIELD_DESC = new org.apache.thrift.protocol.TField("contacts", org.apache.thrift.protocol.TType.LIST, (short)10);
  private static final org.apache.thrift.protocol.TField NOTIFICATION_DISABLED_FIELD_DESC = new org.apache.thrift.protocol.TField("notificationDisabled", org.apache.thrift.protocol.TType.BOOL, (short)31);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new RoomStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new RoomTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String mid; // required
  public long createdTime; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<Contact> contacts; // required
  public boolean notificationDisabled; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MID((short)1, "mid"),
    CREATED_TIME((short)2, "createdTime"),
    CONTACTS((short)10, "contacts"),
    NOTIFICATION_DISABLED((short)31, "notificationDisabled");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // MID
          return MID;
        case 2: // CREATED_TIME
          return CREATED_TIME;
        case 10: // CONTACTS
          return CONTACTS;
        case 31: // NOTIFICATION_DISABLED
          return NOTIFICATION_DISABLED;
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
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __CREATEDTIME_ISSET_ID = 0;
  private static final int __NOTIFICATIONDISABLED_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MID, new org.apache.thrift.meta_data.FieldMetaData("mid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CREATED_TIME, new org.apache.thrift.meta_data.FieldMetaData("createdTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.CONTACTS, new org.apache.thrift.meta_data.FieldMetaData("contacts", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Contact.class))));
    tmpMap.put(_Fields.NOTIFICATION_DISABLED, new org.apache.thrift.meta_data.FieldMetaData("notificationDisabled", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Room.class, metaDataMap);
  }

  public Room() {
  }

  public Room(
    java.lang.String mid,
    long createdTime,
    java.util.List<Contact> contacts,
    boolean notificationDisabled)
  {
    this();
    this.mid = mid;
    this.createdTime = createdTime;
    setCreatedTimeIsSet(true);
    this.contacts = contacts;
    this.notificationDisabled = notificationDisabled;
    setNotificationDisabledIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Room(Room other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetMid()) {
      this.mid = other.mid;
    }
    this.createdTime = other.createdTime;
    if (other.isSetContacts()) {
      java.util.List<Contact> __this__contacts = new java.util.ArrayList<Contact>(other.contacts.size());
      for (Contact other_element : other.contacts) {
        __this__contacts.add(new Contact(other_element));
      }
      this.contacts = __this__contacts;
    }
    this.notificationDisabled = other.notificationDisabled;
  }

  public Room deepCopy() {
    return new Room(this);
  }

  @Override
  public void clear() {
    this.mid = null;
    setCreatedTimeIsSet(false);
    this.createdTime = 0;
    this.contacts = null;
    setNotificationDisabledIsSet(false);
    this.notificationDisabled = false;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getMid() {
    return this.mid;
  }

  public Room setMid(@org.apache.thrift.annotation.Nullable java.lang.String mid) {
    this.mid = mid;
    return this;
  }

  public void unsetMid() {
    this.mid = null;
  }

  /** Returns true if field mid is set (has been assigned a value) and false otherwise */
  public boolean isSetMid() {
    return this.mid != null;
  }

  public void setMidIsSet(boolean value) {
    if (!value) {
      this.mid = null;
    }
  }

  public long getCreatedTime() {
    return this.createdTime;
  }

  public Room setCreatedTime(long createdTime) {
    this.createdTime = createdTime;
    setCreatedTimeIsSet(true);
    return this;
  }

  public void unsetCreatedTime() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CREATEDTIME_ISSET_ID);
  }

  /** Returns true if field createdTime is set (has been assigned a value) and false otherwise */
  public boolean isSetCreatedTime() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CREATEDTIME_ISSET_ID);
  }

  public void setCreatedTimeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CREATEDTIME_ISSET_ID, value);
  }

  public int getContactsSize() {
    return (this.contacts == null) ? 0 : this.contacts.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<Contact> getContactsIterator() {
    return (this.contacts == null) ? null : this.contacts.iterator();
  }

  public void addToContacts(Contact elem) {
    if (this.contacts == null) {
      this.contacts = new java.util.ArrayList<Contact>();
    }
    this.contacts.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<Contact> getContacts() {
    return this.contacts;
  }

  public Room setContacts(@org.apache.thrift.annotation.Nullable java.util.List<Contact> contacts) {
    this.contacts = contacts;
    return this;
  }

  public void unsetContacts() {
    this.contacts = null;
  }

  /** Returns true if field contacts is set (has been assigned a value) and false otherwise */
  public boolean isSetContacts() {
    return this.contacts != null;
  }

  public void setContactsIsSet(boolean value) {
    if (!value) {
      this.contacts = null;
    }
  }

  public boolean isNotificationDisabled() {
    return this.notificationDisabled;
  }

  public Room setNotificationDisabled(boolean notificationDisabled) {
    this.notificationDisabled = notificationDisabled;
    setNotificationDisabledIsSet(true);
    return this;
  }

  public void unsetNotificationDisabled() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __NOTIFICATIONDISABLED_ISSET_ID);
  }

  /** Returns true if field notificationDisabled is set (has been assigned a value) and false otherwise */
  public boolean isSetNotificationDisabled() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __NOTIFICATIONDISABLED_ISSET_ID);
  }

  public void setNotificationDisabledIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __NOTIFICATIONDISABLED_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case MID:
      if (value == null) {
        unsetMid();
      } else {
        setMid((java.lang.String)value);
      }
      break;

    case CREATED_TIME:
      if (value == null) {
        unsetCreatedTime();
      } else {
        setCreatedTime((java.lang.Long)value);
      }
      break;

    case CONTACTS:
      if (value == null) {
        unsetContacts();
      } else {
        setContacts((java.util.List<Contact>)value);
      }
      break;

    case NOTIFICATION_DISABLED:
      if (value == null) {
        unsetNotificationDisabled();
      } else {
        setNotificationDisabled((java.lang.Boolean)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case MID:
      return getMid();

    case CREATED_TIME:
      return getCreatedTime();

    case CONTACTS:
      return getContacts();

    case NOTIFICATION_DISABLED:
      return isNotificationDisabled();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case MID:
      return isSetMid();
    case CREATED_TIME:
      return isSetCreatedTime();
    case CONTACTS:
      return isSetContacts();
    case NOTIFICATION_DISABLED:
      return isSetNotificationDisabled();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Room)
      return this.equals((Room)that);
    return false;
  }

  public boolean equals(Room that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_mid = true && this.isSetMid();
    boolean that_present_mid = true && that.isSetMid();
    if (this_present_mid || that_present_mid) {
      if (!(this_present_mid && that_present_mid))
        return false;
      if (!this.mid.equals(that.mid))
        return false;
    }

    boolean this_present_createdTime = true;
    boolean that_present_createdTime = true;
    if (this_present_createdTime || that_present_createdTime) {
      if (!(this_present_createdTime && that_present_createdTime))
        return false;
      if (this.createdTime != that.createdTime)
        return false;
    }

    boolean this_present_contacts = true && this.isSetContacts();
    boolean that_present_contacts = true && that.isSetContacts();
    if (this_present_contacts || that_present_contacts) {
      if (!(this_present_contacts && that_present_contacts))
        return false;
      if (!this.contacts.equals(that.contacts))
        return false;
    }

    boolean this_present_notificationDisabled = true;
    boolean that_present_notificationDisabled = true;
    if (this_present_notificationDisabled || that_present_notificationDisabled) {
      if (!(this_present_notificationDisabled && that_present_notificationDisabled))
        return false;
      if (this.notificationDisabled != that.notificationDisabled)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetMid()) ? 131071 : 524287);
    if (isSetMid())
      hashCode = hashCode * 8191 + mid.hashCode();

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(createdTime);

    hashCode = hashCode * 8191 + ((isSetContacts()) ? 131071 : 524287);
    if (isSetContacts())
      hashCode = hashCode * 8191 + contacts.hashCode();

    hashCode = hashCode * 8191 + ((notificationDisabled) ? 131071 : 524287);

    return hashCode;
  }

  @Override
  public int compareTo(Room other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetMid()).compareTo(other.isSetMid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mid, other.mid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCreatedTime()).compareTo(other.isSetCreatedTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCreatedTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.createdTime, other.createdTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetContacts()).compareTo(other.isSetContacts());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContacts()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.contacts, other.contacts);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetNotificationDisabled()).compareTo(other.isSetNotificationDisabled());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNotificationDisabled()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.notificationDisabled, other.notificationDisabled);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Room(");
    boolean first = true;

    sb.append("mid:");
    if (this.mid == null) {
      sb.append("null");
    } else {
      sb.append(this.mid);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("createdTime:");
    sb.append(this.createdTime);
    first = false;
    if (!first) sb.append(", ");
    sb.append("contacts:");
    if (this.contacts == null) {
      sb.append("null");
    } else {
      sb.append(this.contacts);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("notificationDisabled:");
    sb.append(this.notificationDisabled);
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

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RoomStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RoomStandardScheme getScheme() {
      return new RoomStandardScheme();
    }
  }

  private static class RoomStandardScheme extends org.apache.thrift.scheme.StandardScheme<Room> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Room struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.mid = iprot.readString();
              struct.setMidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CREATED_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.createdTime = iprot.readI64();
              struct.setCreatedTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 10: // CONTACTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list280 = iprot.readListBegin();
                struct.contacts = new java.util.ArrayList<Contact>(_list280.size);
                @org.apache.thrift.annotation.Nullable Contact _elem281;
                for (int _i282 = 0; _i282 < _list280.size; ++_i282)
                {
                  _elem281 = new Contact();
                  _elem281.read(iprot);
                  struct.contacts.add(_elem281);
                }
                iprot.readListEnd();
              }
              struct.setContactsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 31: // NOTIFICATION_DISABLED
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.notificationDisabled = iprot.readBool();
              struct.setNotificationDisabledIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Room struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.mid != null) {
        oprot.writeFieldBegin(MID_FIELD_DESC);
        oprot.writeString(struct.mid);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CREATED_TIME_FIELD_DESC);
      oprot.writeI64(struct.createdTime);
      oprot.writeFieldEnd();
      if (struct.contacts != null) {
        oprot.writeFieldBegin(CONTACTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.contacts.size()));
          for (Contact _iter283 : struct.contacts)
          {
            _iter283.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(NOTIFICATION_DISABLED_FIELD_DESC);
      oprot.writeBool(struct.notificationDisabled);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RoomTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RoomTupleScheme getScheme() {
      return new RoomTupleScheme();
    }
  }

  private static class RoomTupleScheme extends org.apache.thrift.scheme.TupleScheme<Room> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Room struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetMid()) {
        optionals.set(0);
      }
      if (struct.isSetCreatedTime()) {
        optionals.set(1);
      }
      if (struct.isSetContacts()) {
        optionals.set(2);
      }
      if (struct.isSetNotificationDisabled()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetMid()) {
        oprot.writeString(struct.mid);
      }
      if (struct.isSetCreatedTime()) {
        oprot.writeI64(struct.createdTime);
      }
      if (struct.isSetContacts()) {
        {
          oprot.writeI32(struct.contacts.size());
          for (Contact _iter284 : struct.contacts)
          {
            _iter284.write(oprot);
          }
        }
      }
      if (struct.isSetNotificationDisabled()) {
        oprot.writeBool(struct.notificationDisabled);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Room struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.mid = iprot.readString();
        struct.setMidIsSet(true);
      }
      if (incoming.get(1)) {
        struct.createdTime = iprot.readI64();
        struct.setCreatedTimeIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list285 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.contacts = new java.util.ArrayList<Contact>(_list285.size);
          @org.apache.thrift.annotation.Nullable Contact _elem286;
          for (int _i287 = 0; _i287 < _list285.size; ++_i287)
          {
            _elem286 = new Contact();
            _elem286.read(iprot);
            struct.contacts.add(_elem286);
          }
        }
        struct.setContactsIsSet(true);
      }
      if (incoming.get(3)) {
        struct.notificationDisabled = iprot.readBool();
        struct.setNotificationDisabledIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

