package km.content.eo;

import kmi.foundation.extensions.KMIStringUtilities;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSMutableArray;

@SuppressWarnings("serial")
public class KMIWebDocumentCategory extends _KMIWebDocumentCategory {

	private static Logger log = Logger.getLogger(KMIWebDocumentCategory.class);

	/*
		insert event chain willInsert, didUpdate, didInsert
		update event chain willUpdate, didUpdate
		delete event chain willDelete, didDelete
	 */
	
	public void awakeFromInsertion(EOEditingContext ec) {
		super.awakeFromInsertion(ec);
		setUniqueIdentifier(KMIStringUtilities.sixtyFourBitHash(KMIStringUtilities.randomString(16)));
	}
	
	public void willInsert() {
		super.willInsert();
		setSlug(KMIStringUtilities.toPrettyURL(name()));
		log.debug("---------------------------------------------");
		log.debug("will insert entity with global id: " + editingContext().globalIDForObject(this));
		log.debug("---------------------------------------------");
	}

	public void willUpdate() {
		super.willUpdate();
		log.debug("---------------------------------------------");
		log.debug("will update entity with global id: " + editingContext().globalIDForObject(this));
		log.debug("---------------------------------------------");
	}

	public void didUpdate() {
		super.didUpdate();
		log.debug("---------------------------------------------");
		log.debug("Did Update");
		log.debug("---------------------------------------------");
	}

	public void didInsert() {
		super.didInsert();
		log.debug("---------------------------------------------");
		log.debug("did insert entity with global id: " + editingContext().globalIDForObject(this));
		log.debug("---------------------------------------------");
	}

	public void mightDelete() {
		super.mightDelete();
		log.debug("---------------------------------------------");
		log.debug("might delete entity with global id: " + editingContext().globalIDForObject(this));
		log.debug("---------------------------------------------");	
	}

	public void willDelete() {
		super.willDelete();
		log.debug("---------------------------------------------");
		log.debug("will delete entity with global id: " + editingContext().globalIDForObject(this));
		log.debug("---------------------------------------------");
	}

	public void didDelete(EOEditingContext ec) {
		super.didDelete(ec);
		log.debug("---------------------------------------------");
		log.debug("did delete entity with global id: " + ec.globalIDForObject(this));
		log.debug("---------------------------------------------");
	}

	public boolean hasParent() {
		return parent() != null;
	}
	
	public KMIWebDocumentCategory ancestor() {
		KMIWebDocumentCategory ancestor = this;
		while(ancestor.hasParent()) {
			ancestor = ancestor.parent();
		}
		return ancestor;
	}
	
	public static NSMutableArray<KMIWebDocumentCategory> descendentCategories(KMIWebDocumentCategory parent, NSMutableArray<KMIWebDocumentCategory> descendents) {
		for(KMIWebDocumentCategory child : parent.children()) {
			descendents.addObject(child);
			descendents = descendentCategories(child, descendents);
		}
		return descendents;
	}

	public NSMutableArray<KMIWebDocumentCategory> categoryAndDescendents() {
		NSMutableArray<KMIWebDocumentCategory> categories = new NSMutableArray<KMIWebDocumentCategory>();
		categories.addObject(this);
		categories = descendentCategories(this, categories);
		return categories;
	}
	
	
}
