// DO NOT EDIT.  Make changes to KMIAbstractDocument.java instead.
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
public abstract class _KMIAbstractDocument extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "KMIAbstractDocument";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATE_DATE = new ERXKey<NSTimestamp>("createDate");
  public static final ERXKey<NSTimestamp> LAST_MODIFIED = new ERXKey<NSTimestamp>("lastModified");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> TYPE = new ERXKey<Integer>("type");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIAbstractNode> NODES = new ERXKey<km.content.eo.KMIAbstractNode>("nodes");
  public static final ERXKey<km.content.eo.KMIWebSite> SITE = new ERXKey<km.content.eo.KMIWebSite>("site");

  // Attributes
  public static final String CREATE_DATE_KEY = CREATE_DATE.key();
  public static final String LAST_MODIFIED_KEY = LAST_MODIFIED.key();
  public static final String NAME_KEY = NAME.key();
  public static final String TYPE_KEY = TYPE.key();
  // Relationships
  public static final String NODES_KEY = NODES.key();
  public static final String SITE_KEY = SITE.key();

  private static Logger LOG = Logger.getLogger(_KMIAbstractDocument.class);

  public KMIAbstractDocument localInstanceIn(EOEditingContext editingContext) {
    KMIAbstractDocument localInstance = (KMIAbstractDocument)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp createDate() {
    return (NSTimestamp) storedValueForKey(_KMIAbstractDocument.CREATE_DATE_KEY);
  }

  public void setCreateDate(NSTimestamp value) {
    if (_KMIAbstractDocument.LOG.isDebugEnabled()) {
    	_KMIAbstractDocument.LOG.debug( "updating createDate from " + createDate() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAbstractDocument.CREATE_DATE_KEY);
  }

  public NSTimestamp lastModified() {
    return (NSTimestamp) storedValueForKey(_KMIAbstractDocument.LAST_MODIFIED_KEY);
  }

  public void setLastModified(NSTimestamp value) {
    if (_KMIAbstractDocument.LOG.isDebugEnabled()) {
    	_KMIAbstractDocument.LOG.debug( "updating lastModified from " + lastModified() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAbstractDocument.LAST_MODIFIED_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_KMIAbstractDocument.NAME_KEY);
  }

  public void setName(String value) {
    if (_KMIAbstractDocument.LOG.isDebugEnabled()) {
    	_KMIAbstractDocument.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAbstractDocument.NAME_KEY);
  }

  public Integer type() {
    return (Integer) storedValueForKey(_KMIAbstractDocument.TYPE_KEY);
  }

  public void setType(Integer value) {
    if (_KMIAbstractDocument.LOG.isDebugEnabled()) {
    	_KMIAbstractDocument.LOG.debug( "updating type from " + type() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIAbstractDocument.TYPE_KEY);
  }

  public km.content.eo.KMIWebSite site() {
    return (km.content.eo.KMIWebSite)storedValueForKey(_KMIAbstractDocument.SITE_KEY);
  }
  
  public void setSite(km.content.eo.KMIWebSite value) {
    takeStoredValueForKey(value, _KMIAbstractDocument.SITE_KEY);
  }

  public void setSiteRelationship(km.content.eo.KMIWebSite value) {
    if (_KMIAbstractDocument.LOG.isDebugEnabled()) {
      _KMIAbstractDocument.LOG.debug("updating site from " + site() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setSite(value);
    }
    else if (value == null) {
    	km.content.eo.KMIWebSite oldValue = site();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIAbstractDocument.SITE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIAbstractDocument.SITE_KEY);
    }
  }
  
  public NSArray<km.content.eo.KMIAbstractNode> nodes() {
    return (NSArray<km.content.eo.KMIAbstractNode>)storedValueForKey(_KMIAbstractDocument.NODES_KEY);
  }

  public NSArray<km.content.eo.KMIAbstractNode> nodes(EOQualifier qualifier) {
    return nodes(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIAbstractNode> nodes(EOQualifier qualifier, boolean fetch) {
    return nodes(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIAbstractNode> nodes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIAbstractNode> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIAbstractNode.DOCUMENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = km.content.eo.KMIAbstractNode.fetchKMIAbstractNodes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = nodes();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIAbstractNode>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIAbstractNode>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToNodes(km.content.eo.KMIAbstractNode object) {
    includeObjectIntoPropertyWithKey(object, _KMIAbstractDocument.NODES_KEY);
  }

  public void removeFromNodes(km.content.eo.KMIAbstractNode object) {
    excludeObjectFromPropertyWithKey(object, _KMIAbstractDocument.NODES_KEY);
  }

  public void addToNodesRelationship(km.content.eo.KMIAbstractNode object) {
    if (_KMIAbstractDocument.LOG.isDebugEnabled()) {
      _KMIAbstractDocument.LOG.debug("adding " + object + " to nodes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToNodes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIAbstractDocument.NODES_KEY);
    }
  }

  public void removeFromNodesRelationship(km.content.eo.KMIAbstractNode object) {
    if (_KMIAbstractDocument.LOG.isDebugEnabled()) {
      _KMIAbstractDocument.LOG.debug("removing " + object + " from nodes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromNodes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIAbstractDocument.NODES_KEY);
    }
  }

  public km.content.eo.KMIAbstractNode createNodesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIAbstractNode.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIAbstractDocument.NODES_KEY);
    return (km.content.eo.KMIAbstractNode) eo;
  }

  public void deleteNodesRelationship(km.content.eo.KMIAbstractNode object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIAbstractDocument.NODES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllNodesRelationships() {
    Enumeration<km.content.eo.KMIAbstractNode> objects = nodes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteNodesRelationship(objects.nextElement());
    }
  }


  public static KMIAbstractDocument createKMIAbstractDocument(EOEditingContext editingContext, km.content.eo.KMIWebSite site) {
    KMIAbstractDocument eo = (KMIAbstractDocument) EOUtilities.createAndInsertInstance(editingContext, _KMIAbstractDocument.ENTITY_NAME);    
    eo.setSiteRelationship(site);
    return eo;
  }

  public static ERXFetchSpecification<KMIAbstractDocument> fetchSpec() {
    return new ERXFetchSpecification<KMIAbstractDocument>(_KMIAbstractDocument.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIAbstractDocument> fetchAllKMIAbstractDocuments(EOEditingContext editingContext) {
    return _KMIAbstractDocument.fetchAllKMIAbstractDocuments(editingContext, null);
  }

  public static NSArray<KMIAbstractDocument> fetchAllKMIAbstractDocuments(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIAbstractDocument.fetchKMIAbstractDocuments(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIAbstractDocument> fetchKMIAbstractDocuments(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIAbstractDocument> fetchSpec = new ERXFetchSpecification<KMIAbstractDocument>(_KMIAbstractDocument.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIAbstractDocument> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIAbstractDocument fetchKMIAbstractDocument(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIAbstractDocument.fetchKMIAbstractDocument(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIAbstractDocument fetchKMIAbstractDocument(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIAbstractDocument> eoObjects = _KMIAbstractDocument.fetchKMIAbstractDocuments(editingContext, qualifier, null);
    KMIAbstractDocument eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIAbstractDocument that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIAbstractDocument fetchRequiredKMIAbstractDocument(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIAbstractDocument.fetchRequiredKMIAbstractDocument(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIAbstractDocument fetchRequiredKMIAbstractDocument(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIAbstractDocument eoObject = _KMIAbstractDocument.fetchKMIAbstractDocument(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIAbstractDocument that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIAbstractDocument localInstanceIn(EOEditingContext editingContext, KMIAbstractDocument eo) {
    KMIAbstractDocument localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}