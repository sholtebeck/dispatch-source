package com.hawaiiexecutivetransportation.app;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;

import kmi.foundation.extensions.KMIStringUtilities;

import com.mauishuttle.eo.MESAirportZone;
import com.mauishuttle.eo.MESDispatch;
import com.mauishuttle.eo.MESHub;
import com.mauishuttle.eo.MESSystemMessage;
import com.mauishuttle.eo.MESUser;
import com.webobjects.eoaccess.EOUtilities.MoreThanOneException;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.appserver.ERXSession;

public class Session extends ERXSession {

	public static final String FROM_RESERVATION_DIRECTION = "From";
	public static final String TO_RESERVATION_DIRECTION = "To";
	public static final String POINT_TO_POINT_DIRECTION = "Point to Point";
	public static final String CHARTER_RESERVATION = "Charter";
	
	private MESAirportZone _airport;
	private MESDispatch _fromAirport;
	private MESDispatch _toAirport;
	private MESDispatch _pointToPointReservation;
	private MESDispatch _charterReservation;
	
	private String _direction;
	
	private static final long serialVersionUID = 1L;

	public Session() {
		setStoresIDsInCookies(true);
		setStoresIDsInURLs(false);
	}

	public Application application() {
		return (Application)super.application();
	}
	
	public void initializeReservations(String direction, String routes, EOEditingContext ec) throws IllegalArgumentException, NumberFormatException {
		
		int routeCounts = _routeCount(routes);
		NSTimestamp now = new NSTimestamp();
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(now);
		calendar.add(GregorianCalendar.DATE, 2);

		int unroundedMinutes = calendar.get(GregorianCalendar.MINUTE);
		int mod = unroundedMinutes % 15;
		calendar.add(GregorianCalendar.MINUTE, mod < 8 ? -mod : (15-mod));

		calendar.set(GregorianCalendar.SECOND, 0);
		calendar.set(GregorianCalendar.MILLISECOND, 0);
		
		if(direction.equals(TO_RESERVATION_DIRECTION)) {

			_toAirport = MESDispatch.createMESDispatch(ec);
			_toAirport.setFlightDateTime(new NSTimestamp(calendar.getTime()));
			_toAirport.setUserRelationship(MESUser.localInstanceIn(ec, application().onlineReservations()));
			
			if(routeCounts > 1) {

				_fromAirport = MESDispatch.createMESDispatch(ec);
				_fromAirport.setParentRelationship(_toAirport);
				calendar.add(GregorianCalendar.DATE, 1);
				_fromAirport.setFlightDateTime(new NSTimestamp(calendar.getTime()));
				_fromAirport.setUserRelationship(MESUser.localInstanceIn(ec, application().onlineReservations()));

			} else {
				_fromAirport = null;
			}
			
		} else if(direction.equals(FROM_RESERVATION_DIRECTION)) {

			_fromAirport = MESDispatch.createMESDispatch(ec);
			_fromAirport.setFlightDateTime(new NSTimestamp(calendar.getTime()));
			_fromAirport.setUserRelationship(MESUser.localInstanceIn(ec, application().onlineReservations()));

			if(routeCounts > 1) {

				_toAirport = MESDispatch.createMESDispatch(ec);
				_toAirport.setParentRelationship(_fromAirport);
				calendar.add(GregorianCalendar.DATE, 1);
				_toAirport.setFlightDateTime(new NSTimestamp(calendar.getTime()));
				_toAirport.setUserRelationship(MESUser.localInstanceIn(ec, application().onlineReservations()));

			} else {
				_toAirport = null;
			}
			
		} else {
			throw new IllegalArgumentException("The supplied direction is not valid.");
		}

		if(airport() != null) {

			if(_toAirport != null) {
				_toAirport.setHubRelationship(MESHub.localInstanceIn(ec, airport().hub()));
			}

			if(_fromAirport != null) {
				_fromAirport.setHubRelationship(MESHub.localInstanceIn(ec, airport().hub()));
			}
			
		}
		
		setPointToPointReservation(null);
		setDirection(direction);

	}

	private int _routeCount(String routes) throws NumberFormatException {
		return Integer.valueOf(routes);
	}

	public boolean hasMultipleRoutes() {
		return fromAirport() != null && toAirport() != null;
	}
	
	public boolean isAirportRun() {
		return fromAirport() != null || toAirport() != null;
	}
	
	public boolean isPointToPointRun() {
		return pointToPointReservation() != null;
	}
	
	public boolean isCharterRun() {
		return charterReservation() != null;
	}
		
	public MESDispatch fromAirport() {
		return _fromAirport;
	}

	public void setFromAirport(MESDispatch fromAirport) {
		this._fromAirport = fromAirport;
	}

	public MESDispatch toAirport() {
		return _toAirport;
	}

	public void setToAirport(MESDispatch toAirport) {
		this._toAirport = toAirport;
	}

	public String direction() {
		return _direction;
	}

	public void setDirection(String direction) {
		this._direction = direction;
	}

	public MESDispatch dispatch() {

		MESDispatch dispatch = null;
		
		if(direction().equals(TO_RESERVATION_DIRECTION)) {
			dispatch = toAirport();
		} else if(direction().equals(FROM_RESERVATION_DIRECTION)) {
			dispatch = fromAirport();
		} else if(direction().equals(POINT_TO_POINT_DIRECTION)) {
			dispatch = pointToPointReservation();
		} else if(direction().equals(CHARTER_RESERVATION)) {
			dispatch = charterReservation();
		}

		return dispatch;
		
	}
	
	public BigDecimal tipAmount() {
		BigDecimal tipAmount = new BigDecimal(0.0d);
		if(hasMultipleRoutes()) {
			tipAmount = tipAmount.add(fromAirport().tipAmount());
			tipAmount = tipAmount.add(toAirport().tipAmount());
		} else {
			if(dispatch().isNewObject()) {
				tipAmount = dispatch().tipAmount();
			} else {
				tipAmount = dispatch().tipAmount();
				for(MESDispatch dispatch : dispatch().descendents()) {
					tipAmount = tipAmount.add(dispatch.tipAmount());
				}
			}
		}
		return tipAmount;
	}
	
	public MESAirportZone airport() {
		return _airport;
	}

	public void setAirport(MESAirportZone airport) {

		if(airport != null) {

			if(toAirport() != null) {
				toAirport().setHubRelationship(MESHub.localInstanceIn(toAirport().editingContext(), airport.hub()));
			}
			
			if(fromAirport() != null) {
				fromAirport().setHubRelationship(MESHub.localInstanceIn(fromAirport().editingContext(), airport.hub()));
			}

		}
		
		this._airport = airport;

	}

	public void setAirport(String airportCode) {

		MESAirportZone airportZone = null;
		
		try {

			airportZone = MESAirportZone.fetchRequiredMESAirportZone(defaultEditingContext(), MESAirportZone.AIRPORT_CODE.eq(airportCode));

		} catch(NoSuchElementException e) {
		
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			log.error("Unable to find airport with airport code: " + airportCode);
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);

//			MESSystemMessage.createSystemMessage("Unable to find airport with code: " + airportCode, MESSystemMessage.Level.WARN.value(), KMIStringUtilities.stackTraceToString(e));
			
		} catch (MoreThanOneException e) {

			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			log.error("More than one airport with airport code: " + airportCode);
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);

			MESSystemMessage.createSystemMessage("More than one airport with airport code: " + airportCode, MESSystemMessage.Level.WARN.value(), KMIStringUtilities.stackTraceToString(e));

		}

		setAirport(airportZone);
		
	}

	public MESDispatch pointToPointReservation() {
		return _pointToPointReservation;
	}

	public void setPointToPointReservation(MESDispatch existingReservation) {
		this._pointToPointReservation = existingReservation;
	}

	public MESDispatch charterReservation() {
		return _charterReservation;
	}

	public void setCharterReservation(MESDispatch charterReservation) {
		this._charterReservation = charterReservation;
	}
	
}
