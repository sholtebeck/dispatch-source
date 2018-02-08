package km.content.eo.utilities;

import km.content.eo.KMIHTMLNode;
import km.content.eo.KMIWebDocument;

public class KMIHTMLNodeUtilities {

	
	public static KMIHTMLNode firstChild(KMIHTMLNode parent) {

		KMIHTMLNode firstChild = null;
		
		if(parent.childNodes() != null && parent.childNodes().size() > 0) {
			firstChild = parent.childNodes().get(0);
		}
		
		return firstChild;

	}
	
	public static KMIHTMLNode lastChild(KMIHTMLNode parent) {

		KMIHTMLNode lastChild = null;
		
		if(parent.childNodes() != null && parent.childNodes().size() > 0) {
			lastChild = parent.childNodes().lastObject();
		}
		
		return lastChild;
		
	}

	public static KMIHTMLNode nextSibling(KMIHTMLNode node) {

		KMIHTMLNode nextSibling = null;
		
		if(node.parentNode() != null) {
			if(node.parentNode().childNodes().size() > node.position()) {
				nextSibling = node.parentNode().childNodes().get(node.position() + 1);
			}
		}
		
		return nextSibling;
		
	}
	
	public static String nodeValue(KMIHTMLNode node) {

		StringBuilder nodeValueBuilder = new StringBuilder();
		
		
		return nodeValueBuilder.toString();
		
	}
	
	public static KMIWebDocument ownerDocument(KMIHTMLNode node) {

		KMIWebDocument ownerDocument = null;
		
		if(node.document() != null) {
			ownerDocument = (KMIWebDocument)node.document();
		} else if(node.parentNode() != null) {
			ownerDocument = node.parentNode().ownerDocument();
		}
		
		return ownerDocument;
		
	}

	public static KMIHTMLNode previousSibling(KMIHTMLNode node) {

		KMIHTMLNode previousSibling = null;

		if(node.parentNode() != null) {
			if(node.position() > 0) {
				previousSibling = node.parentNode().childNodes().get(node.position() - 1);
			}
		}
		
		return previousSibling;
		
	}

}
