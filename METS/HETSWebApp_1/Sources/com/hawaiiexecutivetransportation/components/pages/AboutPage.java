package com.hawaiiexecutivetransportation.components.pages;

import km.content.eo.KMIWebDocument;

import com.hawaiiexecutivetransportation.components.Main;
import com.webobjects.appserver.WOContext;
import com.webobjects.eoaccess.EOUtilities;

public class AboutPage extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AboutPage(WOContext context) {
        super(context);
    }

	public void reset() {
		super.reset();
		_document = null;
	}
	
	public boolean isStateless() {
		return true;
	}
	
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	private KMIWebDocument _document;
	public KMIWebDocument document() {

		if(_document == null) {
			String value = System.getProperty("km.content.eo.KMIWebDocument.AboutUs.pk");			
			_document = (KMIWebDocument)EOUtilities.objectWithPrimaryKeyValue(ec(), KMIWebDocument.ENTITY_NAME, Integer.valueOf(value));
		}
		
		return _document;

	}

	public void setDocument(KMIWebDocument document) {
		this._document = document;
	}
	
}