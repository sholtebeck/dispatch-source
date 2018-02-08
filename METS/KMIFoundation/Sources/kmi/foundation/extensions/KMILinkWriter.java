package kmi.foundation.extensions;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.appserver.ERXApplication;
import er.extensions.appserver.ERXWOContext;

public class KMILinkWriter {


	private static NSMutableDictionary<String, Object> _pageNameParameter(String pageName) {
		NSMutableDictionary<String, Object> queryParameters = new NSMutableDictionary<String, Object>();
		queryParameters.takeValueForKey(pageName, "pageName");
		return queryParameters;
	}
	
	public static String pageLinkWithPageName(WOContext context, String pageName) {
		return pageLink(context, "page", null, _pageNameParameter(pageName));
	}

	public static String pageLink(WOContext context, String directActionName) {
		return pageLink(context, directActionName, null, null);
	}
	
	public static String pageLink(WOContext context, String directActionName, String rewriteName) {
		return pageLink(context, directActionName, null, null, rewriteName, false);
	}

	public static String pageLink(WOContext context, String directActionName, String rewriteName, boolean secure) {
		return pageLink(context, directActionName, null, null, rewriteName, secure);
	}
	
	public static String pageLink(WOContext context, String directActionName, String directActionClass, NSDictionary<String, Object> parameters) {
		return pageLink(context, directActionName, directActionClass, parameters, directActionName, false);
	}

	public static String pageLink(WOContext context, String directActionName, String directActionClass, NSDictionary<String, Object> parameters, String rewriteName, boolean secure) {

		String pageLink = null;
		
		if(ERXApplication.isDevelopmentModeSafe()) {
			pageLink = ERXWOContext.directActionUrl(context, directActionName, parameters, false, false);
		} else {
			
			if(secure) {
				pageLink = "https://";
				pageLink += System.getProperty("domainName");
			} else {
				pageLink = "";
			}
			
			pageLink += _prependPath();
			pageLink += "/";
			pageLink += rewriteName;
			
			if(parameters != null) {

				for(String key : parameters.allKeys()) {
				
					if(! key.equals("pageName")) {
						pageLink += "/";
						pageLink += encode(key);
					}

					pageLink += "/";
					pageLink += encode(parameters.valueForKey(key));

				}
			}
		}
	
		return pageLink;
		
		
	}
	
	public static String pageLink(WOContext context, String directActionName, String directActionClass, NSDictionary<String, Object> parameters, KMILinkRewriteDelegate delegate) {

		String pageLink = null;

		if(ERXApplication.isDevelopmentModeSafe()) {
			pageLink = ERXWOContext.directActionUrl(context, directActionName, parameters, false, false);
		} else {
			
			pageLink = "";
			if(_prependPath() != null) {
				pageLink += _prependPath();
			}
 			
			pageLink += delegate.rewriteUrl(parameters);

		}
	
		return pageLink;
		
		
	}
	
	public static String encode(String string) {
		return string.replaceAll(" ", "-");
	}
	
	public static String encode(Object object) {
		return object instanceof String ? encode((String) object) : null;
	}
	
	public static String decode(String string) {
		return string.replaceAll("-", " ");
	}
	
	private static String _prependPath() {
		return System.getProperty("prependPath") != null ? System.getProperty("prependPath") : "";
	}	
	
}