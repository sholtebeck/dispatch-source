package km.content.eo.components;

import km.content.eo.KMIWebDocument;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXStatelessComponent;
import er.extensions.foundation.ERXStringUtilities;

@SuppressWarnings("serial")
public class KMIWebDocumentViewer extends ERXStatelessComponent {

	private KMIWebDocument _document;
	private String _sectionName;
	
	public KMIWebDocumentViewer(WOContext context) {
        super(context);
    }
	
	public void reset() {
		super.reset();
		_document = null;
		_sectionName = null;
	}

	public KMIWebDocument document() {
		if(_document == null) {
			_document = (KMIWebDocument) valueForBinding("document");
		}
		return _document;
	}

	public void setDocument(KMIWebDocument document) {
		this._document = document;
	}

	public String text() {

		String text = null;
		
		if(ERXStringUtilities.stringIsNullOrEmpty(sectionName())) {
			text = document().textContent();
		} else {
			text = document().textContent(sectionName());
		}
		
		return text;

	}

	public String sectionName() {
		if(_sectionName == null) {
			_sectionName = stringValueForBinding("sectionName");
		}
		return _sectionName;
	}

	public void setSectionName(String sectionName) {
		this._sectionName = sectionName;
	}



}