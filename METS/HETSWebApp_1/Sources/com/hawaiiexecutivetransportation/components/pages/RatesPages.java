package com.hawaiiexecutivetransportation.components.pages;

import km.content.eo.KMIWebDocument;

import com.hawaiiexecutivetransportation.app.DirectAction;
import com.hawaiiexecutivetransportation.components.Main;
import com.hawaiiexecutivetransportation.components.views.ExclusiveServiceRatesView;
import com.hawaiiexecutivetransportation.components.views.SharedServiceRatesView;
import com.mauishuttle.eo.MESAbstractService;
import com.mauishuttle.eo.MESExclusiveService;
import com.mauishuttle.eo.MESHub;
import com.mauishuttle.eo.MESSharedService;
import com.webobjects.appserver.WOContext;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.foundation.ERXStringUtilities;

public class RatesPages extends Main {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MESHub _hub;
	private MESHub _currentHub;
	private MESAbstractService _currentService;
	public MESAbstractService _service;
	public NSArray<MESAbstractService> _services;
	
	public RatesPages(WOContext context) {
        super(context);
    }
	
	public void reset() {
		super.reset();
		_document = null;
		_services = null;
	}
	
	private KMIWebDocument _document;
	public KMIWebDocument document() {

		if(_document == null) {
			String value = System.getProperty("km.content.eo.KMIWebDocument.RatesPage.pk");			
			_document = (KMIWebDocument)EOUtilities.objectWithPrimaryKeyValue(ec(), KMIWebDocument.ENTITY_NAME, Integer.valueOf(value));
		}
		
		return _document;

	}

	public void setDocument(KMIWebDocument document) {
		this._document = document;
	}

	
	public boolean isStateless() {
		return true;
	}
	
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}
	
	public MESHub currentHub() {
		return _currentHub;
	}

	public void setCurrentHub(MESHub currentHub) {
		this._currentHub = currentHub;
	}
	
	public String currentHubRatesPageLink() {
		return _hubRatesPageLink(currentHub());
	}
	
	public MESAbstractService currentService() {
		return _currentService;
	}

	public void setCurrentService(MESAbstractService currentService) {
		this._currentService = currentService;
	}

	public NSArray<MESHub> hubs() {
		return MESHub.fetchMESHubs(ec(), null, MESHub.NAME.ascs());
	}

	private String _hubRatesPageLink(MESHub hub) {
		NSMutableDictionary<String, Object> queryParameters = new NSMutableDictionary<String, Object>();
		String hubName = hub.name();
		hubName = hubName.replace(" ", "-");
		queryParameters.takeValueForKey(hubName, DirectAction.HUB_REQUEST_KEY);
		return pageLink("rates", "/rates", queryParameters);
	}
	
	public String hubRatesPageLink() {
		return _hubRatesPageLink(_hub);
	}

	public String hubListItemClassName() {
		return isCurrentHub() ? "active" : "";
	}

	public boolean isCurrentHub() {
		return _hub.equals(currentHub());
	}

	public NSArray<MESAbstractService> services() {
		if(_services == null) {
			_services = currentHub().services(MESAbstractService.PUBLIC_SERVICE.eq(true), 
					MESAbstractService.NAME.ascs(), true);
		}
		return _services;
	}
	
	public String metaDescription() {
		return currentService().metaDescription();
	}

	public String pageTitle() {
		return currentService().pageTitle();
	}	

	private String _serviceLink(MESAbstractService service) {
		String serviceName = ERXStringUtilities.stringIsNullOrEmpty(service.slug()) ? service.name() : service.slug();
		serviceName = serviceName.replace(" ", "-");
		NSMutableDictionary<String, Object> queryParameters = new NSMutableDictionary<String, Object>();
		String currentHubName = currentHub().name().replace(" ", "-");
		queryParameters.takeValueForKey(currentHubName, DirectAction.HUB_REQUEST_KEY);
		queryParameters.takeValueForKey(serviceName, DirectAction.SERVICE_REQUEST_KEY);
		return pageLink("rates", "/rates", queryParameters);
	}
	
	public String serviceLink() {
		return _serviceLink(_service);
	}
	
	public String serviceLinkClassName() {
		return _service.equals(currentService()) ? "selected" : null;
	}

	public String serviceRatesViewComponentName() {

		String serviceRatesViewComponentName = null;
		
		if(currentService() instanceof MESSharedService) {
			serviceRatesViewComponentName = SharedServiceRatesView.class.getName();
		} else if(currentService() instanceof MESExclusiveService) {
			serviceRatesViewComponentName = ExclusiveServiceRatesView.class.getName();
		}
		
		return serviceRatesViewComponentName;

	}

	public String canonical() {
		String canonical = null;
		if(currentService().equals(services().get(0))) {
			canonical = _serviceLink(currentService());
		}
		return canonical;
	}
	
	
}