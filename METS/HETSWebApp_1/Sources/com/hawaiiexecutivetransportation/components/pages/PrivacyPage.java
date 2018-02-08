package com.hawaiiexecutivetransportation.components.pages;

import com.hawaiiexecutivetransportation.components.Main;
import com.webobjects.appserver.WOContext;

@SuppressWarnings("serial")
public class PrivacyPage extends Main {
    
	public PrivacyPage(WOContext context) {
        super(context);
    }
	
	public boolean isStateless() {
		return true;
	}
	
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

}