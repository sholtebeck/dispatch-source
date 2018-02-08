// DO NOT EDIT.  Make changes to KMIImageAsset.java instead.
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
public abstract class _KMIImageAsset extends km.content.eo.KMIAbstractAsset {
  public static final String ENTITY_NAME = "KMIImageAsset";

  // Attribute Keys
  public static final ERXKey<String> ALT = new ERXKey<String>("alt");
  public static final ERXKey<NSTimestamp> CREATE_DATE = new ERXKey<NSTimestamp>("createDate");
  public static final ERXKey<NSTimestamp> LAST_MODIFIED = new ERXKey<NSTimestamp>("lastModified");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> TYPE = new ERXKey<Integer>("type");
  // Relationship Keys
  public static final ERXKey<er.attachment.model.ERFileAttachment> ATTACHMENT = new ERXKey<er.attachment.model.ERFileAttachment>("attachment");
  public static final ERXKey<km.content.eo.KMIAssetGallery> GALLERIES = new ERXKey<km.content.eo.KMIAssetGallery>("galleries");
  public static final ERXKey<km.content.eo.KMIAssetGroup> GROUP = new ERXKey<km.content.eo.KMIAssetGroup>("group");
  public static final ERXKey<km.content.eo.KMIHTMLImageNode> NODES = new ERXKey<km.content.eo.KMIHTMLImageNode>("nodes");
  public static final ERXKey<km.content.eo.KMIWebSite> SITE = new ERXKey<km.content.eo.KMIWebSite>("site");

  // Attributes
  public static final String ALT_KEY = ALT.key();
  public static final String CREATE_DATE_KEY = CREATE_DATE.key();
  public static final String LAST_MODIFIED_KEY = LAST_MODIFIED.key();
  public static final String NAME_KEY = NAME.key();
  public static final String TYPE_KEY = TYPE.key();
  // Relationships
  public static final String ATTACHMENT_KEY = ATTACHMENT.key();
  public static final String GALLERIES_KEY = GALLERIES.key();
  public static final String GROUP_KEY = GROUP.key();
  public static final String NODES_KEY = NODES.key();
  public static final String SITE_KEY = SITE.key();

  private static Logger LOG = Logger.getLogger(_KMIImageAsset.class);

  public KMIImageAsset localInstanceIn(EOEditingContext editingContext) {
    KMIImageAsset localInstance = (KMIImageAsset)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String alt() {
    return (String) storedValueForKey(_KMIImageAsset.ALT_KEY);
  }

  public void setAlt(String value) {
    if (_KMIImageAsset.LOG.isDebugEnabled()) {
    	_KMIImageAsset.LOG.debug( "updating alt from " + alt() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIImageAsset.ALT_KEY);
  }

  public er.attachment.model.ERFileAttachment attachment() {
    return (er.attachment.model.ERFileAttachment)storedValueForKey(_KMIImageAsset.ATTACHMENT_KEY);
  }
  
  public void setAttachment(er.attachment.model.ERFileAttachment value) {
    takeStoredValueForKey(value, _KMIImageAsset.ATTACHMENT_KEY);
  }

  public void setAttachmentRelationship(er.attachment.model.ERFileAttachment value) {
    if (_KMIImageAsset.LOG.isDebugEnabled()) {
      _KMIImageAsset.LOG.debug("updating attachment from " + attachment() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setAttachment(value);
    }
    else if (value == null) {
    	er.attachment.model.ERFileAttachment oldValue = attachment();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIImageAsset.ATTACHMENT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIImageAsset.ATTACHMENT_KEY);
    }
  }
  
  public NSArray<km.content.eo.KMIHTMLImageNode> nodes() {
    return (NSArray<km.content.eo.KMIHTMLImageNode>)storedValueForKey(_KMIImageAsset.NODES_KEY);
  }

  public NSArray<km.content.eo.KMIHTMLImageNode> nodes(EOQualifier qualifier) {
    return nodes(qualifier, null, false);
  }

  public NSArray<km.content.eo.KMIHTMLImageNode> nodes(EOQualifier qualifier, boolean fetch) {
    return nodes(qualifier, null, fetch);
  }

  public NSArray<km.content.eo.KMIHTMLImageNode> nodes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<km.content.eo.KMIHTMLImageNode> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(km.content.eo.KMIHTMLImageNode.IMAGE_ASSET_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = km.content.eo.KMIHTMLImageNode.fetchKMIHTMLImageNodes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = nodes();
      if (qualifier != null) {
        results = (NSArray<km.content.eo.KMIHTMLImageNode>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<km.content.eo.KMIHTMLImageNode>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToNodes(km.content.eo.KMIHTMLImageNode object) {
    includeObjectIntoPropertyWithKey(object, _KMIImageAsset.NODES_KEY);
  }

  public void removeFromNodes(km.content.eo.KMIHTMLImageNode object) {
    excludeObjectFromPropertyWithKey(object, _KMIImageAsset.NODES_KEY);
  }

  public void addToNodesRelationship(km.content.eo.KMIHTMLImageNode object) {
    if (_KMIImageAsset.LOG.isDebugEnabled()) {
      _KMIImageAsset.LOG.debug("adding " + object + " to nodes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToNodes(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _KMIImageAsset.NODES_KEY);
    }
  }

  public void removeFromNodesRelationship(km.content.eo.KMIHTMLImageNode object) {
    if (_KMIImageAsset.LOG.isDebugEnabled()) {
      _KMIImageAsset.LOG.debug("removing " + object + " from nodes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromNodes(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIImageAsset.NODES_KEY);
    }
  }

  public km.content.eo.KMIHTMLImageNode createNodesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( km.content.eo.KMIHTMLImageNode.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _KMIImageAsset.NODES_KEY);
    return (km.content.eo.KMIHTMLImageNode) eo;
  }

  public void deleteNodesRelationship(km.content.eo.KMIHTMLImageNode object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _KMIImageAsset.NODES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllNodesRelationships() {
    Enumeration<km.content.eo.KMIHTMLImageNode> objects = nodes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteNodesRelationship(objects.nextElement());
    }
  }


  public static KMIImageAsset createKMIImageAsset(EOEditingContext editingContext, km.content.eo.KMIWebSite site) {
    KMIImageAsset eo = (KMIImageAsset) EOUtilities.createAndInsertInstance(editingContext, _KMIImageAsset.ENTITY_NAME);    
    eo.setSiteRelationship(site);
    return eo;
  }

  public static ERXFetchSpecification<KMIImageAsset> fetchSpecForKMIImageAsset() {
    return new ERXFetchSpecification<KMIImageAsset>(_KMIImageAsset.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIImageAsset> fetchAllKMIImageAssets(EOEditingContext editingContext) {
    return _KMIImageAsset.fetchAllKMIImageAssets(editingContext, null);
  }

  public static NSArray<KMIImageAsset> fetchAllKMIImageAssets(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIImageAsset.fetchKMIImageAssets(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIImageAsset> fetchKMIImageAssets(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIImageAsset> fetchSpec = new ERXFetchSpecification<KMIImageAsset>(_KMIImageAsset.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIImageAsset> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIImageAsset fetchKMIImageAsset(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIImageAsset.fetchKMIImageAsset(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIImageAsset fetchKMIImageAsset(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIImageAsset> eoObjects = _KMIImageAsset.fetchKMIImageAssets(editingContext, qualifier, null);
    KMIImageAsset eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIImageAsset that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIImageAsset fetchRequiredKMIImageAsset(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIImageAsset.fetchRequiredKMIImageAsset(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIImageAsset fetchRequiredKMIImageAsset(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIImageAsset eoObject = _KMIImageAsset.fetchKMIImageAsset(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIImageAsset that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIImageAsset localInstanceIn(EOEditingContext editingContext, KMIImageAsset eo) {
    KMIImageAsset localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}