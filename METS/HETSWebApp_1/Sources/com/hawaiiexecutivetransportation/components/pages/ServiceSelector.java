package com.hawaiiexecutivetransportation.components.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.NoSuchElementException;

import kmi.foundation.extensions.KMIStringUtilities;

import org.apache.log4j.Logger;

import com.hawaiiexecutivetransportation.app.Session;
import com.mauishuttle.eo.MESAbstractService;
import com.mauishuttle.eo.MESAbstractZone;
import com.mauishuttle.eo.MESDispatch;
import com.mauishuttle.eo.MESExclusiveService;
import com.mauishuttle.eo.MESExclusiveServiceRate;
import com.mauishuttle.eo.MESSharedService;
import com.mauishuttle.eo.MESSharedServiceRate;
import com.mauishuttle.eo.MESSystemMessage;
import com.mauishuttle.eo.MESVehicleType;
import com.mauishuttle.eo.MESZone;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSValidation;

import er.extensions.foundation.ERXStringUtilities;

@SuppressWarnings("serial")
public class ServiceSelector extends ReservationPages {

	private Boolean _alternateRow;
	private MESDispatch _dispatch;
	private String _direction;
	public MESAbstractService _service;
	public NSArray<MESAbstractService> _services;
	private BigDecimal _miscellaneousFee;
	private BigDecimal _serviceBaseRate;
	
	private final static Logger log = Logger.getLogger(ServiceSelector.class);
	
	public ServiceSelector(WOContext context) {
        super(context);
    }
	
	public void sleep() {
		super.sleep();
		_alternateRow = null;
		_dispatch = null;
		_direction = null;
		_service = null;
		_serviceBaseRate = null;
		_services = null;
	}
	
	public boolean synchronizesVariablesWithBindings() {
		return false;
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

	public String routeInformationHeader() {
	
		String pickUpDropOffHeader = null;
		
		if(direction().equals(Session.TO_RESERVATION_DIRECTION)) {
			pickUpDropOffHeader = "Ride <i>to</i> the " + dispatch().dropOffLocation().zone().name();
		} else {
			pickUpDropOffHeader = "Ride <i>from</i> the " + dispatch().pickUpLocation().zone().name();
		}
		
		return pickUpDropOffHeader;

	}

	public String direction() {

		if(ERXStringUtilities.stringIsNullOrEmpty(_direction)) {
			_direction = stringValueForBinding("direction");
		}
		
		return _direction;
	
	}

	public void setDirection(String direction) {
//		this._direction = direction;
	}
	
	public BigDecimal serviceBaseRate() {

		if(_serviceBaseRate == null) {

			MESZone secondaryZone = null;

			if(direction().equals(Session.TO_RESERVATION_DIRECTION)) {
				secondaryZone = (MESZone)dispatch().pickUpLocation().zone();
			} else {
				secondaryZone = (MESZone)dispatch().dropOffLocation().zone();
			}

			try {
				
				if(_service instanceof MESSharedService) {
					_serviceBaseRate = _sharedServiceRate(secondaryZone).transferRate();
				} else if(_service instanceof MESExclusiveService) {
					_serviceBaseRate = _exclusiveServiceRate(secondaryZone).transferRate();
				}
				
			} catch (NoSuchElementException e) {

				String errorTitle = "Unable to find transfer rate for service: " + _service.name() + " for zone: " + secondaryZone.name();
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				log.error(errorTitle);
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				MESSystemMessage.createSystemMessage(errorTitle, MESSystemMessage.Level.ERROR.value(), KMIStringUtilities.stackTraceToString(e));
				_serviceBaseRate = new BigDecimal(0.0d);
			}
			
		}
		
		return _serviceBaseRate;
	}
	
	public MESExclusiveService exclusiveService() {
		return (MESExclusiveService)_service;
	}
	
	public BigDecimal serviceTotal() {
		
		BigDecimal serviceTotal = new BigDecimal(0.0d).setScale(2);
		serviceTotal = serviceTotal.add(serviceBaseRate());
		// sets it to null so that it gets recalculated on next step in loop.
		_serviceBaseRate = null;
		serviceTotal = serviceTotal.add(miscellaneousFee());
		return serviceTotal;

	}

	@SuppressWarnings("unchecked")
	private MESSharedServiceRate _sharedServiceRate(MESZone secondaryZone) throws NoSuchElementException {
		
		MESSharedServiceRate rate = null;
		EOQualifier serviceQualifier = MESSharedServiceRate.SERVICE.eq((MESSharedService)_service);
		EOQualifier secondaryZoneQualifier = MESSharedServiceRate.SECONDARY_ZONE.eq(secondaryZone);
		EOQualifier numberOfPassengersQualifier = MESSharedServiceRate.NUMBER_OF_PASSENGERS.eq(dispatch().numberPassengers());
		
		try {
			rate = MESSharedServiceRate.fetchRequiredMESSharedServiceRate(dispatch().editingContext(), 
					new EOAndQualifier(new NSArray<EOQualifier>(new EOQualifier[] { serviceQualifier, secondaryZoneQualifier, numberOfPassengersQualifier })));
		} catch (NoSuchElementException e) {
			if(secondaryZone.parent() != null) {
				rate = _sharedServiceRate(secondaryZone.parent());
			} else {
				throw new NoSuchElementException("Service Rate was not found.");
			}
		}
		
		return rate;
	
	}

	@SuppressWarnings("unchecked")
	private MESExclusiveServiceRate _exclusiveServiceRate(MESZone secondaryZone) throws NoSuchElementException {

		MESExclusiveServiceRate rate = null;
		EOQualifier serviceQualifier = MESExclusiveServiceRate.SERVICE.eq((MESExclusiveService)_service);
		EOQualifier secondaryZoneQualifier = MESExclusiveServiceRate.SECONDARY_ZONE.eq(secondaryZone);
		EOAndQualifier qualifier = new EOAndQualifier(new NSArray<EOQualifier>(new EOQualifier[] {
				serviceQualifier, secondaryZoneQualifier
		}));

		try {
			rate = MESExclusiveServiceRate.fetchRequiredMESExclusiveServiceRate(dispatch().editingContext(), qualifier);
		} catch (NoSuchElementException e) {
			if(secondaryZone.parent() != null) {
				rate = _exclusiveServiceRate(secondaryZone.parent());
			} else {
				throw new NoSuchElementException("Service Rate was not found.");
			}

		}
		
		return rate;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public NSArray<MESAbstractService> services() {

		if(_services == null) {
			
			MESAbstractZone airportZone = null;
			MESZone secondaryZone = null;

			if(direction().equals(Session.TO_RESERVATION_DIRECTION)) {
				airportZone = dispatch().dropOffLocation().zone();
				secondaryZone = (MESZone)dispatch().pickUpLocation().zone();
			} else {
				airportZone = dispatch().pickUpLocation().zone();
				secondaryZone = (MESZone)dispatch().dropOffLocation().zone();
			}
			
			NSArray<MESSharedService> sharedServices = MESSharedService.fetchMESSharedServices(dispatch().editingContext(), 
					MESSharedService.ZONE.eq(airportZone).and(MESSharedService.PUBLIC_SERVICE.eq(true))
					.and(MESSharedService.RATES.dot(MESSharedServiceRate.SECONDARY_ZONE.eq(secondaryZone)))
					.and(MESSharedService.RATES.dot(MESSharedServiceRate.NUMBER_OF_PASSENGERS.eq(dispatch().numberPassengers()))),
					MESSharedService.NAME.ascs());

			EOQualifier exclusiveServicesQualifier  = MESExclusiveService.ZONE.eq(airportZone).and(MESSharedService.PUBLIC_SERVICE.eq(true))
						.and(MESExclusiveService.RATES.dot(MESExclusiveServiceRate.SECONDARY_ZONE.in(secondaryZone.zoneAndAllParents())
								.and(MESExclusiveServiceRate.SERVICE.dot(MESExclusiveService.VEHICLE_TYPE).dot(MESVehicleType.NUMBER_OF_PASSENGERS.greaterThanOrEqualTo(dispatch().numberPassengers())))));
			
			NSArray<MESExclusiveService> exclusiveServices = MESExclusiveService.fetchMESExclusiveServices(
					dispatch().editingContext(), 
					exclusiveServicesQualifier, 
					MESExclusiveService.RATES.dot(MESExclusiveServiceRate.TRANSFER_RATE).ascs());
			
			NSMutableArray<MESAbstractService> services = new NSMutableArray<MESAbstractService>();
			
			if(direction().equals(Session.FROM_RESERVATION_DIRECTION)) {

				Calendar arrivalDateTime = Calendar.getInstance();
				arrivalDateTime.setTime(dispatch().flightDateTime());
				
				int hourOfDay = arrivalDateTime.get(Calendar.HOUR_OF_DAY);
				
				if(hourOfDay >= 6) {
					services.addObjectsFromArray(sharedServices);
				}
				
			} else {

				Calendar departureDateTime = Calendar.getInstance();
				departureDateTime.setTime(dispatch().flightDateTime());
				
				int hourOfDay = departureDateTime.get(Calendar.HOUR_OF_DAY);
				
				if(hourOfDay < 1 || hourOfDay >= 4) {
					services.addObjectsFromArray(sharedServices);
				}
				
			}

			services.addObjectsFromArray(exclusiveServices);

			_services = services;

		}
		
		return _services;

	}

	public BigDecimal miscellaneousFee() {

		if(_miscellaneousFee == null) {
			
			try {
				_miscellaneousFee = dispatch().calculateMiscellaneousFees();
			} catch (FileNotFoundException e) {
				// TODO: handle exception
			} catch (IOException e) {
				// TODO: handle exception
			}
			
		}

		return _miscellaneousFee;
	}

	public void setMiscellaneousFee(BigDecimal miscellaneousFee) {
		this._miscellaneousFee = miscellaneousFee;
	}

	public boolean selectedService() {
		return dispatch().service() != null && dispatch().service().equals(_service);
	}

	public void setSelectedService(boolean selectedService) {
		if(selectedService) {
			dispatch().setServiceRelationship(_service);
			dispatch().setStatus(_service.dispatchStatus());
		}
	}

	public boolean hasAvailableServices() {
		return services() != null && services().size() > 0;
	}

	public String exclusiveServiceVehicleThumbnailSrc() {
		
		String exclusiveServiceVehicleThumbnailSrc = null;
		
		try {
		
			exclusiveServiceVehicleThumbnailSrc = exclusiveService().vehicleType().onlineReservationsThumbnail().webPath();

		} catch(IOException e) {
			
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			log.error("Unable to create thumbnail for service with name: " + exclusiveService().name());
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			e.printStackTrace();
			MESSystemMessage.createSystemMessage("Unable to create thumbnail for exclusive service", 
					MESSystemMessage.Level.ERROR.value(), KMIStringUtilities.stackTraceToString(e));
			
			exclusiveServiceVehicleThumbnailSrc = WOApplication.application().resourceManager().urlForResourceNamed("images/reservations/image-coming-soon.jpg", "app", null, context().request());
			
		} catch (NSValidation.ValidationException e) {

			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			log.error("Unable to create thumbnail for service with name: " + exclusiveService().name());
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			e.printStackTrace();
			MESSystemMessage.createSystemMessage("Unable to create thumbnail for exclusive service", 
					MESSystemMessage.Level.ERROR.value(), KMIStringUtilities.stackTraceToString(e));

			exclusiveServiceVehicleThumbnailSrc = WOApplication.application().resourceManager().urlForResourceNamed("images/reservations/image-coming-soon.jpg", "app", null, context().request());

		}
		
		return exclusiveServiceVehicleThumbnailSrc;

	}

	public String tableRowClassName() {
	
		String tableRowClassName = null;
		
		if(alternateRow()) {
			tableRowClassName = "even";
		}
		
		setAlternateRow(! alternateRow());
		
		return tableRowClassName;

	}

	public Boolean alternateRow() {
		if(_alternateRow == null) {
			_alternateRow = false;
		}
		return _alternateRow;
	}

	public void setAlternateRow(Boolean alternateRow) {
		this._alternateRow = alternateRow;
	}
	
	

}