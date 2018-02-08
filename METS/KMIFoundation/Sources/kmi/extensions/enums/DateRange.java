package kmi.extensions.enums;

import kmi.foundation.extensions.KMITimestampUtilities;

import com.webobjects.foundation.NSTimestamp;

import er.extensions.foundation.ERXTimestampUtilities;

public enum DateRange {

	CUSTOM,
	TODAY,
	YESTERDAY,
	THIS_WEEK, 
	LAST_WEEK,
	THIS_MONTH,
	LAST_MONTH,
	THIS_YEAR;
	
	private DateRange() {
	}

	public static DateRange make(String key) {
	
		for(DateRange d : DateRange.values()) {
			if(d.toString().equals(key)) {
				return d;
			}
		}
		
		throw new IllegalArgumentException("Invalid Date Range: " + key);

	}
	
	public String toString() {
		String toString = null;
	
		switch (this) {
		case CUSTOM:
			toString = "Custom";
			break;
		case TODAY:
			toString = "Today";
			break;
		case YESTERDAY:
			toString = "Yesterday";
			break;
		case THIS_WEEK:
			toString = "This Week";
			break;
		case LAST_WEEK:
			toString = "Last Week";
			break;
		case THIS_MONTH:
			toString = "This Month";
			break;
		case LAST_MONTH:
			toString = "Last Month";
			break;
		case THIS_YEAR:
			toString = "This Year";
		default:
			break;
		}
		
		return toString;

	}
	
	public static DateRange dateRange(NSTimestamp ts1, NSTimestamp ts2) {
		DateRange dateRange = null;
		if(ts1 != null && ts2 != null) {
			if(ts1.equals(ERXTimestampUtilities.today()) && 
					ts2.equals(ts1.timestampByAddingGregorianUnits(0, 0, 0, 23, 59, 59))) {
				dateRange = TODAY;
			} else if(ts1.equals(ERXTimestampUtilities.yesterday()) && 
					ts2.equals(ts1.timestampByAddingGregorianUnits(0, 0, 0, 23, 59, 59))) {
				dateRange = YESTERDAY;
			} else if(ts1.equals(KMITimestampUtilities.firstDayOfWeek()) &&
					ts2.equals(ts1.timestampByAddingGregorianUnits(0, 0, 6, 23, 59, 59))) {
				dateRange = THIS_WEEK;
			} else if(ts1.equals(KMITimestampUtilities.firstDayOfMonth()) &&
					ts2.equals(KMITimestampUtilities.lastDayOfMonth(ts1).timestampByAddingGregorianUnits(0, 0, 0, 23, 59, 59))) {
				dateRange = THIS_MONTH;
			} else if(ts1.equals(KMITimestampUtilities.firstDayOfLastMonth()) &&
					ts2.equals(KMITimestampUtilities.lastDayOfMonth(ts1).timestampByAddingGregorianUnits(0, 0, 0, 23, 59, 59))) {
				dateRange = LAST_MONTH;
			} else if(ts1.equals(KMITimestampUtilities.firstDayOfWeek().timestampByAddingGregorianUnits(0, 0, -7, 0, 0, 0)) 
					&& ts2.equals(ts1.timestampByAddingGregorianUnits(0, 0, 6, 23, 59, 59))) {
				dateRange = LAST_WEEK;
			} else if(ts1.equals(KMITimestampUtilities.firstDayOfYear()) 
					&& ts2.equals(KMITimestampUtilities.lastDayOfYear(ts1.timestampByAddingGregorianUnits(0, 0, 0, 23, 59, 59)))) {
				dateRange = THIS_YEAR;
			} else {
				dateRange = CUSTOM;
			}
			
		}
		return dateRange;
	}
	
}
