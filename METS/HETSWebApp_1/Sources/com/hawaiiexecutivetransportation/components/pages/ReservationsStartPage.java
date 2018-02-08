package com.hawaiiexecutivetransportation.components.pages;

import km.content.eo.KMIWebDocument;

import com.hawaiiexecutivetransportation.components.Main;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eoaccess.EOUtilities;

import er.ajax.mootools.MTAjaxUtils;
import er.extensions.foundation.ERXStringUtilities;

@SuppressWarnings("serial")
public class ReservationsStartPage extends Main {
	
	private String _errorMessage;
	
    public ReservationsStartPage(WOContext context) {
        super(context);
    }
    
    public void appendToResponse(WOResponse response, WOContext context) {
    	super.appendToResponse(response, context);
    	MTAjaxUtils.addScriptResourceInHead(context, response, "MooTools", MTAjaxUtils.MOOTOOLS_CORE_JS);
    }

	public void reset() {
		super.reset();
		_document = null;
	}
    
	public String errorMessage() {
		return _errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this._errorMessage = errorMessage;
	}
	
	public boolean hasError() {
		return ERXStringUtilities.stringIsNullOrEmpty(errorMessage()) == false;
	}

	private KMIWebDocument _document;
	public KMIWebDocument document() {

		if(_document == null) {
			String value = System.getProperty("km.content.eo.KMIWebDocument.Reservations.pk");			
			_document = (KMIWebDocument)EOUtilities.objectWithPrimaryKeyValue(ec(), KMIWebDocument.ENTITY_NAME, Integer.valueOf(value));
		}
		
		return _document;

	}

	public void setDocument(KMIWebDocument document) {
		this._document = document;
	}	
	
}