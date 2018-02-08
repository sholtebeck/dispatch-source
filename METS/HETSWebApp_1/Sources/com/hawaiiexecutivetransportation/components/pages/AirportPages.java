package com.hawaiiexecutivetransportation.components.pages;

import km.content.eo.KMIWebDocument;

import com.webobjects.appserver.WOContext;
import com.webobjects.eoaccess.EOUtilities;

public class AirportPages extends HomePage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private KMIWebDocument _document;
	
    public AirportPages(WOContext context) {
        super(context);
    }

    public void reset() {
    	super.reset();
    	_document = null;
    }
    
	public KMIWebDocument document() {
		if(_document == null) {
			_document = (KMIWebDocument)EOUtilities.objectWithPrimaryKeyValue(ec(), KMIWebDocument.ENTITY_NAME, Integer.valueOf(documentId()));
		}
		return _document;
	}

	protected String documentId() {
		return null;
	}


}