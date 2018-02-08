package com.hawaiiexecutivetransportation.components.pages.print;

import com.hawaiiexecutivetransportation.components.Main;
import com.mauishuttle.eo.MESDispatch;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;

import er.ajax.mootools.MTAjaxUtils;

@SuppressWarnings("serial")
public class PrintPages extends Main {

	public PrintPages(WOContext context) {
        super(context);
    }

	private MESDispatch _reservation;
	public MESDispatch reservation() {
		return _reservation;
	}

	public void setReservation(MESDispatch reservation) {
		this._reservation = reservation;
	}
	
	public void appendToResponse(WOResponse response, WOContext context) {
    	super.appendToResponse(response, context);
    	MTAjaxUtils.addScriptResourceInHead(context, response, "MooTools", MTAjaxUtils.MOOTOOLS_CORE_JS);
    }

}