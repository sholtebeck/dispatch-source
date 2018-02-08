// DO NOT EDIT.  Make changes to KMIWebDocumentKeyWord.java instead.
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
public abstract class _KMIWebDocumentKeyWord extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "KMIWebDocumentKeyWord";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> SLUG = new ERXKey<String>("slug");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIWebDocument> DOCUMENTS = new ERXKey<km.content.eo.KMIWebDocument>("documents");
  public static final ERXKey<EOGenericRecord> DOCUMENTS_KEY_WORDS = new ERXKey<EOGenericRecord>("documentsKeyWords");
  public static final ERXKey<km.content.eo.KMIWebSite> SITE = new ERXKey<km.content.eo.KMIWebSite>("site");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  public static final String SLUG_KEY = SLUG.key();
  // Relationships
  public static final String DOCUMENTS_KEY = DOCUMENTS.key();
  public static final String DOCUMENTS_KEY_WORDS_KEY = DOCUMENTS_KEY_WORDS.key();
  public static final String SITE_KEY = SITE.key();

  private static Logger LOG = Logger.getLogger(_KMIWebDocumentKeyWord.class);

  public KMIWebDocumentKeyWord localInstanceIn(EOEditingContext editingContext) {
    KMIWebDocumentKeyWord localInstance = (KMIWebDocumentKeyWord)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_KMIWebDocumentKeyWord.NAME_KEY);
  }

  public void setName(String value) {
    if (_KMIWebDocumentKeyWord.LOG.isDebugEnabled()) {
    	_KMIWebDocumentKeyWord.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocumentKeyWord.NAME_KEY);
  }

  public String slug() {
    return (String) storedValueForKey(_KMIWebDocumentKeyWord.SLUG_KEY);
  }

  public void setSlug(String value) {
    if (_KMIWebDocumentKeyWord.LOG.isDebugEnabled()) {
    	_KMIWebDocumentKeyWord.LOG.debug( "updating slug from " + slug() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocumentKeyWord.SLUG_KEY);
  }

  public km.content.eo.KMIWebSite site() {
    return (km.content.eo.KMIWebSite)storedValueForKey(_KMIWebDocumentKeyWord.SITE_KEY);
  }
  
  public void setSite(km.content.eo.KMIWebSite value) {
    takeStoredValueForKey(value, _KMIWebDocumentKeyWord.SITE_KEY);
  }

  public void setSiteRelationship(km.content.eo.KMIWebSite value) {
    if (_KMIWebDocumentKeyWord.LOG.isDebugEnabled()) {
      _KMIWebDocumentKeyWord.LOG.debug("updating site from " + site() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setSite(value);
    }
    else if (value == null) {
    	km.content.eo.KMIWebSite oldValue = site();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIWebDocumentKeyWord.SITE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIWebDocumentKeyWord.SITE_KEY);
    }
  }
  
  public NSArray<km.content.eo.KMIWebDocument> documents() {
    return (NSArray<km.content.eo.KMIWebDocument>)storedValueForKey(_KMIWebDocumentKeyWord.DOCUMENTS_KEY);
  }

  public NSArray<km.content.eo.KMIWebDocument> documents(EOQualifier qualifier) {
    return documents(qualifier, null);
  }

  public NSArray<km.content.eo.KMIWebDocument> documents(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<km.content.eo.KMIWebDocument> results;
      results = documents();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIWebDocument>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIWebDocument>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToDocuments(km.content.eo.KMIWebDocument object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebDocumentKeyWord.DOCUMENTS_KEY);
  }

  public void removeFromDocuments(km.content.eo.KMIWebDocument object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebDocumentKeyWord.DOCUMENTS_KEY);
  }

  public void addToDocumentsRelationship(km.content.eo.KMIWebDocument object) {
    if (_KMIWebDocumentKeyWord.LOG.isDebugEnabled()) {
      _KMIWebDocumentKeyWord.LOG.debug("adding " + object + " to documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToDocuments(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebDocumentKeyWord.DOCUMENTS_KEY);
    }
  }

  public void removeFromDocumentsRelationship(km.content.eo.KMIWebDocument object) {
    if (_KMIWebDocumentKeyWord.LOG.isDebugEnabled()) {
      _KMIWebDocumentKeyWord.LOG.debug("removing " + object + " from documents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromDocuments(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocumentKeyWord.DOCUMENTS_KEY);
    }
  }

  public km.content.eo.KMIWebDocument createDocumentsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIWebDocument.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebDocumentKeyWord.DOCUMENTS_KEY);
    return (km.content.eo.KMIWebDocument) eo;
  }

  public void deleteDocumentsRelationship(km.content.eo.KMIWebDocument object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocumentKeyWord.DOCUMENTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllDocumentsRelationships() {
    Enumeration<km.content.eo.KMIWebDocument> objects = documents().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDocumentsRelationship(objects.nextElement());
    }
  }

  public NSArray<EOGenericRecord> documentsKeyWords() {
    return (NSArray<EOGenericRecord>)storedValueForKey(_KMIWebDocumentKeyWord.DOCUMENTS_KEY_WORDS_KEY);
  }

  public NSArray<EOGenericRecord> documentsKeyWords(EOQualifier qualifier) {
    return documentsKeyWords(qualifier, null);
  }

  public NSArray<EOGenericRecord> documentsKeyWords(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<EOGenericRecord> results;
      results = documentsKeyWords();
      if (qualifier != null) {
        results = (NSArray<EOGenericRecord>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<EOGenericRecord>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToDocumentsKeyWords(EOGenericRecord object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebDocumentKeyWord.DOCUMENTS_KEY_WORDS_KEY);
  }

  public void removeFromDocumentsKeyWords(EOGenericRecord object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebDocumentKeyWord.DOCUMENTS_KEY_WORDS_KEY);
  }

  public void addToDocumentsKeyWordsRelationship(EOGenericRecord object) {
    if (_KMIWebDocumentKeyWord.LOG.isDebugEnabled()) {
      _KMIWebDocumentKeyWord.LOG.debug("adding " + object + " to documentsKeyWords relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToDocumentsKeyWords(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebDocumentKeyWord.DOCUMENTS_KEY_WORDS_KEY);
    }
  }

  public void removeFromDocumentsKeyWordsRelationship(EOGenericRecord object) {
    if (_KMIWebDocumentKeyWord.LOG.isDebugEnabled()) {
      _KMIWebDocumentKeyWord.LOG.debug("removing " + object + " from documentsKeyWords relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromDocumentsKeyWords(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocumentKeyWord.DOCUMENTS_KEY_WORDS_KEY);
    }
  }

  public EOGenericRecord createDocumentsKeyWordsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("KMIWebDocumentsKeyWords");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebDocumentKeyWord.DOCUMENTS_KEY_WORDS_KEY);
    return (EOGenericRecord) eo;
  }

  public void deleteDocumentsKeyWordsRelationship(EOGenericRecord object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocumentKeyWord.DOCUMENTS_KEY_WORDS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllDocumentsKeyWordsRelationships() {
    Enumeration<EOGenericRecord> objects = documentsKeyWords().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDocumentsKeyWordsRelationship(objects.nextElement());
    }
  }


  public static KMIWebDocumentKeyWord createKMIWebDocumentKeyWord(EOEditingContext editingContext, km.content.eo.KMIWebSite site) {
    KMIWebDocumentKeyWord eo = (KMIWebDocumentKeyWord) EOUtilities.createAndInsertInstance(editingContext, _KMIWebDocumentKeyWord.ENTITY_NAME);    
    eo.setSiteRelationship(site);
    return eo;
  }

  public static ERXFetchSpecification<KMIWebDocumentKeyWord> fetchSpec() {
    return new ERXFetchSpecification<KMIWebDocumentKeyWord>(_KMIWebDocumentKeyWord.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIWebDocumentKeyWord> fetchAllKMIWebDocumentKeyWords(EOEditingContext editingContext) {
    return _KMIWebDocumentKeyWord.fetchAllKMIWebDocumentKeyWords(editingContext, null);
  }

  public static NSArray<KMIWebDocumentKeyWord> fetchAllKMIWebDocumentKeyWords(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIWebDocumentKeyWord.fetchKMIWebDocumentKeyWords(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIWebDocumentKeyWord> fetchKMIWebDocumentKeyWords(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIWebDocumentKeyWord> fetchSpec = new ERXFetchSpecification<KMIWebDocumentKeyWord>(_KMIWebDocumentKeyWord.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIWebDocumentKeyWord> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIWebDocumentKeyWord fetchKMIWebDocumentKeyWord(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebDocumentKeyWord.fetchKMIWebDocumentKeyWord(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebDocumentKeyWord fetchKMIWebDocumentKeyWord(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIWebDocumentKeyWord> eoObjects = _KMIWebDocumentKeyWord.fetchKMIWebDocumentKeyWords(editingContext, qualifier, null);
    KMIWebDocumentKeyWord eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIWebDocumentKeyWord that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebDocumentKeyWord fetchRequiredKMIWebDocumentKeyWord(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebDocumentKeyWord.fetchRequiredKMIWebDocumentKeyWord(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebDocumentKeyWord fetchRequiredKMIWebDocumentKeyWord(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIWebDocumentKeyWord eoObject = _KMIWebDocumentKeyWord.fetchKMIWebDocumentKeyWord(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIWebDocumentKeyWord that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebDocumentKeyWord localInstanceIn(EOEditingContext editingContext, KMIWebDocumentKeyWord eo) {
    KMIWebDocumentKeyWord localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}