package com.hawaiiexecutivetransportation.components.pages;

import java.util.GregorianCalendar;
import java.util.NoSuchElementException;

import kmi.foundation.extensions.KMIStringUtilities;

import org.apache.log4j.Logger;

import com.mauishuttle.eo.MESDispatch;
import com.mauishuttle.eo.MESSharedService;
import com.mauishuttle.eo.MESSharedServiceRate;
import com.mauishuttle.eo.MESSharedServiceRate.PickUpTimes;
import com.mauishuttle.eo.MESSystemMessage;
import com.mauishuttle.eo.MESZone;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

@SuppressWarnings("serial")
public class PickUpTimeSelector extends ReservationPages {
    
	private Boolean _alternateRow;
	private MESDispatch _dispatch;
	public NSTimestamp _pickUpTime;
	
	private Logger log = Logger.getLogger(PickUpTimeSelector.class);
	
	public PickUpTimeSelector(WOContext context) {
        super(context);
    }
    
	public void sleep() {
		super.sleep();
		_alternateRow = null;
		_dispatch = null;
	}
	
	public MESDispatch dispatch() {

		if(_dispatch == null) {
			_dispatch = (MESDispatch)valueForBinding("dispatch");
		}
		
		return _dispatch;

	}
	
    public boolean synchronizesVariablesWithBindings() {
    	return false;
    }    
    
    public NSArray<NSTimestamp> pickUpTimeOptions() {

    	NSMutableArray<NSTimestamp> pickUpTimeOptions = new NSMutableArray<NSTimestamp>();
    	GregorianCalendar pickUpTime = new GregorianCalendar();
    	pickUpTime.setTime(dispatch().flightDateTime());
    	pickUpTime.add(GregorianCalendar.HOUR, -3);
    	
    	if(dispatch().service() instanceof MESSharedService) {

    		MESSharedServiceRate rate = null;
    		
    		try {

    			rate = _rateForServiceWithLocation(dispatch().editingContext(), (MESSharedService)dispatch().service(), dispatch().numberPassengers(), (MESZone)dispatch().pickUpLocation().zone());
    			MESSharedServiceRate.PickUpTimes acceptedPickUpTimes = MESSharedServiceRate.PickUpTimes.make(rate.pickUpTime());
        		
        		if(acceptedPickUpTimes.equals(PickUpTimes.TOP_AND_BOTTOM)) {

        			pickUpTime.set(GregorianCalendar.MINUTE, 0);
            		pickUpTimeOptions.addObject(new NSTimestamp(pickUpTime.getTime()));
            		pickUpTime.set(GregorianCalendar.MINUTE, 30);
            		pickUpTimeOptions.addObject(new NSTimestamp(pickUpTime.getTime()));

        		} else if(acceptedPickUpTimes.equals(PickUpTimes.FIVE_AFTER_AND_THIRTY_FIVE_AFTER)) {
        		
        			pickUpTime.set(GregorianCalendar.MINUTE, 5);
            		pickUpTimeOptions.addObject(new NSTimestamp(pickUpTime.getTime()));
            		pickUpTime.set(GregorianCalendar.MINUTE, 35);
            		pickUpTimeOptions.addObject(new NSTimestamp(pickUpTime.getTime()));

        		} else if(acceptedPickUpTimes.equals(PickUpTimes.TEN_AFER_AND_FORTY)) {

        			pickUpTime.set(GregorianCalendar.MINUTE, 10);
            		pickUpTimeOptions.addObject(new NSTimestamp(pickUpTime.getTime()));
            		pickUpTime.set(GregorianCalendar.MINUTE, 40);
            		pickUpTimeOptions.addObject(new NSTimestamp(pickUpTime.getTime()));
        		
        		} else if(acceptedPickUpTimes.equals(PickUpTimes.TEN_AFTER_AND_BEFORE)) {

        			pickUpTime.set(GregorianCalendar.MINUTE, 10);
            		pickUpTimeOptions.addObject(new NSTimestamp(pickUpTime.getTime()));
            		pickUpTime.set(GregorianCalendar.MINUTE, 50);
            		pickUpTimeOptions.addObject(new NSTimestamp(pickUpTime.getTime()));
        			
        		} else if(acceptedPickUpTimes.equals(PickUpTimes.QUARTER_AFTER_AND_BEFORE)) {

        			pickUpTime.set(GregorianCalendar.MINUTE, 15);
            		pickUpTimeOptions.addObject(new NSTimestamp(pickUpTime.getTime()));
            		pickUpTime.set(GregorianCalendar.MINUTE, 45);
            		pickUpTimeOptions.addObject(new NSTimestamp(pickUpTime.getTime()));
        			
        		}
        		
    		} catch (NoSuchElementException e) {
    		
    			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
    			log.error("Unable to find service rate for selected service.  This should be an impossible outcome.");
    			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
    			MESSystemMessage.createSystemMessage("Unable to find service rate for selected service.", MESSystemMessage.Level.ERROR.value(), KMIStringUtilities.stackTraceToString(e));

    		}

    	} else {

    		pickUpTimeOptions.addObject(new NSTimestamp(pickUpTime.getTime()));
    		pickUpTime.add(GregorianCalendar.MINUTE, 20);
    		pickUpTimeOptions.addObject(new NSTimestamp(pickUpTime.getTime()));

    	}
    	
    	return pickUpTimeOptions;
    	
    }
    
    @SuppressWarnings("unchecked")
	private MESSharedServiceRate _rateForServiceWithLocation(EOEditingContext ec, MESSharedService service, int numberOfPassengers, MESZone zone) throws NoSuchElementException {

    	MESSharedServiceRate rate = null;

    	try {

			rate = MESSharedServiceRate.fetchRequiredMESSharedServiceRate(ec, 
    				MESSharedServiceRate.SERVICE.eq(service)
    				.and(MESSharedServiceRate.NUMBER_OF_PASSENGERS.eq(numberOfPassengers)
    						.and(MESSharedServiceRate.SECONDARY_ZONE.eq(zone))));

    	} catch (NoSuchElementException e) {

    		if(zone.hasParent()) {
    			rate = _rateForServiceWithLocation(ec, service, numberOfPassengers, zone.parent());
    		} else {
    			throw new NoSuchElementException(e.getMessage());
    		}

    	}

    	return rate;

    }

	public boolean pickUpTimeChecked() {
		return _pickUpTime.equals(selectedPickUpTime());
	}

	public void setPickUpTimeChecked(boolean pickUpTimeChecked) {
		if(pickUpTimeChecked) {
			setSelectedPickUpTime(_pickUpTime);
		}
	}
	
	public NSTimestamp selectedPickUpTime() {
		return (NSTimestamp) valueForBinding("selectedPickUpTime");
	}
	
	public void setSelectedPickUpTime(NSTimestamp value) {
		setValueForBinding(value, "selectedPickUpTime");
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