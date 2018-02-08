// DO NOT EDIT.  Make changes to KMIWebDocumentComment.java instead.
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
public abstract class _KMIWebDocumentComment extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "KMIWebDocumentComment";

  // Attribute Keys
  public static final ERXKey<String> COMMENT = new ERXKey<String>("comment");
  public static final ERXKey<String> COMMENTER_EMAIL = new ERXKey<String>("commenterEmail");
  public static final ERXKey<String> COMMENTER_NAME = new ERXKey<String>("commenterName");
  public static final ERXKey<NSTimestamp> CREATION_DATE = new ERXKey<NSTimestamp>("creationDate");
  public static final ERXKey<Boolean> FLAGGED = new ERXKey<Boolean>("flagged");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIWebDocument> DOCUMENT = new ERXKey<km.content.eo.KMIWebDocument>("document");

  // Attributes
  public static final String COMMENT_KEY = COMMENT.key();
  public static final String COMMENTER_EMAIL_KEY = COMMENTER_EMAIL.key();
  public static final String COMMENTER_NAME_KEY = COMMENTER_NAME.key();
  public static final String CREATION_DATE_KEY = CREATION_DATE.key();
  public static final String FLAGGED_KEY = FLAGGED.key();
  // Relationships
  public static final String DOCUMENT_KEY = DOCUMENT.key();

  private static Logger LOG = Logger.getLogger(_KMIWebDocumentComment.class);

  public KMIWebDocumentComment localInstanceIn(EOEditingContext editingContext) {
    KMIWebDocumentComment localInstance = (KMIWebDocumentComment)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String comment() {
    return (String) storedValueForKey(_KMIWebDocumentComment.COMMENT_KEY);
  }

  public void setComment(String value) {
    if (_KMIWebDocumentComment.LOG.isDebugEnabled()) {
    	_KMIWebDocumentComment.LOG.debug( "updating comment from " + comment() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocumentComment.COMMENT_KEY);
  }

  public String commenterEmail() {
    return (String) storedValueForKey(_KMIWebDocumentComment.COMMENTER_EMAIL_KEY);
  }

  public void setCommenterEmail(String value) {
    if (_KMIWebDocumentComment.LOG.isDebugEnabled()) {
    	_KMIWebDocumentComment.LOG.debug( "updating commenterEmail from " + commenterEmail() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocumentComment.COMMENTER_EMAIL_KEY);
  }

  public String commenterName() {
    return (String) storedValueForKey(_KMIWebDocumentComment.COMMENTER_NAME_KEY);
  }

  public void setCommenterName(String value) {
    if (_KMIWebDocumentComment.LOG.isDebugEnabled()) {
    	_KMIWebDocumentComment.LOG.debug( "updating commenterName from " + commenterName() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocumentComment.COMMENTER_NAME_KEY);
  }

  public NSTimestamp creationDate() {
    return (NSTimestamp) storedValueForKey(_KMIWebDocumentComment.CREATION_DATE_KEY);
  }

  public void setCreationDate(NSTimestamp value) {
    if (_KMIWebDocumentComment.LOG.isDebugEnabled()) {
    	_KMIWebDocumentComment.LOG.debug( "updating creationDate from " + creationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocumentComment.CREATION_DATE_KEY);
  }

  public Boolean flagged() {
    return (Boolean) storedValueForKey(_KMIWebDocumentComment.FLAGGED_KEY);
  }

  public void setFlagged(Boolean value) {
    if (_KMIWebDocumentComment.LOG.isDebugEnabled()) {
    	_KMIWebDocumentComment.LOG.debug( "updating flagged from " + flagged() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebDocumentComment.FLAGGED_KEY);
  }

  public km.content.eo.KMIWebDocument document() {
    return (km.content.eo.KMIWebDocument)storedValueForKey(_KMIWebDocumentComment.DOCUMENT_KEY);
  }
  
  public void setDocument(km.content.eo.KMIWebDocument value) {
    takeStoredValueForKey(value, _KMIWebDocumentComment.DOCUMENT_KEY);
  }

  public void setDocumentRelationship(km.content.eo.KMIWebDocument value) {
    if (_KMIWebDocumentComment.LOG.isDebugEnabled()) {
      _KMIWebDocumentComment.LOG.debug("updating document from " + document() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setDocument(value);
    }
    else if (value == null) {
    	km.content.eo.KMIWebDocument oldValue = document();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIWebDocumentComment.DOCUMENT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIWebDocumentComment.DOCUMENT_KEY);
    }
  }
  

  public static KMIWebDocumentComment createKMIWebDocumentComment(EOEditingContext editingContext, km.content.eo.KMIWebDocument document) {
    KMIWebDocumentComment eo = (KMIWebDocumentComment) EOUtilities.createAndInsertInstance(editingContext, _KMIWebDocumentComment.ENTITY_NAME);    
    eo.setDocumentRelationship(document);
    return eo;
  }

  public static ERXFetchSpecification<KMIWebDocumentComment> fetchSpec() {
    return new ERXFetchSpecification<KMIWebDocumentComment>(_KMIWebDocumentComment.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIWebDocumentComment> fetchAllKMIWebDocumentComments(EOEditingContext editingContext) {
    return _KMIWebDocumentComment.fetchAllKMIWebDocumentComments(editingContext, null);
  }

  public static NSArray<KMIWebDocumentComment> fetchAllKMIWebDocumentComments(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIWebDocumentComment.fetchKMIWebDocumentComments(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIWebDocumentComment> fetchKMIWebDocumentComments(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIWebDocumentComment> fetchSpec = new ERXFetchSpecification<KMIWebDocumentComment>(_KMIWebDocumentComment.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIWebDocumentComment> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIWebDocumentComment fetchKMIWebDocumentComment(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebDocumentComment.fetchKMIWebDocumentComment(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebDocumentComment fetchKMIWebDocumentComment(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIWebDocumentComment> eoObjects = _KMIWebDocumentComment.fetchKMIWebDocumentComments(editingContext, qualifier, null);
    KMIWebDocumentComment eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIWebDocumentComment that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebDocumentComment fetchRequiredKMIWebDocumentComment(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebDocumentComment.fetchRequiredKMIWebDocumentComment(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebDocumentComment fetchRequiredKMIWebDocumentComment(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIWebDocumentComment eoObject = _KMIWebDocumentComment.fetchKMIWebDocumentComment(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIWebDocumentComment that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebDocumentComment localInstanceIn(EOEditingContext editingContext, KMIWebDocumentComment eo) {
    KMIWebDocumentComment localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}