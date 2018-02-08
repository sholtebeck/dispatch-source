// DO NOT EDIT.  Make changes to KMIHTMLNode.java instead.
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
public abstract class _KMIHTMLNode extends km.content.eo.KMIAbstractNode {
  public static final String ENTITY_NAME = "KMIHTMLNode";

  // Attribute Keys
  public static final ERXKey<com.webobjects.foundation.NSDictionary> ATTRIBUTES = new ERXKey<com.webobjects.foundation.NSDictionary>("attributes");
  public static final ERXKey<NSTimestamp> CREATE_DATE = new ERXKey<NSTimestamp>("createDate");
  public static final ERXKey<String> IDENTIFIER = new ERXKey<String>("identifier");
  public static final ERXKey<NSTimestamp> LAST_MODIFIED = new ERXKey<NSTimestamp>("lastModified");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> POSITION = new ERXKey<Integer>("position");
  public static final ERXKey<String> TAG_NAME = new ERXKey<String>("tagName");
  public static final ERXKey<Integer> TYPE = new ERXKey<Integer>("type");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIHTMLNode> CHILD_NODES = new ERXKey<km.content.eo.KMIHTMLNode>("childNodes");
  public static final ERXKey<km.content.eo.KMIAbstractDocument> DOCUMENT = new ERXKey<km.content.eo.KMIAbstractDocument>("document");
  public static final ERXKey<km.content.eo.KMIHTMLNode> PARENT_NODE = new ERXKey<km.content.eo.KMIHTMLNode>("parentNode");

  // Attributes
  public static final String ATTRIBUTES_KEY = ATTRIBUTES.key();
  public static final String CREATE_DATE_KEY = CREATE_DATE.key();
  public static final String IDENTIFIER_KEY = IDENTIFIER.key();
  public static final String LAST_MODIFIED_KEY = LAST_MODIFIED.key();
  public static final String NAME_KEY = NAME.key();
  public static final String POSITION_KEY = POSITION.key();
  public static final String TAG_NAME_KEY = TAG_NAME.key();
  public static final String TYPE_KEY = TYPE.key();
  // Relationships
  public static final String CHILD_NODES_KEY = CHILD_NODES.key();
  public static final String DOCUMENT_KEY = DOCUMENT.key();
  public static final String PARENT_NODE_KEY = PARENT_NODE.key();

  private static Logger LOG = Logger.getLogger(_KMIHTMLNode.class);

  public KMIHTMLNode localInstanceIn(EOEditingContext editingContext) {
    KMIHTMLNode localInstance = (KMIHTMLNode)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public com.webobjects.foundation.NSDictionary attributes() {
    return (com.webobjects.foundation.NSDictionary) storedValueForKey(_KMIHTMLNode.ATTRIBUTES_KEY);
  }

  public void setAttributes(com.webobjects.foundation.NSDictionary value) {
    if (_KMIHTMLNode.LOG.isDebugEnabled()) {
    	_KMIHTMLNode.LOG.debug( "updating attributes from " + attributes() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIHTMLNode.ATTRIBUTES_KEY);
  }

  public String identifier() {
    return (String) storedValueForKey(_KMIHTMLNode.IDENTIFIER_KEY);
  }

  public void setIdentifier(String value) {
    if (_KMIHTMLNode.LOG.isDebugEnabled()) {
    	_KMIHTMLNode.LOG.debug( "updating identifier from " + identifier() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIHTMLNode.IDENTIFIER_KEY);
  }

  public Integer position() {
    return (Integer) storedValueForKey(_KMIHTMLNode.POSITION_KEY);
  }

  public void setPosition(Integer value) {
    if (_KMIHTMLNode.LOG.isDebugEnabled()) {
    	_KMIHTMLNode.LOG.debug( "updating position from " + position() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIHTMLNode.POSITION_KEY);
  }

  public String tagName() {
    return (String) storedValueForKey(_KMIHTMLNode.TAG_NAME_KEY);
  }

  public void setTagName(String value) {
    if (_KMIHTMLNode.LOG.isDebugEnabled()) {
    	_KMIHTMLNode.LOG.debug( "updating tagName from " + tagName() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIHTMLNode.TAG_NAME_KEY);
  }

  public km.content.eo.KMIHTMLNode parentNode() {
    return (km.content.eo.KMIHTMLNode)storedValueForKey(_KMIHTMLNode.PARENT_NODE_KEY);
  }
  
  public void setParentNode(km.content.eo.KMIHTMLNode value) {
    takeStoredValueForKey(value, _KMIHTMLNode.PARENT_NODE_KEY);
  }

  public void setParentNodeRelationship(km.content.eo.KMIHTMLNode value) {
    if (_KMIHTMLNode.LOG.isDebugEnabled()) {
      _KMIHTMLNode.LOG.debug("updating parentNode from " + parentNode() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setParentNode(value);
    }
    else if (value == null) {
    	km.content.eo.KMIHTMLNode oldValue = parentNode();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIHTMLNode.PARENT_NODE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIHTMLNode.PARENT_NODE_KEY);
    }
  }
  
  public NSArray<km.content.eo.KMIHTMLNode> childNodes() {
    return (NSArray<km.content.eo.KMIHTMLNode>)storedValueForKey(_KMIHTMLNode.CHILD_NODES_KEY);
  }

  public NSArray<km.content.eo.KMIHTMLNode> childNodes(EOQualifier qualifier) {
    return childNodes(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIHTMLNode> childNodes(EOQualifier qualifier, boolean fetch) {
    return childNodes(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIHTMLNode> childNodes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIHTMLNode> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIHTMLNode.PARENT_NODE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = km.content.eo.KMIHTMLNode.fetchKMIHTMLNodes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = childNodes();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIHTMLNode>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIHTMLNode>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToChildNodes(km.content.eo.KMIHTMLNode object) {
    includeObjectIntoPropertyWithKey(object, _KMIHTMLNode.CHILD_NODES_KEY);
  }

  public void removeFromChildNodes(km.content.eo.KMIHTMLNode object) {
    excludeObjectFromPropertyWithKey(object, _KMIHTMLNode.CHILD_NODES_KEY);
  }

  public void addToChildNodesRelationship(km.content.eo.KMIHTMLNode object) {
    if (_KMIHTMLNode.LOG.isDebugEnabled()) {
      _KMIHTMLNode.LOG.debug("adding " + object + " to childNodes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToChildNodes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIHTMLNode.CHILD_NODES_KEY);
    }
  }

  public void removeFromChildNodesRelationship(km.content.eo.KMIHTMLNode object) {
    if (_KMIHTMLNode.LOG.isDebugEnabled()) {
      _KMIHTMLNode.LOG.debug("removing " + object + " from childNodes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromChildNodes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIHTMLNode.CHILD_NODES_KEY);
    }
  }

  public km.content.eo.KMIHTMLNode createChildNodesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIHTMLNode.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIHTMLNode.CHILD_NODES_KEY);
    return (km.content.eo.KMIHTMLNode) eo;
  }

  public void deleteChildNodesRelationship(km.content.eo.KMIHTMLNode object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIHTMLNode.CHILD_NODES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllChildNodesRelationships() {
    Enumeration<km.content.eo.KMIHTMLNode> objects = childNodes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteChildNodesRelationship(objects.nextElement());
    }
  }


  public static KMIHTMLNode createKMIHTMLNode(EOEditingContext editingContext) {
    KMIHTMLNode eo = (KMIHTMLNode) EOUtilities.createAndInsertInstance(editingContext, _KMIHTMLNode.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<KMIHTMLNode> fetchSpecForKMIHTMLNode() {
    return new ERXFetchSpecification<KMIHTMLNode>(_KMIHTMLNode.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIHTMLNode> fetchAllKMIHTMLNodes(EOEditingContext editingContext) {
    return _KMIHTMLNode.fetchAllKMIHTMLNodes(editingContext, null);
  }

  public static NSArray<KMIHTMLNode> fetchAllKMIHTMLNodes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIHTMLNode.fetchKMIHTMLNodes(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIHTMLNode> fetchKMIHTMLNodes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIHTMLNode> fetchSpec = new ERXFetchSpecification<KMIHTMLNode>(_KMIHTMLNode.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIHTMLNode> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIHTMLNode fetchKMIHTMLNode(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIHTMLNode.fetchKMIHTMLNode(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIHTMLNode fetchKMIHTMLNode(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIHTMLNode> eoObjects = _KMIHTMLNode.fetchKMIHTMLNodes(editingContext, qualifier, null);
    KMIHTMLNode eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIHTMLNode that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIHTMLNode fetchRequiredKMIHTMLNode(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIHTMLNode.fetchRequiredKMIHTMLNode(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIHTMLNode fetchRequiredKMIHTMLNode(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIHTMLNode eoObject = _KMIHTMLNode.fetchKMIHTMLNode(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIHTMLNode that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIHTMLNode localInstanceIn(EOEditingContext editingContext, KMIHTMLNode eo) {
    KMIHTMLNode localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}