package km.content.eo;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;

public class KMIAssetGallery extends _KMIAssetGallery {

	private static final long serialVersionUID = 145449124426292096L;

	private static Logger log = Logger.getLogger(KMIAssetGallery.class);

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
