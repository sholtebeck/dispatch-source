package km.content.eo;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;

public abstract class KMIHTMLNode extends _KMIHTMLNode {

	@SuppressWarnings("unchecked")
	private final NSDictionary defaultDictionary = new NSDictionary(new NSArray<String>(new String[] {"", "", ""}), 
			new NSArray<String>(new String[] { "id", "class", "style" }));

	
	public void awakeFromInsertion(EOEditingContext editingContext) {
		super.awakeFromInsertion(editingContext);
		setAttributes(defaultDictionary);
	}
	
	private static final long serialVersionUID = -9223047921969262054L;
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(KMIHTMLNode.class);

	public abstract KMIHTMLNode firstChild();
	public abstract KMIHTMLNode lastChild();
	public abstract KMIHTMLNode nextSibling();
	@SuppressWarnings("rawtypes")
	public abstract Class nodeType();
	public abstract String nodeValue();
	public abstract KMIWebDocument ownerDocument();
	public abstract KMIHTMLNode previousSibling();
	public abstract String toHTML();

	
}
