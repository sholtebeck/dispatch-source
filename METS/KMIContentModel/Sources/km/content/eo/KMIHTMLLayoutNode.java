package km.content.eo;

import km.content.eo.utilities.KMIHTMLNodeUtilities;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;

public class KMIHTMLLayoutNode extends _KMIHTMLLayoutNode {

	private static final long serialVersionUID = -6383673288956718L;
	private static Logger log = Logger.getLogger(KMIHTMLLayoutNode.class);

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
	
	@Override
	public KMIHTMLNode firstChild() {
		return KMIHTMLNodeUtilities.firstChild(this);
	}

	@Override
	public KMIHTMLNode lastChild() {
		return KMIHTMLNodeUtilities.lastChild(this);
	}

	@Override
	public KMIHTMLNode nextSibling() {
		return KMIHTMLNodeUtilities.nextSibling(this);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Class nodeType() {
		return this.getClass();
	}

	@Override
	public String nodeValue() {
		return KMIHTMLNodeUtilities.nodeValue(this);
	}

	@Override
	public KMIWebDocument ownerDocument() {
		return KMIHTMLNodeUtilities.ownerDocument(this);
	}

	@Override
	public KMIHTMLNode previousSibling() {
		return KMIHTMLNodeUtilities.previousSibling(this);
	}

	@Override
	public String toHTML() {
		// TODO Auto-generated method stub
		return null;
	}

}
