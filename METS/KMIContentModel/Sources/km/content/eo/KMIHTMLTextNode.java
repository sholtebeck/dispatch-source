package km.content.eo;

import java.net.MalformedURLException;

import km.content.eo.utilities.KMIHTMLNodeUtilities;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.webobjects.eoaccess.EOObjectNotAvailableException;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.foundation.ERXStringUtilities;

public class KMIHTMLTextNode extends _KMIHTMLTextNode {

	private static final long serialVersionUID = 2366317002749248087L;
	private static Logger log = Logger.getLogger(KMIHTMLTextNode.class);

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
		return KMIHTMLTextNode.class;
	}

	@Override
	public String nodeValue() {
		return KMIHTMLNodeUtilities.nodeValue(this);
	}

	@Override
	public KMIWebDocument ownerDocument() {
		return KMIHTMLNodeUtilities.ownerDocument(this);
	}

	public String toHTML() {

		StringBuilder html = new StringBuilder();
		String elementName = tagName() != null ? tagName() : "div";
		html.append("<");
		html.append(elementName);

		if(attributes() != null && attributes().allKeys().size() > 0) {
			for(Object attributeKey : attributes().allKeys()) {
				String value = (String) attributes().valueForKey((String) attributeKey);
				if(! ERXStringUtilities.stringIsNullOrEmpty(value)) {
					html.append(" ");
					html.append(attributeKey);
					html.append(" = \"");
					html.append(value);
					html.append("\"");
				}
			}
		}

		html.append(">");
		if(textContent() != null) {
			html.append(parse(textContent()));
		}
		html.append("</");
		html.append(elementName);
		html.append(">");

		return html.toString();

	}
	
	public String parse(String textContent) {

		Document document = Jsoup.parse(textContent);
		
		for(Element img : document.getElementsByTag("img")) {

			try {

				KMIImageAsset asset = KMIImageAsset.imageAssetFromURL(editingContext(), img.attr("src"));
				img.attr("src", img.attr("src").split("\\?")[0]);
				img.attr("alt", asset.alt());

			} catch(Exception e) {
				log.error("Unable to find image asset with url: " + img.attr("src"));
			}
		}
	
		return document.toString();

	}
	
	public KMIImageAsset firstImage() throws NumberFormatException, MalformedURLException, EOObjectNotAvailableException {

		KMIImageAsset asset = null;
		String imagePath = firstImagePath();
		if(imagePath != null) {
			asset = KMIImageAsset.imageAssetFromURL(editingContext(), imagePath);
		}

		return asset;

	}
	
	public String firstImagePath() {

		Document document = Jsoup.parse(textContent());
		Element image = document.select("img").first();
		return image.attr("src");
		
	}
	
	@Override
	public KMIHTMLNode previousSibling() {
		return KMIHTMLNodeUtilities.previousSibling(this);
	}

	public NSArray<km.content.eo.KMIHTMLNode> childNodes() {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static KMIHTMLTextNode createKMIHTMLTextNode(EOEditingContext editingContext, KMIWebDocument document) {
		NSArray<KMIHTMLNode> siblings = KMIHTMLNode.fetchKMIHTMLNodes(editingContext, KMIHTMLNode.DOCUMENT.eq(document).and(KMIHTMLNode.PARENT_NODE.isNull()), null);
		KMIHTMLTextNode eo = (KMIHTMLTextNode) EOUtilities.createAndInsertInstance(editingContext, _KMIHTMLTextNode.ENTITY_NAME);    
		eo.setPosition(siblings.size());
		eo.setDocumentRelationship(document);
		return eo;
	}

}