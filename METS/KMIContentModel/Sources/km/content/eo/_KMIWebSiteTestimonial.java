// DO NOT EDIT.  Make changes to KMIWebSiteTestimonial.java instead.
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
public abstract class _KMIWebSiteTestimonial extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "KMIWebSiteTestimonial";

  // Attribute Keys
  public static final ERXKey<String> ATTESTER = new ERXKey<String>("attester");
  public static final ERXKey<NSTimestamp> CREATE_DATE = new ERXKey<NSTimestamp>("createDate");
  public static final ERXKey<String> TESTIMONIAL = new ERXKey<String>("testimonial");
  public static final ERXKey<NSTimestamp> TESTIMONIAL_DATE = new ERXKey<NSTimestamp>("testimonialDate");
  // Relationship Keys
  public static final ERXKey<km.content.eo.KMIWebSite> WEB_SITE = new ERXKey<km.content.eo.KMIWebSite>("webSite");

  // Attributes
  public static final String ATTESTER_KEY = ATTESTER.key();
  public static final String CREATE_DATE_KEY = CREATE_DATE.key();
  public static final String TESTIMONIAL_KEY = TESTIMONIAL.key();
  public static final String TESTIMONIAL_DATE_KEY = TESTIMONIAL_DATE.key();
  // Relationships
  public static final String WEB_SITE_KEY = WEB_SITE.key();

  private static Logger LOG = Logger.getLogger(_KMIWebSiteTestimonial.class);

  public KMIWebSiteTestimonial localInstanceIn(EOEditingContext editingContext) {
    KMIWebSiteTestimonial localInstance = (KMIWebSiteTestimonial)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String attester() {
    return (String) storedValueForKey(_KMIWebSiteTestimonial.ATTESTER_KEY);
  }

  public void setAttester(String value) {
    if (_KMIWebSiteTestimonial.LOG.isDebugEnabled()) {
    	_KMIWebSiteTestimonial.LOG.debug( "updating attester from " + attester() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebSiteTestimonial.ATTESTER_KEY);
  }

  public NSTimestamp createDate() {
    return (NSTimestamp) storedValueForKey(_KMIWebSiteTestimonial.CREATE_DATE_KEY);
  }

  public void setCreateDate(NSTimestamp value) {
    if (_KMIWebSiteTestimonial.LOG.isDebugEnabled()) {
    	_KMIWebSiteTestimonial.LOG.debug( "updating createDate from " + createDate() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebSiteTestimonial.CREATE_DATE_KEY);
  }

  public String testimonial() {
    return (String) storedValueForKey(_KMIWebSiteTestimonial.TESTIMONIAL_KEY);
  }

  public void setTestimonial(String value) {
    if (_KMIWebSiteTestimonial.LOG.isDebugEnabled()) {
    	_KMIWebSiteTestimonial.LOG.debug( "updating testimonial from " + testimonial() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebSiteTestimonial.TESTIMONIAL_KEY);
  }

  public NSTimestamp testimonialDate() {
    return (NSTimestamp) storedValueForKey(_KMIWebSiteTestimonial.TESTIMONIAL_DATE_KEY);
  }

  public void setTestimonialDate(NSTimestamp value) {
    if (_KMIWebSiteTestimonial.LOG.isDebugEnabled()) {
    	_KMIWebSiteTestimonial.LOG.debug( "updating testimonialDate from " + testimonialDate() + " to " + value);
    }
    takeStoredValueForKey(value, _KMIWebSiteTestimonial.TESTIMONIAL_DATE_KEY);
  }

  public km.content.eo.KMIWebSite webSite() {
    return (km.content.eo.KMIWebSite)storedValueForKey(_KMIWebSiteTestimonial.WEB_SITE_KEY);
  }
  
  public void setWebSite(km.content.eo.KMIWebSite value) {
    takeStoredValueForKey(value, _KMIWebSiteTestimonial.WEB_SITE_KEY);
  }

  public void setWebSiteRelationship(km.content.eo.KMIWebSite value) {
    if (_KMIWebSiteTestimonial.LOG.isDebugEnabled()) {
      _KMIWebSiteTestimonial.LOG.debug("updating webSite from " + webSite() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setWebSite(value);
    }
    else if (value == null) {
    	km.content.eo.KMIWebSite oldValue = webSite();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _KMIWebSiteTestimonial.WEB_SITE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _KMIWebSiteTestimonial.WEB_SITE_KEY);
    }
  }
  

  public static KMIWebSiteTestimonial createKMIWebSiteTestimonial(EOEditingContext editingContext, km.content.eo.KMIWebSite webSite) {
    KMIWebSiteTestimonial eo = (KMIWebSiteTestimonial) EOUtilities.createAndInsertInstance(editingContext, _KMIWebSiteTestimonial.ENTITY_NAME);    
    eo.setWebSiteRelationship(webSite);
    return eo;
  }

  public static ERXFetchSpecification<KMIWebSiteTestimonial> fetchSpec() {
    return new ERXFetchSpecification<KMIWebSiteTestimonial>(_KMIWebSiteTestimonial.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<KMIWebSiteTestimonial> fetchAllKMIWebSiteTestimonials(EOEditingContext editingContext) {
    return _KMIWebSiteTestimonial.fetchAllKMIWebSiteTestimonials(editingContext, null);
  }

  public static NSArray<KMIWebSiteTestimonial> fetchAllKMIWebSiteTestimonials(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMIWebSiteTestimonial.fetchKMIWebSiteTestimonials(editingContext, null, sortOrderings);
  }

  public static NSArray<KMIWebSiteTestimonial> fetchKMIWebSiteTestimonials(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<KMIWebSiteTestimonial> fetchSpec = new ERXFetchSpecification<KMIWebSiteTestimonial>(_KMIWebSiteTestimonial.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMIWebSiteTestimonial> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static KMIWebSiteTestimonial fetchKMIWebSiteTestimonial(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebSiteTestimonial.fetchKMIWebSiteTestimonial(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebSiteTestimonial fetchKMIWebSiteTestimonial(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMIWebSiteTestimonial> eoObjects = _KMIWebSiteTestimonial.fetchKMIWebSiteTestimonials(editingContext, qualifier, null);
    KMIWebSiteTestimonial eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMIWebSiteTestimonial that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebSiteTestimonial fetchRequiredKMIWebSiteTestimonial(EOEditingContext editingContext, String keyName, Object value) {
    return _KMIWebSiteTestimonial.fetchRequiredKMIWebSiteTestimonial(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMIWebSiteTestimonial fetchRequiredKMIWebSiteTestimonial(EOEditingContext editingContext, EOQualifier qualifier) {
    KMIWebSiteTestimonial eoObject = _KMIWebSiteTestimonial.fetchKMIWebSiteTestimonial(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMIWebSiteTestimonial that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMIWebSiteTestimonial localInstanceIn(EOEditingContext editingContext, KMIWebSiteTestimonial eo) {
    KMIWebSiteTestimonial localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}