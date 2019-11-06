/**
 * Autogenerated by Thrift Compiler (0.14.0)
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
public partial class EmailConfirmationSession : TBase
{
  private EmailConfirmationType _emailConfirmationType;
  private string _verifier;
  private string _targetEmail;

  /// <summary>
  /// 
  /// <seealso cref="EmailConfirmationType"/>
  /// </summary>
  public EmailConfirmationType EmailConfirmationType
  {
    get
    {
      return _emailConfirmationType;
    }
    set
    {
      __isset.emailConfirmationType = true;
      this._emailConfirmationType = value;
    }
  }

  public string Verifier
  {
    get
    {
      return _verifier;
    }
    set
    {
      __isset.verifier = true;
      this._verifier = value;
    }
  }

  public string TargetEmail
  {
    get
    {
      return _targetEmail;
    }
    set
    {
      __isset.targetEmail = true;
      this._targetEmail = value;
    }
  }


  public Isset __isset;
  #if !SILVERLIGHT
  [Serializable]
  #endif
  public struct Isset {
    public bool emailConfirmationType;
    public bool verifier;
    public bool targetEmail;
  }

  public EmailConfirmationSession() {
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
            if (field.Type == TType.I32) {
              EmailConfirmationType = (EmailConfirmationType)iprot.ReadI32();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 2:
            if (field.Type == TType.String) {
              Verifier = iprot.ReadString();
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 3:
            if (field.Type == TType.String) {
              TargetEmail = iprot.ReadString();
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
      TStruct struc = new TStruct("EmailConfirmationSession");
      oprot.WriteStructBegin(struc);
      TField field = new TField();
      if (__isset.emailConfirmationType) {
        field.Name = "emailConfirmationType";
        field.Type = TType.I32;
        field.ID = 1;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32((int)EmailConfirmationType);
        oprot.WriteFieldEnd();
      }
      if (Verifier != null && __isset.verifier) {
        field.Name = "verifier";
        field.Type = TType.String;
        field.ID = 2;
        oprot.WriteFieldBegin(field);
        oprot.WriteString(Verifier);
        oprot.WriteFieldEnd();
      }
      if (TargetEmail != null && __isset.targetEmail) {
        field.Name = "targetEmail";
        field.Type = TType.String;
        field.ID = 3;
        oprot.WriteFieldBegin(field);
        oprot.WriteString(TargetEmail);
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
    StringBuilder __sb = new StringBuilder("EmailConfirmationSession(");
    bool __first = true;
    if (__isset.emailConfirmationType) {
      if(!__first) { __sb.Append(", "); }
      __first = false;
      __sb.Append("EmailConfirmationType: ");
      __sb.Append(EmailConfirmationType);
    }
    if (Verifier != null && __isset.verifier) {
      if(!__first) { __sb.Append(", "); }
      __first = false;
      __sb.Append("Verifier: ");
      __sb.Append(Verifier);
    }
    if (TargetEmail != null && __isset.targetEmail) {
      if(!__first) { __sb.Append(", "); }
      __first = false;
      __sb.Append("TargetEmail: ");
      __sb.Append(TargetEmail);
    }
    __sb.Append(")");
    return __sb.ToString();
  }

}
