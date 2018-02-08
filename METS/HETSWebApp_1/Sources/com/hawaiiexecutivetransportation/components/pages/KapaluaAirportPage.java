package com.hawaiiexecutivetransportation.components.pages;

import com.webobjects.appserver.WOContext;

public class KapaluaAirportPage extends AirportPages {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public KapaluaAirportPage(WOContext context) {
        super(context);
    }

	@Override
	protected String documentId() {
		return System.getProperty("km.content.eo.KMIWebDocument.Kapalua.pk");
	}

}