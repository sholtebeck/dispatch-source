package com.hawaiiexecutivetransportation.components.pages;

import java.util.NoSuchElementException;

import com.hawaiiexecutivetransportation.app.Session;
import com.mauishuttle.eo.MESAirportZone;
import com.mauishuttle.eo.MESDispatch;
import com.mauishuttle.eo.MESExclusiveService;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXEC;
import er.extensions.foundation.ERXStringUtilities;

@SuppressWarnings("serial")
public class ReservationLookUp extends ReservationPages {

	private static final String RESERVATION_LOOK_UP_ERROR_MESSAGE = "The online reservation system cannot process your request.";
	private static final String SUPPORT_PHONE_NUMBER_MESSAGE = "Please call for booking assistance: 1-800-833-2303 for support.";
	private String _confirmationNumber;

	public ReservationLookUp(WOContext context) {
        super(context);
    }

	/**
	 * @return the confirmationNumber
	 */
	public String confirmationNumber() {
		return _confirmationNumber;
	}

	/**
	 * @param confirmationNumber the confirmationNumber to set
	 */
	public void setConfirmationNumber(String confirmationNumber) {
		this._confirmationNumber = confirmationNumber;
	}

	@SuppressWarnings("unchecked")
	public WOActionResults lookUp() {
	
		WOComponent nextPage = null;
		EOEditingContext ec = ERXEC.newEditingContext();
		
		if(ERXStringUtilities.stringIsNullOrEmpty(confirmationNumber())) {
			addErrorMessage("Please enter a confirmation number to begin.");
		}
		
		if(! hasErrors()) {
			
			try {
			
				MESDispatch dispatch = MESDispatch.fetchRequiredMESDispatch(ec, 
						MESDispatch.CONFIRMATION_NUMBER.eq(confirmationNumber()));

				// even if they give a different confirmation number always find the ancestor.
				// not anymore...
				// yes do it...
				dispatch = dispatch.ancestor();
				
				if(_canServiceDispatchAndDescendentsOnline(dispatch)) {

					if(dispatch.dropOffLocation().zone() instanceof MESAirportZone) {
						session().setAirport((MESAirportZone)dispatch.dropOffLocation().zone());
						session().setToAirport(dispatch);
						session().setDirection(Session.TO_RESERVATION_DIRECTION);
						session().setFromAirport(null);
						session().setCharterReservation(null);
						session().setPointToPointReservation(null);
					} else if(dispatch.pickUpLocation().zone() instanceof MESAirportZone) {
						session().setAirport((MESAirportZone)dispatch.pickUpLocation().zone());
						session().setFromAirport(dispatch);
						session().setDirection(Session.FROM_RESERVATION_DIRECTION);
						session().setToAirport(null);
						session().setCharterReservation(null);
						session().setPointToPointReservation(null);
					} else if(dispatch.numberOfHours() != null && dispatch.numberOfHours() > 0) {
						session().setDirection(Session.CHARTER_RESERVATION);
						session().setCharterReservation(dispatch);
						session().setPointToPointReservation(null);
						session().setToAirport(null);
						session().setFromAirport(null);
					} else {
						session().setDirection(Session.POINT_TO_POINT_DIRECTION);
						session().setPointToPointReservation(dispatch);
						session().setToAirport(null);
						session().setFromAirport(null);
					}

				} else {
					addErrorMessage(RESERVATION_LOOK_UP_ERROR_MESSAGE);
					addErrorMessage(SUPPORT_PHONE_NUMBER_MESSAGE);
				}
								
				if(! hasErrors()) {
					nextPage = pageWithName(ExistingReservationOptionsPage.class);
				}
				
			} catch (NoSuchElementException e) {
				addErrorMessage("Sorry, we were unable to find the reservation with the specified confirmation number.  Please check the value entered.  If you continue to have difficulty please call for booking assistance: 1-800-833-2303");
			}
			
		}

		return nextPage;

	}
	
	private boolean _canServiceDispatchAndDescendentsOnline(MESDispatch dispatch) {

		boolean canServiceDispatchOnline = _canServiceDispatchOnline(dispatch);

		if(canServiceDispatchOnline) {

			for(MESDispatch descendent : dispatch.descendents()) {
				canServiceDispatchOnline = _canServiceDispatchOnline(descendent);
				if(! canServiceDispatchOnline) {
					break;
				}
			}

		}

		return canServiceDispatchOnline;

	}
	
	private boolean _canServiceDispatchOnline(MESDispatch dispatch) {

		boolean canServiceOnline = true;
		
		if(dispatch.service() == null) {
			canServiceOnline = false;
		} else if(dispatch.dropOffLocation() == null || dispatch.pickUpLocation() == null) {
			canServiceOnline = false;
		}
		
		return canServiceOnline;
		
	}
	
}