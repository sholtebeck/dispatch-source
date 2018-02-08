// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to KMISite.java instead.
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
public abstract class _KMISite extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "KMISite";

	// Attributes

	// Relationships

  private static Logger LOG = Logger.getLogger(_KMISite.class);

  public KMISite localInstanceIn(EOEditingContext editingContext) {
    KMISite localInstance = (KMISite)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }


  public static KMISite createKMISite(EOEditingContext editingContext) {
    KMISite eo = (KMISite) EOUtilities.createAndInsertInstance(editingContext, _KMISite.ENTITY_NAME);    
    return eo;
  }

  public static NSArray<KMISite> fetchAllKMISites(EOEditingContext editingContext) {
    return _KMISite.fetchAllKMISites(editingContext, null);
  }

  public static NSArray<KMISite> fetchAllKMISites(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _KMISite.fetchKMISites(editingContext, null, sortOrderings);
  }

  public static NSArray<KMISite> fetchKMISites(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_KMISite.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<KMISite> eoObjects = (NSArray<KMISite>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static KMISite fetchKMISite(EOEditingContext editingContext, String keyName, Object value) {
    return _KMISite.fetchKMISite(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMISite fetchKMISite(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<KMISite> eoObjects = _KMISite.fetchKMISites(editingContext, qualifier, null);
    KMISite eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (KMISite)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one KMISite that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMISite fetchRequiredKMISite(EOEditingContext editingContext, String keyName, Object value) {
    return _KMISite.fetchRequiredKMISite(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static KMISite fetchRequiredKMISite(EOEditingContext editingContext, EOQualifier qualifier) {
    KMISite eoObject = _KMISite.fetchKMISite(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no KMISite that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static KMISite localInstanceIn(EOEditingContext editingContext, KMISite eo) {
    KMISite localInstance = (eo == null) ? null : (KMISite)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
