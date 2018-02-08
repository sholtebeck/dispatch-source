package com.hawaiiexecutivetransportation.components.pages;

import com.hawaiiexecutivetransportation.app.Session;
import com.mauishuttle.eo.MESAirportZone;
import com.mauishuttle.eo.MESDispatch;
import com.webobjects.appserver.WOContext;

@SuppressWarnings("serial")
public class RouteSummary extends ReservationPages {

	private MESDispatch _dispatch;
	private String _direction;
	
	public RouteSummary(WOContext context) {
        super(context);
    }

	public void sleep() {
		super.sleep();
		_dispatch = null;
		_direction = null;
	}
	
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	public MESDispatch dispatch() {
		if(_dispatch == null) {
			_dispatch = (MESDispatch)valueForBinding("dispatch");
		}
		return _dispatch;
	}

	public String direction() {

		if(_direction == null) {

			if(dispatch().pickUpLocation().zone() instanceof MESAirportZone) {
				_direction = Session.FROM_RESERVATION_DIRECTION;
			} else if(dispatch().dropOffLocation().zone() instanceof MESAirportZone) {
				_direction = Session.TO_RESERVATION_DIRECTION;
			} else {
				_direction = Session.POINT_TO_POINT_DIRECTION;
			}
			
		}
		
		return _direction;
		
	}

	public String summaryLabel() {

		String summaryLabel;
		
		if(direction().equals(Session.TO_RESERVATION_DIRECTION)) {
			summaryLabel = "To Airport Summary";
		} else if(direction().equals(Session.FROM_RESERVATION_DIRECTION)) {
			summaryLabel = "From Airport Summary";
		} else {
			summaryLabel = "Route Summary";
		}
		
		return summaryLabel;

	}
	
}