package com.hawaiiexecutivetransportation.app;

import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;

import javax.mail.MessagingException;

import kmi.foundation.extensions.KMILoggingUtilities;
import kmi.foundation.extensions.KMISimpleJavaMail;
import kmi.foundation.extensions.KMIStringUtilities;

import com.hawaiiexecutivetransportation.components.pages.AboutPage;
import com.hawaiiexecutivetransportation.components.pages.BigIslandIronManPage;
import com.hawaiiexecutivetransportation.components.pages.BigIslandVolcanoToursPage;
import com.hawaiiexecutivetransportation.components.pages.CharterBusInformationPage;
import com.hawaiiexecutivetransportation.components.pages.ContactPage;
import com.hawaiiexecutivetransportation.components.pages.HomePage;
import com.hawaiiexecutivetransportation.components.pages.KahuluiAirportPage;
import com.hawaiiexecutivetransportation.components.pages.KapaluaAirportPage;
import com.hawaiiexecutivetransportation.components.pages.KonaAirportPage;
import com.hawaiiexecutivetransportation.components.pages.LihueAirportPage;
import com.hawaiiexecutivetransportation.components.pages.LimousineRentalPages;
import com.hawaiiexecutivetransportation.components.pages.PageNotFoundPage;
import com.hawaiiexecutivetransportation.components.pages.PrivacyPage;
import com.hawaiiexecutivetransportation.components.pages.PrivateCarServiceRequestForm;
import com.hawaiiexecutivetransportation.components.pages.RatesPages;
import com.hawaiiexecutivetransportation.components.pages.ReservationConfirmationPage;
import com.hawaiiexecutivetransportation.components.pages.ReservationLookUp;
import com.hawaiiexecutivetransportation.components.pages.ReservationRoutePage;
import com.hawaiiexecutivetransportation.components.pages.ReservationsStartPage;
import com.hawaiiexecutivetransportation.components.pages.TermsAndConditions;
import com.hawaiiexecutivetransportation.components.pages.ThankYouPage;
import com.mauishuttle.eo.MESAbstractService;
import com.mauishuttle.eo.MESHub;
import com.mauishuttle.eo.MESHubRole;
import com.mauishuttle.eo.MESRole;
import com.mauishuttle.eo.MESSystemMessage;
import com.mauishuttle.eo.MESUser;
import com.mauishuttle.eo.MESUserMessage;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WORedirect;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSForwardException;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSValidation;

import er.extensions.appserver.ERXApplication;
import er.extensions.appserver.ERXDirectAction;
import er.extensions.appserver.ERXWOContext;
import er.extensions.eof.ERXEC;
import er.extensions.foundation.ERXStringUtilities;
import er.extensions.foundation.ERXThreadStorage;
public class DirectAction extends ERXDirectAction {

	private static final String AIRPORT_CODE_REQUEST_KEY = "airport";
	private static final String RESERVATION_ROUTES_DIRECTION_KEY = "routes";
	private static final String RESERVATION_DIRECTION_REQUEST_KEY = "direction";
	public static final String SERVICE_REQUEST_KEY = "service";
	public static final String HUB_REQUEST_KEY = "hub";
	private static final String DEFAULT_HUB_NAME = System.getProperty("com.hawaiiexecutivetransportation.hub.default");

	public DirectAction(WORequest request) {
		super(request);
	}


    public WOActionResults performActionNamed(String actionName) {
    	try {
    		ERXThreadStorage.takeValueForKey(ERXEC.newEditingContext(), "ec");
    		return super.performActionNamed(actionName);
    	} catch (NSForwardException e) {
    		log.error(e.getMessage());
    		return ERXApplication.application().handleException(e, this.context());
    	}
    }    

    private EOEditingContext _ec() {
    	return (EOEditingContext)ERXThreadStorage.valueForKey("ec");
    }
	
	@Override
	public WOActionResults defaultAction() {
		return pageWithName(HomePage.class.getName());
	}
	
	public WOActionResults bigIslandVolcanoToursPageAction() {
		return pageWithName(BigIslandVolcanoToursPage.class);
	}
	
	public WOActionResults kahuluiAirportPageAction() {
		return pageWithName(KahuluiAirportPage.class);
	}
	
	public WOActionResults konaAirportPageAction() {
		return pageWithName(KonaAirportPage.class);
	}

	public WOActionResults kapaluaAirportPageAction() {
		return pageWithName(KapaluaAirportPage.class);
	}
	
	public WOActionResults lihueAirportPageAction() {
		return pageWithName(LihueAirportPage.class);
	}
	
	public WOActionResults konaIronmanPageAction() {
		return pageWithName(BigIslandIronManPage.class.getName());
	}
	
	public WOActionResults charterBusInformationPageAction() {
		return pageWithName(CharterBusInformationPage.class);
	}
	
	public WOActionResults limousineRentalPageAction() {
		return pageWithName(LimousineRentalPages.class);
	}
	
	public WOActionResults aboutAction() {
		return pageWithName(AboutPage.class);
	}
	
	public WOActionResults privateCarInformationRequestFormAction() {
		return pageWithName(PrivateCarServiceRequestForm.class);
	}
	
	public WOActionResults submitPrivateCarInformationRequestAction() {
		
		WOResponse response = null;
		
		NSMutableArray<String> errorMessages = new NSMutableArray<String>();
		
		String firstName = context().request().stringFormValueForKey("firstName");
		String lastName = context().request().stringFormValueForKey("lastName");
		String emailAddress = context().request().stringFormValueForKey("emailAddress");
		String phoneNumber = context().request().stringFormValueForKey("phoneNumber");
		String reservationDate = context().request().stringFormValueForKey("reservationDate");
		String service = context().request().stringFormValueForKey("service");

		if(ERXStringUtilities.stringIsNullOrEmpty(firstName)) {
			errorMessages.addObject("Please provide your first name.");
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(lastName)) {
			errorMessages.addObject("Please provide your last name.");
		}
		
		if(ERXStringUtilities.stringIsNullOrEmpty(emailAddress)) {
			errorMessages.addObject("Please provide your email address.");
		} else if(KMIStringUtilities.isValidEmail(emailAddress) == false) {
			errorMessages.addObject("Please provide a valid email address.");
		}
		
		if(errorMessages.size() == 0) {

			Runnable mailer = new SendPrivateCarInformationRequest(firstName, lastName, emailAddress, phoneNumber, reservationDate, service);
			new Thread(mailer).start();
			
			EOEditingContext ec = ERXEC.newEditingContext();

			try {
				
				MESUserMessage message = MESUserMessage.createMESUserMessage(ec, MESUser.localInstanceIn(ec, application().onlineReservations()));
				message.setCreationDate(new NSTimestamp());
				message.setSubject("Online Information Request");
				message.setMessageBody(privateCarInformationRequestMessage(firstName, lastName, emailAddress, phoneNumber, reservationDate, service, "<br/>"));

				MESHubRole hubRole = null;
				
				if(service.startsWith("Volcano")) {
					hubRole = MESHubRole.fetchMESHubRole(ec, MESHubRole.HUB.dot(MESHub.NAME).startsWith("The"));
				} else {
					hubRole = MESHubRole.fetchMESHubRole(ec, MESHubRole.HUB.dot(MESHub.NAME).startsWith("Maui"));
				}
				
				if(hubRole != null) {

					NSArray<MESUser> users = MESUser.fetchMESUsers(ec, MESUser.ROLES.containsObject(hubRole), null);
					
					for(MESUser user : users) {
						message.addToRecipients(user);
					}

				}
				
				ec.saveChanges();
				
			} catch(NSValidation.ValidationException e) {
				KMILoggingUtilities.logStatement(log, "Unable to record message to users: " + e.getMessage());
				e.printStackTrace();
			}

			String url = ERXWOContext.directActionUrl(context(), "thankYouPage", false, false);
			WORedirect redirect = new WORedirect(context());
			redirect.setUrl(url);
			response = redirect.generateResponse();
			
		} else {
		
			WOComponent nextPage = pageWithName(PrivateCarServiceRequestForm.class);
			((PrivateCarServiceRequestForm) nextPage).setErrors(errorMessages);
			response = nextPage.generateResponse();

		}
		
		return response;
		
	}
	
	public WOActionResults thankYouPageAction() {
		return pageWithName(ThankYouPage.class);
	}
	
	public Application application() {
		return (Application) ERXApplication.application();
	}
	
	public class SendPrivateCarInformationRequest implements Runnable {


		private String _firstName;
		private String _lastName;
		private String _emailAddress;
		private String _phoneNumber;
		private String _reservationDate;
		private String _service;
		
		public SendPrivateCarInformationRequest(String firstName, String lastName, String emailAddress, String phoneNumber, String reservationDate, String service) {
			this._firstName = firstName;
			this._lastName = lastName;
			this._emailAddress = emailAddress;
			this._phoneNumber = phoneNumber;
			this._reservationDate = reservationDate;
			this._service = service;
		}
		
		@Override
		public void run() {
			
			EOEditingContext ec = ERXEC.newEditingContext();
		
			String message = privateCarInformationRequestMessage(_firstName, _lastName, _emailAddress, _phoneNumber, _reservationDate, _service, "\n");

			boolean messageSent = false;
			
			try {

				MESRole adminRole = MESRole.fetchRequiredMESRole(ec, MESRole.LABEL.eq("Super Users"));
				NSArray<MESUser> users = MESUser.fetchMESUsers(ec, MESUser.ROLES.containsObject(adminRole), null);
				
				KMISimpleJavaMail mailer = new KMISimpleJavaMail();
				mailer.setSubject("Information Request");
				mailer.setText(message);

				for(MESUser user : users) {
					mailer.addRecipient(user.emailAddress(), user.fullName());
				}

				mailer.sendMessage();
				messageSent = true;
				
				
			} catch(NoSuchElementException e) {
				KMILoggingUtilities.logStatement(log, "Unable to find Super users role.");
			} catch (MessagingException e) {
				KMILoggingUtilities.logStatement(log, "Unable to send information request message with error: " + e.getMessage());
			} catch (UnsupportedEncodingException e) {
				KMILoggingUtilities.logStatement(log, "Unable to send information request message with error: " + e.getMessage());
			} finally {
				if(!messageSent) {
					MESSystemMessage systemMessage = MESSystemMessage.createMESSystemMessage(ec);
					systemMessage.setSubject("Unable to send information request email.");
					systemMessage.setCreationDate(new NSTimestamp());
					systemMessage.setLevel(MESSystemMessage.Level.ERROR.value());
					systemMessage.setMessageBody(message);
				}
			}
			
		}
		
	}
	
	
	public WOActionResults startReservationAction() {
		
		WOComponent nextPage = null;
		WOResponse response = null;

		String direction = context().request().stringFormValueForKey(RESERVATION_DIRECTION_REQUEST_KEY);
		String routes = context().request().stringFormValueForKey(RESERVATION_ROUTES_DIRECTION_KEY);
		String airportCode = context().request().stringFormValueForKey(AIRPORT_CODE_REQUEST_KEY);
		String errorMessage = null;

		EOEditingContext ec = ERXEC.newEditingContext();

		Session session = (Session)session();

		try {
			session.initializeReservations(direction, routes, ec);
			session.setAirport(airportCode);
			nextPage = pageWithName(ReservationRoutePage.class);
		} catch (NumberFormatException e) {
			errorMessage = "The number of routes you chose is invalid.  Don't spoof URLs";
		} catch (IllegalArgumentException e) {
			errorMessage = "The direction you chose is invalid.  Don't spoof URLs";
		}

		if(errorMessage != null) {
			ReservationsStartPage errorPage = pageWithName(ReservationsStartPage.class);
			errorPage.setErrorMessage(errorMessage);
			nextPage = errorPage;
		}

		response = nextPage.generateResponse();
		
		return response;
		
	}
	
	public WOActionResults contactAction() {
		return pageWithName(ContactPage.class);
	}
	
	public WOActionResults privacyAction() {
		return pageWithName(PrivacyPage.class);
	}
	
	public WOActionResults ratesAction() {

		WOComponent nextPage = null;
		MESHub hub = null;
		MESAbstractService service = null;
		String hubName = context().request().stringFormValueForKey(HUB_REQUEST_KEY);
		if(ERXStringUtilities.stringIsNullOrEmpty(hubName) == false) {
			hubName = hubName.replace("-", " ");
		}
		String serviceName = context().request().stringFormValueForKey(SERVICE_REQUEST_KEY);

		if(ERXStringUtilities.stringIsNullOrEmpty(hubName)) {
			hubName = DEFAULT_HUB_NAME;
		}
		
		try {

			hub = MESHub.fetchRequiredMESHub(_ec(), MESHub.NAME.eq(hubName));
			
			if(ERXStringUtilities.stringIsNullOrEmpty(serviceName) == false) {

				service = MESAbstractService.fetchRequiredMESAbstractService(_ec(), 
						MESAbstractService.HUB.eq(hub).and(MESAbstractService.NAME.eq(serviceName.replace("-", " ")).or(MESAbstractService.SLUG.eq(serviceName))));
			
			} else {
				service = hub.services(null, MESAbstractService.NAME.ascs(), true).get(0);
			}
			
		} catch (NoSuchElementException e) {
			nextPage = pageWithName(PageNotFoundPage.class);
		} catch (IndexOutOfBoundsException e) {
			nextPage = pageWithName(PageNotFoundPage.class);
		}
		
		if(nextPage == null) {
			nextPage = pageWithName(RatesPages.class);
			((RatesPages)nextPage).setCurrentHub(hub);
			((RatesPages)nextPage).setCurrentService(service);
		}
		
		return nextPage;

	}
	
	public WOActionResults termsAndConditionsAction() {
		return pageWithName(TermsAndConditions.class);
	}

	public WOActionResults reservationsAction() {
		return pageWithName(ReservationsStartPage.class);
	}
	
	public WOActionResults reservationLookupAction() {
		return pageWithName(ReservationLookUp.class);
	}
	
	public WOActionResults thankYouAction() {
		return pageWithName(ReservationConfirmationPage.class);
	}

	protected String privateCarInformationRequestMessage(String firstName, String lastName, String emailAddress, String phoneNumber, String reservationDate, String service, String lineBreak) {

		StringBuilder sb = new StringBuilder();
		
		sb.append("Dear staff:");
		sb.append(lineBreak);
		sb.append(lineBreak);
		sb.append("A request for information was filled out on the http://www.hawaiiexecutivetransportation.com website.\n\n");
		sb.append("Please find their information below:\n\n");
		sb.append(lineBreak);
		sb.append(lineBreak);
		sb.append("First name: ");
		sb.append(firstName);
		sb.append(lineBreak);
		sb.append("Last Name: ");
		sb.append(lastName);
		sb.append(lineBreak);
		sb.append("E-Mail Address: ");
		sb.append(emailAddress);
		sb.append(lineBreak);
		sb.append("Phone Number: ");
		sb.append(phoneNumber);
		sb.append(lineBreak);
		sb.append("Date: ");
		sb.append(reservationDate);
		sb.append(lineBreak);
		sb.append("Interested In: ");
		sb.append(service);
		sb.append(lineBreak);
		sb.append(lineBreak);
		sb.append("Thank you,");
		sb.append(lineBreak);
		sb.append(lineBreak);
		sb.append("The website.");

		return sb.toString();

	}
	
}
