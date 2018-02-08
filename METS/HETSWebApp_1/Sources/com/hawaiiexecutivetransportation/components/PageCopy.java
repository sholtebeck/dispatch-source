package com.hawaiiexecutivetransportation.components;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXStatelessComponent;

public class PageCopy extends ERXStatelessComponent {
    
	public PageCopy(WOContext context) {
        super(context);
    }
    
	public String pageCopy() {
		return valueForStringBinding("pageCopy", null);
	}
    
    
}