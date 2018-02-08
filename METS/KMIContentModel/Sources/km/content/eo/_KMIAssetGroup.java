// DO NOT EDIT.  Make changes to KMIAssetGroup.java instead.
package km.content.eo;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _KMIAssetGroup extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "KMIAssetGroup";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATE_DATE = new ERXKey<NSTimestamp>("createDate");
  public static final ERXKey<NSTimestamp> LAST_MODIFIED = new ERXKey<NSTimestamp>("lastModified");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIAbstractAsset> ASSETS = new ERXKey<km.content.eo.KMIAbstractAsset>("assets");
  public static final ERXKey<km.content.eo.KMIWebSite> SITE = new ERXKey<km.content.eo.KMIWebSite>("site");

  // Attributes
  public static final String CREATE_DATE_KEY = CREATE_DATE.key();
  public static final String LAST_MODIFIED_KEY = LAST_MODIFIED.key();
  public static final String NAME_KEY = NAME.key();
  // Relationships
  public static final String ASSETS_KEY = ASSETS.key();
  public static final String SITE_KEY = SITE.key();

  private static Logger LOG = Logger.getLogger(_KMIAssetGroup.class);

  public KMIAssetGroup localInstanceIn(EOEditingContext editingContext) {
    KMIAssetGroup localInstance = (KMIAssetGroup)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp createDate() {
    return (NSTimestamp) storedValueForKey(_KMIAssetGroup.CREATE_DATE_KEY);
  }

  public void setCreateDate(NSTimestamp value) {
    if (_KMIAssetGroup.LOG.isDebugEnabled()) {
    	_KMIAssetGroup.LOG.debug( "updating createDate from " + createDate() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAssetGroup.CREATE_DATE_KEY);
  }

  public NSTimestamp lastModified() {
    return (NSTimestamp) storedValueForKey(_KMIAssetGroup.LAST_MODIFIED_KEY);
  }

  public void setLastModified(NSTimestamp value) {
    if (_KMIAssetGroup.LOG.isDebugEnabled()) {
    	_KMIAssetGroup.LOG.debug( "updating lastModified from " + lastModified() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAssetGroup.LAST_MODIFIED_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_KMIAssetGroup.NAME_KEY);
  }

  public void setName(String value) {
    if (_KMIAssetGroup.LOG.isDebugEnabled()) {
    	_KMIAssetGroup.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAssetGroup.NAME_KEY);
  }

  public km.content.eo.KMIWebSite site() {
    return (km.content.eo.KMIWebSite)storedValueForKey(_KMIAssetGroup.SITE_KEY);
  }
  
  public void setSite(km.content.eo.KMIWebSite value) {
    takeStoredValueForKey(value, _KMIAssetGroup.SITE_KEY);
  }

  public void setSiteRelationship(km.content.eo.KMIWebSite value) {
    if (_KMIAssetGroup.LOG.isDebugEnabled()) {
      _KMIAssetGroup.LOG.debug("updating site from " + site() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setSite(value);
    }
    else if (value == null) {
    	km.content.eo.KMIWebSite oldValue = site();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIAssetGroup.SITE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIAssetGroup.SITE_KEY);
    }
  }
  
  public NSArray<km.content.eo.KMIAbstractAsset> assets() {
    return (NSArray<km.content.eo.KMIAbstractAsset>)storedValueForKey(_KMIAssetGroup.ASSETS_KEY);
  }

  public NSArray<km.content.eo.KMIAbstractAsset> assets(EOQualifier qualifier) {
    return assets(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIAbstractAsset> assets(EOQualifier qualifier, boolean fetch) {
    return assets(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIAbstractAsset> assets(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIAbstractAsset> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIAbstractAsset.GROUP_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = km.content.eo.KMIAbstractAsset.fetchKMIAbstractAssets(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = assets();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIAbstractAsset>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIAbstractAsset>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToAssets(km.content.eo.KMIAbstractAsset object) {
    includeObjectIntoPropertyWithKey(object, _KMIAssetGroup.ASSETS_KEY);
  }

  public void removeFromAssets(km.content.eo.KMIAbstractAsset object) {
    excludeObjectFromPropertyWithKey(object, _KMIAssetGroup.ASSETS_KEY);
  }

  public void addToAssetsRelationship(km.content.eo.KMIAbstractAsset object) {
    if (_KMIAssetGroup.LOG.isDebugEnabled()) {
      _KMIAssetGroup.LOG.debug("adding " + object + " to assets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToAssets(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIAssetGroup.ASSETS_KEY);
    }
  }

  public void removeFromAssetsRelationship(km.content.eo.KMIAbstractAsset object) {
    if (_KMIAssetGroup.LOG.isDebugEnabled()) {
      _KMIAssetGroup.LOG.debug("removing " + object + " from assets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromAssets(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIAssetGroup.ASSETS_KEY);
    }
  }

  public km.content.eo.KMIAbstractAsset createAssetsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIAbstractAsset.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIAssetGroup.ASSETS_KEY);
    return (km.content.eo.KMIAbstractAsset) eo;
  }

  public void deleteAssetsRelationship(km.content.eo.KMIAbstractAsset object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIAssetGroup.ASSETS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllAssetsRelationships() {
    Enumeration<km.content.eo.KMIAbstractAsset> objects = assets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteAssetsRelationship(objects.nextElement());
    }
  }


  public static KMIAssetGroup createKMIAssetGroup(EOEditingContext editingContext, km.content.eo.KMIWebSite site) {
    KMIAssetGroup eo = (KMIAssetGroup) EOUtilities.createAndInsertInstance(editingContext, _KMIAssetGroup.ENTITY_NAME);    
    eo.setSiteRelationship(site);
    return eo;
  }

  public static ERXFetchSpecification<KMIAssetGroup> fetchSpec() {
    return new ERXFetchSpecification<KMIAssetGroup>(_KMIAssetGroup.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIAssetGroup> fetchAllKMIAssetGroups(EOEditingContext editingContext) {
    return _KMIAssetGroup.fetchAllKMIAssetGroups(editingContext, null);
  }

  public static NSArray<KMIAssetGroup> fetchAllKMIAssetGroups(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIAssetGroup.fetchKMIAssetGroups(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIAssetGroup> fetchKMIAssetGroups(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIAssetGroup> fetchSpec = new ERXFetchSpecification<KMIAssetGroup>(_KMIAssetGroup.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIAssetGroup> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIAssetGroup fetchKMIAssetGroup(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIAssetGroup.fetchKMIAssetGroup(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIAssetGroup fetchKMIAssetGroup(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIAssetGroup> eoObjects = _KMIAssetGroup.fetchKMIAssetGroups(editingContext, qualifier, null);
    KMIAssetGroup eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIAssetGroup that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIAssetGroup fetchRequiredKMIAssetGroup(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIAssetGroup.fetchRequiredKMIAssetGroup(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIAssetGroup fetchRequiredKMIAssetGroup(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIAssetGroup eoObject = _KMIAssetGroup.fetchKMIAssetGroup(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIAssetGroup that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIAssetGroup localInstanceIn(EOEditingContext editingContext, KMIAssetGroup eo) {
    KMIAssetGroup localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}