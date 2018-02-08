package com.hawaiiexecutivetransportation.components;

import com.webobjects.appserver.WOContext;

@SuppressWarnings("serial")
public class MessagePanel extends Main {
	
	public String _message;
	
	public MessagePanel(WOContext context) {
        super(context);
    }
	
	public void reset() {
		super.reset();
		_message = null;
	}

	public boolean isStateless() {
		return true;
	}

}