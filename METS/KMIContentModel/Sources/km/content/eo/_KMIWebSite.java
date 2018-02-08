// DO NOT EDIT.  Make changes to KMIWebSite.java instead.
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
public abstract class _KMIWebSite extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "KMIWebSite";

  // Attribute Keys
  public static final ERXKey<String> DOMAIN_NAME = new ERXKey<String>("domainName");
  public static final ERXKey<com.webobjects.foundation.NSDictionary> PROPERTIES = new ERXKey<com.webobjects.foundation.NSDictionary>("properties");
  public static final ERXKey<Integer> TYPE = new ERXKey<Integer>("type");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIAssetGallery> ASSET_GALLERIES = new ERXKey<km.content.eo.KMIAssetGallery>("assetGalleries");
  public static final ERXKey<km.content.eo.KMIAssetGroup> ASSET_GROUPS = new ERXKey<km.content.eo.KMIAssetGroup>("assetGroups");
  public static final ERXKey<km.content.eo.KMIAbstractAsset> ASSETS = new ERXKey<km.content.eo.KMIAbstractAsset>("assets");
  public static final ERXKey<km.content.eo.KMIWebDocumentCategory> CATEGORIES = new ERXKey<km.content.eo.KMIWebDocumentCategory>("categories");
  public static final ERXKey<km.content.eo.KMIAbstractDocument> DOCUMENTS = new ERXKey<km.content.eo.KMIAbstractDocument>("documents");
  public static final ERXKey<km.content.eo.KMIWebDocumentKeyWord> KEY_WORDS = new ERXKey<km.content.eo.KMIWebDocumentKeyWord>("keyWords");
  public static final ERXKey<km.content.eo.KMIWebSiteTestimonial> TESTIMONIALS = new ERXKey<km.content.eo.KMIWebSiteTestimonial>("testimonials");

  // Attributes
  public static final String DOMAIN_NAME_KEY = DOMAIN_NAME.key();
  public static final String PROPERTIES_KEY = PROPERTIES.key();
  public static final String TYPE_KEY = TYPE.key();
  // Relationships
  public static final String ASSET_GALLERIES_KEY = ASSET_GALLERIES.key();
  public static final String ASSET_GROUPS_KEY = ASSET_GROUPS.key();
  public static final String ASSETS_KEY = ASSETS.key();
  public static final String CATEGORIES_KEY = CATEGORIES.key();
  public static final String DOCUMENTS_KEY = DOCUMENTS.key();
  public static final String KEY_WORDS_KEY = KEY_WORDS.key();
  public static final String TESTIMONIALS_KEY = TESTIMONIALS.key();

  private static Logger LOG = Logger.getLogger(_KMIWebSite.class);

  public KMIWebSite localInstanceIn(EOEditingContext editingContext) {
    KMIWebSite localInstance = (KMIWebSite)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String domainName() {
    return (String) storedValueForKey(_KMIWebSite.DOMAIN_NAME_KEY);
  }

  public void setDomainName(String value) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
    	_KMIWebSite.LOG.debug( "updating domainName from " + domainName() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebSite.DOMAIN_NAME_KEY);
  }

  public com.webobjects.foundation.NSDictionary properties() {
    return (com.webobjects.foundation.NSDictionary) storedValueForKey(_KMIWebSite.PROPERTIES_KEY);
  }

  public void setProperties(com.webobjects.foundation.NSDictionary value) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
    	_KMIWebSite.LOG.debug( "updating properties from " + properties() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebSite.PROPERTIES_KEY);
  }

  public Integer type() {
    return (Integer) storedValueForKey(_KMIWebSite.TYPE_KEY);
  }

  public void setType(Integer value) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
    	_KMIWebSite.LOG.debug( "updating type from " + type() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebSite.TYPE_KEY);
  }

  public NSArray<km.content.eo.KMIAssetGallery> assetGalleries() {
    return (NSArray<km.content.eo.KMIAssetGallery>)storedValueForKey(_KMIWebSite.ASSET_GALLERIES_KEY);
  }

  public NSArray<km.content.eo.KMIAssetGallery> assetGalleries(EOQualifier qualifier) {
    return assetGalleries(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIAssetGallery> assetGalleries(EOQualifier qualifier, boolean fetch) {
    return assetGalleries(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIAssetGallery> assetGalleries(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIAssetGallery> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIAssetGallery.SITE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = km.content.eo.KMIAssetGallery.fetchKMIAssetGalleries(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = assetGalleries();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIAssetGallery>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIAssetGallery>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToAssetGalleries(km.content.eo.KMIAssetGallery object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebSite.ASSET_GALLERIES_KEY);
  }

  public void removeFromAssetGalleries(km.content.eo.KMIAssetGallery object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebSite.ASSET_GALLERIES_KEY);
  }

  public void addToAssetGalleriesRelationship(km.content.eo.KMIAssetGallery object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("adding " + object + " to assetGalleries relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToAssetGalleries(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebSite.ASSET_GALLERIES_KEY);
    }
  }

  public void removeFromAssetGalleriesRelationship(km.content.eo.KMIAssetGallery object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("removing " + object + " from assetGalleries relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromAssetGalleries(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.ASSET_GALLERIES_KEY);
    }
  }

  public km.content.eo.KMIAssetGallery createAssetGalleriesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIAssetGallery.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebSite.ASSET_GALLERIES_KEY);
    return (km.content.eo.KMIAssetGallery) eo;
  }

  public void deleteAssetGalleriesRelationship(km.content.eo.KMIAssetGallery object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.ASSET_GALLERIES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllAssetGalleriesRelationships() {
    Enumeration<km.content.eo.KMIAssetGallery> objects = assetGalleries().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteAssetGalleriesRelationship(objects.nextElement());
    }
  }

  public NSArray<km.content.eo.KMIAssetGroup> assetGroups() {
    return (NSArray<km.content.eo.KMIAssetGroup>)storedValueForKey(_KMIWebSite.ASSET_GROUPS_KEY);
  }

  public NSArray<km.content.eo.KMIAssetGroup> assetGroups(EOQualifier qualifier) {
    return assetGroups(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIAssetGroup> assetGroups(EOQualifier qualifier, boolean fetch) {
    return assetGroups(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIAssetGroup> assetGroups(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIAssetGroup> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIAssetGroup.SITE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = km.content.eo.KMIAssetGroup.fetchKMIAssetGroups(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = assetGroups();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIAssetGroup>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIAssetGroup>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToAssetGroups(km.content.eo.KMIAssetGroup object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebSite.ASSET_GROUPS_KEY);
  }

  public void removeFromAssetGroups(km.content.eo.KMIAssetGroup object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebSite.ASSET_GROUPS_KEY);
  }

  public void addToAssetGroupsRelationship(km.content.eo.KMIAssetGroup object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("adding " + object + " to assetGroups relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToAssetGroups(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebSite.ASSET_GROUPS_KEY);
    }
  }

  public void removeFromAssetGroupsRelationship(km.content.eo.KMIAssetGroup object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("removing " + object + " from assetGroups relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromAssetGroups(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.ASSET_GROUPS_KEY);
    }
  }

  public km.content.eo.KMIAssetGroup createAssetGroupsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIAssetGroup.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebSite.ASSET_GROUPS_KEY);
    return (km.content.eo.KMIAssetGroup) eo;
  }

  public void deleteAssetGroupsRelationship(km.content.eo.KMIAssetGroup object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.ASSET_GROUPS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllAssetGroupsRelationships() {
    Enumeration<km.content.eo.KMIAssetGroup> objects = assetGroups().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteAssetGroupsRelationship(objects.nextElement());
    }
  }

  public NSArray<km.content.eo.KMIAbstractAsset> assets() {
    return (NSArray<km.content.eo.KMIAbstractAsset>)storedValueForKey(_KMIWebSite.ASSETS_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIAbstractAsset.SITE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _KMIWebSite.ASSETS_KEY);
  }

  public void removeFromAssets(km.content.eo.KMIAbstractAsset object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebSite.ASSETS_KEY);
  }

  public void addToAssetsRelationship(km.content.eo.KMIAbstractAsset object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("adding " + object + " to assets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToAssets(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebSite.ASSETS_KEY);
    }
  }

  public void removeFromAssetsRelationship(km.content.eo.KMIAbstractAsset object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("removing " + object + " from assets relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromAssets(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.ASSETS_KEY);
    }
  }

  public km.content.eo.KMIAbstractAsset createAssetsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIAbstractAsset.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebSite.ASSETS_KEY);
    return (km.content.eo.KMIAbstractAsset) eo;
  }

  public void deleteAssetsRelationship(km.content.eo.KMIAbstractAsset object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.ASSETS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllAssetsRelationships() {
    Enumeration<km.content.eo.KMIAbstractAsset> objects = assets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteAssetsRelationship(objects.nextElement());
    }
  }

  public NSArray<km.content.eo.KMIWebDocumentCategory> categories() {
    return (NSArray<km.content.eo.KMIWebDocumentCategory>)storedValueForKey(_KMIWebSite.CATEGORIES_KEY);
  }

  public NSArray<km.content.eo.KMIWebDocumentCategory> categories(EOQualifier qualifier) {
    return categories(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIWebDocumentCategory> categories(EOQualifier qualifier, boolean fetch) {
    return categories(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIWebDocumentCategory> categories(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIWebDocumentCategory> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIWebDocumentCategory.SITE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = km.content.eo.KMIWebDocumentCategory.fetchKMIWebDocumentCategories(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = categories();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIWebDocumentCategory>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIWebDocumentCategory>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToCategories(km.content.eo.KMIWebDocumentCategory object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebSite.CATEGORIES_KEY);
  }

  public void removeFromCategories(km.content.eo.KMIWebDocumentCategory object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebSite.CATEGORIES_KEY);
  }

  public void addToCategoriesRelationship(km.content.eo.KMIWebDocumentCategory object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("adding " + object + " to categories relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToCategories(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebSite.CATEGORIES_KEY);
    }
  }

  public void removeFromCategoriesRelationship(km.content.eo.KMIWebDocumentCategory object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("removing " + object + " from categories relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromCategories(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.CATEGORIES_KEY);
    }
  }

  public km.content.eo.KMIWebDocumentCategory createCategoriesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIWebDocumentCategory.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebSite.CATEGORIES_KEY);
    return (km.content.eo.KMIWebDocumentCategory) eo;
  }

  public void deleteCategoriesRelationship(km.content.eo.KMIWebDocumentCategory object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.CATEGORIES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllCategoriesRelationships() {
    Enumeration<km.content.eo.KMIWebDocumentCategory> objects = categories().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteCategoriesRelationship(objects.nextElement());
    }
  }

  public NSArray<km.content.eo.KMIAbstractDocument> documents() {
    return (NSArray<km.content.eo.KMIAbstractDocument>)storedValueForKey(_KMIWebSite.DOCUMENTS_KEY);
  }

  public NSArray<km.content.eo.KMIAbstractDocument> documents(EOQualifier qualifier) {
    return documents(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIAbstractDocument> documents(EOQualifier qualifier, boolean fetch) {
    return documents(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIAbstractDocument> documents(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIAbstractDocument> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIAbstractDocument.SITE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = km.content.eo.KMIAbstractDocument.fetchKMIAbstractDocuments(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = documents();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIAbstractDocument>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIAbstractDocument>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToDocuments(km.content.eo.KMIAbstractDocument object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebSite.DOCUMENTS_KEY);
  }

  public void removeFromDocuments(km.content.eo.KMIAbstractDocument object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebSite.DOCUMENTS_KEY);
  }

  public void addToDocumentsRelationship(km.content.eo.KMIAbstractDocument object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("adding " + object + " to documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToDocuments(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebSite.DOCUMENTS_KEY);
    }
  }

  public void removeFromDocumentsRelationship(km.content.eo.KMIAbstractDocument object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("removing " + object + " from documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromDocuments(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.DOCUMENTS_KEY);
    }
  }

  public km.content.eo.KMIAbstractDocument createDocumentsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIAbstractDocument.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebSite.DOCUMENTS_KEY);
    return (km.content.eo.KMIAbstractDocument) eo;
  }

  public void deleteDocumentsRelationship(km.content.eo.KMIAbstractDocument object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.DOCUMENTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllDocumentsRelationships() {
    Enumeration<km.content.eo.KMIAbstractDocument> objects = documents().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDocumentsRelationship(objects.nextElement());
    }
  }

  public NSArray<km.content.eo.KMIWebDocumentKeyWord> keyWords() {
    return (NSArray<km.content.eo.KMIWebDocumentKeyWord>)storedValueForKey(_KMIWebSite.KEY_WORDS_KEY);
  }

  public NSArray<km.content.eo.KMIWebDocumentKeyWord> keyWords(EOQualifier qualifier) {
    return keyWords(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIWebDocumentKeyWord> keyWords(EOQualifier qualifier, boolean fetch) {
    return keyWords(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIWebDocumentKeyWord> keyWords(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIWebDocumentKeyWord> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIWebDocumentKeyWord.SITE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = km.content.eo.KMIWebDocumentKeyWord.fetchKMIWebDocumentKeyWords(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = keyWords();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIWebDocumentKeyWord>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIWebDocumentKeyWord>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToKeyWords(km.content.eo.KMIWebDocumentKeyWord object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebSite.KEY_WORDS_KEY);
  }

  public void removeFromKeyWords(km.content.eo.KMIWebDocumentKeyWord object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebSite.KEY_WORDS_KEY);
  }

  public void addToKeyWordsRelationship(km.content.eo.KMIWebDocumentKeyWord object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("adding " + object + " to keyWords relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToKeyWords(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebSite.KEY_WORDS_KEY);
    }
  }

  public void removeFromKeyWordsRelationship(km.content.eo.KMIWebDocumentKeyWord object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("removing " + object + " from keyWords relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromKeyWords(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.KEY_WORDS_KEY);
    }
  }

  public km.content.eo.KMIWebDocumentKeyWord createKeyWordsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIWebDocumentKeyWord.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebSite.KEY_WORDS_KEY);
    return (km.content.eo.KMIWebDocumentKeyWord) eo;
  }

  public void deleteKeyWordsRelationship(km.content.eo.KMIWebDocumentKeyWord object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.KEY_WORDS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllKeyWordsRelationships() {
    Enumeration<km.content.eo.KMIWebDocumentKeyWord> objects = keyWords().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteKeyWordsRelationship(objects.nextElement());
    }
  }

  public NSArray<km.content.eo.KMIWebSiteTestimonial> testimonials() {
    return (NSArray<km.content.eo.KMIWebSiteTestimonial>)storedValueForKey(_KMIWebSite.TESTIMONIALS_KEY);
  }

  public NSArray<km.content.eo.KMIWebSiteTestimonial> testimonials(EOQualifier qualifier) {
    return testimonials(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIWebSiteTestimonial> testimonials(EOQualifier qualifier, boolean fetch) {
    return testimonials(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIWebSiteTestimonial> testimonials(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIWebSiteTestimonial> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIWebSiteTestimonial.WEB_SITE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = km.content.eo.KMIWebSiteTestimonial.fetchKMIWebSiteTestimonials(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = testimonials();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIWebSiteTestimonial>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIWebSiteTestimonial>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToTestimonials(km.content.eo.KMIWebSiteTestimonial object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebSite.TESTIMONIALS_KEY);
  }

  public void removeFromTestimonials(km.content.eo.KMIWebSiteTestimonial object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebSite.TESTIMONIALS_KEY);
  }

  public void addToTestimonialsRelationship(km.content.eo.KMIWebSiteTestimonial object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("adding " + object + " to testimonials relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToTestimonials(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebSite.TESTIMONIALS_KEY);
    }
  }

  public void removeFromTestimonialsRelationship(km.content.eo.KMIWebSiteTestimonial object) {
    if (_KMIWebSite.LOG.isDebugEnabled()) {
      _KMIWebSite.LOG.debug("removing " + object + " from testimonials relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromTestimonials(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.TESTIMONIALS_KEY);
    }
  }

  public km.content.eo.KMIWebSiteTestimonial createTestimonialsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIWebSiteTestimonial.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebSite.TESTIMONIALS_KEY);
    return (km.content.eo.KMIWebSiteTestimonial) eo;
  }

  public void deleteTestimonialsRelationship(km.content.eo.KMIWebSiteTestimonial object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebSite.TESTIMONIALS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllTestimonialsRelationships() {
    Enumeration<km.content.eo.KMIWebSiteTestimonial> objects = testimonials().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteTestimonialsRelationship(objects.nextElement());
    }
  }


  public static KMIWebSite createKMIWebSite(EOEditingContext editingContext) {
    KMIWebSite eo = (KMIWebSite) EOUtilities.createAndInsertInstance(editingContext, _KMIWebSite.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<KMIWebSite> fetchSpec() {
    return new ERXFetchSpecification<KMIWebSite>(_KMIWebSite.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIWebSite> fetchAllKMIWebSites(EOEditingContext editingContext) {
    return _KMIWebSite.fetchAllKMIWebSites(editingContext, null);
  }

  public static NSArray<KMIWebSite> fetchAllKMIWebSites(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIWebSite.fetchKMIWebSites(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIWebSite> fetchKMIWebSites(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIWebSite> fetchSpec = new ERXFetchSpecification<KMIWebSite>(_KMIWebSite.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIWebSite> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIWebSite fetchKMIWebSite(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebSite.fetchKMIWebSite(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebSite fetchKMIWebSite(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIWebSite> eoObjects = _KMIWebSite.fetchKMIWebSites(editingContext, qualifier, null);
    KMIWebSite eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIWebSite that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebSite fetchRequiredKMIWebSite(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebSite.fetchRequiredKMIWebSite(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebSite fetchRequiredKMIWebSite(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIWebSite eoObject = _KMIWebSite.fetchKMIWebSite(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIWebSite that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebSite localInstanceIn(EOEditingContext editingContext, KMIWebSite eo) {
    KMIWebSite localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}