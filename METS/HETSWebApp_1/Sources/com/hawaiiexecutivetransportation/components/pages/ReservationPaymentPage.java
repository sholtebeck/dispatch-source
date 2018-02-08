package com.hawaiiexecutivetransportation.components.pages;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import kmi.foundation.ecommerce.KMIAIMCustomer;
import kmi.foundation.ecommerce.KMIAIMTransaction;
import kmi.foundation.ecommerce.KMICreditCard;
import kmi.foundation.extensions.KMIStringUtilities;

import org.apache.log4j.Logger;

import com.hawaiiexecutivetransportation.app.Session;
import com.mauishuttle.eo.MESAbstractPaymentInfo;
import com.mauishuttle.eo.MESCreditCard;
import com.mauishuttle.eo.MESCreditCardPayment;
import com.mauishuttle.eo.MESDispatch;
import com.mauishuttle.eo.MESSystemMessage;
import com.mauishuttle.eo.MESUser;
import com.mauishuttle.eo.MESUserMessage;
import com.mauishuttle.eo.mail.FailedDispatchInsertionMailer;
import com.mauishuttle.eo.mail.ReservationMailer;
import com.mauishuttle.eo.mail.SendFailedDispatchInformation;
import com.mauishuttle.eo.mail.SendReservationInformation;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORedirect;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eoaccess.EOGeneralAdaptorException;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSComparator;
import com.webobjects.foundation.NSComparator.ComparisonException;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSValidation;

import er.extensions.eof.ERXEC;
import er.extensions.foundation.ERXStringUtilities;

@SuppressWarnings("serial")
public class ReservationPaymentPage extends ReservationPages {

	private KMICreditCard _creditCard;
	private KMIAIMCustomer _billingAddress;
	private BigDecimal _total;
	public MESDispatch _child;
	private static Logger log = Logger.getLogger(ReservationPaymentPage.class);
	private Boolean _isNewObject;
	private Boolean _isPaid;
	public Integer _gratuityPercent;
	private Integer _selectedGratuityAmount;
	private Boolean _displayNavigation;
	
	public ReservationPaymentPage(WOContext context) {
        super(context);
    }

	public final NSArray<Integer> gratuityOptions() {
		
		NSMutableArray<Integer> gratuityOptions = new NSMutableArray<Integer>();
		
		for(int i = 0; i < 26; i++) {
			gratuityOptions.addObject(i);
		}
		
		return gratuityOptions;

	}
	
	public WOActionResults processPayment() {

		WOComponent nextPage = null;
		WOResponse response = null;
		
		KMIAIMCustomer customer = new KMIAIMCustomer();
		MESDispatch dispatch = session().dispatch();

		//Validate
		if(ERXStringUtilities.stringIsNullOrEmpty(firstName())) {
			addErrorMessage("Please supply your first name.");
		}  else {
			customer.setFirstName(firstName());
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(lastName())) {
			addErrorMessage("Please supply your last name.");
		} else {
			customer.setLastName(lastName());
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(cellPhoneNumber())) {
			addErrorMessage("Please supply your phone number.");
		} else {
			customer.setPhone(cellPhoneNumber());
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(emailAddress()) == false && ! KMIStringUtilities.isValidEmail(emailAddress())) {
			addErrorMessage("Please supply a valid e-mail address.");
		} else {
			customer.setEmail(emailAddress());
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(billingAddress().addressOne())) {
			addErrorMessage("Please supply the street name and number of your billing address.");
		} else {
			customer.setAddressOne(billingAddress().addressOne());
		}
		
		if(! ERXStringUtilities.stringIsNullOrEmpty(billingAddress().addressTwo())) {
			customer.setAddressTwo(billingAddress().addressTwo());
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(billingAddress().city())) {
			addErrorMessage("Please supply the city of your billing address.");
		} else {
			customer.setCity(billingAddress().city());
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(billingAddress().region())) {
			addErrorMessage("Please supply the state / province of your billing address.");
		} else {
			customer.setRegion(billingAddress().region());
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(billingAddress().country())) {
			addErrorMessage("Please supply the country of your billing address.");
		} else {
			customer.setCountry(billingAddress().country());
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(billingAddress().zipCode())) {
			addErrorMessage("Please supply the zip / postal code of your billing address.");
		} else {
			customer.setZipCode(billingAddress().zipCode());
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(creditCard().creditCardNumber())) {
			addErrorMessage("Please supply the credit card's number.");
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(creditCard().securityID())) {
			addErrorMessage("Please supply the credit card's security id.");
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(creditCard().expirationMonth())) {
			addErrorMessage("Please supply the credit card's expiration month.");
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(creditCard().expirationYear())) {
			addErrorMessage("Please supply the credit card's expiration year.");
		}
		
		if(! hasErrors()) {

			KMIAIMTransaction transaction = new KMIAIMTransaction();
			BigDecimal total = total();
			total = total.setScale(2, BigDecimal.ROUND_HALF_UP);
			transaction.setAmount(total.doubleValue());
			transaction.setCreditCard(creditCard());
			transaction.setCustomer(customer);
			
			transaction.setTransactionDescription("Hawaii Executive Transportation Receipt");
			
			try {
					
				transaction.processTransaction();
				
				if(transaction.response().wasApproved() || transaction.response().wasHeldForReview()) {

					MESCreditCardPayment creditCardPayment = MESCreditCardPayment.createMESCreditCardPayment(ec(), dispatch);
					
					creditCardPayment.setAmount(total());
					creditCardPayment.setDriverCollect(false);
					creditCardPayment.setPaid(true);
					creditCardPayment.setPaidOnline(true);

					MESCreditCard card = MESCreditCard.createMESCreditCard(ec());
					card.setCardNumber(creditCard().creditCardNumberHidden());
					card.setCardHolder(firstName() + " " + lastName());
					card.setExpirationDate(creditCard().expirationDate());
					creditCardPayment.setCreditCardRelationship(card);
					
					if(session().toAirport() != null && session().toAirport().isNewObject()) {
						session().toAirport().setSubTotal(session().toAirport().serviceTransferRate());
						session().toAirport().setMiscellaneousFee(session().toAirport().calculateMiscellaneousFees());
					}

					if(session().fromAirport() != null && session().fromAirport().isNewObject()) {
						session().fromAirport().setSubTotal(session().fromAirport().serviceTransferRate());
						session().fromAirport().setMiscellaneousFee(session().fromAirport().calculateMiscellaneousFees());
					}
					
					ec().saveChanges();

					String primaryKey = dispatch.primaryKey();

					WORedirect redirect = new WORedirect(context());
					String url = context().directActionURLForActionNamed("thankYou", null);
					redirect.setUrl(url);
					response = redirect.generateResponse();
					createMessages(primaryKey);

					if(dispatch.customerEmailAddress() != null) {
						ReservationMailer mailer = new ReservationMailer(new WOContext(context().request()));
						mailer.setDispatch(primaryKey);
						Runnable r = new SendReservationInformation(mailer, mailer.dispatch());
						new Thread(r).start();
					}
					
				} else if(transaction.response().wasDeclined()) {
					addErrorMessage("The payment method was declined with error: " + transaction.response().responseReason());
				} else {
					addErrorMessage("There was an error processing the payment.  Please fix the problem or call to complete your order.");
					addErrorMessage("Error Message: " + transaction.response().responseReason());
				}
				
			} catch (MalformedURLException e) {

				addErrorMessage("There has been a system error.  Unable to process this transaction: " + e.getMessage());
				String errorTitle = "MalformedURLException with message: " + e.getMessage() + " while processing transaction with payment gateway.";
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				log.error(errorTitle);
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				MESSystemMessage.createSystemMessage(errorTitle, MESSystemMessage.Level.ERROR.value(), KMIStringUtilities.stackTraceToString(e));

			} catch (IOException e) {

				addErrorMessage("There has been a system error.  Unable to process this transaction: " + e.getMessage());
				String errorTitle = "IOException with message: " + e.getMessage() + " while processing transaction with payment gateway.";
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				log.error(errorTitle);
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				MESSystemMessage.createSystemMessage(errorTitle, MESSystemMessage.Level.ERROR.value(), KMIStringUtilities.stackTraceToString(e));

			} catch (NullPointerException e) {

				addErrorMessage("There has been a system error.  Unable to process this transaction: " + e.getMessage());
				String errorTitle = "NullPointerException with message: " + e.getMessage() + " while processing transaction with payment gateway.";
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				log.error(errorTitle);
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				MESSystemMessage.createSystemMessage(errorTitle, MESSystemMessage.Level.ERROR.value(), KMIStringUtilities.stackTraceToString(e));

			} catch (NSValidation.ValidationException e) {
			
				addErrorMessage("The credit card was successfully processed.  But there was an error in creating your record.  Please contact support: 1-800-833-2303");
				String errorTitle = "ValidationException with message: " + e.getMessage() + " while saving changes after successfully processing transaction with payment gateway.";
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				log.error(errorTitle);
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				_runbackup(dispatch);
				MESSystemMessage.createSystemMessage(errorTitle, MESSystemMessage.Level.ERROR.value(), KMIStringUtilities.stackTraceToString(e));
			
			} catch (EOGeneralAdaptorException e) {
				addErrorMessage("The credit card was successfully processed.  But there was an error in creating your record.  Please contact support: 1-800-833-2303");
				String errorTitle = "EOGeneralAdaptorException with message: " + e.getMessage() + " while saving changes after successfully processing transaction with payment gateway.";
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				log.error(errorTitle);
				log.error(dispatch);
				_runbackup(dispatch);
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				MESSystemMessage.createSystemMessage(errorTitle, MESSystemMessage.Level.ERROR.value(), KMIStringUtilities.stackTraceToString(e));
				
			}
			
		}
		
		return response;

	}
	
	public void createMessages(String primaryKey) {
		/* Dashboard Message */

		try {

			EOEditingContext ec = ERXEC.newEditingContext();
			MESDispatch dispatch = (MESDispatch) EOUtilities.objectWithPrimaryKeyValue(ec, MESDispatch.ENTITY_NAME, Integer.valueOf(primaryKey));
			
			if(dispatch != null) {

				MESUserMessage message = MESUserMessage.createMESUserMessage(ec, MESUser.localInstanceIn(ec, application().onlineReservations()));
				message.setSubject("Online Reservation Created: " + dispatch.confirmationNumber());

				for(MESUser user : dispatch.hub().role().users()) {
					message.addToRecipientsRelationship(user);
				}

				String messageBody = "<p>Please check the reservation: " + dispatch.confirmationNumber();

				if(session().airport() != null) {
					messageBody += " for aiport: "; 
					messageBody += session().airport().name();
				}
				
				messageBody += " and make sure that the information was properly captured.</p><p>Thank you,</p><p>Online Reservations</p>";
				message.setMessageBody(messageBody);

				ec.saveChanges();
				
			}
			
		} catch(NSValidation.ValidationException e) {
			
			String errorTitle = "ValidationException with message: " + e.getMessage() + " while inserting purchase notification messages.";
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			log.error(errorTitle);
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			MESSystemMessage.createSystemMessage(errorTitle, MESSystemMessage.Level.ERROR.value(), KMIStringUtilities.stackTraceToString(e));
			
		} catch (EOGeneralAdaptorException e) {
			String errorTitle = "EOGeneralAdaptorException with message: " + e.getMessage() + " while inserting purchase notification messages.";
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			log.error(errorTitle);
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			MESSystemMessage.createSystemMessage(errorTitle, MESSystemMessage.Level.ERROR.value(), KMIStringUtilities.stackTraceToString(e));
		}
		
	}
	
	private void _runbackup(MESDispatch dispatch) {

		if(dispatch != null) {

			try {

				if(dispatch.children() != null && dispatch.children().size() > 0) {
					for(MESDispatch child : session().dispatch().children()) {
						log.error(child.toString());
					}
				}
				
				FailedDispatchInsertionMailer mailer = new FailedDispatchInsertionMailer(new WOContext(context().request()));
				mailer.setDispatch(dispatch);
				Runnable r = new SendFailedDispatchInformation(mailer);
				new Thread(r).start();
				
			} catch(Exception ex) {
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
				log.error(ex.getMessage());
				ex.printStackTrace();
				log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			}

		}
		
	}

	public String emailAddress() {
		return _dispatchValueForKey(MESDispatch.CUSTOMER_EMAIL_ADDRESS_KEY);
	}

	public void setEmailAddress(String value) {
		_dispatchTakeValueForKey(value, MESDispatch.CUSTOMER_EMAIL_ADDRESS_KEY);
	}

	public String cellPhoneNumber() {
		return _dispatchValueForKey(MESDispatch.CUSTOMER_PHONE_NUMBER_KEY);
	}

	public void setCellPhoneNumber(String value) {
		_dispatchTakeValueForKey(value, MESDispatch.CUSTOMER_PHONE_NUMBER_KEY);
	}
	
	public String firstName() {
		return _dispatchValueForKey(MESDispatch.CUSTOMER_FIRST_NAME_KEY);
	}

	public void setFirstName(String value) {
		_dispatchTakeValueForKey(value, MESDispatch.CUSTOMER_FIRST_NAME_KEY);
	}

	public String lastName() {
		return _dispatchValueForKey(MESDispatch.CUSTOMER_LAST_NAME_KEY);
	}

	public void setLastName(String value) {
		_dispatchTakeValueForKey(value, MESDispatch.CUSTOMER_LAST_NAME_KEY);
	}	
	
	private String _dispatchValueForKey(String key) {

		String value = null;

		if(session().direction().equals(Session.TO_RESERVATION_DIRECTION)) {
			value = (String)session().toAirport().valueForKey(key);
		} else if(session().direction().equals(Session.FROM_RESERVATION_DIRECTION)) {
			value = (String)session().fromAirport().valueForKey(key);
		} else if(session().direction().equals(Session.POINT_TO_POINT_DIRECTION)) {
			value = (String)session().pointToPointReservation().valueForKey(key);
		} else if(session().direction().equals(Session.CHARTER_RESERVATION)){
			value = (String)session().charterReservation().valueForKey(key);
		}	
		return value;
		
	}
	
	private void _dispatchTakeValueForKey(String value, String key) {

		if(session().isAirportRun()) {
			if(session().hasMultipleRoutes()) {
				session().toAirport().takeValueForKey(value, key);
				session().fromAirport().takeValueForKey(value, key);
			} else {
				if(session().direction().equals(Session.TO_RESERVATION_DIRECTION)) {
					session().toAirport().takeValueForKey(value, key);
				} else {
					session().fromAirport().takeValueForKey(value, key);
				}
			}
		} else if(session().isPointToPointRun()) {
			session().pointToPointReservation().takeValueForKey(value, key);
		} else {
			session().charterReservation().takeStoredValueForKey(value, key);
		}
		
	}

	public KMICreditCard creditCard() {
		if(_creditCard == null) {
			_creditCard = new KMICreditCard();
		}
		return _creditCard;
	}

	public void setCreditCard(KMICreditCard creditCard) {
		this._creditCard = creditCard;
	}

	public NSArray<String> months() {
		return KMICreditCard.months;
	}

	public String selectedMonth() {
		return creditCard().expirationMonth();
	}

	public void setSelectedMonth(String selectedMonth) {
		creditCard().setExpirationMonth(selectedMonth);
	}
	
	public NSArray<String> years() {
		NSMutableArray<String> years = new NSMutableArray<String>();
		Calendar calendar = Calendar.getInstance();
		for(int i = 0; i < 11; i++) {
			years.addObject(String.valueOf(calendar.get(GregorianCalendar.YEAR)));
			calendar.add(GregorianCalendar.YEAR, 1);
		}
		return years;
	}

	public String selectedYear() {
		return creditCard().expirationYear();
	}

	public void setSelectedYear(String selectedYear) {
		creditCard().setExpirationYear(selectedYear);
	}

	private BigDecimal totalWithoutTip() {
	
		BigDecimal total = new BigDecimal(0.0d).setScale(2);
		
		try {
			
			if(session().hasMultipleRoutes()) {

				total = total.add(session().toAirport().calculateOnlineTotal());
				total = total.add(session().fromAirport().calculateOnlineTotal());
				
			} else {

				MESDispatch dispatch = session().dispatch();
				total = total.add(dispatch.calculateOnlineTotal());

				if(! dispatch.isNewObject()) {
					for(MESDispatch descendent : dispatch.descendents()) {
						total = total.add(descendent.calculateOnlineTotal());
					}
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			log.error("There was an error calculating the payment amount.");
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);

		}
		
		return total.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
	}
	
	public BigDecimal total() {

		_total = totalWithoutTip();
		_total = _total.add(session().tipAmount());		
		return _total.setScale(2, BigDecimal.ROUND_HALF_EVEN);

	}

	public boolean toAirportFirst() {
		return session().toAirport().reservationDate().getTime() < session().fromAirport().reservationDate().getTime();
	}

	public boolean isNewObject() {
	
		if(_isNewObject == null) {
			
			if(session().direction().equals(Session.TO_RESERVATION_DIRECTION)) {
				_isNewObject = session().toAirport().isNewObject();
			} else {
				_isNewObject = session().fromAirport().isNewObject();
			}
			
		}
		
		return _isNewObject;

	}

	public Boolean isPaid() {

		MESDispatch dispatch = session().dispatch();
		
		if(_isPaid == null) {
			
			if(dispatch.isNewObject()) {

				_isPaid = false;

			} else {
				
				if(dispatch.payments() != null && dispatch.payments().size() > 0) {

					for(MESAbstractPaymentInfo paymentInfo : dispatch.payments()) {

						if(paymentInfo.paid()) {
							_isPaid = true;
							break;
						}
						
					}
					
				} else {
					_isPaid = false;
				}

			}
			
		}
		
		return _isPaid;

	}

	public WOActionResults cancelReservation() {
		return null;
	}

	public String gratuityDisplayString() {
		return _gratuityPercent + "%";
	}

	/**
	 * @return the selectedGratuityAmount
	 */
	public Integer selectedGratuityAmount() {
		if(_selectedGratuityAmount == null) {
			_selectedGratuityAmount = 0;
		}
		return _selectedGratuityAmount;
	}

	/**
	 * @param selectedGratuityAmount the selectedGratuityAmount to set
	 */
	public void setSelectedGratuityAmount(Integer selectedGratuityAmount) {

		this._selectedGratuityAmount = selectedGratuityAmount;

		BigDecimal gratuityAmountAsPercentage = new BigDecimal(0.00d);
		gratuityAmountAsPercentage.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		gratuityAmountAsPercentage = gratuityAmountAsPercentage.add(new BigDecimal(Double.valueOf(selectedGratuityAmount()) / 100));
		BigDecimal tipAmount = totalWithoutTip().multiply(gratuityAmountAsPercentage);

		if(session().hasMultipleRoutes()) {
			tipAmount = tipAmount.divide(new BigDecimal(2.00d)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
			session().fromAirport().setTipAmount(tipAmount);
			session().toAirport().setTipAmount(tipAmount);
		} else {
			if(session().dispatch().isNewObject()) {
				session().dispatch().setTipAmount(tipAmount.setScale(2, BigDecimal.ROUND_HALF_EVEN));
			} else {
				int descendentsLength = session().dispatch().descendents().size();
				descendentsLength++;
				tipAmount = tipAmount.divide(new BigDecimal(Double.valueOf(descendentsLength))).setScale(2, BigDecimal.ROUND_HALF_EVEN);	
				session().dispatch().setTipAmount(tipAmount);
				for(MESDispatch dispatch : session().dispatch().descendents()) {
					dispatch.setTipAmount(tipAmount);
				}
			}
		}
		
	}

	public boolean displayGratuityAmount() {
		return selectedGratuityAmount() > 0;
	}

	/**
	 * @return the displayNavigation
	 */
	public Boolean displayNavigation() {
		if(_displayNavigation == null) {
			_displayNavigation = Boolean.TRUE;
		}
		return _displayNavigation;
	}

	/**
	 * @param displayNavigation the displayNavigation to set
	 */
	public void setDisplayNavigation(Boolean displayNavigation) {
		this._displayNavigation = displayNavigation;
	}

	public boolean disableCustomerInputs() {
		return ! displayNavigation();
	}

	public WOActionResults viewTermsAndConditions() {
		return pageWithName(TermsAndConditions.class);
	}

	public KMIAIMCustomer billingAddress() {
		if(_billingAddress == null) {
			_billingAddress = new KMIAIMCustomer();
		}
		return _billingAddress;
	}

	public void setBillingAddress(KMIAIMCustomer billingAddress) {
		this._billingAddress = billingAddress;
	}

	public NSArray<String> countries() {
	
		NSMutableArray<String> countries = new NSMutableArray<String>();
		NSArray<String> countryCodes = new NSArray<String>(Locale.getISOCountries());
		
		for(int i = 0; i < countryCodes.size(); i++) {
			String countryCode = countryCodes.get(i);
			Locale aLocale = new Locale("English", countryCode);
			countries.insertObjectAtIndex(aLocale.getDisplayCountry(), i);
		}
		
		try {
			countries.sortUsingComparator(NSComparator.AscendingStringComparator);
		} catch (ComparisonException e) {
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			log.error("Unable to sort countries by name...");
		}
		
		countries.insertObjectAtIndex("United States", 0);
		countries.insertObjectAtIndex("Canada", 1);
		countries.insertObjectAtIndex("United Kingdom", 2);
		countries.insertObjectAtIndex("Australia", 3);
		countries.insertObjectAtIndex("New Zealand", 4);
		countries.insertObjectAtIndex(new String(), 5);

		return countries.immutableClone();

	}

}