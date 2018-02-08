package com.hawaiiexecutivetransportation.components.pages;

import com.hawaiiexecutivetransportation.components.pages.print.PrintBoardingPassPage;
import com.hawaiiexecutivetransportation.components.pages.print.PrintReceiptPage;
import com.mauishuttle.eo.MESDispatch;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;

@SuppressWarnings("serial")
public class ExistingReservationOptionsPage extends ReservationPages {

	private MESDispatch _reservation;
	
	public ExistingReservationOptionsPage(WOContext context) {
        super(context);
    }

	public MESDispatch reservation() {

		if(_reservation == null) {
			_reservation = session().dispatch();
		}
		
		return _reservation;

	}

	public void setReservation(MESDispatch reservation) {
		this._reservation = reservation;
	}

	public WOActionResults payDispatch() {
		ReservationPaymentPage nextPage = pageWithName(ReservationPaymentPage.class);
		nextPage.setDisplayNavigation(false);
		return nextPage;
	}

	public WOActionResults printBoardingPass() {
		PrintBoardingPassPage nextPage = pageWithName(PrintBoardingPassPage.class);
		nextPage.setReservation(reservation());
		return nextPage;
	}

	public WOActionResults printReceipt() {
		PrintReceiptPage nextPage = pageWithName(PrintReceiptPage.class);
		nextPage.setReservation(reservation());
		return nextPage;
	}

}