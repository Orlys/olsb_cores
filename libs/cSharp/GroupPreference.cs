/**
 * Compiled for SuperSonic Line API Lite
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
using System.IO;
using Thrift;
using Thrift.Collections;
using System.Runtime.Serialization;
using Thrift.Protocol;
using Thrift.Transport;


#if !SILVERLIGHT
[Serializable]
#endif
public partial class GroupPreference : TBase
{
  private string _invitationTicket;
  private long _favoriteTimestamp;

  public string InvitationTicket
  {
    get
    {
      return _invitationTicket;
    }
    set
    {
      __isset.invitationTicket = true;
      this._invitationTicket = value;
    }
  }

  public long FavoriteTimestamp
  {
    get
    {
      return _favoriteTimestamp;
    }
    set
    {
      __isset.favoriteTimestamp = true;
      this._favoriteTimestamp = value;
    }
  }


  public Isset __isset;
  #if !SILVERLIGHT
  [Serializable]
  #endif
  public struct Isset {
    public bool invitationTicket;
    public bool favoriteTimestamp;
  }

  public GroupPreference() {
  }

  public void Read (TProtocol iprot)
  {
    iprot.IncrementRecursionDepth();
    try
    {
      TField field;
      iprot.ReadStructBegin();
      while (true)
      {
        field = iprot.ReadFieldBegin();
        if (field.Type == TType.Stop) { 
          break;
        }
        switch (field.ID)
        {
          case 1:
            if (field.Type == TType.String) {
              InvitationTicket = iprot.ReadString();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 2:
            if (field.Type == TType.I64) {
              FavoriteTimestamp = iprot.ReadI64();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          default: 
            TProtocolUtil.Skip(iprot, field.Type);
            break;
        }
        iprot.ReadFieldEnd();
      }
      iprot.ReadStructEnd();
    }
    finally
    {
      iprot.DecrementRecursionDepth();
    }
  }

  public void Write(TProtocol oprot) {
    oprot.IncrementRecursionDepth();
    try
    {
      TStruct struc = new TStruct("GroupPreference");
      oprot.WriteStructBegin(struc);
      TField field = new TField();
      if (InvitationTicket != null && __isset.invitationTicket) {
        field.Name = "invitationTicket";
        field.Type = TType.String;
        field.ID = 1;
        oprot.WriteFieldBegin(field);
        oprot.WriteString(InvitationTicket);
        oprot.WriteFieldEnd();
      }
      if (__isset.favoriteTimestamp) {
        field.Name = "favoriteTimestamp";
        field.Type = TType.I64;
        field.ID = 2;
        oprot.WriteFieldBegin(field);
        oprot.WriteI64(FavoriteTimestamp);
        oprot.WriteFieldEnd();
      }
      oprot.WriteFieldStop();
      oprot.WriteStructEnd();
    }
    finally
    {
      oprot.DecrementRecursionDepth();
    }
  }

  public override string ToString() {
    StringBuilder __sb = new StringBuilder("GroupPreference(");
    bool __first = true;
    if (InvitationTicket != null && __isset.invitationTicket) {
      if(!__first) { __sb.Append(", "); }
      __first = false;
      __sb.Append("InvitationTicket: ");
      __sb.Append(InvitationTicket);
    }
    if (__isset.favoriteTimestamp) {
      if(!__first) { __sb.Append(", "); }
      __first = false;
      __sb.Append("FavoriteTimestamp: ");
      __sb.Append(FavoriteTimestamp);
    }
    __sb.Append(")");
    return __sb.ToString();
  }

}
