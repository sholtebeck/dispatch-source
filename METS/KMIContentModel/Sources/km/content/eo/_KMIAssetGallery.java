// DO NOT EDIT.  Make changes to KMIAssetGallery.java instead.
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
public abstract class _KMIAssetGallery extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "KMIAssetGallery";

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

  private static Logger LOG = Logger.getLogger(_KMIAssetGallery.class);

  public KMIAssetGallery localInstanceIn(EOEditingContext editingContext) {
    KMIAssetGallery localInstance = (KMIAssetGallery)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp createDate() {
    return (NSTimestamp) storedValueForKey(_KMIAssetGallery.CREATE_DATE_KEY);
  }

  public void setCreateDate(NSTimestamp value) {
    if (_KMIAssetGallery.LOG.isDebugEnabled()) {
    	_KMIAssetGallery.LOG.debug( "updating createDate from " + createDate() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAssetGallery.CREATE_DATE_KEY);
  }

  public NSTimestamp lastModified() {
    return (NSTimestamp) storedValueForKey(_KMIAssetGallery.LAST_MODIFIED_KEY);
  }

  public void setLastModified(NSTimestamp value) {
    if (_KMIAssetGallery.LOG.isDebugEnabled()) {
    	_KMIAssetGallery.LOG.debug( "updating lastModified from " + lastModified() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAssetGallery.LAST_MODIFIED_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_KMIAssetGallery.NAME_KEY);
  }

  public void setName(String value) {
    if (_KMIAssetGallery.LOG.isDebugEnabled()) {
    	_KMIAssetGallery.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAssetGallery.NAME_KEY);
  }

  public km.content.eo.KMIWebSite site() {
    return (km.content.eo.KMIWebSite)storedValueForKey(_KMIAssetGallery.SITE_KEY);
  }
  
  public void setSite(km.content.eo.KMIWebSite value) {
    takeStoredValueForKey(value, _KMIAssetGallery.SITE_KEY);
  }

  public void setSiteRelationship(km.content.eo.KMIWebSite value) {
    if (_KMIAssetGallery.LOG.isDebugEnabled()) {
      _KMIAssetGallery.LOG.debug("updating site from " + site() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setSite(value);
    }
    else if (value == null) {
    	km.content.eo.KMIWebSite oldValue = site();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIAssetGallery.SITE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIAssetGallery.SITE_KEY);
    }
  }
  
  public NSArray<km.content.eo.KMIAbstractAsset> assets() {
    return (NSArray<km.content.eo.KMIAbstractAsset>)storedValueForKey(_KMIAssetGallery.ASSETS_KEY);
  }

  public NSArray<km.content.eo.KMIAbstractAsset> assets(EOQualifier qualifier) {
    return assets(qualifier, null);
  }

  public NSArray<km.content.eo.KMIAbstractAsset> assets(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<km.content.eo.KMIAbstractAsset> results;
      results = assets();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIAbstractAsset>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIAbstractAsset>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToAssets(km.content.eo.KMIAbstractAsset object) {
    includeObjectIntoPropertyWithKey(object, _KMIAssetGallery.ASSETS_KEY);
  }

  public void removeFromAssets(km.content.eo.KMIAbstractAsset object) {
    excludeObjectFromPropertyWithKey(object, _KMIAssetGallery.ASSETS_KEY);
  }

  public void addToAssetsRelationship(km.content.eo.KMIAbstractAsset object) {
    if (_KMIAssetGallery.LOG.isDebugEnabled()) {
      _KMIAssetGallery.LOG.debug("adding " + object + " to assets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToAssets(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIAssetGallery.ASSETS_KEY);
    }
  }

  public void removeFromAssetsRelationship(km.content.eo.KMIAbstractAsset object) {
    if (_KMIAssetGallery.LOG.isDebugEnabled()) {
      _KMIAssetGallery.LOG.debug("removing " + object + " from assets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromAssets(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIAssetGallery.ASSETS_KEY);
    }
  }

  public km.content.eo.KMIAbstractAsset createAssetsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIAbstractAsset.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIAssetGallery.ASSETS_KEY);
    return (km.content.eo.KMIAbstractAsset) eo;
  }

  public void deleteAssetsRelationship(km.content.eo.KMIAbstractAsset object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIAssetGallery.ASSETS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllAssetsRelationships() {
    Enumeration<km.content.eo.KMIAbstractAsset> objects = assets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteAssetsRelationship(objects.nextElement());
    }
  }


  public static KMIAssetGallery createKMIAssetGallery(EOEditingContext editingContext, km.content.eo.KMIWebSite site) {
    KMIAssetGallery eo = (KMIAssetGallery) EOUtilities.createAndInsertInstance(editingContext, _KMIAssetGallery.ENTITY_NAME);    
    eo.setSiteRelationship(site);
    return eo;
  }

  public static ERXFetchSpecification<KMIAssetGallery> fetchSpec() {
    return new ERXFetchSpecification<KMIAssetGallery>(_KMIAssetGallery.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIAssetGallery> fetchAllKMIAssetGalleries(EOEditingContext editingContext) {
    return _KMIAssetGallery.fetchAllKMIAssetGalleries(editingContext, null);
  }

  public static NSArray<KMIAssetGallery> fetchAllKMIAssetGalleries(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIAssetGallery.fetchKMIAssetGalleries(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIAssetGallery> fetchKMIAssetGalleries(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIAssetGallery> fetchSpec = new ERXFetchSpecification<KMIAssetGallery>(_KMIAssetGallery.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIAssetGallery> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIAssetGallery fetchKMIAssetGallery(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIAssetGallery.fetchKMIAssetGallery(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIAssetGallery fetchKMIAssetGallery(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIAssetGallery> eoObjects = _KMIAssetGallery.fetchKMIAssetGalleries(editingContext, qualifier, null);
    KMIAssetGallery eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIAssetGallery that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIAssetGallery fetchRequiredKMIAssetGallery(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIAssetGallery.fetchRequiredKMIAssetGallery(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIAssetGallery fetchRequiredKMIAssetGallery(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIAssetGallery eoObject = _KMIAssetGallery.fetchKMIAssetGallery(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIAssetGallery that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIAssetGallery localInstanceIn(EOEditingContext editingContext, KMIAssetGallery eo) {
    KMIAssetGallery localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}