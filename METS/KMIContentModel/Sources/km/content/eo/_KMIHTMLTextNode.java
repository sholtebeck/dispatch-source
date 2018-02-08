// DO NOT EDIT.  Make changes to KMIHTMLTextNode.java instead.
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
public abstract class _KMIHTMLTextNode extends km.content.eo.KMIHTMLNode {
  public static final String ENTITY_NAME = "KMIHTMLTextNode";

  // Attribute Keys
  public static final ERXKey<com.webobjects.foundation.NSDictionary> ATTRIBUTES = new ERXKey<com.webobjects.foundation.NSDictionary>("attributes");
  public static final ERXKey<NSTimestamp> CREATE_DATE = new ERXKey<NSTimestamp>("createDate");
  public static final ERXKey<String> IDENTIFIER = new ERXKey<String>("identifier");
  public static final ERXKey<NSTimestamp> LAST_MODIFIED = new ERXKey<NSTimestamp>("lastModified");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> POSITION = new ERXKey<Integer>("position");
  public static final ERXKey<String> TAG_NAME = new ERXKey<String>("tagName");
  public static final ERXKey<String> TEXT_CONTENT = new ERXKey<String>("textContent");
  public static final ERXKey<Integer> TYPE = new ERXKey<Integer>("type");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIHTMLNode> CHILD_NODES = new ERXKey<km.content.eo.KMIHTMLNode>("childNodes");
  public static final ERXKey<km.content.eo.KMIWebDocument> DOCUMENT = new ERXKey<km.content.eo.KMIWebDocument>("document");
  public static final ERXKey<km.content.eo.KMIHTMLNode> PARENT_NODE = new ERXKey<km.content.eo.KMIHTMLNode>("parentNode");

  // Attributes
  public static final String ATTRIBUTES_KEY = ATTRIBUTES.key();
  public static final String CREATE_DATE_KEY = CREATE_DATE.key();
  public static final String IDENTIFIER_KEY = IDENTIFIER.key();
  public static final String LAST_MODIFIED_KEY = LAST_MODIFIED.key();
  public static final String NAME_KEY = NAME.key();
  public static final String POSITION_KEY = POSITION.key();
  public static final String TAG_NAME_KEY = TAG_NAME.key();
  public static final String TEXT_CONTENT_KEY = TEXT_CONTENT.key();
  public static final String TYPE_KEY = TYPE.key();
  // Relationships
  public static final String CHILD_NODES_KEY = CHILD_NODES.key();
  public static final String DOCUMENT_KEY = DOCUMENT.key();
  public static final String PARENT_NODE_KEY = PARENT_NODE.key();

  private static Logger LOG = Logger.getLogger(_KMIHTMLTextNode.class);

  public KMIHTMLTextNode localInstanceIn(EOEditingContext editingContext) {
    KMIHTMLTextNode localInstance = (KMIHTMLTextNode)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String textContent() {
    return (String) storedValueForKey(_KMIHTMLTextNode.TEXT_CONTENT_KEY);
  }

  public void setTextContent(String value) {
    if (_KMIHTMLTextNode.LOG.isDebugEnabled()) {
    	_KMIHTMLTextNode.LOG.debug( "updating textContent from " + textContent() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIHTMLTextNode.TEXT_CONTENT_KEY);
  }


  public static KMIHTMLTextNode createKMIHTMLTextNode(EOEditingContext editingContext) {
    KMIHTMLTextNode eo = (KMIHTMLTextNode) EOUtilities.createAndInsertInstance(editingContext, _KMIHTMLTextNode.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<KMIHTMLTextNode> fetchSpecForKMIHTMLTextNode() {
    return new ERXFetchSpecification<KMIHTMLTextNode>(_KMIHTMLTextNode.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIHTMLTextNode> fetchAllKMIHTMLTextNodes(EOEditingContext editingContext) {
    return _KMIHTMLTextNode.fetchAllKMIHTMLTextNodes(editingContext, null);
  }

  public static NSArray<KMIHTMLTextNode> fetchAllKMIHTMLTextNodes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIHTMLTextNode.fetchKMIHTMLTextNodes(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIHTMLTextNode> fetchKMIHTMLTextNodes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIHTMLTextNode> fetchSpec = new ERXFetchSpecification<KMIHTMLTextNode>(_KMIHTMLTextNode.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIHTMLTextNode> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIHTMLTextNode fetchKMIHTMLTextNode(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIHTMLTextNode.fetchKMIHTMLTextNode(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIHTMLTextNode fetchKMIHTMLTextNode(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIHTMLTextNode> eoObjects = _KMIHTMLTextNode.fetchKMIHTMLTextNodes(editingContext, qualifier, null);
    KMIHTMLTextNode eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIHTMLTextNode that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIHTMLTextNode fetchRequiredKMIHTMLTextNode(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIHTMLTextNode.fetchRequiredKMIHTMLTextNode(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIHTMLTextNode fetchRequiredKMIHTMLTextNode(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIHTMLTextNode eoObject = _KMIHTMLTextNode.fetchKMIHTMLTextNode(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIHTMLTextNode that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIHTMLTextNode localInstanceIn(EOEditingContext editingContext, KMIHTMLTextNode eo) {
    KMIHTMLTextNode localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}