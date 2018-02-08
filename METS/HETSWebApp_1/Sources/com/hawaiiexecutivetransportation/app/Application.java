package com.hawaiiexecutivetransportation.app;

import kmi.foundation.extensions.KMIStringUtilities;

import com.hawaiiexecutivetransportation.components.pages.ReservationsStartPage;
import com.mauishuttle.eo.MESSystemMessage;
import com.mauishuttle.eo.MESUser;
import com.webobjects.appserver.WOAction;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WORequestHandler;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eoaccess.EOGeneralAdaptorException;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSTimeZone;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSValidation;

import er.ajax.AjaxUtils;
import er.extensions.appserver.ERXApplication;
import er.extensions.appserver.ERXWOContext;
import er.extensions.eof.ERXEC;

public class Application extends ERXApplication {

	private MESUser _onlineReservations;
	private NSTimestamp _startTime;
	
	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	public Application() {
		ERXApplication.log.info("Welcome to " + name() + " !");
		/* ** put your initialization code in here ** */
		setAllowsConcurrentRequestHandling(true);		
		setDefaultRequestHandler(requestHandlerForKey(directActionRequestHandlerKey()));
		_setOnlineReservationsWithDefaultUser();
		EOEditingContext.setDefaultFetchTimestampLag(2);
		NSTimeZone.setDefaultTimeZone(NSTimeZone.timeZoneWithName("HST", true));
	}

	@Override
	public WOResponse handleSessionRestorationErrorInContext(WOContext aContext) {

		WOResponse response = null;
		
		try {
			
			if(aContext != null) {
		
				if(AjaxUtils.isAjaxRequest(aContext.request())) {
					
					response = createResponseInContext(aContext);
					response.appendContentString("<p class = \"error\">Your session has timed out!  You will be redirected.</p>");

					NSMutableDictionary<String, Object> queryParams = new NSMutableDictionary<String, Object>();
					queryParams.put("wosid", Boolean.FALSE);
					queryParams.put("timeout", Boolean.TRUE);

					AjaxUtils.appendScriptHeader(response);

					String url = ERXWOContext._directActionURL(aContext, "default", queryParams, true);

					response.appendContentString("setTimeout(function() { document.location.href = ");
					response.appendContentString(AjaxUtils.quote(url));
					response.appendContentString("}, 1000);");

					AjaxUtils.appendScriptFooter(response);
					
				} else {
					
					ReservationsStartPage nextPage = pageWithName(ReservationsStartPage.class);
					nextPage.addErrorMessage("Your session has timed out!");
					response = nextPage.generateResponse();
					
				}

			}

		} catch(Throwable t) {
			log.fatal(t.getMessage(), t);
			response = super.handleSessionRestorationErrorInContext(aContext);
		}
		
		return response;
		
	}
	
	
	private void _setOnlineReservationsWithDefaultUser() {

		try {

			EOEditingContext editingContext = ERXEC.newEditingContext();
			String defaultUserName = System.getProperty("com.mauishuttle.eo.mesuser");
			_onlineReservations = MESUser.fetchRequiredMESUser(editingContext, 
					MESUser.USER_NAME.eq(defaultUserName));

		} catch (Exception e) {
			
			ERXApplication.log.error("Unable to set default user.  Please check properties file: " +
					"com.mauishuttle.eo.mesuser");
			System.exit(0);
			
		}

	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public WOResponse handleActionRequestError( WORequest request, 
			Exception anException, 
			String reason, 
			WORequestHandler rh,
			String actionClassName, 
			String actionName,
			Class actionClass,
			WOAction actionInstance) {

		WOContext aContext = createContextForRequest(request);

		return handleException(anException, aContext);

	}

	@Override
	public WOResponse handleException(Exception anException, WOContext context) {

		if(context.hasSession()) {
			context.session().terminate();
		}

		recordErrorMessage(context, anException);
		
		ReservationsStartPage nextPage = pageWithName(ReservationsStartPage.class);
		nextPage.addErrorMessage("There has been an error while processing your reservation.  Please begin again.  If you continue to have trouble please contact our toll free number: 1-800-833-2303");
		return nextPage.generateResponse();
	
	}
	
	@Override
	public WOResponse handlePageRestorationErrorInContext(WOContext context) {
		ReservationsStartPage nextPage = pageWithName(ReservationsStartPage.class);
		nextPage.addErrorMessage("There has been an error.  Please begin again.  If you continue to have trouble please contact our toll free number: 1-800-833-2303");
		return nextPage.generateResponse();
	}

	public void recordErrorMessage(WOContext context, Exception anException) {

		String errorTitle = "There has been an exception on: " + application().name() + " of type: " + anException.getClass().getName() + " with message: " + anException.getMessage();
		if(errorTitle.length() > 250) {
			errorTitle = errorTitle.substring(0, 250);
		}
		log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
		log.error(errorTitle);
		log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
		anException.printStackTrace();
		
		EOEditingContext ec = ERXEC.newEditingContext();
		
		try {
			MESSystemMessage message = MESSystemMessage.createMESSystemMessage(ec);
			message.setSubject(errorTitle);
			message.setMessageBody(KMIStringUtilities.stackTraceToString(anException));
			message.setLevel(MESSystemMessage.Level.ERROR.value());
			ec.saveChanges();
		} catch (NSValidation.ValidationException e) {
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			log.error("Unable to save error message with validation error: " + e.getMessage());
			e.printStackTrace();
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
		} catch (EOGeneralAdaptorException e) {
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			log.error("Unable to save error message with EOGeneralAdapterException error: " + e.getMessage());
			e.printStackTrace();
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
		} finally {
			ec.dispose();
			ec = null;
		}
		
	}
	
	public MESUser onlineReservations() {
		return _onlineReservations;
	}

	public void setOnlineReservations(MESUser onlineReservations) {
		this._onlineReservations = onlineReservations;
	}

	public NSTimestamp startTime() {
		if(_startTime == null) {
			_startTime = new NSTimestamp();
		}
		return _startTime;
	}

	public void setStartTime(NSTimestamp startTime) {
		this._startTime = startTime;
	}
	
	
	
}
