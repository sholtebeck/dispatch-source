package com.hawaiiexecutivetransportation.components;

import com.webobjects.appserver.WOContext;

public class AirportNavigation extends Main {

	private int counter;
	private boolean wasFound;
	
	public AirportNavigation(WOContext context) {
        super(context);
    }

	public void reset() {
		super.reset();
		counter = 0;
		wasFound = false;
	}
	
	public boolean isStateless() {
		return true;
	}

	public int index() {
		return intValueForBinding("index", -1);
	}
	
	public String listItemClassAttributeNames() {
		// TODO
		String listItemClassName = null;
		if(! wasFound) {
			if(index() == counter) {
				listItemClassName = "active";
				wasFound = true;
			} else {
				counter++;
			}
		}
		return listItemClassName;
	}


}