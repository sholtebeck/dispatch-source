package com.hawaiiexecutivetransportation.components.pages;

import com.hawaiiexecutivetransportation.app.Session;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

@SuppressWarnings("serial")
public class ReservationServicePage extends ReservationPages {
	
	public ReservationServicePage(WOContext context) {
        super(context);
    }

	public WOActionResults saveChanges() {

		WOComponent nextPage = null;

		//validation
		
		if(pageKey().equals(Session.TO_RESERVATION_DIRECTION) && session().toAirport().service() == null) {
			addErrorMessage("Please pick a service before continuing.");
		}
		
		if(pageKey().equals(Session.FROM_RESERVATION_DIRECTION) && session().fromAirport().service() == null) {
			addErrorMessage("Please pick a service before continuing.");
		}

		if(! hasErrors()) {
			
			
			if(session().hasMultipleRoutes() && session().direction().equals(pageKey())) {

				setPageKey(session().direction().equals(Session.TO_RESERVATION_DIRECTION) ? 
						Session.FROM_RESERVATION_DIRECTION : Session.TO_RESERVATION_DIRECTION);

			} else {

				if(session().toAirport() != null) {
					nextPage = pageWithName(ReservationPickUpTime.class);
				} else {
					nextPage = pageWithName(ReservationPaymentPage.class);
				}

			}
			
		}
		
		return nextPage;
		
	}
	
}