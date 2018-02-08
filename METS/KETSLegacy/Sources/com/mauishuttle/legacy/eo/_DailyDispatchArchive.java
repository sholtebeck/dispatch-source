// DO NOT EDIT.  Make changes to DailyDispatchArchive.java instead.
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
public abstract class _DailyDispatchArchive extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "DailyDispatchArchive";

  // Attribute Keys
  public static final ERXKey<Long> ACCOUNT_ID = new ERXKey<Long>("accountId");
  public static final ERXKey<String> BILLTYPE = new ERXKey<String>("billtype");
  public static final ERXKey<Long> CHILDSEAT = new ERXKey<Long>("childseat");
  public static final ERXKey<String> CONFNUMBER = new ERXKey<String>("confnumber");
  public static final ERXKey<String> DEST_ID = new ERXKey<String>("destId");
  public static final ERXKey<Long> DRIVER_ID = new ERXKey<Long>("driverId");
  public static final ERXKey<String> EMAILADDRESS = new ERXKey<String>("emailaddress");
  public static final ERXKey<String> ENTERDATE = new ERXKey<String>("enterdate");
  public static final ERXKey<String> ENTERED_BY = new ERXKey<String>("enteredBy");
  public static final ERXKey<String> FNAMEPARTY = new ERXKey<String>("fnameparty");
  public static final ERXKey<String> GREET = new ERXKey<String>("greet");
  public static final ERXKey<String> LNAMEPARTY = new ERXKey<String>("lnameparty");
  public static final ERXKey<String> NOTES = new ERXKey<String>("notes");
  public static final ERXKey<Long> NUMPASSENGERS = new ERXKey<Long>("numpassengers");
  public static final ERXKey<NSTimestamp> PUDATE = new ERXKey<NSTimestamp>("pudate");
  public static final ERXKey<String> PULOCATION = new ERXKey<String>("pulocation");
  public static final ERXKey<NSTimestamp> PUTIME = new ERXKey<NSTimestamp>("putime");
  public static final ERXKey<NSTimestamp> RESDATE = new ERXKey<NSTimestamp>("resdate");
  public static final ERXKey<Long> RESID = new ERXKey<Long>("resid");
  public static final ERXKey<String> SERVICE_TYPE = new ERXKey<String>("serviceType");
  public static final ERXKey<Long> STATUS = new ERXKey<Long>("status");
  public static final ERXKey<String> UPDATED_BY = new ERXKey<String>("updatedBy");
  // Relationship Keys

  // Attributes
  public static final String ACCOUNT_ID_KEY = ACCOUNT_ID.key();
  public static final String BILLTYPE_KEY = BILLTYPE.key();
  public static final String CHILDSEAT_KEY = CHILDSEAT.key();
  public static final String CONFNUMBER_KEY = CONFNUMBER.key();
  public static final String DEST_ID_KEY = DEST_ID.key();
  public static final String DRIVER_ID_KEY = DRIVER_ID.key();
  public static final String EMAILADDRESS_KEY = EMAILADDRESS.key();
  public static final String ENTERDATE_KEY = ENTERDATE.key();
  public static final String ENTERED_BY_KEY = ENTERED_BY.key();
  public static final String FNAMEPARTY_KEY = FNAMEPARTY.key();
  public static final String GREET_KEY = GREET.key();
  public static final String LNAMEPARTY_KEY = LNAMEPARTY.key();
  public static final String NOTES_KEY = NOTES.key();
  public static final String NUMPASSENGERS_KEY = NUMPASSENGERS.key();
  public static final String PUDATE_KEY = PUDATE.key();
  public static final String PULOCATION_KEY = PULOCATION.key();
  public static final String PUTIME_KEY = PUTIME.key();
  public static final String RESDATE_KEY = RESDATE.key();
  public static final String RESID_KEY = RESID.key();
  public static final String SERVICE_TYPE_KEY = SERVICE_TYPE.key();
  public static final String STATUS_KEY = STATUS.key();
  public static final String UPDATED_BY_KEY = UPDATED_BY.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_DailyDispatchArchive.class);

  public DailyDispatchArchive localInstanceIn(EOEditingContext editingContext) {
    DailyDispatchArchive localInstance = (DailyDispatchArchive)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Long accountId() {
    return (Long) storedValueForKey(_DailyDispatchArchive.ACCOUNT_ID_KEY);
  }

  public void setAccountId(Long value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating accountId from " + accountId() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.ACCOUNT_ID_KEY);
  }

  public String billtype() {
    return (String) storedValueForKey(_DailyDispatchArchive.BILLTYPE_KEY);
  }

  public void setBilltype(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating billtype from " + billtype() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.BILLTYPE_KEY);
  }

  public Long childseat() {
    return (Long) storedValueForKey(_DailyDispatchArchive.CHILDSEAT_KEY);
  }

  public void setChildseat(Long value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating childseat from " + childseat() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.CHILDSEAT_KEY);
  }

  public String confnumber() {
    return (String) storedValueForKey(_DailyDispatchArchive.CONFNUMBER_KEY);
  }

  public void setConfnumber(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating confnumber from " + confnumber() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.CONFNUMBER_KEY);
  }

  public String destId() {
    return (String) storedValueForKey(_DailyDispatchArchive.DEST_ID_KEY);
  }

  public void setDestId(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating destId from " + destId() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.DEST_ID_KEY);
  }

  public Long driverId() {
    return (Long) storedValueForKey(_DailyDispatchArchive.DRIVER_ID_KEY);
  }

  public void setDriverId(Long value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating driverId from " + driverId() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.DRIVER_ID_KEY);
  }

  public String emailaddress() {
    return (String) storedValueForKey(_DailyDispatchArchive.EMAILADDRESS_KEY);
  }

  public void setEmailaddress(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating emailaddress from " + emailaddress() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.EMAILADDRESS_KEY);
  }

  public String enterdate() {
    return (String) storedValueForKey(_DailyDispatchArchive.ENTERDATE_KEY);
  }

  public void setEnterdate(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating enterdate from " + enterdate() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.ENTERDATE_KEY);
  }

  public String enteredBy() {
    return (String) storedValueForKey(_DailyDispatchArchive.ENTERED_BY_KEY);
  }

  public void setEnteredBy(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating enteredBy from " + enteredBy() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.ENTERED_BY_KEY);
  }

  public String fnameparty() {
    return (String) storedValueForKey(_DailyDispatchArchive.FNAMEPARTY_KEY);
  }

  public void setFnameparty(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating fnameparty from " + fnameparty() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.FNAMEPARTY_KEY);
  }

  public String greet() {
    return (String) storedValueForKey(_DailyDispatchArchive.GREET_KEY);
  }

  public void setGreet(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating greet from " + greet() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.GREET_KEY);
  }

  public String lnameparty() {
    return (String) storedValueForKey(_DailyDispatchArchive.LNAMEPARTY_KEY);
  }

  public void setLnameparty(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating lnameparty from " + lnameparty() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.LNAMEPARTY_KEY);
  }

  public String notes() {
    return (String) storedValueForKey(_DailyDispatchArchive.NOTES_KEY);
  }

  public void setNotes(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating notes from " + notes() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.NOTES_KEY);
  }

  public Long numpassengers() {
    return (Long) storedValueForKey(_DailyDispatchArchive.NUMPASSENGERS_KEY);
  }

  public void setNumpassengers(Long value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating numpassengers from " + numpassengers() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.NUMPASSENGERS_KEY);
  }

  public NSTimestamp pudate() {
    return (NSTimestamp) storedValueForKey(_DailyDispatchArchive.PUDATE_KEY);
  }

  public void setPudate(NSTimestamp value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating pudate from " + pudate() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.PUDATE_KEY);
  }

  public String pulocation() {
    return (String) storedValueForKey(_DailyDispatchArchive.PULOCATION_KEY);
  }

  public void setPulocation(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating pulocation from " + pulocation() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.PULOCATION_KEY);
  }

  public NSTimestamp putime() {
    return (NSTimestamp) storedValueForKey(_DailyDispatchArchive.PUTIME_KEY);
  }

  public void setPutime(NSTimestamp value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating putime from " + putime() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.PUTIME_KEY);
  }

  public NSTimestamp resdate() {
    return (NSTimestamp) storedValueForKey(_DailyDispatchArchive.RESDATE_KEY);
  }

  public void setResdate(NSTimestamp value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating resdate from " + resdate() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.RESDATE_KEY);
  }

  public Long resid() {
    return (Long) storedValueForKey(_DailyDispatchArchive.RESID_KEY);
  }

  public void setResid(Long value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating resid from " + resid() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.RESID_KEY);
  }

  public String serviceType() {
    return (String) storedValueForKey(_DailyDispatchArchive.SERVICE_TYPE_KEY);
  }

  public void setServiceType(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating serviceType from " + serviceType() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.SERVICE_TYPE_KEY);
  }

  public Long status() {
    return (Long) storedValueForKey(_DailyDispatchArchive.STATUS_KEY);
  }

  public void setStatus(Long value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating status from " + status() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.STATUS_KEY);
  }

  public String updatedBy() {
    return (String) storedValueForKey(_DailyDispatchArchive.UPDATED_BY_KEY);
  }

  public void setUpdatedBy(String value) {
    if (_DailyDispatchArchive.LOG.isDebugEnabled()) {
    	_DailyDispatchArchive.LOG.debug( "updating updatedBy from " + updatedBy() + " to " + value);
    }
    takeStoredValueForKey(value, _DailyDispatchArchive.UPDATED_BY_KEY);
  }


  public static DailyDispatchArchive createDailyDispatchArchive(EOEditingContext editingContext, String billtype
, Long childseat
, String emailaddress
, String enterdate
, String enteredBy
, String fnameparty
, String lnameparty
, Long numpassengers
, NSTimestamp pudate
, String pulocation
, NSTimestamp putime
, NSTimestamp resdate
, Long resid
, String serviceType
, Long status
) {
    DailyDispatchArchive eo = (DailyDispatchArchive) EOUtilities.createAndInsertInstance(editingContext, _DailyDispatchArchive.ENTITY_NAME);    
		eo.setBilltype(billtype);
		eo.setChildseat(childseat);
		eo.setEmailaddress(emailaddress);
		eo.setEnterdate(enterdate);
		eo.setEnteredBy(enteredBy);
		eo.setFnameparty(fnameparty);
		eo.setLnameparty(lnameparty);
		eo.setNumpassengers(numpassengers);
		eo.setPudate(pudate);
		eo.setPulocation(pulocation);
		eo.setPutime(putime);
		eo.setResdate(resdate);
		eo.setResid(resid);
		eo.setServiceType(serviceType);
		eo.setStatus(status);
    return eo;
  }

  public static ERXFetchSpecification<DailyDispatchArchive> fetchSpec() {
    return new ERXFetchSpecification<DailyDispatchArchive>(_DailyDispatchArchive.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<DailyDispatchArchive> fetchAllDailyDispatchArchives(EOEditingContext editingContext) {
    return _DailyDispatchArchive.fetchAllDailyDispatchArchives(editingContext, null);
  }

  public static NSArray<DailyDispatchArchive> fetchAllDailyDispatchArchives(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _DailyDispatchArchive.fetchDailyDispatchArchives(editingContext, null, sortOrderings);
  }

  public static NSArray<DailyDispatchArchive> fetchDailyDispatchArchives(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<DailyDispatchArchive> fetchSpec = new ERXFetchSpecification<DailyDispatchArchive>(_DailyDispatchArchive.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<DailyDispatchArchive> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static DailyDispatchArchive fetchDailyDispatchArchive(EOEditingContext editingContext, String keyName, Object value) {
    return _DailyDispatchArchive.fetchDailyDispatchArchive(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static DailyDispatchArchive fetchDailyDispatchArchive(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<DailyDispatchArchive> eoObjects = _DailyDispatchArchive.fetchDailyDispatchArchives(editingContext, qualifier, null);
    DailyDispatchArchive eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one DailyDispatchArchive that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static DailyDispatchArchive fetchRequiredDailyDispatchArchive(EOEditingContext editingContext, String keyName, Object value) {
    return _DailyDispatchArchive.fetchRequiredDailyDispatchArchive(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static DailyDispatchArchive fetchRequiredDailyDispatchArchive(EOEditingContext editingContext, EOQualifier qualifier) {
    DailyDispatchArchive eoObject = _DailyDispatchArchive.fetchDailyDispatchArchive(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no DailyDispatchArchive that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static DailyDispatchArchive localInstanceIn(EOEditingContext editingContext, DailyDispatchArchive eo) {
    DailyDispatchArchive localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}