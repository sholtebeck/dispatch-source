package km.content.eo.components;

import km.content.eo.KMIAbstractNode;
import km.content.eo.KMIHTMLNode;
import km.content.eo.KMIHTMLTextNode;
import km.content.eo.KMIWebDocument;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXStatelessComponent;

public class KMIHTMLNodeViewer extends ERXStatelessComponent {

	public KMIHTMLNodeViewer(WOContext context) {
        super(context);
    }

	public String content() {
		
		String content = null;
		
		if(hasBinding("node")) {

			KMIHTMLNode node = (KMIHTMLNode) valueForBinding("node");
			content = node.toHTML();

		} else if(hasBinding("document") && hasBinding("section")) {

			KMIWebDocument document = (KMIWebDocument) valueForBinding("document");
			String section = stringValueForBinding("section");
	
			for(KMIAbstractNode aNode : document.nodes()) {
				if(aNode instanceof KMIHTMLTextNode) {
					if(aNode.name().equals(section)) {
						content = ((KMIHTMLNode) aNode).toHTML();
						break;
					}
				}
			}

		}

		return content;

	}

}