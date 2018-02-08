// DO NOT EDIT.  Make changes to User.java instead.
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
public abstract class _User extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "User";

  // Attribute Keys
  public static final ERXKey<String> FNAME = new ERXKey<String>("fname");
  public static final ERXKey<NSTimestamp> LASTLOG = new ERXKey<NSTimestamp>("lastlog");
  public static final ERXKey<String> LEVEL = new ERXKey<String>("level");
  public static final ERXKey<String> LNAME = new ERXKey<String>("lname");
  public static final ERXKey<Long> LOGINCOUNT = new ERXKey<Long>("logincount");
  public static final ERXKey<String> LOGINID = new ERXKey<String>("loginid");
  public static final ERXKey<String> PASSWORD = new ERXKey<String>("password");
  public static final ERXKey<Long> RESERVATIONSMADE = new ERXKey<Long>("reservationsmade");
  // Relationship Keys
  public static final ERXKey<com.mauishuttle.legacy.eo.DailyDispatch> DISPATCHES = new ERXKey<com.mauishuttle.legacy.eo.DailyDispatch>("dispatches");

  // Attributes
  public static final String FNAME_KEY = FNAME.key();
  public static final String LASTLOG_KEY = LASTLOG.key();
  public static final String LEVEL_KEY = LEVEL.key();
  public static final String LNAME_KEY = LNAME.key();
  public static final String LOGINCOUNT_KEY = LOGINCOUNT.key();
  public static final String LOGINID_KEY = LOGINID.key();
  public static final String PASSWORD_KEY = PASSWORD.key();
  public static final String RESERVATIONSMADE_KEY = RESERVATIONSMADE.key();
  // Relationships
  public static final String DISPATCHES_KEY = DISPATCHES.key();

  private static Logger LOG = Logger.getLogger(_User.class);

  public User localInstanceIn(EOEditingContext editingContext) {
    User localInstance = (User)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String fname() {
    return (String) storedValueForKey(_User.FNAME_KEY);
  }

  public void setFname(String value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating fname from " + fname() + " to " + value);
    }
    takeStoredValueForKey(value, _User.FNAME_KEY);
  }

  public NSTimestamp lastlog() {
    return (NSTimestamp) storedValueForKey(_User.LASTLOG_KEY);
  }

  public void setLastlog(NSTimestamp value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating lastlog from " + lastlog() + " to " + value);
    }
    takeStoredValueForKey(value, _User.LASTLOG_KEY);
  }

  public String level() {
    return (String) storedValueForKey(_User.LEVEL_KEY);
  }

  public void setLevel(String value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating level from " + level() + " to " + value);
    }
    takeStoredValueForKey(value, _User.LEVEL_KEY);
  }

  public String lname() {
    return (String) storedValueForKey(_User.LNAME_KEY);
  }

  public void setLname(String value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating lname from " + lname() + " to " + value);
    }
    takeStoredValueForKey(value, _User.LNAME_KEY);
  }

  public Long logincount() {
    return (Long) storedValueForKey(_User.LOGINCOUNT_KEY);
  }

  public void setLogincount(Long value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating logincount from " + logincount() + " to " + value);
    }
    takeStoredValueForKey(value, _User.LOGINCOUNT_KEY);
  }

  public String loginid() {
    return (String) storedValueForKey(_User.LOGINID_KEY);
  }

  public void setLoginid(String value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating loginid from " + loginid() + " to " + value);
    }
    takeStoredValueForKey(value, _User.LOGINID_KEY);
  }

  public String password() {
    return (String) storedValueForKey(_User.PASSWORD_KEY);
  }

  public void setPassword(String value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating password from " + password() + " to " + value);
    }
    takeStoredValueForKey(value, _User.PASSWORD_KEY);
  }

  public Long reservationsmade() {
    return (Long) storedValueForKey(_User.RESERVATIONSMADE_KEY);
  }

  public void setReservationsmade(Long value) {
    if (_User.LOG.isDebugEnabled()) {
    	_User.LOG.debug( "updating reservationsmade from " + reservationsmade() + " to " + value);
    }
    takeStoredValueForKey(value, _User.RESERVATIONSMADE_KEY);
  }

  public NSArray<com.mauishuttle.legacy.eo.DailyDispatch> dispatches() {
    return (NSArray<com.mauishuttle.legacy.eo.DailyDispatch>)storedValueForKey(_User.DISPATCHES_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(com.mauishuttle.legacy.eo.DailyDispatch.USER_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _User.DISPATCHES_KEY);
  }

  public void removeFromDispatches(com.mauishuttle.legacy.eo.DailyDispatch object) {
    excludeObjectFromPropertyWithKey(object, _User.DISPATCHES_KEY);
  }

  public void addToDispatchesRelationship(com.mauishuttle.legacy.eo.DailyDispatch object) {
    if (_User.LOG.isDebugEnabled()) {
      _User.LOG.debug("adding " + object + " to dispatches relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToDispatches(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _User.DISPATCHES_KEY);
    }
  }

  public void removeFromDispatchesRelationship(com.mauishuttle.legacy.eo.DailyDispatch object) {
    if (_User.LOG.isDebugEnabled()) {
      _User.LOG.debug("removing " + object + " from dispatches relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromDispatches(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _User.DISPATCHES_KEY);
    }
  }

  public com.mauishuttle.legacy.eo.DailyDispatch createDispatchesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( com.mauishuttle.legacy.eo.DailyDispatch.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _User.DISPATCHES_KEY);
    return (com.mauishuttle.legacy.eo.DailyDispatch) eo;
  }

  public void deleteDispatchesRelationship(com.mauishuttle.legacy.eo.DailyDispatch object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _User.DISPATCHES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllDispatchesRelationships() {
    Enumeration<com.mauishuttle.legacy.eo.DailyDispatch> objects = dispatches().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDispatchesRelationship(objects.nextElement());
    }
  }


  public static User createUser(EOEditingContext editingContext) {
    User eo = (User) EOUtilities.createAndInsertInstance(editingContext, _User.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<User> fetchSpec() {
    return new ERXFetchSpecification<User>(_User.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<User> fetchAllUsers(EOEditingContext editingContext) {
    return _User.fetchAllUsers(editingContext, null);
  }

  public static NSArray<User> fetchAllUsers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _User.fetchUsers(editingContext, null, sortOrderings);
  }

  public static NSArray<User> fetchUsers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<User> fetchSpec = new ERXFetchSpecification<User>(_User.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<User> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static User fetchUser(EOEditingContext editingContext, String keyName, Object value) {
    return _User.fetchUser(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static User fetchUser(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<User> eoObjects = _User.fetchUsers(editingContext, qualifier, null);
    User eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one User that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static User fetchRequiredUser(EOEditingContext editingContext, String keyName, Object value) {
    return _User.fetchRequiredUser(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static User fetchRequiredUser(EOEditingContext editingContext, EOQualifier qualifier) {
    User eoObject = _User.fetchUser(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no User that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static User localInstanceIn(EOEditingContext editingContext, User eo) {
    User localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}