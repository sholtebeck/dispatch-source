package com.hawaiiexecutivetransportation.components;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXStatelessComponent;

public class FacebookButton extends ERXStatelessComponent {
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FacebookButton(WOContext context) {
        super(context);
    }

	public String css() {
		String css = stringValueForBinding("css", "span-7-5");
		css += " facebook last";
		return css;
	}
	
}