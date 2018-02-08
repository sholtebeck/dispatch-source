package com.hawaiiexecutivetransportation.components.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import kmi.foundation.extensions.KMILoggingUtilities;

import org.apache.log4j.Logger;

import com.hawaiiexecutivetransportation.components.Main;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.foundation.ERXStringUtilities;

public class PrivateCarServiceRequestForm extends Main {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String FIRST_NAME_KEY;
	private final static String LAST_NAME_KEY;
	private final static String EMAIL_ADDRESS_KEY;
	private final static String PHONE_NUMBER_KEY;
	private final static String RESERVATION_DATE_KEY;
	private final static SimpleDateFormat DATE_FORMATTER;
	private final static Logger log;
	
    public PrivateCarServiceRequestForm(WOContext context) {
        super(context);
    }

    static {
    	FIRST_NAME_KEY = "firstName";
    	LAST_NAME_KEY = "lastName";
    	EMAIL_ADDRESS_KEY = "emailAddress";
    	PHONE_NUMBER_KEY = "phoneNumber";
    	RESERVATION_DATE_KEY = "reservationDate";
    	DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
    	log = Logger.getLogger(PrivateCarServiceRequestForm.class);
    }
    
    @Override
    public boolean isStateless() {
    	return true;
    }
    
    @Override
    public void reset() {
    	super.reset();
    	setFirstName(null);
    	setLastName(null);
    	setEmailAddress(null);
    	setPhoneNumber(null);
    	setReservationDate(null);
    }
    
    public String firstName() {
    	if(_firstName == null) {
    		_firstName = context().request().stringFormValueForKey(FIRST_NAME_KEY);
    	}
		return _firstName;
	}

	public void setFirstName(String firstName) {
		this._firstName = firstName;
	}

	public String lastName() {
		if(_lastName == null) {
			_lastName = context().request().stringFormValueForKey(LAST_NAME_KEY);
		}
		return _lastName;
	}

	public void setLastName(String lastName) {
		this._lastName = lastName;
	}

	public String emailAddress() {
		if(_emailAddress == null) {
			_emailAddress = context().request().stringFormValueForKey(EMAIL_ADDRESS_KEY);
		}
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this._emailAddress = emailAddress;
	}

	public String phoneNumber() {
		if(_phoneNumber == null) {
			_phoneNumber = context().request().stringFormValueForKey(PHONE_NUMBER_KEY);
		}
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this._phoneNumber = phoneNumber;
	}

	public NSTimestamp reservationDate() {
		if(_reservationDate == null) {
			String dateString = context().request().stringFormValueForKey(RESERVATION_DATE_KEY);
			if(ERXStringUtilities.stringIsNullOrEmpty(dateString) == false) {
				try {
					_reservationDate = new NSTimestamp(DATE_FORMATTER.parse(dateString));
				} catch(ParseException e) {
					KMILoggingUtilities.logStatement(log, "Unable to parse string to date: " + dateString);
				}
			}
		}
		return _reservationDate;
	}

	public void setReservationDate(NSTimestamp reservationDate) {
		this._reservationDate = reservationDate;
	}

	private String _firstName;
    private String _lastName;
    private String _emailAddress;
    private String _phoneNumber;
    private NSTimestamp _reservationDate;
    

}