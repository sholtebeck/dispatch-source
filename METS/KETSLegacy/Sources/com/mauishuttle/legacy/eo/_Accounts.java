// DO NOT EDIT.  Make changes to Accounts.java instead.
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
public abstract class _Accounts extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Accounts";

  // Attribute Keys
  public static final ERXKey<String> ACCOUNTACTIVE = new ERXKey<String>("accountactive");
  public static final ERXKey<String> ACCOUNTADDRESS = new ERXKey<String>("accountaddress");
  public static final ERXKey<String> ACCOUNTCITY = new ERXKey<String>("accountcity");
  public static final ERXKey<String> ACCOUNTCONTACT1 = new ERXKey<String>("accountcontact1");
  public static final ERXKey<String> ACCOUNTCONTACT2 = new ERXKey<String>("accountcontact2");
  public static final ERXKey<String> ACCOUNTCONTACT3 = new ERXKey<String>("accountcontact3");
  public static final ERXKey<String> ACCOUNTFAXNUMBER = new ERXKey<String>("accountfaxnumber");
  public static final ERXKey<String> ACCOUNTNAME = new ERXKey<String>("accountname");
  public static final ERXKey<String> ACCOUNTPHONENUMBER = new ERXKey<String>("accountphonenumber");
  public static final ERXKey<String> ACCOUNTTYPE = new ERXKey<String>("accounttype");
  // Relationship Keys
  public static final ERXKey<com.mauishuttle.legacy.eo.DailyDispatch> DISPATCHES = new ERXKey<com.mauishuttle.legacy.eo.DailyDispatch>("dispatches");

  // Attributes
  public static final String ACCOUNTACTIVE_KEY = ACCOUNTACTIVE.key();
  public static final String ACCOUNTADDRESS_KEY = ACCOUNTADDRESS.key();
  public static final String ACCOUNTCITY_KEY = ACCOUNTCITY.key();
  public static final String ACCOUNTCONTACT1_KEY = ACCOUNTCONTACT1.key();
  public static final String ACCOUNTCONTACT2_KEY = ACCOUNTCONTACT2.key();
  public static final String ACCOUNTCONTACT3_KEY = ACCOUNTCONTACT3.key();
  public static final String ACCOUNTFAXNUMBER_KEY = ACCOUNTFAXNUMBER.key();
  public static final String ACCOUNTNAME_KEY = ACCOUNTNAME.key();
  public static final String ACCOUNTPHONENUMBER_KEY = ACCOUNTPHONENUMBER.key();
  public static final String ACCOUNTTYPE_KEY = ACCOUNTTYPE.key();
  // Relationships
  public static final String DISPATCHES_KEY = DISPATCHES.key();

  private static Logger LOG = Logger.getLogger(_Accounts.class);

  public Accounts localInstanceIn(EOEditingContext editingContext) {
    Accounts localInstance = (Accounts)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String accountactive() {
    return (String) storedValueForKey(_Accounts.ACCOUNTACTIVE_KEY);
  }

  public void setAccountactive(String value) {
    if (_Accounts.LOG.isDebugEnabled()) {
    	_Accounts.LOG.debug( "updating accountactive from " + accountactive() + " to " + value);
    }
    takeStoredValueForKey(value, _Accounts.ACCOUNTACTIVE_KEY);
  }

  public String accountaddress() {
    return (String) storedValueForKey(_Accounts.ACCOUNTADDRESS_KEY);
  }

  public void setAccountaddress(String value) {
    if (_Accounts.LOG.isDebugEnabled()) {
    	_Accounts.LOG.debug( "updating accountaddress from " + accountaddress() + " to " + value);
    }
    takeStoredValueForKey(value, _Accounts.ACCOUNTADDRESS_KEY);
  }

  public String accountcity() {
    return (String) storedValueForKey(_Accounts.ACCOUNTCITY_KEY);
  }

  public void setAccountcity(String value) {
    if (_Accounts.LOG.isDebugEnabled()) {
    	_Accounts.LOG.debug( "updating accountcity from " + accountcity() + " to " + value);
    }
    takeStoredValueForKey(value, _Accounts.ACCOUNTCITY_KEY);
  }

  public String accountcontact1() {
    return (String) storedValueForKey(_Accounts.ACCOUNTCONTACT1_KEY);
  }

  public void setAccountcontact1(String value) {
    if (_Accounts.LOG.isDebugEnabled()) {
    	_Accounts.LOG.debug( "updating accountcontact1 from " + accountcontact1() + " to " + value);
    }
    takeStoredValueForKey(value, _Accounts.ACCOUNTCONTACT1_KEY);
  }

  public String accountcontact2() {
    return (String) storedValueForKey(_Accounts.ACCOUNTCONTACT2_KEY);
  }

  public void setAccountcontact2(String value) {
    if (_Accounts.LOG.isDebugEnabled()) {
    	_Accounts.LOG.debug( "updating accountcontact2 from " + accountcontact2() + " to " + value);
    }
    takeStoredValueForKey(value, _Accounts.ACCOUNTCONTACT2_KEY);
  }

  public String accountcontact3() {
    return (String) storedValueForKey(_Accounts.ACCOUNTCONTACT3_KEY);
  }

  public void setAccountcontact3(String value) {
    if (_Accounts.LOG.isDebugEnabled()) {
    	_Accounts.LOG.debug( "updating accountcontact3 from " + accountcontact3() + " to " + value);
    }
    takeStoredValueForKey(value, _Accounts.ACCOUNTCONTACT3_KEY);
  }

  public String accountfaxnumber() {
    return (String) storedValueForKey(_Accounts.ACCOUNTFAXNUMBER_KEY);
  }

  public void setAccountfaxnumber(String value) {
    if (_Accounts.LOG.isDebugEnabled()) {
    	_Accounts.LOG.debug( "updating accountfaxnumber from " + accountfaxnumber() + " to " + value);
    }
    takeStoredValueForKey(value, _Accounts.ACCOUNTFAXNUMBER_KEY);
  }

  public String accountname() {
    return (String) storedValueForKey(_Accounts.ACCOUNTNAME_KEY);
  }

  public void setAccountname(String value) {
    if (_Accounts.LOG.isDebugEnabled()) {
    	_Accounts.LOG.debug( "updating accountname from " + accountname() + " to " + value);
    }
    takeStoredValueForKey(value, _Accounts.ACCOUNTNAME_KEY);
  }

  public String accountphonenumber() {
    return (String) storedValueForKey(_Accounts.ACCOUNTPHONENUMBER_KEY);
  }

  public void setAccountphonenumber(String value) {
    if (_Accounts.LOG.isDebugEnabled()) {
    	_Accounts.LOG.debug( "updating accountphonenumber from " + accountphonenumber() + " to " + value);
    }
    takeStoredValueForKey(value, _Accounts.ACCOUNTPHONENUMBER_KEY);
  }

  public String accounttype() {
    return (String) storedValueForKey(_Accounts.ACCOUNTTYPE_KEY);
  }

  public void setAccounttype(String value) {
    if (_Accounts.LOG.isDebugEnabled()) {
    	_Accounts.LOG.debug( "updating accounttype from " + accounttype() + " to " + value);
    }
    takeStoredValueForKey(value, _Accounts.ACCOUNTTYPE_KEY);
  }

  public NSArray<com.mauishuttle.legacy.eo.DailyDispatch> dispatches() {
    return (NSArray<com.mauishuttle.legacy.eo.DailyDispatch>)storedValueForKey(_Accounts.DISPATCHES_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(com.mauishuttle.legacy.eo.DailyDispatch.ACCOUNT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _Accounts.DISPATCHES_KEY);
  }

  public void removeFromDispatches(com.mauishuttle.legacy.eo.DailyDispatch object) {
    excludeObjectFromPropertyWithKey(object, _Accounts.DISPATCHES_KEY);
  }

  public void addToDispatchesRelationship(com.mauishuttle.legacy.eo.DailyDispatch object) {
    if (_Accounts.LOG.isDebugEnabled()) {
      _Accounts.LOG.debug("adding " + object + " to dispatches relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToDispatches(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Accounts.DISPATCHES_KEY);
    }
  }

  public void removeFromDispatchesRelationship(com.mauishuttle.legacy.eo.DailyDispatch object) {
    if (_Accounts.LOG.isDebugEnabled()) {
      _Accounts.LOG.debug("removing " + object + " from dispatches relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromDispatches(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Accounts.DISPATCHES_KEY);
    }
  }

  public com.mauishuttle.legacy.eo.DailyDispatch createDispatchesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( com.mauishuttle.legacy.eo.DailyDispatch.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Accounts.DISPATCHES_KEY);
    return (com.mauishuttle.legacy.eo.DailyDispatch) eo;
  }

  public void deleteDispatchesRelationship(com.mauishuttle.legacy.eo.DailyDispatch object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Accounts.DISPATCHES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllDispatchesRelationships() {
    Enumeration<com.mauishuttle.legacy.eo.DailyDispatch> objects = dispatches().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDispatchesRelationship(objects.nextElement());
    }
  }


  public static Accounts createAccounts(EOEditingContext editingContext) {
    Accounts eo = (Accounts) EOUtilities.createAndInsertInstance(editingContext, _Accounts.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<Accounts> fetchSpec() {
    return new ERXFetchSpecification<Accounts>(_Accounts.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Accounts> fetchAllAccountses(EOEditingContext editingContext) {
    return _Accounts.fetchAllAccountses(editingContext, null);
  }

  public static NSArray<Accounts> fetchAllAccountses(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Accounts.fetchAccountses(editingContext, null, sortOrderings);
  }

  public static NSArray<Accounts> fetchAccountses(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Accounts> fetchSpec = new ERXFetchSpecification<Accounts>(_Accounts.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Accounts> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Accounts fetchAccounts(EOEditingContext editingContext, String keyName, Object value) {
    return _Accounts.fetchAccounts(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Accounts fetchAccounts(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Accounts> eoObjects = _Accounts.fetchAccountses(editingContext, qualifier, null);
    Accounts eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Accounts that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Accounts fetchRequiredAccounts(EOEditingContext editingContext, String keyName, Object value) {
    return _Accounts.fetchRequiredAccounts(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Accounts fetchRequiredAccounts(EOEditingContext editingContext, EOQualifier qualifier) {
    Accounts eoObject = _Accounts.fetchAccounts(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Accounts that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Accounts localInstanceIn(EOEditingContext editingContext, Accounts eo) {
    Accounts localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}