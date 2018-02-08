package com.hawaiiexecutivetransportation.components.pages.print;

import com.webobjects.appserver.WOContext;

@SuppressWarnings("serial")
public class PrintReceiptPage extends PrintPages {
	
	public PrintReceiptPage(WOContext context) {
        super(context);
    }

	public String pageTitle() {
		return "Hawaii Executive Transportation - Receipt for Reservation: " + reservation().confirmationNumber();
	}
	
}