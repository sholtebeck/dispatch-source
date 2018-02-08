package com.hawaiiexecutivetransportation.components.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import kmi.foundation.extensions.KMITimeUtilities;

import com.hawaiiexecutivetransportation.app.Session;
import com.hawaiiexecutivetransportation.interfaces.AirportRouteControllerInterface;
import com.mauishuttle.eo.MESDispatch;
import com.mauishuttle.eo.MESDispatch.Greet;
import com.mauishuttle.eo.MESLocation;
import com.mauishuttle.eo.MESZone;
import com.mauishuttle.eo.properties.MESDispatchGlobalProperties;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

import er.ajax.mootools.MTAjaxUtils;
import er.extensions.foundation.ERXArrayUtilities;
import er.extensions.foundation.ERXStringUtilities;

@SuppressWarnings("serial")
public class AirportRoute extends ReservationPages {

	private MESDispatch _dispatch;
	private String _direction;
	private NSMutableArray<String> _years;
	public MESLocation _location;
	public MESZone _zone;
	private AirportRouteControllerInterface _controller;
	private MESDispatchGlobalProperties _globalProperties;
	private String _leiRequest;

	public AirportRoute(WOContext context) {
        super(context);
    }
    
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		MTAjaxUtils.addScriptResourceInHead(context, response, "MooTools", MTAjaxUtils.MOOTOOLS_CORE_JS);
	}
	
    public boolean synchronizesVariablesWithBindings() {
    	return false;
    }
    
    public boolean isStateless() {
    	return true;
    }
    
    public void reset() {
    	super.reset();
    	_controller = null;
    	_direction = null;
    	_dispatch = null;
    	_globalProperties = null;
    	_leiRequest = null;
    	_years = null;
    }

	public String airportName() {
		return controller().selectedAirportZone().name();
	}
	
	@SuppressWarnings("unchecked")
	public NSArray<MESLocation> airlines() {
		return MESLocation.fetchMESLocations(dispatch().editingContext(), 
				MESLocation.ZONE.eq(controller().selectedAirportZone()), 
				MESLocation.NAME.ascs());
	}
    
	public String panelClassName() {
		return stringValueForBinding("panelClassName", "span-15-5 last");
	}
	
	public String panelCss() {
		return panelClassName() + " reservations-panel prepend-top";
	}
	
    public AirportRouteControllerInterface controller() {
    	if(_controller == null) {
    		_controller = (AirportRouteControllerInterface)valueForBinding("controller");
    	}
    	return _controller;
    }
    
	public MESDispatch dispatch() {
		if(_dispatch == null) {
			_dispatch = (MESDispatch)valueForBinding("dispatch");
		}
		return _dispatch;
	}

	public void setDispatch(MESDispatch dispatch) {
//		this._dispatch = dispatch;
	}

	public String flightDateHeader() {
		return isToDirection() ? "Departure Time From Airport" : "Arrival Time At Airport";
	}
	
	public String flightDateLabel() {
		return isToDirection() ? "Departure Date" : "Arrival Date";
	}	

	public String flightTimeLabel() {
		return isToDirection() ? "Time of Departure" : "Time of Arrival";
	}
	
	public MESDispatchGlobalProperties globalProperties() {
	
		if(_globalProperties == null) {
		
			try {
				_globalProperties = new MESDispatchGlobalProperties();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return _globalProperties;
	
	}

	
	public String direction() {
		if(_direction == null) {
			_direction = (String)valueForBinding("direction");
		}
		return _direction;
	}
	
	@SuppressWarnings("unchecked")
	public NSArray<MESLocation> hubLocations() {
		
		NSArray<MESLocation> hubLocations =  MESLocation.fetchMESLocations(dispatch().editingContext(), 
				MESLocation.ZONE.dot(MESZone.HUB).eq(controller().selectedAirportZone().hub()).and(MESLocation.ZONE.dot(MESZone.TYPE.eq(1))),
				MESLocation.NAME.ascs());
		
		if(direction().equals(Session.TO_RESERVATION_DIRECTION)) {

			if(controller().selectedPickUpZone() != null) {
				hubLocations = ERXArrayUtilities.filteredArrayWithQualifierEvaluation(hubLocations, 
						MESLocation.ZONE.eq(controller().selectedPickUpZone())
						.or(MESLocation.ZONE.dot(MESZone.PARENT).eq(controller().selectedPickUpZone())));
			}
			
		} else if(direction().equals(Session.FROM_RESERVATION_DIRECTION)) {

			if(controller().selectedDropOffZone() != null) {
				hubLocations = ERXArrayUtilities.filteredArrayWithQualifierEvaluation(hubLocations, 
						MESLocation.ZONE.eq(controller().selectedDropOffZone())
						.or(MESLocation.ZONE.dot(MESZone.PARENT).eq(controller().selectedDropOffZone())));
			}

		}
	
		return hubLocations;

	}
	
	@SuppressWarnings("unchecked")
	public NSArray<MESZone> hubZones() {

		return MESZone.fetchMESZones(dispatch().editingContext(), 
				MESZone.HUB.eq(controller().selectedAirportZone().hub()), 
				MESZone.NAME.ascs());

	}

	public boolean isToDirection() {
		return direction().equals("To");
	}
	
	public void setDirection(String direction) {
//		this._direction = direction;
	}
	
	public NSArray<String> months() {
		return KMITimeUtilities.months();
	}
	
	public NSArray<String> dates() {
		NSMutableArray<String> dates = new NSMutableArray<String>();
		for(int i = 1; i <= _calendar().getActualMaximum(GregorianCalendar.DAY_OF_MONTH); i++) {
			dates.addObject(String.valueOf(i));
		}
		return dates;
	}
	
	public NSArray<String> hours() {
		return KMITimeUtilities.hours();
	}

	private GregorianCalendar _calendar() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dispatch().flightDateTime());
		return calendar;
	}
	
	public NSArray<String> minutes() {
		return KMITimeUtilities.minutesOfHourKeys();
	}
	
	private void _setFlightDateTime(GregorianCalendar calendar) {
		dispatch().setFlightDateTime(new NSTimestamp(calendar.getTime()));
	}

	public String hubLocationsSelectorUpdateContainerId() {
		return "HETSLocationSelectorUpdateContainer" + direction();
	}
	
	public String hubZoneSelectorId() {
		return "HETSZoneSelector" + direction();
	}
	
	public String reservationMonthSelectorId() {
		return "HETSReservationMonthSelector" + direction();
	}
	
	public String reservationDateUpdateContainerId() {
		return "HETSReservationUpdateContainer" + direction();
	}
	
	public String reservationYearSelectorId() {
		return "HETSReservationYearSelector" + direction();
	}

	public String selectedDate() {
		return String.valueOf(_calendar().get(GregorianCalendar.DATE));
	}
	
	public void setSelectedDate(String value) {
		GregorianCalendar calendar = _calendar();
		calendar.set(GregorianCalendar.DATE, Integer.valueOf(value));
		_setFlightDateTime(calendar);
	}
	
	public String selectedHour() {
		return hours().objectAtIndex(_calendar().get(GregorianCalendar.HOUR));
	}
	
	public void setSelectedHour(String value) {
		GregorianCalendar calendar = _calendar();
		calendar.set(GregorianCalendar.HOUR, hours().indexOf(value));
		_setFlightDateTime(calendar);
	}
	
	public String selectedMeridiem() {
		return meridiems().objectAtIndex(_calendar().get(GregorianCalendar.AM_PM));
	}
	
	public void setSelectedMeridiem(String value) {
		GregorianCalendar calendar = _calendar();
		calendar.set(GregorianCalendar.AM_PM, meridiems().indexOf(value));
		_setFlightDateTime(calendar);
	}
	
	public String selectedMinute() {
		return String.valueOf(_calendar().get(GregorianCalendar.MINUTE));
	}
	
	public void setSelectedMinute(String value) {
		GregorianCalendar calendar = _calendar();
		calendar.set(GregorianCalendar.MINUTE, Integer.valueOf(value));
		_setFlightDateTime(calendar);
	}
	
	public String selectedMonth() {
		GregorianCalendar calendar = _calendar();
		return months().objectAtIndex(calendar.get(GregorianCalendar.MONTH));
	}
	
	public void setSelectedMonth(String value) {
		GregorianCalendar calendar = _calendar();
		calendar.set(GregorianCalendar.MONTH, months().indexOf(value));
		_setFlightDateTime(calendar);
	}
	
	public String selectedYear() {
		return String.valueOf(_calendar().get(GregorianCalendar.YEAR));
	}
	
	public void setSelectedYear(String value) {
		GregorianCalendar calendar = _calendar();
		calendar.set(GregorianCalendar.YEAR, Integer.valueOf(value));
		_setFlightDateTime(calendar);
	}
	
	public NSArray<String> years() {

		if(_years == null) {
		
			_years = new NSMutableArray<String>();

			Calendar calendar = Calendar.getInstance();
			for(int i = 0; i < 4; i++) {
				_years.addObject(String.valueOf(calendar.get(Calendar.YEAR)));
				calendar.add(GregorianCalendar.YEAR, 1);
			}
			
		}
	
		return _years;

	}

	public final NSArray<Integer> passengerCount() {
		return new NSArray<Integer>(new Integer[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		});
	}
	
	public final NSArray<Integer> zeroThroughTen() {
		return new NSArray<Integer>(new Integer[] {
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		});
	}
	
	public final NSArray<Integer> zeroThroughTwenty() {
		return new NSArray<Integer>(new Integer[] {
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
		});
	}
		
	
	public NSArray<String> meridiems() {
		return KMITimeUtilities.meridiems();
	}

	public String locationTypeHeader() {
		return isToDirection() ? "Pick Up Location" : "Drop Off Location";
	}

	public MESLocation selectedLocation() {
		MESLocation selectedLocation = null;
		if(direction().equals(Session.TO_RESERVATION_DIRECTION)) {
			selectedLocation = dispatch().pickUpLocation();
		} else {
			selectedLocation = dispatch().dropOffLocation();
		}
		return selectedLocation;
	}

	public void setSelectedLocation(MESLocation selectedLocation) {
		if(direction().equals(Session.TO_RESERVATION_DIRECTION)) {
			dispatch().setPickUpLocationRelationship(selectedLocation);
		} else {
			dispatch().setDropOffLocationRelationship(selectedLocation);
		}
	}

	public MESZone selectedZone() {
	
		MESZone selectedZone = null;
		
		if(direction().equals(Session.TO_RESERVATION_DIRECTION)) {
			selectedZone = controller().selectedPickUpZone();
		} else {
			selectedZone = controller().selectedDropOffZone();
		}
		
		return selectedZone;

	}

	public void setSelectedZone(MESZone selectedZone) {

		if(direction().equals(Session.TO_RESERVATION_DIRECTION)) {
			controller().setSelectedPickUpZone(selectedZone);
		} else {
			controller().setSelectedDropOffZone(selectedZone);
		}
	
	}

	public String locationNoSelectionString() {
	
		String noSelectionString = null;
		
		if(direction().equals(Session.TO_RESERVATION_DIRECTION)) {
			noSelectionString = "The Pick Up Location -- Required";
		} else {
			noSelectionString = "The Drop Off Location -- Required.";
		}
		
		return noSelectionString;

	}

	public MESLocation selectedAirline() {
	
		MESLocation selectedAirline = null;
		
		if(direction().equals(Session.TO_RESERVATION_DIRECTION)) {
			selectedAirline = dispatch().dropOffLocation();
		} else {
			selectedAirline = dispatch().pickUpLocation();
		}
		
		return selectedAirline;

	}

	public void setSelectedAirline(MESLocation selectedAirline) {

		if(direction().equals(Session.TO_RESERVATION_DIRECTION)) {
			dispatch().setDropOffLocationRelationship(selectedAirline);
		} else {
			dispatch().setPickUpLocationRelationship(selectedAirline);
		}

	}

	public boolean leiGreet() {
		return dispatch().greet().equals(Greet.LEI_GREET.value());
	}

	public void setLeiGreet(boolean leiGreet) {
		if(leiGreet) {
			dispatch().setGreet(Greet.LEI_GREET.value());
		} else {
			dispatch().setGreet(Greet.NO_GREET.value());
		}
	}

	public Number bicycleMiscellaneousFeeTotal() {
		return Double.valueOf(globalProperties().bicycleRate()) * dispatch().numberOfBicycles();
	}

	public Number boosterSeatFeeTotal() {
		return Double.valueOf(globalProperties().childSeatRate()) * dispatch().booster();
	}

	public Number infantSeatsFeeTotal() {
		return Double.valueOf(globalProperties().childSeatRate()) * dispatch().infant();
	}
	
	public Number childSeatsFeeTotal() {
		return Double.valueOf(globalProperties().childSeatRate()) * dispatch().toddler();
	}

	public Number leiFeesTotal() {
		return Double.valueOf(globalProperties().leiRate()) * dispatch().numberOfLeis();
	}

	public Number surfboardsFeeTotal() {
		return Double.valueOf(globalProperties().surfboardRate()) * dispatch().numberOfSurfboards();
	}

	public Number windsurfsFeeTotal() {
		return Double.valueOf(globalProperties().windsurfRate()) * dispatch().numberOfWindsurfs();
	}

	public Number boxesFeeTotal() {
		return Double.valueOf(globalProperties().boxRate()) * dispatch().numberOfBoxes();
	}
	
	/**
	 * @return the leiRequest
	 */
	public String leiRequest() {
		if(ERXStringUtilities.stringIsNullOrEmpty(_leiRequest)) {
			_leiRequest = dispatch().greet().equals(Greet.LEI_GREET.value()) ? YES_KEY : NO_KEY;
		}
		return _leiRequest;
	}

	/**
	 * @param leiRequest the leiRequest to set
	 */
	public void setLeiRequest(String leiRequest) {

		if(leiRequest.equals(YES_KEY)) {
			dispatch().setGreet(MESDispatch.Greet.LEI_GREET.value());
		} else {
			dispatch().setGreet(MESDispatch.Greet.NO_GREET.value());
			dispatch().setNumberOfLeis(0);
		}
		
		this._leiRequest = leiRequest;

	}

	public boolean greetWithLei() {
		return dispatch().greet().equals(MESDispatch.Greet.LEI_GREET.value());
	}

	public String numberOfBicyclesSelectorId() {
		return "NumberOfBicyclesSelector_" + direction();
	}

	public String bicycleMiscellaneousFeeTotalUpdateContainerId() {
		return "BicycleMiscellaneousFeeTotalUpdateContainer_" + direction();
	}

	public String numberOfBoosterSeatsSelectorId() {
		return "NumberOfBoosterSeatsSelector_" + direction();
	}

	public String numberOfInfantSeatsSelectorId() {
		return "NumberOfInfantSeatsSelector_" + direction();
	}
	
	public String boosterSeatsFeeTotalUpdateContainerId() {
		return "BoosterSeatsFeeTotalUpdateContainer_" + direction();
	}
	
	public String infantSeatsFeeTotalUpdateContainerId() {
		return "InfantSeatsFeeTotalUpdateContainer_" + direction();
	}

	public String numberOfChildSeatsSelectorId() {
		return "NumberOfChildSeatsSelector_" + direction();
	}

	public String childSeatsFeeTotalUpdateContainerId() {
		return "ChildSeatsFeeTotalUpdateContainer_" + direction();
	}

	public String numberOfSufboardsSelectorId() {
		return "NumberOfSurfboardsSelector_" + direction();
	}

	public String surfboardsFeeTotalUpdateContainerId() {
		return "SurfboardsFeeTotalUpdateContainer_" + direction();
	}

	public String numberOfWindsurfsSelectorId() {
		return "NumberOfWindsurfsSelector_" + direction();
	}

	public String windsurfsFeeTotalUpdateContainerId() {
		return "WindsurfsFeeTotalUpdateContainer_" + direction();
	}

	public String leiSelectorId() {
		return "LeiSelector_" + direction();
	}

	public String numberOfLeisUpdateContainerId() {
		return "NumberOfLeisUpdateContainer_" + direction();
	}

	public String numberOfLeisSelectorId() {
		return "NumberOfLeisSelector_" + direction();
	}

	public String leisFeeTotalUpdateContainerId() {
		return "LeisFeeTotalUpdateContainer_" + direction();
	}

	public String boxesFeeTotalUpdateContainerId() {
		return "BoxesFeeTotalUpdateContainer_" + direction();
	}

	public String numberOfBoxesSelectorId() {
		return "NumberOfBoxesSelector_" + direction();
	}

}