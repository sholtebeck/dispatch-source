// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to KMIAbstractNodeAttribute.java instead.
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
public abstract class _KMIAbstractNodeAttribute extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "KMIAbstractNodeAttribute";

	// Attributes
	public static final String NAME_KEY = "name";
	public static final ERXKey NAME = new ERXKey(NAME_KEY);
	public static final String TYPE_KEY = "type";
	public static final ERXKey TYPE = new ERXKey(TYPE_KEY);
	public static final String VALUE_KEY = "value";
	public static final ERXKey VALUE = new ERXKey(VALUE_KEY);

	// Relationships

  private static Logger LOG = Logger.getLogger(_KMIAbstractNodeAttribute.class);

  public KMIAbstractNodeAttribute localInstanceIn(EOEditingContext editingContext) {
    KMIAbstractNodeAttribute localInstance = (KMIAbstractNodeAttribute)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_KMIAbstractNodeAttribute.LOG.isDebugEnabled()) {
    	_KMIAbstractNodeAttribute.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public Integer type() {
    return (Integer) storedValueForKey("type");
  }

  public void setType(Integer value) {
    if (_KMIAbstractNodeAttribute.LOG.isDebugEnabled()) {
    	_KMIAbstractNodeAttribute.LOG.debug( "updating type from " + type() + " to " + value);
    }
    takeStoredValueForKey(value, "type");
  }

  public String value() {
    return (String) storedValueForKey("value");
  }

  public void setValue(String value) {
    if (_KMIAbstractNodeAttribute.LOG.isDebugEnabled()) {
    	_KMIAbstractNodeAttribute.LOG.debug( "updating value from " + value() + " to " + value);
    }
    takeStoredValueForKey(value, "value");
  }


  public static KMIAbstractNodeAttribute createKMIAbstractNodeAttribute(EOEditingContext editingContext) {
    KMIAbstractNodeAttribute eo = (KMIAbstractNodeAttribute) EOUtilities.createAndInsertInstance(editingContext, _KMIAbstractNodeAttribute.ENTITY_NAME);    
    return eo;
  }

  public static NSArray<KMIAbstractNodeAttribute> fetchAllKMIAbstractNodeAttributes(EOEditingContext editingContext) {
    return _KMIAbstractNodeAttribute.fetchAllKMIAbstractNodeAttributes(editingContext, null);
  }

  public static NSArray<KMIAbstractNodeAttribute> fetchAllKMIAbstractNodeAttributes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIAbstractNodeAttribute.fetchKMIAbstractNodeAttributes(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIAbstractNodeAttribute> fetchKMIAbstractNodeAttributes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_KMIAbstractNodeAttribute.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIAbstractNodeAttribute> eoObjects = (NSArray<KMIAbstractNodeAttribute>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static KMIAbstractNodeAttribute fetchKMIAbstractNodeAttribute(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIAbstractNodeAttribute.fetchKMIAbstractNodeAttribute(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIAbstractNodeAttribute fetchKMIAbstractNodeAttribute(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIAbstractNodeAttribute> eoObjects = _KMIAbstractNodeAttribute.fetchKMIAbstractNodeAttributes(editingContext, qualifier, null);
    KMIAbstractNodeAttribute eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (KMIAbstractNodeAttribute)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIAbstractNodeAttribute that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIAbstractNodeAttribute fetchRequiredKMIAbstractNodeAttribute(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIAbstractNodeAttribute.fetchRequiredKMIAbstractNodeAttribute(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIAbstractNodeAttribute fetchRequiredKMIAbstractNodeAttribute(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIAbstractNodeAttribute eoObject = _KMIAbstractNodeAttribute.fetchKMIAbstractNodeAttribute(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIAbstractNodeAttribute that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIAbstractNodeAttribute localInstanceIn(EOEditingContext editingContext, KMIAbstractNodeAttribute eo) {
    KMIAbstractNodeAttribute localInstance = (eo == null) ? null : (KMIAbstractNodeAttribute)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
