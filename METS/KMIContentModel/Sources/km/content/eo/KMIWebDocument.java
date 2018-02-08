package km.content.eo;

import kmi.foundation.extensions.KMIStringUtilities;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSValidation;

import er.extensions.foundation.ERXStringUtilities;
import er.extensions.foundation.ERXTimestampUtilities;
import er.extensions.validation.ERXValidationException;
import er.extensions.validation.ERXValidationFactory;

public class KMIWebDocument extends _KMIWebDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4889463731677434618L;
	private static Logger log = Logger.getLogger(KMIWebDocument.class);

	public void awakeFromInsertion(EOEditingContext editingContext) {
		super.awakeFromInsertion(editingContext);
		setCommentsEnabled(false);
		NSTimestamp today = ERXTimestampUtilities.today();
		setCreateDate(today);
		setIsPublished(false);
		setPublishDate(today);
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
	
	public boolean hasComments() {
		return comments() != null && comments().size() > 0;
	}

	public boolean hasNodes() {
		return nodes() != null && nodes().size() > 0;
	}
	
	public static KMIHTMLNode namedSectionForDocument(KMIWebDocument document, 
			String name) {
		
		KMIHTMLNode namedSection = null;
		for(KMIAbstractNode node : document.nodes()) {
			if(node.name() != null && node.name().equalsIgnoreCase(name)) {
				namedSection = (KMIHTMLNode) node;
				break;
			}
		}
	
		return namedSection;
	
	}
	
	public static NSArray<KMIAbstractNode> namedSectionsForDocument(KMIWebDocument document, String name, NSArray<EOSortOrdering> sortOrderings) {
		
		if(sortOrderings == null) {
			sortOrderings = KMIHTMLNode.POSITION.ascs();
		}

		return document.nodes(KMIAbstractNode.NAME.eq(name), KMIWebDocument.POSITION.ascs(), true);
		
	}
	
	public String textContent() {
	
		StringBuilder textContent = new StringBuilder();
		
		for(KMIAbstractNode node : nodes(null, KMIWebDocument.POSITION.ascs(), true)) {
			if(node instanceof KMIHTMLNode) {
				textContent.append(((KMIHTMLNode) node).toHTML());
			}
		}

		String stringValue = textContent.toString();

		return stringValue == null ? "" : stringValue;

	}
	
	public String textContent(String name) {

		StringBuilder textContent = new StringBuilder();
		NSArray<KMIAbstractNode> namedNodes = namedSectionsForDocument(this, name, null);
		
		for(KMIAbstractNode node : namedNodes) {
			textContent.append(((KMIHTMLNode) node).toHTML());
		}

		String stringValue = textContent.toString();

		return stringValue == null ? "" : stringValue;

	}
	

	public String plainText() {
		
		String content = textContent();
		Document doc = Jsoup.parse(content);
		StringBuilder sb = new StringBuilder();
		
		Elements elements = doc.getAllElements();
		for(Element element : elements) {
			for(Node node : element.childNodes()) {
				if(node instanceof TextNode) {
					sb.append(((TextNode) node).text());
				}
			}
		}

		return sb.toString();
		
	}
	
	public String validateName(String value) throws NSValidation.ValidationException {
		if(ERXStringUtilities.stringIsNullOrEmpty(value)) {
			throw ERXValidationFactory.defaultFactory().createException(this, KMIWebDocument.NAME_KEY, value, ERXValidationException.NullPropertyException);
		}
		return value;
	}

	public NSArray<KMIHTMLImageNode> imageNodes() {
		return KMIHTMLImageNode.fetchKMIHTMLImageNodes(editingContext(), KMIHTMLImageNode.DOCUMENT.eq(this), KMIHTMLImageNode.POSITION.ascs());
	}
	
}
