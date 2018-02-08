package com.hawaiiexecutivetransportation.components.pages;

import com.hawaiiexecutivetransportation.components.Main;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;

@SuppressWarnings("serial")
public class PageNotFoundPage extends Main {
    
	public PageNotFoundPage(WOContext context) {
        super(context);
    }
    
	public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		response.setStatus(404);
	}
    
	public boolean isStateless() {
		return true;
	}
	
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}
	
}