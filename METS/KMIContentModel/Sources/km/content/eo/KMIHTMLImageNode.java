package km.content.eo;

import km.content.eo.utilities.KMIHTMLNodeUtilities;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;

public class KMIHTMLImageNode extends _KMIHTMLImageNode {

	private static final long serialVersionUID = -5262279929745161990L;

	private static Logger log = Logger.getLogger(KMIHTMLImageNode.class);

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
		return null;
	}

	@Override
	public KMIHTMLNode lastChild() {
		return null;
	}

	@Override
	public KMIHTMLNode nextSibling() {
		return KMIHTMLNodeUtilities.nextSibling(this);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Class nodeType() {
		return null;
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

		StringBuilder sb = new StringBuilder();
		
		if(imageAsset() != null) {
			sb.append("<img src=\"");
			sb.append(imageAsset().attachment().webPath());
			sb.append("\" />");
		} else {
			sb.append("<h2>No image assets are associated with this section.</h2>");
		}
		
		return sb.toString();

	}

}
