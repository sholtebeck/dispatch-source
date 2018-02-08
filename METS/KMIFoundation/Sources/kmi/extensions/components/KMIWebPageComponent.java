package kmi.extensions.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.components.ERXComponent;

public abstract class KMIWebPageComponent extends ERXComponent {

	/**
	 * Do I need to update serialVersionUID?
	 * See section 5.6 <cite>Type Changes Affecting Serialization</cite> on page 51 of the 
	 * <a href="http://java.sun.com/j2se/1.4/pdf/serial-spec.pdf">Java Object Serialization Spec</a>
	 */
	private static final long serialVersionUID = 1L;

	private NSMutableArray<String> _errorMessages;
	private String _metaDescription;
	private NSMutableArray<String> _notices;
	private String _pageKey;
	private String _pageTitle;
	public String _string;
	
	public KMIWebPageComponent(WOContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void awake() {
		super.awake();
		_errorMessages = null;
		_notices = null;
	}
		
	public void addErrorMessage(String message) {
		errorMessages().addObject(message);
	}
	
	public void addNotice(String message) {
		notifications().addObject(message);
	}
	
	public boolean hasError() {
		return errorMessages() != null && errorMessages().size() > 0;
	}
	
	public NSMutableArray<String> errorMessages() {
		if(_errorMessages == null) {
			_errorMessages = new NSMutableArray<String>();
		}
		return _errorMessages;
	}

	public void setErrorMessages(NSMutableArray<String> errorMessages) {
		this._errorMessages = errorMessages;
	}

	public boolean hasNotifications() {
		return notifications() != null && notifications().size() > 0;
	}
	
	public NSMutableArray<String> notifications() {
		if(_notices == null) {
			_notices = new NSMutableArray<String>();
		}
		return _notices;
	}

	public void setNotifications(NSMutableArray<String> notices) {
		this._notices = notices;
	}

	public boolean hasMessages() {
		return hasNotifications() || hasError();
	}
	
	public String pageKey() {
		return _pageKey;
	}

	public void setPageKey(String pageKey) {
		this._pageKey = pageKey;
	}

	public String pageTitle() {
		return _pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this._pageTitle = pageTitle;
	}
	
	public void validationFailedWithException(Throwable t, Object value, String keyPath) {
		addErrorMessage(t.getMessage());
	}

	public String metaDescription() {
		return _metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this._metaDescription = metaDescription;
	}

}
