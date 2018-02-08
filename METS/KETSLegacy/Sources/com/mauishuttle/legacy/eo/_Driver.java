// DO NOT EDIT.  Make changes to Driver.java instead.
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
public abstract class _Driver extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Driver";

  // Attribute Keys
  public static final ERXKey<String> ACTIVE = new ERXKey<String>("active");
  public static final ERXKey<String> CONTACTED = new ERXKey<String>("contacted");
  public static final ERXKey<String> DRIVERFNAME = new ERXKey<String>("driverfname");
  public static final ERXKey<String> DRIVERLNAME = new ERXKey<String>("driverlname");
  public static final ERXKey<NSTimestamp> ENDTIME = new ERXKey<NSTimestamp>("endtime");
  public static final ERXKey<String> LOCATION = new ERXKey<String>("location");
  public static final ERXKey<String> NOTES = new ERXKey<String>("notes");
  public static final ERXKey<Long> PHONE_ID = new ERXKey<Long>("phoneId");
  public static final ERXKey<NSTimestamp> STARTTIME = new ERXKey<NSTimestamp>("starttime");
  public static final ERXKey<Long> VEHICLE_ID = new ERXKey<Long>("vehicleId");
  // Relationship Keys
  public static final ERXKey<com.mauishuttle.legacy.eo.DailyDispatch> DISPATCHES = new ERXKey<com.mauishuttle.legacy.eo.DailyDispatch>("dispatches");

  // Attributes
  public static final String ACTIVE_KEY = ACTIVE.key();
  public static final String CONTACTED_KEY = CONTACTED.key();
  public static final String DRIVERFNAME_KEY = DRIVERFNAME.key();
  public static final String DRIVERLNAME_KEY = DRIVERLNAME.key();
  public static final String ENDTIME_KEY = ENDTIME.key();
  public static final String LOCATION_KEY = LOCATION.key();
  public static final String NOTES_KEY = NOTES.key();
  public static final String PHONE_ID_KEY = PHONE_ID.key();
  public static final String STARTTIME_KEY = STARTTIME.key();
  public static final String VEHICLE_ID_KEY = VEHICLE_ID.key();
  // Relationships
  public static final String DISPATCHES_KEY = DISPATCHES.key();

  private static Logger LOG = Logger.getLogger(_Driver.class);

  public Driver localInstanceIn(EOEditingContext editingContext) {
    Driver localInstance = (Driver)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String active() {
    return (String) storedValueForKey(_Driver.ACTIVE_KEY);
  }

  public void setActive(String value) {
    if (_Driver.LOG.isDebugEnabled()) {
    	_Driver.LOG.debug( "updating active from " + active() + " to " + value);
    }
    takeStoredValueForKey(value, _Driver.ACTIVE_KEY);
  }

  public String contacted() {
    return (String) storedValueForKey(_Driver.CONTACTED_KEY);
  }

  public void setContacted(String value) {
    if (_Driver.LOG.isDebugEnabled()) {
    	_Driver.LOG.debug( "updating contacted from " + contacted() + " to " + value);
    }
    takeStoredValueForKey(value, _Driver.CONTACTED_KEY);
  }

  public String driverfname() {
    return (String) storedValueForKey(_Driver.DRIVERFNAME_KEY);
  }

  public void setDriverfname(String value) {
    if (_Driver.LOG.isDebugEnabled()) {
    	_Driver.LOG.debug( "updating driverfname from " + driverfname() + " to " + value);
    }
    takeStoredValueForKey(value, _Driver.DRIVERFNAME_KEY);
  }

  public String driverlname() {
    return (String) storedValueForKey(_Driver.DRIVERLNAME_KEY);
  }

  public void setDriverlname(String value) {
    if (_Driver.LOG.isDebugEnabled()) {
    	_Driver.LOG.debug( "updating driverlname from " + driverlname() + " to " + value);
    }
    takeStoredValueForKey(value, _Driver.DRIVERLNAME_KEY);
  }

  public NSTimestamp endtime() {
    return (NSTimestamp) storedValueForKey(_Driver.ENDTIME_KEY);
  }

  public void setEndtime(NSTimestamp value) {
    if (_Driver.LOG.isDebugEnabled()) {
    	_Driver.LOG.debug( "updating endtime from " + endtime() + " to " + value);
    }
    takeStoredValueForKey(value, _Driver.ENDTIME_KEY);
  }

  public String location() {
    return (String) storedValueForKey(_Driver.LOCATION_KEY);
  }

  public void setLocation(String value) {
    if (_Driver.LOG.isDebugEnabled()) {
    	_Driver.LOG.debug( "updating location from " + location() + " to " + value);
    }
    takeStoredValueForKey(value, _Driver.LOCATION_KEY);
  }

  public String notes() {
    return (String) storedValueForKey(_Driver.NOTES_KEY);
  }

  public void setNotes(String value) {
    if (_Driver.LOG.isDebugEnabled()) {
    	_Driver.LOG.debug( "updating notes from " + notes() + " to " + value);
    }
    takeStoredValueForKey(value, _Driver.NOTES_KEY);
  }

  public Long phoneId() {
    return (Long) storedValueForKey(_Driver.PHONE_ID_KEY);
  }

  public void setPhoneId(Long value) {
    if (_Driver.LOG.isDebugEnabled()) {
    	_Driver.LOG.debug( "updating phoneId from " + phoneId() + " to " + value);
    }
    takeStoredValueForKey(value, _Driver.PHONE_ID_KEY);
  }

  public NSTimestamp starttime() {
    return (NSTimestamp) storedValueForKey(_Driver.STARTTIME_KEY);
  }

  public void setStarttime(NSTimestamp value) {
    if (_Driver.LOG.isDebugEnabled()) {
    	_Driver.LOG.debug( "updating starttime from " + starttime() + " to " + value);
    }
    takeStoredValueForKey(value, _Driver.STARTTIME_KEY);
  }

  public Long vehicleId() {
    return (Long) storedValueForKey(_Driver.VEHICLE_ID_KEY);
  }

  public void setVehicleId(Long value) {
    if (_Driver.LOG.isDebugEnabled()) {
    	_Driver.LOG.debug( "updating vehicleId from " + vehicleId() + " to " + value);
    }
    takeStoredValueForKey(value, _Driver.VEHICLE_ID_KEY);
  }

  public NSArray<com.mauishuttle.legacy.eo.DailyDispatch> dispatches() {
    return (NSArray<com.mauishuttle.legacy.eo.DailyDispatch>)storedValueForKey(_Driver.DISPATCHES_KEY);
  }

  public NSArray<com.mauishuttle.legacy.eo.DailyDispatch> dispatches(EOQualifier qualifier) {
    return dispatches(qualifier, null, false);
  }

  public NSArray<com.mauishuttle.legacy.eo.DailyDispatch> dispatches(EOQualifier qualifier, boolean fetch) {
    return dispatches(qualifier, null, fetch);
  }

  public NSArray<com.mauishuttle.legacy.eo.DailyDispatch> dispatches(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<com.mauishuttle.legacy.eo.DailyDispatch> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(com.mauishuttle.legacy.eo.DailyDispatch.DRIVER_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = com.mauishuttle.legacy.eo.DailyDispatch.fetchDailyDispatchs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = dispatches();
      if (qualifier != null) {
        results = (NSArray<com.mauishuttle.legacy.eo.DailyDispatch>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<com.mauishuttle.legacy.eo.DailyDispatch>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToDispatches(com.mauishuttle.legacy.eo.DailyDispatch object) {
    includeObjectIntoPropertyWithKey(object, _Driver.DISPATCHES_KEY);
  }

  public void removeFromDispatches(com.mauishuttle.legacy.eo.DailyDispatch object) {
    excludeObjectFromPropertyWithKey(object, _Driver.DISPATCHES_KEY);
  }

  public void addToDispatchesRelationship(com.mauishuttle.legacy.eo.DailyDispatch object) {
    if (_Driver.LOG.isDebugEnabled()) {
      _Driver.LOG.debug("adding " + object + " to dispatches relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToDispatches(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Driver.DISPATCHES_KEY);
    }
  }

  public void removeFromDispatchesRelationship(com.mauishuttle.legacy.eo.DailyDispatch object) {
    if (_Driver.LOG.isDebugEnabled()) {
      _Driver.LOG.debug("removing " + object + " from dispatches relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromDispatches(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Driver.DISPATCHES_KEY);
    }
  }

  public com.mauishuttle.legacy.eo.DailyDispatch createDispatchesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( com.mauishuttle.legacy.eo.DailyDispatch.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Driver.DISPATCHES_KEY);
    return (com.mauishuttle.legacy.eo.DailyDispatch) eo;
  }

  public void deleteDispatchesRelationship(com.mauishuttle.legacy.eo.DailyDispatch object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Driver.DISPATCHES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllDispatchesRelationships() {
    Enumeration<com.mauishuttle.legacy.eo.DailyDispatch> objects = dispatches().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDispatchesRelationship(objects.nextElement());
    }
  }


  public static Driver createDriver(EOEditingContext editingContext) {
    Driver eo = (Driver) EOUtilities.createAndInsertInstance(editingContext, _Driver.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<Driver> fetchSpec() {
    return new ERXFetchSpecification<Driver>(_Driver.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Driver> fetchAllDrivers(EOEditingContext editingContext) {
    return _Driver.fetchAllDrivers(editingContext, null);
  }

  public static NSArray<Driver> fetchAllDrivers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Driver.fetchDrivers(editingContext, null, sortOrderings);
  }

  public static NSArray<Driver> fetchDrivers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Driver> fetchSpec = new ERXFetchSpecification<Driver>(_Driver.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Driver> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Driver fetchDriver(EOEditingContext editingContext, String keyName, Object value) {
    return _Driver.fetchDriver(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Driver fetchDriver(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Driver> eoObjects = _Driver.fetchDrivers(editingContext, qualifier, null);
    Driver eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Driver that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Driver fetchRequiredDriver(EOEditingContext editingContext, String keyName, Object value) {
    return _Driver.fetchRequiredDriver(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Driver fetchRequiredDriver(EOEditingContext editingContext, EOQualifier qualifier) {
    Driver eoObject = _Driver.fetchDriver(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Driver that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Driver localInstanceIn(EOEditingContext editingContext, Driver eo) {
    Driver localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}