package com.hawaiiexecutivetransportation.components.wrappers;

import com.hawaiiexecutivetransportation.components.Main;
import com.webobjects.appserver.WOContext;

public class PageWrapper extends Main {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PageWrapper(WOContext context) {
        super(context);
    }

	public boolean isStateless() {
		return true;
	}

	public String canonical() {
		return stringValueForBinding("canonical");
	}
	
	public String pageTitle() {
		return stringValueForBinding("pageTitle");
	}
	
	public String metaDescription() {
		return stringValueForBinding("metaDescription");
	}

	public boolean isSecure() {
		return ! application().isDevelopmentModeSafe();
	}
	
}