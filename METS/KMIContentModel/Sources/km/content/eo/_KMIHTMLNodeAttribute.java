// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to KMIHTMLNodeAttribute.java instead.
package km.content.eo;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;
import er.extensions.eof.ERXGenericRecord;
import er.extensions.eof.ERXKey;

@SuppressWarnings("all")
public abstract class _KMIHTMLNodeAttribute extends km.content.eo.KMIAbstractNodeAttribute {
	public static final String ENTITY_NAME = "KMIHTMLNodeAttribute";

	// Attributes
	public static final String NAME_KEY = "name";
	public static final ERXKey NAME = new ERXKey(NAME_KEY);
	public static final String TYPE_KEY = "type";
	public static final ERXKey TYPE = new ERXKey(TYPE_KEY);
	public static final String VALUE_KEY = "value";
	public static final ERXKey VALUE = new ERXKey(VALUE_KEY);

	// Relationships
	public static final String NODE_KEY = "node";
	public static final ERXKey NODE = new ERXKey(NODE_KEY);

  private static Logger LOG = Logger.getLogger(_KMIHTMLNodeAttribute.class);

  public KMIHTMLNodeAttribute localInstanceIn(EOEditingContext editingContext) {
    KMIHTMLNodeAttribute localInstance = (KMIHTMLNodeAttribute)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public km.content.eo.KMIHTMLNode node() {
    return (km.content.eo.KMIHTMLNode)storedValueForKey("node");
  }

  public void setNodeRelationship(km.content.eo.KMIHTMLNode value) {
    if (_KMIHTMLNodeAttribute.LOG.isDebugEnabled()) {
      _KMIHTMLNodeAttribute.LOG.debug("updating node from " + node() + " to " + value);
    }
    if (value == null) {
    	km.content.eo.KMIHTMLNode oldValue = node();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "node");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "node");
    }
  }
  

  public static KMIHTMLNodeAttribute createKMIHTMLNodeAttribute(EOEditingContext editingContext, km.content.eo.KMIHTMLNode node) {
    KMIHTMLNodeAttribute eo = (KMIHTMLNodeAttribute) EOUtilities.createAndInsertInstance(editingContext, _KMIHTMLNodeAttribute.ENTITY_NAME);    
    eo.setNodeRelationship(node);
    return eo;
  }

  public static NSArray<KMIHTMLNodeAttribute> fetchAllKMIHTMLNodeAttributes(EOEditingContext editingContext) {
    return _KMIHTMLNodeAttribute.fetchAllKMIHTMLNodeAttributes(editingContext, null);
  }

  public static NSArray<KMIHTMLNodeAttribute> fetchAllKMIHTMLNodeAttributes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIHTMLNodeAttribute.fetchKMIHTMLNodeAttributes(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIHTMLNodeAttribute> fetchKMIHTMLNodeAttributes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_KMIHTMLNodeAttribute.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIHTMLNodeAttribute> eoObjects = (NSArray<KMIHTMLNodeAttribute>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static KMIHTMLNodeAttribute fetchKMIHTMLNodeAttribute(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIHTMLNodeAttribute.fetchKMIHTMLNodeAttribute(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIHTMLNodeAttribute fetchKMIHTMLNodeAttribute(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIHTMLNodeAttribute> eoObjects = _KMIHTMLNodeAttribute.fetchKMIHTMLNodeAttributes(editingContext, qualifier, null);
    KMIHTMLNodeAttribute eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (KMIHTMLNodeAttribute)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIHTMLNodeAttribute that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIHTMLNodeAttribute fetchRequiredKMIHTMLNodeAttribute(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIHTMLNodeAttribute.fetchRequiredKMIHTMLNodeAttribute(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIHTMLNodeAttribute fetchRequiredKMIHTMLNodeAttribute(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIHTMLNodeAttribute eoObject = _KMIHTMLNodeAttribute.fetchKMIHTMLNodeAttribute(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIHTMLNodeAttribute that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIHTMLNodeAttribute localInstanceIn(EOEditingContext editingContext, KMIHTMLNodeAttribute eo) {
    KMIHTMLNodeAttribute localInstance = (eo == null) ? null : (KMIHTMLNodeAttribute)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
