package com.hawaiiexecutivetransportation.components.pages;

import km.content.eo.KMIWebDocument;

import com.hawaiiexecutivetransportation.components.Main;
import com.webobjects.appserver.WOContext;
import com.webobjects.eoaccess.EOUtilities;

@SuppressWarnings("serial")
public class TermsAndConditions extends Main {

	public TermsAndConditions(WOContext context) {
        super(context);
    }
	
	public void reset() {
		super.reset();
		_document = null;
	}
	
	@Override
	public boolean isStateless() {
		return true;
	}
	
	private KMIWebDocument _document;
	public KMIWebDocument document() {

		if(_document == null) {
			String value = System.getProperty("km.content.eo.KMIWebDocument.TermsAndConditions.pk");			
			_document = (KMIWebDocument)EOUtilities.objectWithPrimaryKeyValue(ec(), KMIWebDocument.ENTITY_NAME, Integer.valueOf(value));
		}
		
		return _document;

	}

	public void setDocument(KMIWebDocument document) {
		this._document = document;
	}
	


}