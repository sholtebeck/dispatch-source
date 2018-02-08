package com.hawaiiexecutivetransportation.components;

import com.hawaiiexecutivetransportation.app.Application;
import com.mauishuttle.eo.MESAirportZone;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.appserver.ERXWOContext;
import er.extensions.components.ERXStatelessComponent;
import er.extensions.eof.ERXEC;
import er.extensions.foundation.ERXThreadStorage;

public class ReservationWidget extends ERXStatelessComponent {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NSArray<MESAirportZone> _airportZones;
	public MESAirportZone _airport;
	
	public ReservationWidget(WOContext context) {
        super(context);
    }

	public void reset() {
		super.reset();
		_airportZones = null;
	}
	
	public EOEditingContext ec() {
		EOEditingContext ec = (EOEditingContext) ERXThreadStorage.valueForKey("ec");
		return ec != null ? ec : ERXEC.newEditingContext();
	}	

	public boolean isStateless() {
		return true;
	}
	
	public NSArray<MESAirportZone> airportZones() {
		if(_airportZones == null) {
			_airportZones = MESAirportZone.fetchAllMESAirportZones(ec(), MESAirportZone.NAME.ascs());
		}
		return _airportZones;
	}

	public void setAirportZones(NSArray<MESAirportZone> airportZones) {
		this._airportZones = airportZones;
	}

	public String startReservationLink() {
		return ERXWOContext.directActionUrl(context(), "startReservation", ! ((Application)application()).isDevelopmentMode(), false);
	}
	
	
}