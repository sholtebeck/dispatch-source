// DO NOT EDIT.  Make changes to KMIWebDocument.java instead.
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
public abstract class _KMIWebDocument extends km.content.eo.KMIAbstractDocument {
  public static final String ENTITY_NAME = "KMIWebDocument";

  // Attribute Keys
  public static final ERXKey<String> AUTHOR = new ERXKey<String>("author");
  public static final ERXKey<Boolean> COMMENTS_ENABLED = new ERXKey<Boolean>("commentsEnabled");
  public static final ERXKey<NSTimestamp> CREATE_DATE = new ERXKey<NSTimestamp>("createDate");
  public static final ERXKey<Boolean> IS_PUBLISHED = new ERXKey<Boolean>("isPublished");
  public static final ERXKey<NSTimestamp> LAST_MODIFIED = new ERXKey<NSTimestamp>("lastModified");
  public static final ERXKey<String> META_DESCRIPTION = new ERXKey<String>("metaDescription");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> PAGE_TITLE = new ERXKey<String>("pageTitle");
  public static final ERXKey<Integer> POSITION = new ERXKey<Integer>("position");
  public static final ERXKey<NSTimestamp> PUBLISH_DATE = new ERXKey<NSTimestamp>("publishDate");
  public static final ERXKey<String> SLUG = new ERXKey<String>("slug");
  public static final ERXKey<Integer> TYPE = new ERXKey<Integer>("type");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIWebDocumentCategory> CATEGORY = new ERXKey<km.content.eo.KMIWebDocumentCategory>("category");
  public static final ERXKey<km.content.eo.KMIWebDocument> CHILDREN = new ERXKey<km.content.eo.KMIWebDocument>("children");
  public static final ERXKey<km.content.eo.KMIWebDocumentComment> COMMENTS = new ERXKey<km.content.eo.KMIWebDocumentComment>("comments");
  public static final ERXKey<km.content.eo.KMIWebDocumentKeyWord> KEY_WORDS = new ERXKey<km.content.eo.KMIWebDocumentKeyWord>("keyWords");
  public static final ERXKey<km.content.eo.KMIHTMLNode> NODES = new ERXKey<km.content.eo.KMIHTMLNode>("nodes");
  public static final ERXKey<km.content.eo.KMIWebDocument> PARENT = new ERXKey<km.content.eo.KMIWebDocument>("parent");
  public static final ERXKey<km.content.eo.KMIWebSite> SITE = new ERXKey<km.content.eo.KMIWebSite>("site");

  // Attributes
  public static final String AUTHOR_KEY = AUTHOR.key();
  public static final String COMMENTS_ENABLED_KEY = COMMENTS_ENABLED.key();
  public static final String CREATE_DATE_KEY = CREATE_DATE.key();
  public static final String IS_PUBLISHED_KEY = IS_PUBLISHED.key();
  public static final String LAST_MODIFIED_KEY = LAST_MODIFIED.key();
  public static final String META_DESCRIPTION_KEY = META_DESCRIPTION.key();
  public static final String NAME_KEY = NAME.key();
  public static final String PAGE_TITLE_KEY = PAGE_TITLE.key();
  public static final String POSITION_KEY = POSITION.key();
  public static final String PUBLISH_DATE_KEY = PUBLISH_DATE.key();
  public static final String SLUG_KEY = SLUG.key();
  public static final String TYPE_KEY = TYPE.key();
  // Relationships
  public static final String CATEGORY_KEY = CATEGORY.key();
  public static final String CHILDREN_KEY = CHILDREN.key();
  public static final String COMMENTS_KEY = COMMENTS.key();
  public static final String KEY_WORDS_KEY = KEY_WORDS.key();
  public static final String NODES_KEY = NODES.key();
  public static final String PARENT_KEY = PARENT.key();
  public static final String SITE_KEY = SITE.key();

  private static Logger LOG = Logger.getLogger(_KMIWebDocument.class);

  public KMIWebDocument localInstanceIn(EOEditingContext editingContext) {
    KMIWebDocument localInstance = (KMIWebDocument)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String author() {
    return (String) storedValueForKey(_KMIWebDocument.AUTHOR_KEY);
  }

  public void setAuthor(String value) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
    	_KMIWebDocument.LOG.debug( "updating author from " + author() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocument.AUTHOR_KEY);
  }

  public Boolean commentsEnabled() {
    return (Boolean) storedValueForKey(_KMIWebDocument.COMMENTS_ENABLED_KEY);
  }

  public void setCommentsEnabled(Boolean value) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
    	_KMIWebDocument.LOG.debug( "updating commentsEnabled from " + commentsEnabled() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocument.COMMENTS_ENABLED_KEY);
  }

  public Boolean isPublished() {
    return (Boolean) storedValueForKey(_KMIWebDocument.IS_PUBLISHED_KEY);
  }

  public void setIsPublished(Boolean value) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
    	_KMIWebDocument.LOG.debug( "updating isPublished from " + isPublished() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocument.IS_PUBLISHED_KEY);
  }

  public String metaDescription() {
    return (String) storedValueForKey(_KMIWebDocument.META_DESCRIPTION_KEY);
  }

  public void setMetaDescription(String value) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
    	_KMIWebDocument.LOG.debug( "updating metaDescription from " + metaDescription() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocument.META_DESCRIPTION_KEY);
  }

  public String pageTitle() {
    return (String) storedValueForKey(_KMIWebDocument.PAGE_TITLE_KEY);
  }

  public void setPageTitle(String value) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
    	_KMIWebDocument.LOG.debug( "updating pageTitle from " + pageTitle() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocument.PAGE_TITLE_KEY);
  }

  public Integer position() {
    return (Integer) storedValueForKey(_KMIWebDocument.POSITION_KEY);
  }

  public void setPosition(Integer value) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
    	_KMIWebDocument.LOG.debug( "updating position from " + position() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocument.POSITION_KEY);
  }

  public NSTimestamp publishDate() {
    return (NSTimestamp) storedValueForKey(_KMIWebDocument.PUBLISH_DATE_KEY);
  }

  public void setPublishDate(NSTimestamp value) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
    	_KMIWebDocument.LOG.debug( "updating publishDate from " + publishDate() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocument.PUBLISH_DATE_KEY);
  }

  public String slug() {
    return (String) storedValueForKey(_KMIWebDocument.SLUG_KEY);
  }

  public void setSlug(String value) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
    	_KMIWebDocument.LOG.debug( "updating slug from " + slug() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocument.SLUG_KEY);
  }

  public km.content.eo.KMIWebDocumentCategory category() {
    return (km.content.eo.KMIWebDocumentCategory)storedValueForKey(_KMIWebDocument.CATEGORY_KEY);
  }
  
  public void setCategory(km.content.eo.KMIWebDocumentCategory value) {
    takeStoredValueForKey(value, _KMIWebDocument.CATEGORY_KEY);
  }

  public void setCategoryRelationship(km.content.eo.KMIWebDocumentCategory value) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
      _KMIWebDocument.LOG.debug("updating category from " + category() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setCategory(value);
    }
    else if (value == null) {
    	km.content.eo.KMIWebDocumentCategory oldValue = category();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIWebDocument.CATEGORY_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIWebDocument.CATEGORY_KEY);
    }
  }
  
  public km.content.eo.KMIWebDocument parent() {
    return (km.content.eo.KMIWebDocument)storedValueForKey(_KMIWebDocument.PARENT_KEY);
  }
  
  public void setParent(km.content.eo.KMIWebDocument value) {
    takeStoredValueForKey(value, _KMIWebDocument.PARENT_KEY);
  }

  public void setParentRelationship(km.content.eo.KMIWebDocument value) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
      _KMIWebDocument.LOG.debug("updating parent from " + parent() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setParent(value);
    }
    else if (value == null) {
    	km.content.eo.KMIWebDocument oldValue = parent();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIWebDocument.PARENT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIWebDocument.PARENT_KEY);
    }
  }
  
  public NSArray<km.content.eo.KMIWebDocument> children() {
    return (NSArray<km.content.eo.KMIWebDocument>)storedValueForKey(_KMIWebDocument.CHILDREN_KEY);
  }

  public NSArray<km.content.eo.KMIWebDocument> children(EOQualifier qualifier) {
    return children(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIWebDocument> children(EOQualifier qualifier, boolean fetch) {
    return children(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIWebDocument> children(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIWebDocument> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIWebDocument.PARENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
      results = children();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIWebDocument>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIWebDocument>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToChildren(km.content.eo.KMIWebDocument object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebDocument.CHILDREN_KEY);
  }

  public void removeFromChildren(km.content.eo.KMIWebDocument object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebDocument.CHILDREN_KEY);
  }

  public void addToChildrenRelationship(km.content.eo.KMIWebDocument object) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
      _KMIWebDocument.LOG.debug("adding " + object + " to children relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToChildren(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebDocument.CHILDREN_KEY);
    }
  }

  public void removeFromChildrenRelationship(km.content.eo.KMIWebDocument object) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
      _KMIWebDocument.LOG.debug("removing " + object + " from children relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromChildren(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocument.CHILDREN_KEY);
    }
  }

  public km.content.eo.KMIWebDocument createChildrenRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIWebDocument.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebDocument.CHILDREN_KEY);
    return (km.content.eo.KMIWebDocument) eo;
  }

  public void deleteChildrenRelationship(km.content.eo.KMIWebDocument object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocument.CHILDREN_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllChildrenRelationships() {
    Enumeration<km.content.eo.KMIWebDocument> objects = children().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteChildrenRelationship(objects.nextElement());
    }
  }

  public NSArray<km.content.eo.KMIWebDocumentComment> comments() {
    return (NSArray<km.content.eo.KMIWebDocumentComment>)storedValueForKey(_KMIWebDocument.COMMENTS_KEY);
  }

  public NSArray<km.content.eo.KMIWebDocumentComment> comments(EOQualifier qualifier) {
    return comments(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIWebDocumentComment> comments(EOQualifier qualifier, boolean fetch) {
    return comments(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIWebDocumentComment> comments(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIWebDocumentComment> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIWebDocumentComment.DOCUMENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = km.content.eo.KMIWebDocumentComment.fetchKMIWebDocumentComments(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = comments();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIWebDocumentComment>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIWebDocumentComment>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToComments(km.content.eo.KMIWebDocumentComment object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebDocument.COMMENTS_KEY);
  }

  public void removeFromComments(km.content.eo.KMIWebDocumentComment object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebDocument.COMMENTS_KEY);
  }

  public void addToCommentsRelationship(km.content.eo.KMIWebDocumentComment object) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
      _KMIWebDocument.LOG.debug("adding " + object + " to comments relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToComments(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebDocument.COMMENTS_KEY);
    }
  }

  public void removeFromCommentsRelationship(km.content.eo.KMIWebDocumentComment object) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
      _KMIWebDocument.LOG.debug("removing " + object + " from comments relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromComments(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocument.COMMENTS_KEY);
    }
  }

  public km.content.eo.KMIWebDocumentComment createCommentsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIWebDocumentComment.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebDocument.COMMENTS_KEY);
    return (km.content.eo.KMIWebDocumentComment) eo;
  }

  public void deleteCommentsRelationship(km.content.eo.KMIWebDocumentComment object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocument.COMMENTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllCommentsRelationships() {
    Enumeration<km.content.eo.KMIWebDocumentComment> objects = comments().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteCommentsRelationship(objects.nextElement());
    }
  }

  public NSArray<km.content.eo.KMIWebDocumentKeyWord> keyWords() {
    return (NSArray<km.content.eo.KMIWebDocumentKeyWord>)storedValueForKey(_KMIWebDocument.KEY_WORDS_KEY);
  }

  public NSArray<km.content.eo.KMIWebDocumentKeyWord> keyWords(EOQualifier qualifier) {
    return keyWords(qualifier, null);
  }

  public NSArray<km.content.eo.KMIWebDocumentKeyWord> keyWords(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<km.content.eo.KMIWebDocumentKeyWord> results;
      results = keyWords();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIWebDocumentKeyWord>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIWebDocumentKeyWord>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToKeyWords(km.content.eo.KMIWebDocumentKeyWord object) {
    includeObjectIntoPropertyWithKey(object, _KMIWebDocument.KEY_WORDS_KEY);
  }

  public void removeFromKeyWords(km.content.eo.KMIWebDocumentKeyWord object) {
    excludeObjectFromPropertyWithKey(object, _KMIWebDocument.KEY_WORDS_KEY);
  }

  public void addToKeyWordsRelationship(km.content.eo.KMIWebDocumentKeyWord object) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
      _KMIWebDocument.LOG.debug("adding " + object + " to keyWords relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToKeyWords(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIWebDocument.KEY_WORDS_KEY);
    }
  }

  public void removeFromKeyWordsRelationship(km.content.eo.KMIWebDocumentKeyWord object) {
    if (_KMIWebDocument.LOG.isDebugEnabled()) {
      _KMIWebDocument.LOG.debug("removing " + object + " from keyWords relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromKeyWords(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocument.KEY_WORDS_KEY);
    }
  }

  public km.content.eo.KMIWebDocumentKeyWord createKeyWordsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIWebDocumentKeyWord.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIWebDocument.KEY_WORDS_KEY);
    return (km.content.eo.KMIWebDocumentKeyWord) eo;
  }

  public void deleteKeyWordsRelationship(km.content.eo.KMIWebDocumentKeyWord object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIWebDocument.KEY_WORDS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllKeyWordsRelationships() {
    Enumeration<km.content.eo.KMIWebDocumentKeyWord> objects = keyWords().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteKeyWordsRelationship(objects.nextElement());
    }
  }


  public static KMIWebDocument createKMIWebDocument(EOEditingContext editingContext, km.content.eo.KMIWebSite site) {
    KMIWebDocument eo = (KMIWebDocument) EOUtilities.createAndInsertInstance(editingContext, _KMIWebDocument.ENTITY_NAME);    
    eo.setSiteRelationship(site);
    return eo;
  }

  public static ERXFetchSpecification<KMIWebDocument> fetchSpecForKMIWebDocument() {
    return new ERXFetchSpecification<KMIWebDocument>(_KMIWebDocument.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIWebDocument> fetchAllKMIWebDocuments(EOEditingContext editingContext) {
    return _KMIWebDocument.fetchAllKMIWebDocuments(editingContext, null);
  }

  public static NSArray<KMIWebDocument> fetchAllKMIWebDocuments(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIWebDocument.fetchKMIWebDocuments(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIWebDocument> fetchKMIWebDocuments(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIWebDocument> fetchSpec = new ERXFetchSpecification<KMIWebDocument>(_KMIWebDocument.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIWebDocument> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIWebDocument fetchKMIWebDocument(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebDocument.fetchKMIWebDocument(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebDocument fetchKMIWebDocument(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIWebDocument> eoObjects = _KMIWebDocument.fetchKMIWebDocuments(editingContext, qualifier, null);
    KMIWebDocument eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIWebDocument that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebDocument fetchRequiredKMIWebDocument(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebDocument.fetchRequiredKMIWebDocument(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebDocument fetchRequiredKMIWebDocument(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIWebDocument eoObject = _KMIWebDocument.fetchKMIWebDocument(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIWebDocument that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebDocument localInstanceIn(EOEditingContext editingContext, KMIWebDocument eo) {
    KMIWebDocument localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}