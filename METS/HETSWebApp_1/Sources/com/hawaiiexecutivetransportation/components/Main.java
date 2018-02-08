package com.hawaiiexecutivetransportation.components;

import com.hawaiiexecutivetransportation.app.Application;
import com.hawaiiexecutivetransportation.app.Session;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.appserver.ERXWOContext;
import er.extensions.components.ERXComponent;
import er.extensions.eof.ERXEC;
import er.extensions.foundation.ERXStringUtilities;
import er.extensions.foundation.ERXThreadStorage;

public class Main extends ERXComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EOEditingContext _ec;
	private int _mainNavigationCounter = 0;
	private Integer _mainNavigationIndex;
	private String _metaDescription;
	private String _pageTitle;
	private String _robots;
	private NSMutableArray<String> _errors;
	private NSMutableArray<String> _messages;
	public String _message;
	public static final String YES_KEY = "Yes";
	public static final String NO_KEY = "No";
	public final NSArray<String> yesOrNoArray = new NSArray<String>(new String[] {
			YES_KEY, NO_KEY
	});
	
	public Main(WOContext context) {
		super(context);
	}

	public EOEditingContext ec() {
		if(_ec == null) {
			_ec = (EOEditingContext)ERXThreadStorage.valueForKey("ec");
		}
		if(_ec == null) {
			_ec = ERXEC.newEditingContext();
		}
		return _ec;
	}

	public void setEc(EOEditingContext ec) {
		this._ec = ec;
	}

	public Application application() {
		return (Application)super.application();
	}
	
	public Session session() {
		return (Session)super.session();
	}

	public void awake() {
		super.awake();
		_mainNavigationCounter = 0;
		_errors = null;
		_messages = null;
	}
	
	protected String pageLink(String directActionName, String url, NSDictionary<String, Object> queryParameters, boolean secure, boolean includeSessionID) {

		String link = "";

		if(false) {

			if(queryParameters != null) {
				link = ERXWOContext.directActionUrl(context(), directActionName, queryParameters, secure, includeSessionID);
			} else {
				link = ERXWOContext.directActionUrl(context(), directActionName, secure, includeSessionID);
			}
			
		} else {

			if(secure) {
				
				link += "https://";
				link += System.getProperty("domain_name");

			} else if(context().secureMode()) {
				
				link += "http://";
				link += System.getProperty("domain_name");

			}
			
			link += System.getProperty("prepend_path_name");
	
			link += url;
			
			if(queryParameters != null) {
				for(String key : queryParameters.allKeys()) {
					link += "/";
					link += queryParameters.valueForKey(key);
				}
			}

		}
				
		return link;
		
		
	}
	
	protected String pageLink(String directActionName, String url, NSDictionary<String, Object> queryParameters) {
		return pageLink(directActionName, url, queryParameters, false, false);
	}
	
	protected String pageLink(String directActionName, String url) {
		return pageLink(directActionName, url, null);
	}
	
	public String aboutPageLink() {
		return pageLink("about", "/about-us");
	}
	
	public String contactPageLink() {
		return pageLink("contact", "/contact-us");
	}
	
	public String kahuluiAirportPageLink() {
		return pageLink("kahuluiAirportPage", "/Maui/Kahului-Airport-Shuttle-Transportation");
	}

	public String kapaluaAirportPageLink() {
		return pageLink("kapaluaAirportPage", "/West-Maui/Kapalua-Airport-Shuttle-Transportation");
	}	

	public String konaAirportPageLink()	 {
		return pageLink("konaAirportPage", "/Big-Island-Hawaii/Kona-International-Airport-Shuttle-Transportation");
	}
	
	public String lihueAirportPageLink()	 {
		return pageLink("lihueAirportPage", "/Kauai/Lihue-Airport-Shuttle-Transportation");
	}
	
	public String limousineInformationPageLink() {
		return pageLink("limousineRentalPage", "/Maui/Limousine-Private-Car-Services");
	}
	
	public String charterBusInformationPageLink() {
		return pageLink("charterBusInformationPage", "/Maui/Charter-Bus-Services");
	}
	
	public String bigIslandVolcanoToursPageLink() {
		return pageLink("bigIslandVolcanoToursPage", "/Big-Island-Hawaii/Big-Island-Volcano-Tours");
	}
	
	public String ironmanPageLink() {
		return pageLink("konaIronmanPage", "/Big-Island-Hawaii/Kona-IRONMAN-Tournament-Airport-Transportation");
	}
	
	public String homePageLink() {
		return pageLink("default", "/");
	}

	public String ratesPagesLink() {
		return pageLink("rates", "/rates");
	}
	
	public String reservationsPageLink() {
		return pageLink("reservations", "/reservations", null, ! application().isDevelopmentMode(), false);
	}
	
	public String privacyPageLink() {
		return pageLink("privacy", "/privacy");
	}
	
	public String metaDescription() {
		return _metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this._metaDescription = metaDescription;
	}

	public String pageTitle() {

		if(ERXStringUtilities.stringIsNullOrEmpty(_pageTitle)) {
			_pageTitle = "Hawaii Executive Transportation";
		}
		
		return _pageTitle;
	
	}

	public void setPageTitle(String pageTitle) {
		this._pageTitle = pageTitle;
	}

	/**
	 * @return the robots
	 */
	public String robots() {
		if(ERXStringUtilities.stringIsNullOrEmpty(_robots)) {
			_robots = "index, follow";
		}
		return _robots;
	}

	/**
	 * @param robots the robots to set
	 */
	public void setRobots(String robots) {
		this._robots = robots;
	}


	public String mainNavigationClassName() {

		String mainNavigationClassName = null;
		
		if(_mainNavigationCounter == mainNavigationIndex()) {
			mainNavigationClassName = "active";
		}

		_mainNavigationCounter++;
	
		return mainNavigationClassName;

	}
	
	public Integer mainNavigationIndex() {
		if(_mainNavigationIndex == null) {
			_mainNavigationIndex = -1;
		}
		return _mainNavigationIndex;
	}

	public void setMainNavigationIndex(Integer mainNavigationIndex) {
		this._mainNavigationIndex = mainNavigationIndex;
	}

	public void validationFailedWithException(Throwable t, Object value, String keyPath) {
		addErrorMessage(t.getMessage());
	}
	
	public void addErrorMessage(String errorMessage) {
		errors().addObject(errorMessage);
	}
	
	public void addMessage(String message) {
		messages().addObject(message);
	}
	
	public boolean hasErrors() {
		return errors().size() > 0;
	}
	
	public boolean hasMessages() {
		return messages().size() > 0;
	}

	public NSMutableArray<String> errors() {
		if(_errors == null) {
			_errors = new NSMutableArray<String>();
		}
		return _errors;
	}

	public void setErrors(NSMutableArray<String> errors) {
		this._errors = errors;
	}

	public NSMutableArray<String> messages() {
		if(_messages == null) {
			_messages = new NSMutableArray<String>();
		}
		return _messages;
	}

	public void setMessages(NSMutableArray<String> messages) {
		this._messages = messages;
	}
	
}
