// DO NOT EDIT.  Make changes to KMIWebDocumentCategory.java instead.
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
public abstract class _KMIWebDocumentCategory extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "KMIWebDocumentCategory";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> SLUG = new ERXKey<String>("slug");
  public static final ERXKey<String> UNIQUE_IDENTIFIER = new ERXKey<String>("uniqueIdentifier");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIWebDocumentCategory> CHILDREN = new ERXKey<km.content.eo.KMIWebDocumentCategory>("children");
  public static final ERXKey<km.content.eo.KMIWebDocument> DOCUMENTS = new ERXKey<km.content.eo.KMIWebDocument>("documents");
  public static final ERXKey<km.content.eo.KMIWebDocumentCategory> PARENT = new ERXKey<km.content.eo.KMIWebDocumentCategory>("parent");
  public static final ERXKey<km.content.eo.KMIWebSite> SITE = new ERXKey<km.content.eo.KMIWebSite>("site");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  public static final String SLUG_KEY = SLUG.key();
  public static final String UNIQUE_IDENTIFIER_KEY = UNIQUE_IDENTIFIER.key();
  // Relationships
  public static final String CHILDREN_KEY = CHILDREN.key();
  public static final String DOCUMENTS_KEY = DOCUMENTS.key();
  public static final String PARENT_KEY = PARENT.key();
  public static final String SITE_KEY = SITE.key();

  private static Logger LOG = Logger.getLogger(_KMIWebDocumentCategory.class);

  public KMIWebDocumentCategory localInstanceIn(EOEditingContext editingContext) {
    KMIWebDocumentCategory localInstance = (KMIWebDocumentCategory)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_KMIWebDocumentCategory.NAME_KEY);
  }

  public void setName(String value) {
    if (_KMIWebDocumentCategory.LOG.isDebugEnabled()) {
    	_KMIWebDocumentCategory.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocumentCategory.NAME_KEY);
  }

  public String slug() {
    return (String) storedValueForKey(_KMIWebDocumentCategory.SLUG_KEY);
  }

  public void setSlug(String value) {
    if (_KMIWebDocumentCategory.LOG.isDebugEnabled()) {
    	_KMIWebDocumentCategory.LOG.debug( "updating slug from " + slug() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocumentCategory.SLUG_KEY);
  }

  public String uniqueIdentifier() {
    return (String) storedValueForKey(_KMIWebDocumentCategory.UNIQUE_IDENTIFIER_KEY);
  }

  public void setUniqueIdentifier(String value) {
    if (_KMIWebDocumentCategory.LOG.isDebugEnabled()) {
    	_KMIWebDocumentCategory.LOG.debug( "updating uniqueIdentifier from " + uniqueIdentifier() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocumentCategory.UNIQUE_IDENTIFIER_KEY);
  }

  public km.content.eo.KMIWebDocumentCategory parent() {
    return (km.content.eo.KMIWebDocumentCategory)storedValueForKey(_KMIWebDocumentCategory.PARENT_KEY);
  }
  
  public void setParent(km.content.eo.KMIWebDocumentCategory value) {
    takeStoredValueForKey(value, _KMIWebDocumentCategory.PARENT_KEY);
  }

  public void setParentRelationship(km.content.eo.KMIWebDocumentCategory value) {
    if (_KMIWebDocumentCategory.LOG.isDebugEnabled()) {
      _KMIWebDocumentCategory.LOG.debug("updating parent from " + parent() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setParent(value);
    }
    else if (value == null) {
    	km.content.eo.KMIWebDocumentCategory oldValue = parent();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIWebDocumentCategory.PARENT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIWebDocumentCategory.PARENT_KEY);
    }
  }
  
  public km.content.eo.KMIWebSite site() {
    return (km.content.eo.KMIWebSite)storedValueForKey(_KMIWebDocumentCategory.SITE_KEY);
  }
  
  public void setSite(km.content.eo.KMIWebSite value) {
    takeStoredValueForKey(value, _KMIWebDocumentCategory.SITE_KEY);
  }

  public void setSiteRelationship(km.content.eo.KMIWebSite value) {
    if (_KMIWebDocumentCategory.LOG.isDebugEnabled()) {
      _KMIWebDocumentCategory.LOG.debug("updating site from " + site() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setSite(value);
    }
    else if (value == null) {
    	km.content.eo.KMIWebSite oldValue = site();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIWebDocumentCategory.SITE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIWebDocumentCategory.SITE_KEY);
    }
  }
  
  public NSArray<km.content.eo.KMIWebDocumentCategory> children() {
    return (NSArray<km.content.eo.KMIWebDocumentCategory>)storedValueForKey(_KMIWebDocumentCategory.CHILDREN_KEY);
  }

  public NSArray<km.content.eo.KMIWebDocumentCategory> children(EOQualifier qualifier) {
    return children(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIWebDocumentCategory> children(EOQualifier qualifier, boolean fetch) {
    return children(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIWebDocumentCategory> children(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIWebDocumentCategory> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIWebDocumentCategory.PARENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
      results = children();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIWebDocumentCategory>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIWebDocumentCategory>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToChildren(km.content.eo.KMIWebDocumentCategory object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebDocumentCategory.CHILDREN_KEY);
  }

  public void removeFromChildren(km.content.eo.KMIWebDocumentCategory object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebDocumentCategory.CHILDREN_KEY);
  }

  public void addToChildrenRelationship(km.content.eo.KMIWebDocumentCategory object) {
    if (_KMIWebDocumentCategory.LOG.isDebugEnabled()) {
      _KMIWebDocumentCategory.LOG.debug("adding " + object + " to children relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToChildren(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebDocumentCategory.CHILDREN_KEY);
    }
  }

  public void removeFromChildrenRelationship(km.content.eo.KMIWebDocumentCategory object) {
    if (_KMIWebDocumentCategory.LOG.isDebugEnabled()) {
      _KMIWebDocumentCategory.LOG.debug("removing " + object + " from children relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromChildren(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocumentCategory.CHILDREN_KEY);
    }
  }

  public km.content.eo.KMIWebDocumentCategory createChildrenRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIWebDocumentCategory.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebDocumentCategory.CHILDREN_KEY);
    return (km.content.eo.KMIWebDocumentCategory) eo;
  }

  public void deleteChildrenRelationship(km.content.eo.KMIWebDocumentCategory object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocumentCategory.CHILDREN_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllChildrenRelationships() {
    Enumeration<km.content.eo.KMIWebDocumentCategory> objects = children().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteChildrenRelationship(objects.nextElement());
    }
  }

  public NSArray<km.content.eo.KMIWebDocument> documents() {
    return (NSArray<km.content.eo.KMIWebDocument>)storedValueForKey(_KMIWebDocumentCategory.DOCUMENTS_KEY);
  }

  public NSArray<km.content.eo.KMIWebDocument> documents(EOQualifier qualifier) {
    return documents(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIWebDocument> documents(EOQualifier qualifier, boolean fetch) {
    return documents(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIWebDocument> documents(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIWebDocument> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIWebDocument.CATEGORY_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = km.content.eo.KMIWebDocument.fetchKMIWebDocuments(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = documents();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIWebDocument>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIWebDocument>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToDocuments(km.content.eo.KMIWebDocument object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebDocumentCategory.DOCUMENTS_KEY);
  }

  public void removeFromDocuments(km.content.eo.KMIWebDocument object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebDocumentCategory.DOCUMENTS_KEY);
  }

  public void addToDocumentsRelationship(km.content.eo.KMIWebDocument object) {
    if (_KMIWebDocumentCategory.LOG.isDebugEnabled()) {
      _KMIWebDocumentCategory.LOG.debug("adding " + object + " to documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToDocuments(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebDocumentCategory.DOCUMENTS_KEY);
    }
  }

  public void removeFromDocumentsRelationship(km.content.eo.KMIWebDocument object) {
    if (_KMIWebDocumentCategory.LOG.isDebugEnabled()) {
      _KMIWebDocumentCategory.LOG.debug("removing " + object + " from documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromDocuments(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocumentCategory.DOCUMENTS_KEY);
    }
  }

  public km.content.eo.KMIWebDocument createDocumentsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIWebDocument.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebDocumentCategory.DOCUMENTS_KEY);
    return (km.content.eo.KMIWebDocument) eo;
  }

  public void deleteDocumentsRelationship(km.content.eo.KMIWebDocument object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocumentCategory.DOCUMENTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllDocumentsRelationships() {
    Enumeration<km.content.eo.KMIWebDocument> objects = documents().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDocumentsRelationship(objects.nextElement());
    }
  }


  public static KMIWebDocumentCategory createKMIWebDocumentCategory(EOEditingContext editingContext, km.content.eo.KMIWebSite site) {
    KMIWebDocumentCategory eo = (KMIWebDocumentCategory) EOUtilities.createAndInsertInstance(editingContext, _KMIWebDocumentCategory.ENTITY_NAME);    
    eo.setSiteRelationship(site);
    return eo;
  }

  public static ERXFetchSpecification<KMIWebDocumentCategory> fetchSpec() {
    return new ERXFetchSpecification<KMIWebDocumentCategory>(_KMIWebDocumentCategory.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIWebDocumentCategory> fetchAllKMIWebDocumentCategories(EOEditingContext editingContext) {
    return _KMIWebDocumentCategory.fetchAllKMIWebDocumentCategories(editingContext, null);
  }

  public static NSArray<KMIWebDocumentCategory> fetchAllKMIWebDocumentCategories(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIWebDocumentCategory.fetchKMIWebDocumentCategories(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIWebDocumentCategory> fetchKMIWebDocumentCategories(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIWebDocumentCategory> fetchSpec = new ERXFetchSpecification<KMIWebDocumentCategory>(_KMIWebDocumentCategory.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIWebDocumentCategory> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIWebDocumentCategory fetchKMIWebDocumentCategory(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebDocumentCategory.fetchKMIWebDocumentCategory(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebDocumentCategory fetchKMIWebDocumentCategory(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIWebDocumentCategory> eoObjects = _KMIWebDocumentCategory.fetchKMIWebDocumentCategories(editingContext, qualifier, null);
    KMIWebDocumentCategory eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIWebDocumentCategory that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebDocumentCategory fetchRequiredKMIWebDocumentCategory(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebDocumentCategory.fetchRequiredKMIWebDocumentCategory(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebDocumentCategory fetchRequiredKMIWebDocumentCategory(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIWebDocumentCategory eoObject = _KMIWebDocumentCategory.fetchKMIWebDocumentCategory(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIWebDocumentCategory that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebDocumentCategory localInstanceIn(EOEditingContext editingContext, KMIWebDocumentCategory eo) {
    KMIWebDocumentCategory localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}