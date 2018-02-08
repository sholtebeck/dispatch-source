package com.hawaiiexecutivetransportation.components.pages;

import km.content.eo.KMIWebDocument;

import com.webobjects.appserver.WOContext;
import com.webobjects.eoaccess.EOUtilities;

public class LimousineRentalPages extends AboutPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LimousineRentalPages(WOContext context) {
        super(context);
    }

	public void reset() {
		super.reset();
		_document = null;
	}	
	
	private KMIWebDocument _document;
	public KMIWebDocument document() {

		if(_document == null) {
			String value = System.getProperty("km.content.eo.KMIWebDocument.MauiLimousines.pk");			
			_document = (KMIWebDocument)EOUtilities.objectWithPrimaryKeyValue(ec(), KMIWebDocument.ENTITY_NAME, Integer.valueOf(value));
		}
		
		return _document;

	}

	
	

}