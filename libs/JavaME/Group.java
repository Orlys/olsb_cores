/**
 * Autogenerated by Thrift Compiler (0.14.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

public class Group implements TBase {
  private static final TStruct STRUCT_DESC = new TStruct("Group");

  private static final TField ID_FIELD_DESC = new TField("id", TType.STRING, (short)1);
  private static final TField CREATED_TIME_FIELD_DESC = new TField("createdTime", TType.I64, (short)2);
  private static final TField NAME_FIELD_DESC = new TField("name", TType.STRING, (short)10);
  private static final TField PICTURE_STATUS_FIELD_DESC = new TField("pictureStatus", TType.STRING, (short)11);
  private static final TField MEMBERS_FIELD_DESC = new TField("members", TType.LIST, (short)20);
  private static final TField CREATOR_FIELD_DESC = new TField("creator", TType.STRUCT, (short)21);
  private static final TField INVITEE_FIELD_DESC = new TField("invitee", TType.LIST, (short)22);
  private static final TField NOTIFICATION_DISABLED_FIELD_DESC = new TField("notificationDisabled", TType.BOOL, (short)31);

  private String id;
  private long createdTime;
  private String name;
  private String pictureStatus;
  private Vector members;
  private Contact creator;
  private Vector invitee;
  private boolean notificationDisabled;

  // isset id assignments
  private static final int __CREATEDTIME_ISSET_ID = 0;
  private static final int __NOTIFICATIONDISABLED_ISSET_ID = 1;
  private boolean[] __isset_vector = new boolean[2];

  public Group() {
  }

  public Group(
    String id,
    long createdTime,
    String name,
    String pictureStatus,
    Vector members,
    Contact creator,
    Vector invitee,
    boolean notificationDisabled)
  {
    this();
    this.id = id;
    this.createdTime = createdTime;
    setCreatedTimeIsSet(true);
    this.name = name;
    this.pictureStatus = pictureStatus;
    this.members = members;
    this.creator = creator;
    this.invitee = invitee;
    this.notificationDisabled = notificationDisabled;
    setNotificationDisabledIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Group(Group other) {
    System.arraycopy(other.__isset_vector, 0, __isset_vector, 0, other.__isset_vector.length);
    if (other.isSetId()) {
      this.id = other.id;
    }
    this.createdTime = other.createdTime;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetPictureStatus()) {
      this.pictureStatus = other.pictureStatus;
    }
    if (other.isSetMembers()) {
      Vector __this__members = new Vector();
      for (Enumeration other_enum = other.members.elements(); other_enum.hasMoreElements(); ) {
        Contact other_element = (Contact)other_enum.nextElement();
        __this__members.addElement(new Contact(other_element));
      }
      this.members = __this__members;
    }
    if (other.isSetCreator()) {
      this.creator = new Contact(other.creator);
    }
    if (other.isSetInvitee()) {
      Vector __this__invitee = new Vector();
      for (Enumeration other_enum = other.invitee.elements(); other_enum.hasMoreElements(); ) {
        Contact other_element = (Contact)other_enum.nextElement();
        __this__invitee.addElement(new Contact(other_element));
      }
      this.invitee = __this__invitee;
    }
    this.notificationDisabled = other.notificationDisabled;
  }

  public Group deepCopy() {
    return new Group(this);
  }

  public void clear() {
    this.id = null;
    setCreatedTimeIsSet(false);
    this.createdTime = 0;
    this.name = null;
    this.pictureStatus = null;
    this.members = null;
    this.creator = null;
    this.invitee = null;
    setNotificationDisabledIsSet(false);
    this.notificationDisabled = false;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void unsetId() {
    this.id = null;
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return this.id != null;
  }

  public void setIdIsSet(boolean value) {
    if (!value) {
      this.id = null;
    }
  }

  public long getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(long createdTime) {
    this.createdTime = createdTime;
    setCreatedTimeIsSet(true);
  }

  public void unsetCreatedTime() {
    __isset_vector[__CREATEDTIME_ISSET_ID] = false;
  }

  /** Returns true if field createdTime is set (has been assigned a value) and false otherwise */
  public boolean isSetCreatedTime() {
    return __isset_vector[__CREATEDTIME_ISSET_ID];
  }

  public void setCreatedTimeIsSet(boolean value) {
    __isset_vector[__CREATEDTIME_ISSET_ID] = value;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getPictureStatus() {
    return this.pictureStatus;
  }

  public void setPictureStatus(String pictureStatus) {
    this.pictureStatus = pictureStatus;
  }

  public void unsetPictureStatus() {
    this.pictureStatus = null;
  }

  /** Returns true if field pictureStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetPictureStatus() {
    return this.pictureStatus != null;
  }

  public void setPictureStatusIsSet(boolean value) {
    if (!value) {
      this.pictureStatus = null;
    }
  }

  public int getMembersSize() {
    return (this.members == null) ? 0 : this.members.size();
  }

  public Enumeration getMembersEnumeration() {
    return (this.members == null) ? null : this.members.elements();
  }

  public void addToMembers(Contact elem) {
    if (this.members == null) {
      this.members = new Vector();
    }
    this.members.addElement(elem);
  }

  public Vector getMembers() {
    return this.members;
  }

  public void setMembers(Vector members) {
    this.members = members;
  }

  public void unsetMembers() {
    this.members = null;
  }

  /** Returns true if field members is set (has been assigned a value) and false otherwise */
  public boolean isSetMembers() {
    return this.members != null;
  }

  public void setMembersIsSet(boolean value) {
    if (!value) {
      this.members = null;
    }
  }

  public Contact getCreator() {
    return this.creator;
  }

  public void setCreator(Contact creator) {
    this.creator = creator;
  }

  public void unsetCreator() {
    this.creator = null;
  }

  /** Returns true if field creator is set (has been assigned a value) and false otherwise */
  public boolean isSetCreator() {
    return this.creator != null;
  }

  public void setCreatorIsSet(boolean value) {
    if (!value) {
      this.creator = null;
    }
  }

  public int getInviteeSize() {
    return (this.invitee == null) ? 0 : this.invitee.size();
  }

  public Enumeration getInviteeEnumeration() {
    return (this.invitee == null) ? null : this.invitee.elements();
  }

  public void addToInvitee(Contact elem) {
    if (this.invitee == null) {
      this.invitee = new Vector();
    }
    this.invitee.addElement(elem);
  }

  public Vector getInvitee() {
    return this.invitee;
  }

  public void setInvitee(Vector invitee) {
    this.invitee = invitee;
  }

  public void unsetInvitee() {
    this.invitee = null;
  }

  /** Returns true if field invitee is set (has been assigned a value) and false otherwise */
  public boolean isSetInvitee() {
    return this.invitee != null;
  }

  public void setInviteeIsSet(boolean value) {
    if (!value) {
      this.invitee = null;
    }
  }

  public boolean isNotificationDisabled() {
    return this.notificationDisabled;
  }

  public void setNotificationDisabled(boolean notificationDisabled) {
    this.notificationDisabled = notificationDisabled;
    setNotificationDisabledIsSet(true);
  }

  public void unsetNotificationDisabled() {
    __isset_vector[__NOTIFICATIONDISABLED_ISSET_ID] = false;
  }

  /** Returns true if field notificationDisabled is set (has been assigned a value) and false otherwise */
  public boolean isSetNotificationDisabled() {
    return __isset_vector[__NOTIFICATIONDISABLED_ISSET_ID];
  }

  public void setNotificationDisabledIsSet(boolean value) {
    __isset_vector[__NOTIFICATIONDISABLED_ISSET_ID] = value;
  }

  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Group)
      return this.equals((Group)that);
    return false;
  }

  public boolean equals(Group that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (!this.id.equals(that.id))
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

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_pictureStatus = true && this.isSetPictureStatus();
    boolean that_present_pictureStatus = true && that.isSetPictureStatus();
    if (this_present_pictureStatus || that_present_pictureStatus) {
      if (!(this_present_pictureStatus && that_present_pictureStatus))
        return false;
      if (!this.pictureStatus.equals(that.pictureStatus))
        return false;
    }

    boolean this_present_members = true && this.isSetMembers();
    boolean that_present_members = true && that.isSetMembers();
    if (this_present_members || that_present_members) {
      if (!(this_present_members && that_present_members))
        return false;
      if (!this.members.equals(that.members))
        return false;
    }

    boolean this_present_creator = true && this.isSetCreator();
    boolean that_present_creator = true && that.isSetCreator();
    if (this_present_creator || that_present_creator) {
      if (!(this_present_creator && that_present_creator))
        return false;
      if (!this.creator.equals(that.creator))
        return false;
    }

    boolean this_present_invitee = true && this.isSetInvitee();
    boolean that_present_invitee = true && that.isSetInvitee();
    if (this_present_invitee || that_present_invitee) {
      if (!(this_present_invitee && that_present_invitee))
        return false;
      if (!this.invitee.equals(that.invitee))
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

  public int hashCode() {
    return 0;
  }

  public int compareTo(Object otherObject) {
    if (!getClass().equals(otherObject.getClass())) {
      return getClass().getName().compareTo(otherObject.getClass().getName());
    }

    Group other = (Group)otherObject;    int lastComparison = 0;

    lastComparison = TBaseHelper.compareTo(isSetId(), other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = TBaseHelper.compareTo(isSetCreatedTime(), other.isSetCreatedTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCreatedTime()) {
      lastComparison = TBaseHelper.compareTo(this.createdTime, other.createdTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = TBaseHelper.compareTo(isSetName(), other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = TBaseHelper.compareTo(isSetPictureStatus(), other.isSetPictureStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPictureStatus()) {
      lastComparison = TBaseHelper.compareTo(this.pictureStatus, other.pictureStatus);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = TBaseHelper.compareTo(isSetMembers(), other.isSetMembers());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMembers()) {
      lastComparison = TBaseHelper.compareTo(this.members, other.members);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = TBaseHelper.compareTo(isSetCreator(), other.isSetCreator());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCreator()) {
      lastComparison = this.creator.compareTo(other.creator);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = TBaseHelper.compareTo(isSetInvitee(), other.isSetInvitee());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInvitee()) {
      lastComparison = TBaseHelper.compareTo(this.invitee, other.invitee);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = TBaseHelper.compareTo(isSetNotificationDisabled(), other.isSetNotificationDisabled());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNotificationDisabled()) {
      lastComparison = TBaseHelper.compareTo(this.notificationDisabled, other.notificationDisabled);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // ID
          if (field.type == TType.STRING) {
            this.id = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // CREATED_TIME
          if (field.type == TType.I64) {
            this.createdTime = iprot.readI64();
            setCreatedTimeIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 10: // NAME
          if (field.type == TType.STRING) {
            this.name = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 11: // PICTURE_STATUS
          if (field.type == TType.STRING) {
            this.pictureStatus = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 20: // MEMBERS
          if (field.type == TType.LIST) {
            {
              TList _list84 = iprot.readListBegin();
              this.members = new Vector(_list84.size);
              for (int _i85 = 0; _i85 < _list84.size; ++_i85)
              {
                Contact _elem86;
                _elem86 = new Contact();
                _elem86.read(iprot);
                this.members.addElement(_elem86);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 21: // CREATOR
          if (field.type == TType.STRUCT) {
            this.creator = new Contact();
            this.creator.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 22: // INVITEE
          if (field.type == TType.LIST) {
            {
              TList _list87 = iprot.readListBegin();
              this.invitee = new Vector(_list87.size);
              for (int _i88 = 0; _i88 < _list87.size; ++_i88)
              {
                Contact _elem89;
                _elem89 = new Contact();
                _elem89.read(iprot);
                this.invitee.addElement(_elem89);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 31: // NOTIFICATION_DISABLED
          if (field.type == TType.BOOL) {
            this.notificationDisabled = iprot.readBool();
            setNotificationDisabledIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.id != null) {
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeString(this.id);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(CREATED_TIME_FIELD_DESC);
    oprot.writeI64(this.createdTime);
    oprot.writeFieldEnd();
    if (this.name != null) {
      oprot.writeFieldBegin(NAME_FIELD_DESC);
      oprot.writeString(this.name);
      oprot.writeFieldEnd();
    }
    if (this.pictureStatus != null) {
      oprot.writeFieldBegin(PICTURE_STATUS_FIELD_DESC);
      oprot.writeString(this.pictureStatus);
      oprot.writeFieldEnd();
    }
    if (this.members != null) {
      oprot.writeFieldBegin(MEMBERS_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.STRUCT, this.members.size()));
        for (Enumeration _iter90_enum = this.members.elements(); _iter90_enum.hasMoreElements(); )         {
          Contact _iter90 = (Contact)_iter90_enum.nextElement();
          _iter90.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.creator != null) {
      oprot.writeFieldBegin(CREATOR_FIELD_DESC);
      this.creator.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.invitee != null) {
      oprot.writeFieldBegin(INVITEE_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.STRUCT, this.invitee.size()));
        for (Enumeration _iter91_enum = this.invitee.elements(); _iter91_enum.hasMoreElements(); )         {
          Contact _iter91 = (Contact)_iter91_enum.nextElement();
          _iter91.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(NOTIFICATION_DISABLED_FIELD_DESC);
    oprot.writeBool(this.notificationDisabled);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("Group(");
    boolean first = true;

    sb.append("id:");
    if (this.id == null) {
      sb.append("null");
    } else {
      sb.append(this.id);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("createdTime:");
    sb.append(this.createdTime);
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("pictureStatus:");
    if (this.pictureStatus == null) {
      sb.append("null");
    } else {
      sb.append(this.pictureStatus);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("members:");
    if (this.members == null) {
      sb.append("null");
    } else {
      sb.append(this.members);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("creator:");
    if (this.creator == null) {
      sb.append("null");
    } else {
      sb.append(this.creator);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("invitee:");
    if (this.invitee == null) {
      sb.append("null");
    } else {
      sb.append(this.invitee);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("notificationDisabled:");
    sb.append(this.notificationDisabled);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}
