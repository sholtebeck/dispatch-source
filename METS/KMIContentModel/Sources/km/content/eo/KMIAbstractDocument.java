package km.content.eo;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

public class KMIAbstractDocument extends _KMIAbstractDocument {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7968502891473225057L;
	private static Logger log = Logger.getLogger(KMIAbstractDocument.class);

	public void awakeFromInsertion(EOEditingContext editingContext) {
		super.awakeFromInsertion(editingContext);
		setCreateDate(new NSTimestamp());
		setLastModified(new NSTimestamp());
	}

	public void awakeFromClientUpdate(EOEditingContext editingContext) {
		super.awakeFromClientUpdate(editingContext);
		setCreateDate(new NSTimestamp());
		setLastModified(new NSTimestamp());
	}

	public void willInsert() {
		super.willInsert();
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
	
}
