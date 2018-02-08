package km.content.eo;

import jgravatar.Gravatar;
import jgravatar.GravatarDefaultImage;
import jgravatar.GravatarRating;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

@SuppressWarnings("serial")
public class KMIWebDocumentComment extends _KMIWebDocumentComment {

	private static Logger log = Logger.getLogger(KMIWebDocumentComment.class);

	/*
		insert event chain willInsert, didUpdate, didInsert
		update event chain willUpdate, didUpdate
		delete event chain willDelete, didDelete
	 */
	
	public void awakeFromInsertion(EOEditingContext ec) {
		super.awakeFromInsertion(ec);
		setCreationDate(new NSTimestamp());
		setFlagged(false);
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
	
	public String gravatarUrl() {
		Gravatar gravatar = new Gravatar();
		gravatar.setSize(60);
		gravatar.setRating(GravatarRating.GENERAL_AUDIENCES);
		gravatar.setDefaultImage(GravatarDefaultImage.IDENTICON);
		String url = gravatar.getUrl(commenterEmail());		
		return url;
	}	

}
