// DO NOT EDIT.  Make changes to KMIAbstractAsset.java instead.
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
public abstract class _KMIAbstractAsset extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "KMIAbstractAsset";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATE_DATE = new ERXKey<NSTimestamp>("createDate");
  public static final ERXKey<NSTimestamp> LAST_MODIFIED = new ERXKey<NSTimestamp>("lastModified");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> TYPE = new ERXKey<Integer>("type");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIAssetGallery> GALLERIES = new ERXKey<km.content.eo.KMIAssetGallery>("galleries");
  public static final ERXKey<km.content.eo.KMIAssetGroup> GROUP = new ERXKey<km.content.eo.KMIAssetGroup>("group");
  public static final ERXKey<km.content.eo.KMIWebSite> SITE = new ERXKey<km.content.eo.KMIWebSite>("site");

  // Attributes
  public static final String CREATE_DATE_KEY = CREATE_DATE.key();
  public static final String LAST_MODIFIED_KEY = LAST_MODIFIED.key();
  public static final String NAME_KEY = NAME.key();
  public static final String TYPE_KEY = TYPE.key();
  // Relationships
  public static final String GALLERIES_KEY = GALLERIES.key();
  public static final String GROUP_KEY = GROUP.key();
  public static final String SITE_KEY = SITE.key();

  private static Logger LOG = Logger.getLogger(_KMIAbstractAsset.class);

  public KMIAbstractAsset localInstanceIn(EOEditingContext editingContext) {
    KMIAbstractAsset localInstance = (KMIAbstractAsset)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp createDate() {
    return (NSTimestamp) storedValueForKey(_KMIAbstractAsset.CREATE_DATE_KEY);
  }

  public void setCreateDate(NSTimestamp value) {
    if (_KMIAbstractAsset.LOG.isDebugEnabled()) {
    	_KMIAbstractAsset.LOG.debug( "updating createDate from " + createDate() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAbstractAsset.CREATE_DATE_KEY);
  }

  public NSTimestamp lastModified() {
    return (NSTimestamp) storedValueForKey(_KMIAbstractAsset.LAST_MODIFIED_KEY);
  }

  public void setLastModified(NSTimestamp value) {
    if (_KMIAbstractAsset.LOG.isDebugEnabled()) {
    	_KMIAbstractAsset.LOG.debug( "updating lastModified from " + lastModified() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAbstractAsset.LAST_MODIFIED_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_KMIAbstractAsset.NAME_KEY);
  }

  public void setName(String value) {
    if (_KMIAbstractAsset.LOG.isDebugEnabled()) {
    	_KMIAbstractAsset.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAbstractAsset.NAME_KEY);
  }

  public Integer type() {
    return (Integer) storedValueForKey(_KMIAbstractAsset.TYPE_KEY);
  }

  public void setType(Integer value) {
    if (_KMIAbstractAsset.LOG.isDebugEnabled()) {
    	_KMIAbstractAsset.LOG.debug( "updating type from " + type() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAbstractAsset.TYPE_KEY);
  }

  public km.content.eo.KMIAssetGroup group() {
    return (km.content.eo.KMIAssetGroup)storedValueForKey(_KMIAbstractAsset.GROUP_KEY);
  }
  
  public void setGroup(km.content.eo.KMIAssetGroup value) {
    takeStoredValueForKey(value, _KMIAbstractAsset.GROUP_KEY);
  }

  public void setGroupRelationship(km.content.eo.KMIAssetGroup value) {
    if (_KMIAbstractAsset.LOG.isDebugEnabled()) {
      _KMIAbstractAsset.LOG.debug("updating group from " + group() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setGroup(value);
    }
    else if (value == null) {
    	km.content.eo.KMIAssetGroup oldValue = group();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIAbstractAsset.GROUP_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIAbstractAsset.GROUP_KEY);
    }
  }
  
  public km.content.eo.KMIWebSite site() {
    return (km.content.eo.KMIWebSite)storedValueForKey(_KMIAbstractAsset.SITE_KEY);
  }
  
  public void setSite(km.content.eo.KMIWebSite value) {
    takeStoredValueForKey(value, _KMIAbstractAsset.SITE_KEY);
  }

  public void setSiteRelationship(km.content.eo.KMIWebSite value) {
    if (_KMIAbstractAsset.LOG.isDebugEnabled()) {
      _KMIAbstractAsset.LOG.debug("updating site from " + site() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setSite(value);
    }
    else if (value == null) {
    	km.content.eo.KMIWebSite oldValue = site();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIAbstractAsset.SITE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIAbstractAsset.SITE_KEY);
    }
  }
  
  public NSArray<km.content.eo.KMIAssetGallery> galleries() {
    return (NSArray<km.content.eo.KMIAssetGallery>)storedValueForKey(_KMIAbstractAsset.GALLERIES_KEY);
  }

  public NSArray<km.content.eo.KMIAssetGallery> galleries(EOQualifier qualifier) {
    return galleries(qualifier, null);
  }

  public NSArray<km.content.eo.KMIAssetGallery> galleries(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<km.content.eo.KMIAssetGallery> results;
      results = galleries();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIAssetGallery>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIAssetGallery>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToGalleries(km.content.eo.KMIAssetGallery object) {
    includeObjectIntoPropertyWithKey(object, _KMIAbstractAsset.GALLERIES_KEY);
  }

  public void removeFromGalleries(km.content.eo.KMIAssetGallery object) {
    excludeObjectFromPropertyWithKey(object, _KMIAbstractAsset.GALLERIES_KEY);
  }

  public void addToGalleriesRelationship(km.content.eo.KMIAssetGallery object) {
    if (_KMIAbstractAsset.LOG.isDebugEnabled()) {
      _KMIAbstractAsset.LOG.debug("adding " + object + " to galleries relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToGalleries(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIAbstractAsset.GALLERIES_KEY);
    }
  }

  public void removeFromGalleriesRelationship(km.content.eo.KMIAssetGallery object) {
    if (_KMIAbstractAsset.LOG.isDebugEnabled()) {
      _KMIAbstractAsset.LOG.debug("removing " + object + " from galleries relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromGalleries(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIAbstractAsset.GALLERIES_KEY);
    }
  }

  public km.content.eo.KMIAssetGallery createGalleriesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIAssetGallery.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIAbstractAsset.GALLERIES_KEY);
    return (km.content.eo.KMIAssetGallery) eo;
  }

  public void deleteGalleriesRelationship(km.content.eo.KMIAssetGallery object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIAbstractAsset.GALLERIES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllGalleriesRelationships() {
    Enumeration<km.content.eo.KMIAssetGallery> objects = galleries().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteGalleriesRelationship(objects.nextElement());
    }
  }


  public static KMIAbstractAsset createKMIAbstractAsset(EOEditingContext editingContext, km.content.eo.KMIWebSite site) {
    KMIAbstractAsset eo = (KMIAbstractAsset) EOUtilities.createAndInsertInstance(editingContext, _KMIAbstractAsset.ENTITY_NAME);    
    eo.setSiteRelationship(site);
    return eo;
  }

  public static ERXFetchSpecification<KMIAbstractAsset> fetchSpec() {
    return new ERXFetchSpecification<KMIAbstractAsset>(_KMIAbstractAsset.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIAbstractAsset> fetchAllKMIAbstractAssets(EOEditingContext editingContext) {
    return _KMIAbstractAsset.fetchAllKMIAbstractAssets(editingContext, null);
  }

  public static NSArray<KMIAbstractAsset> fetchAllKMIAbstractAssets(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIAbstractAsset.fetchKMIAbstractAssets(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIAbstractAsset> fetchKMIAbstractAssets(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIAbstractAsset> fetchSpec = new ERXFetchSpecification<KMIAbstractAsset>(_KMIAbstractAsset.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIAbstractAsset> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIAbstractAsset fetchKMIAbstractAsset(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIAbstractAsset.fetchKMIAbstractAsset(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIAbstractAsset fetchKMIAbstractAsset(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIAbstractAsset> eoObjects = _KMIAbstractAsset.fetchKMIAbstractAssets(editingContext, qualifier, null);
    KMIAbstractAsset eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIAbstractAsset that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIAbstractAsset fetchRequiredKMIAbstractAsset(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIAbstractAsset.fetchRequiredKMIAbstractAsset(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIAbstractAsset fetchRequiredKMIAbstractAsset(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIAbstractAsset eoObject = _KMIAbstractAsset.fetchKMIAbstractAsset(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIAbstractAsset that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIAbstractAsset localInstanceIn(EOEditingContext editingContext, KMIAbstractAsset eo) {
    KMIAbstractAsset localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}