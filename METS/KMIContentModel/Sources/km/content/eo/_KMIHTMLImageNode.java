// DO NOT EDIT.  Make changes to KMIHTMLImageNode.java instead.
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
public abstract class _KMIHTMLImageNode extends km.content.eo.KMIHTMLNode {
  public static final String ENTITY_NAME = "KMIHTMLImageNode";

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
  public static final ERXKey<km.content.eo.KMIWebDocument> DOCUMENT = new ERXKey<km.content.eo.KMIWebDocument>("document");
  public static final ERXKey<km.content.eo.KMIImageAsset> IMAGE_ASSET = new ERXKey<km.content.eo.KMIImageAsset>("imageAsset");
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
  public static final String IMAGE_ASSET_KEY = IMAGE_ASSET.key();
  public static final String PARENT_NODE_KEY = PARENT_NODE.key();

  private static Logger LOG = Logger.getLogger(_KMIHTMLImageNode.class);

  public KMIHTMLImageNode localInstanceIn(EOEditingContext editingContext) {
    KMIHTMLImageNode localInstance = (KMIHTMLImageNode)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public km.content.eo.KMIImageAsset imageAsset() {
    return (km.content.eo.KMIImageAsset)storedValueForKey(_KMIHTMLImageNode.IMAGE_ASSET_KEY);
  }
  
  public void setImageAsset(km.content.eo.KMIImageAsset value) {
    takeStoredValueForKey(value, _KMIHTMLImageNode.IMAGE_ASSET_KEY);
  }

  public void setImageAssetRelationship(km.content.eo.KMIImageAsset value) {
    if (_KMIHTMLImageNode.LOG.isDebugEnabled()) {
      _KMIHTMLImageNode.LOG.debug("updating imageAsset from " + imageAsset() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setImageAsset(value);
    }
    else if (value == null) {
    	km.content.eo.KMIImageAsset oldValue = imageAsset();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIHTMLImageNode.IMAGE_ASSET_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIHTMLImageNode.IMAGE_ASSET_KEY);
    }
  }
  

  public static KMIHTMLImageNode createKMIHTMLImageNode(EOEditingContext editingContext) {
    KMIHTMLImageNode eo = (KMIHTMLImageNode) EOUtilities.createAndInsertInstance(editingContext, _KMIHTMLImageNode.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<KMIHTMLImageNode> fetchSpecForKMIHTMLImageNode() {
    return new ERXFetchSpecification<KMIHTMLImageNode>(_KMIHTMLImageNode.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIHTMLImageNode> fetchAllKMIHTMLImageNodes(EOEditingContext editingContext) {
    return _KMIHTMLImageNode.fetchAllKMIHTMLImageNodes(editingContext, null);
  }

  public static NSArray<KMIHTMLImageNode> fetchAllKMIHTMLImageNodes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIHTMLImageNode.fetchKMIHTMLImageNodes(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIHTMLImageNode> fetchKMIHTMLImageNodes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIHTMLImageNode> fetchSpec = new ERXFetchSpecification<KMIHTMLImageNode>(_KMIHTMLImageNode.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIHTMLImageNode> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIHTMLImageNode fetchKMIHTMLImageNode(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIHTMLImageNode.fetchKMIHTMLImageNode(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIHTMLImageNode fetchKMIHTMLImageNode(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIHTMLImageNode> eoObjects = _KMIHTMLImageNode.fetchKMIHTMLImageNodes(editingContext, qualifier, null);
    KMIHTMLImageNode eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIHTMLImageNode that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIHTMLImageNode fetchRequiredKMIHTMLImageNode(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIHTMLImageNode.fetchRequiredKMIHTMLImageNode(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIHTMLImageNode fetchRequiredKMIHTMLImageNode(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIHTMLImageNode eoObject = _KMIHTMLImageNode.fetchKMIHTMLImageNode(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIHTMLImageNode that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIHTMLImageNode localInstanceIn(EOEditingContext editingContext, KMIHTMLImageNode eo) {
    KMIHTMLImageNode localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}