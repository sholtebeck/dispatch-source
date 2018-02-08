// DO NOT EDIT.  Make changes to KMIWebDocumentTemplate.java instead.
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
public abstract class _KMIWebDocumentTemplate extends km.content.eo.KMIAbstractDocument {
  public static final String ENTITY_NAME = "KMIWebDocumentTemplate";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATE_DATE = new ERXKey<NSTimestamp>("createDate");
  public static final ERXKey<NSTimestamp> LAST_MODIFIED = new ERXKey<NSTimestamp>("lastModified");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Integer> TYPE = new ERXKey<Integer>("type");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIHTMLNode> NODES = new ERXKey<km.content.eo.KMIHTMLNode>("nodes");
  public static final ERXKey<km.content.eo.KMIWebSite> SITE = new ERXKey<km.content.eo.KMIWebSite>("site");

  // Attributes
  public static final String CREATE_DATE_KEY = CREATE_DATE.key();
  public static final String LAST_MODIFIED_KEY = LAST_MODIFIED.key();
  public static final String NAME_KEY = NAME.key();
  public static final String TYPE_KEY = TYPE.key();
  // Relationships
  public static final String NODES_KEY = NODES.key();
  public static final String SITE_KEY = SITE.key();

  private static Logger LOG = Logger.getLogger(_KMIWebDocumentTemplate.class);

  public KMIWebDocumentTemplate localInstanceIn(EOEditingContext editingContext) {
    KMIWebDocumentTemplate localInstance = (KMIWebDocumentTemplate)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }


  public static KMIWebDocumentTemplate createKMIWebDocumentTemplate(EOEditingContext editingContext, km.content.eo.KMIWebSite site) {
    KMIWebDocumentTemplate eo = (KMIWebDocumentTemplate) EOUtilities.createAndInsertInstance(editingContext, _KMIWebDocumentTemplate.ENTITY_NAME);    
    eo.setSiteRelationship(site);
    return eo;
  }

  public static ERXFetchSpecification<KMIWebDocumentTemplate> fetchSpecForKMIWebDocumentTemplate() {
    return new ERXFetchSpecification<KMIWebDocumentTemplate>(_KMIWebDocumentTemplate.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIWebDocumentTemplate> fetchAllKMIWebDocumentTemplates(EOEditingContext editingContext) {
    return _KMIWebDocumentTemplate.fetchAllKMIWebDocumentTemplates(editingContext, null);
  }

  public static NSArray<KMIWebDocumentTemplate> fetchAllKMIWebDocumentTemplates(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIWebDocumentTemplate.fetchKMIWebDocumentTemplates(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIWebDocumentTemplate> fetchKMIWebDocumentTemplates(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIWebDocumentTemplate> fetchSpec = new ERXFetchSpecification<KMIWebDocumentTemplate>(_KMIWebDocumentTemplate.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIWebDocumentTemplate> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIWebDocumentTemplate fetchKMIWebDocumentTemplate(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebDocumentTemplate.fetchKMIWebDocumentTemplate(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebDocumentTemplate fetchKMIWebDocumentTemplate(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIWebDocumentTemplate> eoObjects = _KMIWebDocumentTemplate.fetchKMIWebDocumentTemplates(editingContext, qualifier, null);
    KMIWebDocumentTemplate eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIWebDocumentTemplate that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebDocumentTemplate fetchRequiredKMIWebDocumentTemplate(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebDocumentTemplate.fetchRequiredKMIWebDocumentTemplate(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebDocumentTemplate fetchRequiredKMIWebDocumentTemplate(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIWebDocumentTemplate eoObject = _KMIWebDocumentTemplate.fetchKMIWebDocumentTemplate(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIWebDocumentTemplate that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebDocumentTemplate localInstanceIn(EOEditingContext editingContext, KMIWebDocumentTemplate eo) {
    KMIWebDocumentTemplate localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}