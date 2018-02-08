package km.content.eo;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.foundation.ERXMutableDictionary;
import er.extensions.validation.ERXValidationException;
import er.extensions.validation.ERXValidationFactory;

@SuppressWarnings("serial")
public class KMIWebSite extends _KMIWebSite {

	private static Logger log = Logger.getLogger(KMIWebSite.class);

	/*
		insert event chain willInsert, didUpdate, didInsert
		update event chain willUpdate, didUpdate
		delete event chain willDelete, didDelete
	 */
	
	public void awakeFromInsertion(EOEditingContext ec) {
		super.awakeFromInsertion(ec);
		setProperties(new ERXMutableDictionary<String, Object>());
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
	
	public boolean hasCategories() {
		return categories() != null && categories().size() > 0;
	}
	
	public String validateDomainName(String value) throws ERXValidationException {
		if(value != null) {
			if(! value.startsWith("http://")) {
				throw ERXValidationFactory.defaultFactory().createException(this, DOMAIN_NAME_KEY, value, ERXValidationException.InvalidValueException);
			}
		}
		return value;
	}


}
