package com.hawaiiexecutivetransportation.interfaces;

import com.mauishuttle.eo.MESAirportZone;
import com.mauishuttle.eo.MESZone;

public interface AirportRouteControllerInterface {

	public MESAirportZone selectedAirportZone();
	
	public MESZone selectedPickUpZone();
	public void setSelectedPickUpZone(MESZone zone);
	
	public MESZone selectedDropOffZone();
	public void setSelectedDropOffZone(MESZone zone);
	
}
