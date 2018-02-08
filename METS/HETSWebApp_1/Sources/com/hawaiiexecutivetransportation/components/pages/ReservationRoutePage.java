package com.hawaiiexecutivetransportation.components.pages;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.hawaiiexecutivetransportation.app.Session;
import com.hawaiiexecutivetransportation.interfaces.AirportRouteControllerInterface;
import com.mauishuttle.eo.MESAirportZone;
import com.mauishuttle.eo.MESDispatch.Greet;
import com.mauishuttle.eo.MESZone;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

@SuppressWarnings("serial")
public class ReservationRoutePage extends ReservationPages implements AirportRouteControllerInterface {
    
	private MESAirportZone _selectedAirportZone;
	private NSArray<MESAirportZone> _airportZones;
	private MESZone _selectedPickUpZone;
	private MESZone _selectedDropOffZone;
	
	public ReservationRoutePage(WOContext context) {
        super(context);
    }

	public NSArray<MESAirportZone> airportZones() {
		if(_airportZones == null) {
			_airportZones = MESAirportZone.fetchAllMESAirportZones(session().defaultEditingContext(), MESAirportZone.NAME.ascs());
		}
		return _airportZones;
	}
	
	public MESAirportZone selectedAirportZone() {
		if(_selectedAirportZone == null) {
			_selectedAirportZone = session().airport();
		}
		return _selectedAirportZone;
	}

	public void setSelectedAirportZone(MESAirportZone selectedAirportZone) {
		session().setAirport(selectedAirportZone);
		this._selectedAirportZone = selectedAirportZone;
	}
	
	public AirportRouteControllerInterface controller() {
		return this;
	}

	public MESZone selectedPickUpZone() {
		return _selectedPickUpZone;
	}

	public void setSelectedPickUpZone(MESZone zone) {
		_selectedPickUpZone = zone;
	}

	public MESZone selectedDropOffZone() {
		return _selectedDropOffZone;
	}

	public void setSelectedDropOffZone(MESZone zone) {
		_selectedDropOffZone = zone;
	}

	public WOActionResults saveChanges() {

		WOComponent nextPage = null;

		GregorianCalendar blockedDate = new GregorianCalendar();
		blockedDate.set(GregorianCalendar.MONTH, GregorianCalendar.OCTOBER);
		blockedDate.set(GregorianCalendar.DATE, 12);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(GregorianCalendar.DATE, 2);

		NSTimestamp ts = new NSTimestamp(calendar.getTime());
		
		if(session().hasMultipleRoutes()) {

			if(session().direction().equals(Session.TO_RESERVATION_DIRECTION)) {
				if(session().toAirport().flightDateTime().after(session().fromAirport().flightDateTime())) {
					addErrorMessage("The specified departure date/time is greater than the arrival date/time.");
				} else if(session().toAirport().flightDateTime().before(ts)) {
					addErrorMessage("To book departures within the next 48 hours please call: 1-800-833-2303");
				}
			} else {
				if(session().toAirport().flightDateTime().before(session().fromAirport().flightDateTime())) {
					addErrorMessage("The specified arrival date/time is greater than the departure date/time.");
				} else if(session().fromAirport().flightDateTime().before(ts)) {
					addErrorMessage("To book arrivals within the next 48 hours please call: 1-800-833-2303");
				}
			}
			
			if(session().airport().airportCode().equalsIgnoreCase("KOA")) {
				GregorianCalendar departureDate = new GregorianCalendar();
				departureDate.setTime(session().toAirport().reservationDate());
				GregorianCalendar arrivalDate = new GregorianCalendar();
				arrivalDate.setTime(session().fromAirport().reservationDate());
				if(arrivalDate.get(GregorianCalendar.DAY_OF_YEAR) == blockedDate.get(GregorianCalendar.DAY_OF_YEAR) ||
						departureDate.get(GregorianCalendar.DAY_OF_YEAR) == blockedDate.get(GregorianCalendar.DAY_OF_YEAR)) {
					addErrorMessage("Do to high demand during the Big Island Ironman Tournament on October 12th we kindly ask that you call 1-800-833-2303 to check availability.");
				}
			}
			
		} else {
			if(session().direction().equals(Session.TO_RESERVATION_DIRECTION)) {
				
				if(session().toAirport().flightDateTime().before(ts)) {
					addErrorMessage("To book departures within the next 48 hours please call: 1-800-833-2303");

				}	

				GregorianCalendar departureDate = new GregorianCalendar();
				departureDate.setTime(session().toAirport().reservationDate());
				if(departureDate.get(GregorianCalendar.DAY_OF_YEAR) == blockedDate.get(GregorianCalendar.DAY_OF_YEAR)) {
					addErrorMessage("Do to high demand during the Big Island Ironman Tournament on October 12th we kindly ask that you call 1-800-833-2303 to check availability.");
				}

			} else {

				if(session().fromAirport().flightDateTime().before(ts)) {
					addErrorMessage("To book arrivals within the next 48 hours please call: 1-800-833-2303");
				}

				GregorianCalendar arrivalDate = new GregorianCalendar();
				arrivalDate.setTime(session().fromAirport().reservationDate());
				if(arrivalDate.get(GregorianCalendar.DAY_OF_YEAR) == blockedDate.get(GregorianCalendar.DAY_OF_YEAR)) {
					addErrorMessage("Do to high demand during the Big Island Ironman Tournament on October 12th we kindly ask that you call 1-800-833-2303 to check availability.");
				}

			
			}
		}
		
		if(session().fromAirport() != null) {
		
			session().fromAirport().setReservationDate(session().fromAirport().flightDateTime());

		}
		
		// validation
		if(session().toAirport() != null) {

			if(session().toAirport().pickUpLocation() == null) {
				addErrorMessage("Please specify the pick up location.");
			} 
			if(session().toAirport().dropOffLocation() == null) {
				addErrorMessage("Please specify the airline you are flying.");
			}
			if(session().toAirport().greet().equals(Greet.LEI_GREET.value()) && session().toAirport().numberOfLeis() < 1) {
				addErrorMessage("Please specify the number of leis you require for your departure.");
			}
		
		}
		
		if(session().fromAirport() != null) {
			if(session().fromAirport().dropOffLocation() == null) {
				addErrorMessage("Please specify the drop off location.");
			}
			if(session().fromAirport().pickUpLocation() == null) {
				addErrorMessage("Please specify the airline you are flying.");
			}
			if(session().fromAirport().greet().equals(Greet.LEI_GREET.value()) && session().fromAirport().numberOfLeis() < 1) {
				addErrorMessage("Please specify the number of leis you require for your arrival.");
			}
		}
		
		if(! hasErrors()) {
			nextPage = pageWithName(ReservationServicePage.class);
		}

		return nextPage;
	
	}

}