package com.hawaiiexecutivetransportation.components.views;

import com.hawaiiexecutivetransportation.components.Main;
import com.mauishuttle.eo.MESAbstractZone;
import com.mauishuttle.eo.MESExclusiveService;
import com.mauishuttle.eo.MESExclusiveServiceRate;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class ExclusiveServiceRatesView extends Main {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MESExclusiveServiceRate _rate;
	private Boolean _alternateRow;
	
	public ExclusiveServiceRatesView(WOContext context) {
        super(context);
    }

	public void reset() {
		super.reset();
		_alternateRow = null;
	}
	
	public boolean isStateless() {
		return true;
	}
	
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public NSArray<MESExclusiveServiceRate> rates() {
		return service().rates(null, MESExclusiveServiceRate.SECONDARY_ZONE.dot(MESAbstractZone.NAME.ascs()), true);
	}

	public MESExclusiveService service() {
		return (MESExclusiveService)valueForBinding("service");
	}

	public Boolean alternateRow() {

		if(_alternateRow == null) {
			_alternateRow = true;
		}
		
		return _alternateRow;

	}

	public void setAlternateRow(Boolean alternateRow) {
		this._alternateRow = alternateRow;
	}

	public String tableRowClassName() {
		
		String tableRowClassName = null;
		
		if(alternateRow()) {
			tableRowClassName = "even";
		}

		setAlternateRow(! alternateRow());

		return tableRowClassName;

	}	
	
}