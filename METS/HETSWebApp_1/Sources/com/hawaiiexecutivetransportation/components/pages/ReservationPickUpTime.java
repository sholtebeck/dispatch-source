package com.hawaiiexecutivetransportation.components.pages;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestamp;

@SuppressWarnings("serial")
public class ReservationPickUpTime extends ReservationPages {
	
	private NSTimestamp selectedPickUpTime;

	public ReservationPickUpTime(WOContext context) {
        super(context);
    }

	public WOActionResults saveChanges() {

		WOComponent nextPage = null;
		
		if(selectedPickUpTime() == null) {
			addErrorMessage("Please select a pick up time.");
		}
		
		if(! hasErrors()) {
			session().toAirport().setReservationDate(selectedPickUpTime());
			nextPage = pageWithName(ReservationPaymentPage.class);
		}

		return nextPage;

	}

	/**
	 * @return the selectedPickUpTime
	 */
	public NSTimestamp selectedPickUpTime() {
		return selectedPickUpTime;
	}

	/**
	 * @param selectedPickUpTime the selectedPickUpTime to set
	 */
	public void setSelectedPickUpTime(NSTimestamp selectedPickUpTime) {
		this.selectedPickUpTime = selectedPickUpTime;
	}


}