package com.hawaiiexecutivetransportation.components.pages;

import com.hawaiiexecutivetransportation.app.Session;
import com.hawaiiexecutivetransportation.components.Main;
import com.mauishuttle.eo.MESAirportZone;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.foundation.ERXStringUtilities;

@SuppressWarnings("serial")
public class ReservationPages extends Main {
	
	public MESAirportZone _airport;
	private String _pageKey;
	
    public ReservationPages(WOContext context) {
        super(context);
    }

    public EOEditingContext ec() {
    	return session().dispatch().editingContext();
    }
    
    public WOActionResults reservationInformationPage() {
    	return pageWithName(ReservationRoutePage.class);
    }
    
    public WOActionResults reservationServiceSelectionPage() {
    	return pageWithName(ReservationServicePage.class);
    }
    
    public String pageKey() {
    	if(ERXStringUtilities.stringIsNullOrEmpty(_pageKey)) {
    		_pageKey = session().direction();
    	}
    	return _pageKey;
    }
    
    public void setPageKey(String value) {
    	_pageKey = value;
    }

    public String fromPageKey() {
    	return Session.FROM_RESERVATION_DIRECTION;
    }
    
    public String toPageKey() {
    	return Session.TO_RESERVATION_DIRECTION;
    }
    
    public String pointToPointPageKey() {
    	return Session.POINT_TO_POINT_DIRECTION;
    }
    
    public String charterReservationPageKey() {
    	return Session.CHARTER_RESERVATION;
    }
    
}