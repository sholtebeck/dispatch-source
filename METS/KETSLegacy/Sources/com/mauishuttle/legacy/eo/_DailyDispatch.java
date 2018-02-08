// DO NOT EDIT.  Make changes to DailyDispatch.java instead.
package com.mauishuttle.legacy.eo;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _DailyDispatch extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "DailyDispatch";

  // Attribute Keys
  public static final ERXKey<Long> ACCOUNT_ID = new ERXKey<Long>("accountId");
  public static final ERXKey<String> BILLTYPE = new ERXKey<String>("billtype");
  public static final ERXKey<Long> BOOSTER = new ERXKey<Long>("booster");
  public static final ERXKey<java.math.BigDecimal> CARSEATFEE = new ERXKey<java.math.BigDecimal>("carseatfee");
  public static final ERXKey<java.math.BigDecimal> CASHAMOUNT = new ERXKey<java.math.BigDecimal>("cashamount");
  public static final ERXKey<java.math.BigDecimal> CCAMOUNT = new ERXKey<java.math.BigDecimal>("ccamount");
  public static final ERXKey<String> CCAPP = new ERXKey<String>("ccapp");
  public static final ERXKey<String> CCEXPDATE = new ERXKey<String>("ccexpdate");
  public static final ERXKey<String> CCNUMBER = new ERXKey<String>("ccnumber");
  public static final ERXKey<String> CCPHONE = new ERXKey<String>("ccphone");
  public static final ERXKey<String> CCTYPE = new ERXKey<String>("cctype");
  public static final ERXKey<Long> CHILDSEAT = new ERXKey<Long>("childseat");
  public static final ERXKey<String> CONFNUMBER = new ERXKey<String>("confnumber");
  public static final ERXKey<String> DEST_ID = new ERXKey<String>("destId");
  public static final ERXKey<Long> DRIVER_ID = new ERXKey<Long>("driverId");
  public static final ERXKey<String> DRIVERNOTES = new ERXKey<String>("drivernotes");
  public static final ERXKey<String> DROPOFFPERSON = new ERXKey<String>("dropoffperson");
  public static final ERXKey<String> DROPOFFTIME = new ERXKey<String>("dropofftime");
  public static final ERXKey<String> EMAILADDRESS = new ERXKey<String>("emailaddress");
  public static final ERXKey<String> ENTERDATE = new ERXKey<String>("enterdate");
  public static final ERXKey<String> ENTERED_BY = new ERXKey<String>("enteredBy");
  public static final ERXKey<String> FNAMEPARTY = new ERXKey<String>("fnameparty");
  public static final ERXKey<String> GREET = new ERXKey<String>("greet");
  public static final ERXKey<String> GROUPNAME = new ERXKey<String>("groupname");
  public static final ERXKey<Long> INFANT = new ERXKey<Long>("infant");
  public static final ERXKey<String> LNAMEPARTY = new ERXKey<String>("lnameparty");
  public static final ERXKey<Long> MISCFEE = new ERXKey<Long>("miscfee");
  public static final ERXKey<java.math.BigDecimal> MISCFEECHG = new ERXKey<java.math.BigDecimal>("miscfeechg");
  public static final ERXKey<String> MISCFEETYPE = new ERXKey<String>("miscfeetype");
  public static final ERXKey<String> NOTES = new ERXKey<String>("notes");
  public static final ERXKey<Long> NUMPASSENGERS = new ERXKey<Long>("numpassengers");
  public static final ERXKey<String> OLDBILLINGREMARKS = new ERXKey<String>("oldbillingremarks");
  public static final ERXKey<NSTimestamp> PUDATE = new ERXKey<NSTimestamp>("pudate");
  public static final ERXKey<String> PULOCATION = new ERXKey<String>("pulocation");
  public static final ERXKey<NSTimestamp> PUTIME = new ERXKey<NSTimestamp>("putime");
  public static final ERXKey<NSTimestamp> RESDATE = new ERXKey<NSTimestamp>("resdate");
  public static final ERXKey<Long> RESID = new ERXKey<Long>("resid");
  public static final ERXKey<Long> RTRIP = new ERXKey<Long>("rtrip");
  public static final ERXKey<java.math.BigDecimal> SERVICEORDERAMOUNT = new ERXKey<java.math.BigDecimal>("serviceorderamount");
  public static final ERXKey<String> SERVICE_TYPE = new ERXKey<String>("serviceType");
  public static final ERXKey<Long> STATUS = new ERXKey<Long>("status");
  public static final ERXKey<java.math.BigDecimal> TIPAMOUNT = new ERXKey<java.math.BigDecimal>("tipamount");
  public static final ERXKey<Long> TODDLER = new ERXKey<Long>("toddler");
  public static final ERXKey<String> UPDATED_BY = new ERXKey<String>("updatedBy");
  public static final ERXKey<java.math.BigDecimal> VOUCHERAMOUNT = new ERXKey<java.math.BigDecimal>("voucheramount");
  public static final ERXKey<String> VOUCHERNUMBER = new ERXKey<String>("vouchernumber");
  // Relationship Keys
  public static final ERXKey<com.mauishuttle.legacy.eo.Accounts> ACCOUNT = new ERXKey<com.mauishuttle.legacy.eo.Accounts>("account");
  public static final ERXKey<com.mauishuttle.legacy.eo.Driver> DRIVER = new ERXKey<com.mauishuttle.legacy.eo.Driver>("driver");
  public static final ERXKey<com.mauishuttle.legacy.eo.User> USER = new ERXKey<com.mauishuttle.legacy.eo.User>("user");

  // Attributes
  public static final String ACCOUNT_ID_KEY = ACCOUNT_ID.key();
  public static final String BILLTYPE_KEY = BILLTYPE.key();
  public static final String BOOSTER_KEY = BOOSTER.key();
  public static final String CARSEATFEE_KEY = CARSEATFEE.key();
  public static final String CASHAMOUNT_KEY = CASHAMOUNT.key();
  public static final String CCAMOUNT_KEY = CCAMOUNT.key();
  public static final String CCAPP_KEY = CCAPP.key();
  public static final String CCEXPDATE_KEY = CCEXPDATE.key();
  public static final String CCNUMBER_KEY = CCNUMBER.key();
  public static final String CCPHONE_KEY = CCPHONE.key();
  public static final String CCTYPE_KEY = CCTYPE.key();
  public static final String CHILDSEAT_KEY = CHILDSEAT.key();
  public static final String CONFNUMBER_KEY = CONFNUMBER.key();
  public static final String DEST_ID_KEY = DEST_ID.key();
  public static final String DRIVER_ID_KEY = DRIVER_ID.key();
  public static final String DRIVERNOTES_KEY = DRIVERNOTES.key();
  public static final String DROPOFFPERSON_KEY = DROPOFFPERSON.key();
  public static final String DROPOFFTIME_KEY = DROPOFFTIME.key();
  public static final String EMAILADDRESS_KEY = EMAILADDRESS.key();
  public static final String ENTERDATE_KEY = ENTERDATE.key();
  public static final String ENTERED_BY_KEY = ENTERED_BY.key();
  public static final String FNAMEPARTY_KEY = FNAMEPARTY.key();
  public static final String GREET_KEY = GREET.key();
  public static final String GROUPNAME_KEY = GROUPNAME.key();
  public static final String INFANT_KEY = INFANT.key();
  public static final String LNAMEPARTY_KEY = LNAMEPARTY.key();
  public static final String MISCFEE_KEY = MISCFEE.key();
  public static final String MISCFEECHG_KEY = MISCFEECHG.key();
  public static final String MISCFEETYPE_KEY = MISCFEETYPE.key();
  public static final String NOTES_KEY = NOTES.key();
  public static final String NUMPASSENGERS_KEY = NUMPASSENGERS.key();
  public static final String OLDBILLINGREMARKS_KEY = OLDBILLINGREMARKS.key();
  public static final String PUDATE_KEY = PUDATE.key();
  public static final String PULOCATION_KEY = PULOCATION.key();
  public static final String PUTIME_KEY = PUTIME.key();
  public static final String RESDATE_KEY = RESDATE.key();
  public static final String RESID_KEY = RESID.key();
  public static final String RTRIP_KEY = RTRIP.key();
  public static final String SERVICEORDERAMOUNT_KEY = SERVICEORDERAMOUNT.key();
  public static final String SERVICE_TYPE_KEY = SERVICE_TYPE.key();
  public static final String STATUS_KEY = STATUS.key();
  public static final String TIPAMOUNT_KEY = TIPAMOUNT.key();
  public static final String TODDLER_KEY = TODDLER.key();
  public static final String UPDATED_BY_KEY = UPDATED_BY.key();
  public static final String VOUCHERAMOUNT_KEY = VOUCHERAMOUNT.key();
  public static final String VOUCHERNUMBER_KEY = VOUCHERNUMBER.key();
  // Relationships
  public static final String ACCOUNT_KEY = ACCOUNT.key();
  public static final String DRIVER_KEY = DRIVER.key();
  public static final String USER_KEY = USER.key();

  private static Logger LOG = Logger.getLogger(_DailyDispatch.class);

  public DailyDispatch localInstanceIn(EOEditingContext editingContext) {
    DailyDispatch localInstance = (DailyDispatch)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Long accountId() {
    return (Long) storedValueForKey(_DailyDispatch.ACCOUNT_ID_KEY);
  }

  public void setAccountId(Long value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating accountId from " + accountId() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.ACCOUNT_ID_KEY);
  }

  public String billtype() {
    return (String) storedValueForKey(_DailyDispatch.BILLTYPE_KEY);
  }

  public void setBilltype(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating billtype from " + billtype() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.BILLTYPE_KEY);
  }

  public Long booster() {
    return (Long) storedValueForKey(_DailyDispatch.BOOSTER_KEY);
  }

  public void setBooster(Long value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating booster from " + booster() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.BOOSTER_KEY);
  }

  public java.math.BigDecimal carseatfee() {
    return (java.math.BigDecimal) storedValueForKey(_DailyDispatch.CARSEATFEE_KEY);
  }

  public void setCarseatfee(java.math.BigDecimal value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating carseatfee from " + carseatfee() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.CARSEATFEE_KEY);
  }

  public java.math.BigDecimal cashamount() {
    return (java.math.BigDecimal) storedValueForKey(_DailyDispatch.CASHAMOUNT_KEY);
  }

  public void setCashamount(java.math.BigDecimal value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating cashamount from " + cashamount() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.CASHAMOUNT_KEY);
  }

  public java.math.BigDecimal ccamount() {
    return (java.math.BigDecimal) storedValueForKey(_DailyDispatch.CCAMOUNT_KEY);
  }

  public void setCcamount(java.math.BigDecimal value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating ccamount from " + ccamount() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.CCAMOUNT_KEY);
  }

  public String ccapp() {
    return (String) storedValueForKey(_DailyDispatch.CCAPP_KEY);
  }

  public void setCcapp(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating ccapp from " + ccapp() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.CCAPP_KEY);
  }

  public String ccexpdate() {
    return (String) storedValueForKey(_DailyDispatch.CCEXPDATE_KEY);
  }

  public void setCcexpdate(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating ccexpdate from " + ccexpdate() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.CCEXPDATE_KEY);
  }

  public String ccnumber() {
    return (String) storedValueForKey(_DailyDispatch.CCNUMBER_KEY);
  }

  public void setCcnumber(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating ccnumber from " + ccnumber() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.CCNUMBER_KEY);
  }

  public String ccphone() {
    return (String) storedValueForKey(_DailyDispatch.CCPHONE_KEY);
  }

  public void setCcphone(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating ccphone from " + ccphone() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.CCPHONE_KEY);
  }

  public String cctype() {
    return (String) storedValueForKey(_DailyDispatch.CCTYPE_KEY);
  }

  public void setCctype(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating cctype from " + cctype() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.CCTYPE_KEY);
  }

  public Long childseat() {
    return (Long) storedValueForKey(_DailyDispatch.CHILDSEAT_KEY);
  }

  public void setChildseat(Long value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating childseat from " + childseat() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.CHILDSEAT_KEY);
  }

  public String confnumber() {
    return (String) storedValueForKey(_DailyDispatch.CONFNUMBER_KEY);
  }

  public void setConfnumber(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating confnumber from " + confnumber() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.CONFNUMBER_KEY);
  }

  public String destId() {
    return (String) storedValueForKey(_DailyDispatch.DEST_ID_KEY);
  }

  public void setDestId(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating destId from " + destId() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.DEST_ID_KEY);
  }

  public Long driverId() {
    return (Long) storedValueForKey(_DailyDispatch.DRIVER_ID_KEY);
  }

  public void setDriverId(Long value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating driverId from " + driverId() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.DRIVER_ID_KEY);
  }

  public String drivernotes() {
    return (String) storedValueForKey(_DailyDispatch.DRIVERNOTES_KEY);
  }

  public void setDrivernotes(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating drivernotes from " + drivernotes() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.DRIVERNOTES_KEY);
  }

  public String dropoffperson() {
    return (String) storedValueForKey(_DailyDispatch.DROPOFFPERSON_KEY);
  }

  public void setDropoffperson(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating dropoffperson from " + dropoffperson() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.DROPOFFPERSON_KEY);
  }

  public String dropofftime() {
    return (String) storedValueForKey(_DailyDispatch.DROPOFFTIME_KEY);
  }

  public void setDropofftime(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating dropofftime from " + dropofftime() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.DROPOFFTIME_KEY);
  }

  public String emailaddress() {
    return (String) storedValueForKey(_DailyDispatch.EMAILADDRESS_KEY);
  }

  public void setEmailaddress(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating emailaddress from " + emailaddress() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.EMAILADDRESS_KEY);
  }

  public String enterdate() {
    return (String) storedValueForKey(_DailyDispatch.ENTERDATE_KEY);
  }

  public void setEnterdate(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating enterdate from " + enterdate() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.ENTERDATE_KEY);
  }

  public String enteredBy() {
    return (String) storedValueForKey(_DailyDispatch.ENTERED_BY_KEY);
  }

  public void setEnteredBy(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating enteredBy from " + enteredBy() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.ENTERED_BY_KEY);
  }

  public String fnameparty() {
    return (String) storedValueForKey(_DailyDispatch.FNAMEPARTY_KEY);
  }

  public void setFnameparty(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating fnameparty from " + fnameparty() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.FNAMEPARTY_KEY);
  }

  public String greet() {
    return (String) storedValueForKey(_DailyDispatch.GREET_KEY);
  }

  public void setGreet(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating greet from " + greet() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.GREET_KEY);
  }

  public String groupname() {
    return (String) storedValueForKey(_DailyDispatch.GROUPNAME_KEY);
  }

  public void setGroupname(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating groupname from " + groupname() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.GROUPNAME_KEY);
  }

  public Long infant() {
    return (Long) storedValueForKey(_DailyDispatch.INFANT_KEY);
  }

  public void setInfant(Long value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating infant from " + infant() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.INFANT_KEY);
  }

  public String lnameparty() {
    return (String) storedValueForKey(_DailyDispatch.LNAMEPARTY_KEY);
  }

  public void setLnameparty(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating lnameparty from " + lnameparty() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.LNAMEPARTY_KEY);
  }

  public Long miscfee() {
    return (Long) storedValueForKey(_DailyDispatch.MISCFEE_KEY);
  }

  public void setMiscfee(Long value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating miscfee from " + miscfee() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.MISCFEE_KEY);
  }

  public java.math.BigDecimal miscfeechg() {
    return (java.math.BigDecimal) storedValueForKey(_DailyDispatch.MISCFEECHG_KEY);
  }

  public void setMiscfeechg(java.math.BigDecimal value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating miscfeechg from " + miscfeechg() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.MISCFEECHG_KEY);
  }

  public String miscfeetype() {
    return (String) storedValueForKey(_DailyDispatch.MISCFEETYPE_KEY);
  }

  public void setMiscfeetype(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating miscfeetype from " + miscfeetype() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.MISCFEETYPE_KEY);
  }

  public String notes() {
    return (String) storedValueForKey(_DailyDispatch.NOTES_KEY);
  }

  public void setNotes(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating notes from " + notes() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.NOTES_KEY);
  }

  public Long numpassengers() {
    return (Long) storedValueForKey(_DailyDispatch.NUMPASSENGERS_KEY);
  }

  public void setNumpassengers(Long value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating numpassengers from " + numpassengers() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.NUMPASSENGERS_KEY);
  }

  public String oldbillingremarks() {
    return (String) storedValueForKey(_DailyDispatch.OLDBILLINGREMARKS_KEY);
  }

  public void setOldbillingremarks(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating oldbillingremarks from " + oldbillingremarks() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.OLDBILLINGREMARKS_KEY);
  }

  public NSTimestamp pudate() {
    return (NSTimestamp) storedValueForKey(_DailyDispatch.PUDATE_KEY);
  }

  public void setPudate(NSTimestamp value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating pudate from " + pudate() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.PUDATE_KEY);
  }

  public String pulocation() {
    return (String) storedValueForKey(_DailyDispatch.PULOCATION_KEY);
  }

  public void setPulocation(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating pulocation from " + pulocation() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.PULOCATION_KEY);
  }

  public NSTimestamp putime() {
    return (NSTimestamp) storedValueForKey(_DailyDispatch.PUTIME_KEY);
  }

  public void setPutime(NSTimestamp value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating putime from " + putime() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.PUTIME_KEY);
  }

  public NSTimestamp resdate() {
    return (NSTimestamp) storedValueForKey(_DailyDispatch.RESDATE_KEY);
  }

  public void setResdate(NSTimestamp value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating resdate from " + resdate() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.RESDATE_KEY);
  }

  public Long resid() {
    return (Long) storedValueForKey(_DailyDispatch.RESID_KEY);
  }

  public void setResid(Long value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating resid from " + resid() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.RESID_KEY);
  }

  public Long rtrip() {
    return (Long) storedValueForKey(_DailyDispatch.RTRIP_KEY);
  }

  public void setRtrip(Long value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating rtrip from " + rtrip() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.RTRIP_KEY);
  }

  public java.math.BigDecimal serviceorderamount() {
    return (java.math.BigDecimal) storedValueForKey(_DailyDispatch.SERVICEORDERAMOUNT_KEY);
  }

  public void setServiceorderamount(java.math.BigDecimal value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating serviceorderamount from " + serviceorderamount() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.SERVICEORDERAMOUNT_KEY);
  }

  public String serviceType() {
    return (String) storedValueForKey(_DailyDispatch.SERVICE_TYPE_KEY);
  }

  public void setServiceType(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating serviceType from " + serviceType() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.SERVICE_TYPE_KEY);
  }

  public Long status() {
    return (Long) storedValueForKey(_DailyDispatch.STATUS_KEY);
  }

  public void setStatus(Long value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating status from " + status() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.STATUS_KEY);
  }

  public java.math.BigDecimal tipamount() {
    return (java.math.BigDecimal) storedValueForKey(_DailyDispatch.TIPAMOUNT_KEY);
  }

  public void setTipamount(java.math.BigDecimal value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating tipamount from " + tipamount() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.TIPAMOUNT_KEY);
  }

  public Long toddler() {
    return (Long) storedValueForKey(_DailyDispatch.TODDLER_KEY);
  }

  public void setToddler(Long value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating toddler from " + toddler() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.TODDLER_KEY);
  }

  public String updatedBy() {
    return (String) storedValueForKey(_DailyDispatch.UPDATED_BY_KEY);
  }

  public void setUpdatedBy(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating updatedBy from " + updatedBy() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.UPDATED_BY_KEY);
  }

  public java.math.BigDecimal voucheramount() {
    return (java.math.BigDecimal) storedValueForKey(_DailyDispatch.VOUCHERAMOUNT_KEY);
  }

  public void setVoucheramount(java.math.BigDecimal value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating voucheramount from " + voucheramount() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.VOUCHERAMOUNT_KEY);
  }

  public String vouchernumber() {
    return (String) storedValueForKey(_DailyDispatch.VOUCHERNUMBER_KEY);
  }

  public void setVouchernumber(String value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
    	_DailyDispatch.LOG.debug( "updating vouchernumber from " + vouchernumber() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatch.VOUCHERNUMBER_KEY);
  }

  public com.mauishuttle.legacy.eo.Accounts account() {
    return (com.mauishuttle.legacy.eo.Accounts)storedValueForKey(_DailyDispatch.ACCOUNT_KEY);
  }
  
  public void setAccount(com.mauishuttle.legacy.eo.Accounts value) {
    takeStoredValueForKey(value, _DailyDispatch.ACCOUNT_KEY);
  }

  public void setAccountRelationship(com.mauishuttle.legacy.eo.Accounts value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
      _DailyDispatch.LOG.debug("updating account from " + account() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setAccount(value);
    }
    else if (value == null) {
    	com.mauishuttle.legacy.eo.Accounts oldValue = account();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _DailyDispatch.ACCOUNT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _DailyDispatch.ACCOUNT_KEY);
    }
  }
  
  public com.mauishuttle.legacy.eo.Driver driver() {
    return (com.mauishuttle.legacy.eo.Driver)storedValueForKey(_DailyDispatch.DRIVER_KEY);
  }
  
  public void setDriver(com.mauishuttle.legacy.eo.Driver value) {
    takeStoredValueForKey(value, _DailyDispatch.DRIVER_KEY);
  }

  public void setDriverRelationship(com.mauishuttle.legacy.eo.Driver value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
      _DailyDispatch.LOG.debug("updating driver from " + driver() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setDriver(value);
    }
    else if (value == null) {
    	com.mauishuttle.legacy.eo.Driver oldValue = driver();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _DailyDispatch.DRIVER_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _DailyDispatch.DRIVER_KEY);
    }
  }
  
  public com.mauishuttle.legacy.eo.User user() {
    return (com.mauishuttle.legacy.eo.User)storedValueForKey(_DailyDispatch.USER_KEY);
  }
  
  public void setUser(com.mauishuttle.legacy.eo.User value) {
    takeStoredValueForKey(value, _DailyDispatch.USER_KEY);
  }

  public void setUserRelationship(com.mauishuttle.legacy.eo.User value) {
    if (_DailyDispatch.LOG.isDebugEnabled()) {
      _DailyDispatch.LOG.debug("updating user from " + user() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setUser(value);
    }
    else if (value == null) {
    	com.mauishuttle.legacy.eo.User oldValue = user();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _DailyDispatch.USER_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _DailyDispatch.USER_KEY);
    }
  }
  

  public static DailyDispatch createDailyDispatch(EOEditingContext editingContext, Long resid
) {
    DailyDispatch eo = (DailyDispatch) EOUtilities.createAndInsertInstance(editingContext, _DailyDispatch.ENTITY_NAME);    
		eo.setResid(resid);
    return eo;
  }

  public static ERXFetchSpecification<DailyDispatch> fetchSpec() {
    return new ERXFetchSpecification<DailyDispatch>(_DailyDispatch.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<DailyDispatch> fetchAllDailyDispatchs(EOEditingContext editingContext) {
    return _DailyDispatch.fetchAllDailyDispatchs(editingContext, null);
  }

  public static NSArray<DailyDispatch> fetchAllDailyDispatchs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _DailyDispatch.fetchDailyDispatchs(editingContext, null, sortOrderings);
  }

  public static NSArray<DailyDispatch> fetchDailyDispatchs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<DailyDispatch> fetchSpec = new ERXFetchSpecification<DailyDispatch>(_DailyDispatch.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<DailyDispatch> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static DailyDispatch fetchDailyDispatch(EOEditingContext editingContext, String keyName, Object value) {
    return _DailyDispatch.fetchDailyDispatch(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static DailyDispatch fetchDailyDispatch(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<DailyDispatch> eoObjects = _DailyDispatch.fetchDailyDispatchs(editingContext, qualifier, null);
    DailyDispatch eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one DailyDispatch that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static DailyDispatch fetchRequiredDailyDispatch(EOEditingContext editingContext, String keyName, Object value) {
    return _DailyDispatch.fetchRequiredDailyDispatch(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static DailyDispatch fetchRequiredDailyDispatch(EOEditingContext editingContext, EOQualifier qualifier) {
    DailyDispatch eoObject = _DailyDispatch.fetchDailyDispatch(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no DailyDispatch that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static DailyDispatch localInstanceIn(EOEditingContext editingContext, DailyDispatch eo) {
    DailyDispatch localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}