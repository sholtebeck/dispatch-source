package com.hawaiiexecutivetransportation.components.views;

import com.hawaiiexecutivetransportation.components.Main;
import com.mauishuttle.eo.MESAbstractZone;
import com.mauishuttle.eo.MESSharedService;
import com.mauishuttle.eo.MESSharedServiceRate;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class SharedServiceRatesView extends Main {

	private static final long serialVersionUID = 1L;
	public MESAbstractZone _zone;
	public MESSharedServiceRate _rate;
	private Boolean _alternateRow;
	
	public SharedServiceRatesView(WOContext context) {
        super(context);
    }

	public void reset() {
		super.reset();
		_alternateRow = null;
	}
	
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}
	
	public boolean isStateless() {
		return true;
	}

	@SuppressWarnings("unchecked")
	public NSArray<MESSharedServiceRate> rates() {
		return MESSharedServiceRate.fetchMESSharedServiceRates(service().editingContext(), 
				MESSharedServiceRate.SERVICE.eq(service())
					.and(MESSharedServiceRate.SECONDARY_ZONE.eq(_zone)
							.and(MESSharedServiceRate.NUMBER_OF_PASSENGERS.lessThan(11))), 
				MESSharedServiceRate.NUMBER_OF_PASSENGERS.ascs());
	}
	
	public MESSharedService service() {
		return (MESSharedService)valueForBinding("service");
	}
	
	@SuppressWarnings("unchecked")
	public NSArray<MESAbstractZone> zones() {
		return MESAbstractZone.fetchMESAbstractZones(service().editingContext(), 
				MESAbstractZone.SHARED_SERVICE_RATES.in(service().rates()), 
				MESAbstractZone.NAME.ascs());
	}

	public String tableRowClassName() {
		
		String tableRowClassName = null;
		
		if(alternateRow()) {
			tableRowClassName = "even";
		}

		setAlternateRow(! alternateRow());

		return tableRowClassName;

	}

	public Boolean alternateRow() {
		if(_alternateRow == null) {
			_alternateRow = false;
		}
		return _alternateRow;
	}

	public void setAlternateRow(Boolean alternateRow) {
		this._alternateRow = alternateRow;
	}
	
}