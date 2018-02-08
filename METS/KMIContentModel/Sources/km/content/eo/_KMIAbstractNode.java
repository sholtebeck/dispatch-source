// DO NOT EDIT.  Make changes to KMIAbstractNode.java instead.
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
public abstract class _KMIAbstractNode extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "KMIAbstractNode";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATE_DATE = new ERXKey<NSTimestamp>("createDate");
  public static final ERXKey<NSTimestamp> LAST_MODIFIED = new ERXKey<NSTimestamp>("lastModified");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> TYPE = new ERXKey<Integer>("type");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIAbstractDocument> DOCUMENT = new ERXKey<km.content.eo.KMIAbstractDocument>("document");

  // Attributes
  public static final String CREATE_DATE_KEY = CREATE_DATE.key();
  public static final String LAST_MODIFIED_KEY = LAST_MODIFIED.key();
  public static final String NAME_KEY = NAME.key();
  public static final String TYPE_KEY = TYPE.key();
  // Relationships
  public static final String DOCUMENT_KEY = DOCUMENT.key();

  private static Logger LOG = Logger.getLogger(_KMIAbstractNode.class);

  public KMIAbstractNode localInstanceIn(EOEditingContext editingContext) {
    KMIAbstractNode localInstance = (KMIAbstractNode)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp createDate() {
    return (NSTimestamp) storedValueForKey(_KMIAbstractNode.CREATE_DATE_KEY);
  }

  public void setCreateDate(NSTimestamp value) {
    if (_KMIAbstractNode.LOG.isDebugEnabled()) {
    	_KMIAbstractNode.LOG.debug( "updating createDate from " + createDate() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAbstractNode.CREATE_DATE_KEY);
  }

  public NSTimestamp lastModified() {
    return (NSTimestamp) storedValueForKey(_KMIAbstractNode.LAST_MODIFIED_KEY);
  }

  public void setLastModified(NSTimestamp value) {
    if (_KMIAbstractNode.LOG.isDebugEnabled()) {
    	_KMIAbstractNode.LOG.debug( "updating lastModified from " + lastModified() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAbstractNode.LAST_MODIFIED_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_KMIAbstractNode.NAME_KEY);
  }

  public void setName(String value) {
    if (_KMIAbstractNode.LOG.isDebugEnabled()) {
    	_KMIAbstractNode.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAbstractNode.NAME_KEY);
  }

  public Integer type() {
    return (Integer) storedValueForKey(_KMIAbstractNode.TYPE_KEY);
  }

  public void setType(Integer value) {
    if (_KMIAbstractNode.LOG.isDebugEnabled()) {
    	_KMIAbstractNode.LOG.debug( "updating type from " + type() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAbstractNode.TYPE_KEY);
  }

  public km.content.eo.KMIAbstractDocument document() {
    return (km.content.eo.KMIAbstractDocument)storedValueForKey(_KMIAbstractNode.DOCUMENT_KEY);
  }
  
  public void setDocument(km.content.eo.KMIAbstractDocument value) {
    takeStoredValueForKey(value, _KMIAbstractNode.DOCUMENT_KEY);
  }

  public void setDocumentRelationship(km.content.eo.KMIAbstractDocument value) {
    if (_KMIAbstractNode.LOG.isDebugEnabled()) {
      _KMIAbstractNode.LOG.debug("updating document from " + document() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setDocument(value);
    }
    else if (value == null) {
    	km.content.eo.KMIAbstractDocument oldValue = document();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIAbstractNode.DOCUMENT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIAbstractNode.DOCUMENT_KEY);
    }
  }
  

  public static KMIAbstractNode createKMIAbstractNode(EOEditingContext editingContext) {
    KMIAbstractNode eo = (KMIAbstractNode) EOUtilities.createAndInsertInstance(editingContext, _KMIAbstractNode.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<KMIAbstractNode> fetchSpec() {
    return new ERXFetchSpecification<KMIAbstractNode>(_KMIAbstractNode.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIAbstractNode> fetchAllKMIAbstractNodes(EOEditingContext editingContext) {
    return _KMIAbstractNode.fetchAllKMIAbstractNodes(editingContext, null);
  }

  public static NSArray<KMIAbstractNode> fetchAllKMIAbstractNodes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIAbstractNode.fetchKMIAbstractNodes(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIAbstractNode> fetchKMIAbstractNodes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIAbstractNode> fetchSpec = new ERXFetchSpecification<KMIAbstractNode>(_KMIAbstractNode.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIAbstractNode> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIAbstractNode fetchKMIAbstractNode(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIAbstractNode.fetchKMIAbstractNode(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIAbstractNode fetchKMIAbstractNode(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIAbstractNode> eoObjects = _KMIAbstractNode.fetchKMIAbstractNodes(editingContext, qualifier, null);
    KMIAbstractNode eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIAbstractNode that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIAbstractNode fetchRequiredKMIAbstractNode(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIAbstractNode.fetchRequiredKMIAbstractNode(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIAbstractNode fetchRequiredKMIAbstractNode(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIAbstractNode eoObject = _KMIAbstractNode.fetchKMIAbstractNode(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIAbstractNode that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIAbstractNode localInstanceIn(EOEditingContext editingContext, KMIAbstractNode eo) {
    KMIAbstractNode localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}