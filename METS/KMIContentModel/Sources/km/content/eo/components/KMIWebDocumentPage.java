package km.content.eo.components;

import km.content.eo.KMIWebDocument;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

public class KMIWebDocumentPage extends ERXComponent {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private KMIWebDocument _document;

	public KMIWebDocumentPage(WOContext context) {
        super(context);
    }

    public KMIWebDocument document()
    {
        return _document;
    }

    public void setDocument(KMIWebDocument document)
    {
        _document = document;
    }

}