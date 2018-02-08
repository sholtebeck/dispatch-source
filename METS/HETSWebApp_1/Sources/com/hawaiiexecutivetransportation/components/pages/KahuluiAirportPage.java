package com.hawaiiexecutivetransportation.components.pages;

import com.webobjects.appserver.WOContext;

public class KahuluiAirportPage extends AirportPages {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KahuluiAirportPage(WOContext context) {
        super(context);
    }

	@Override
	protected String documentId() {
		return System.getProperty("km.content.eo.KMIWebDocument.Kahului.pk");
	}

}