package kmi.foundation.extensions;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.webobjects.foundation.NSTimestamp;

import er.extensions.foundation.ERXTimestampUtilities;

public class KMITimestampUtilities {

	private static GregorianCalendar calendar(NSTimestamp timestamp) {
		GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
		calendar.setTime(timestamp);
		return calendar;
	}
	
	private static NSTimestamp timestamp(GregorianCalendar calendar) {
		return new NSTimestamp(calendar.getTime());
	}

	public static NSTimestamp firstDayOfWeek(NSTimestamp timestamp) {
		GregorianCalendar calendar = calendar(timestamp);
		calendar.set(GregorianCalendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		return timestamp(calendar);
	}

	public static NSTimestamp firstDayOfWeek() {
		return firstDayOfWeek(ERXTimestampUtilities.today());
	}
	
	public static NSTimestamp firstDayOfMonth(NSTimestamp timestamp) {

		GregorianCalendar calendar = calendar(timestamp);
		calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
		return timestamp(calendar);
		
	}

	public static NSTimestamp firstDayOfMonth() {
		return firstDayOfMonth(ERXTimestampUtilities.today());
	}
	
	public static NSTimestamp lastDayOfMonth(NSTimestamp timestamp) {
		
		GregorianCalendar calendar = calendar(timestamp);
		calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
		
		return timestamp(calendar);
		
	}
	
	public static NSTimestamp firstDayOfLastMonth(NSTimestamp timestamp) {
		GregorianCalendar calendar = calendar(timestamp);
		calendar.add(GregorianCalendar.MONTH, -1);
		return firstDayOfMonth(timestamp(calendar));
	}
	
	public static NSTimestamp firstDayOfLastMonth() {
		return firstDayOfLastMonth(ERXTimestampUtilities.today());
	}
	
	public static NSTimestamp firstDayOfYear(NSTimestamp timestamp) {
		GregorianCalendar calendar = calendar(timestamp);
		calendar.set(GregorianCalendar.DAY_OF_YEAR, calendar.getActualMinimum(GregorianCalendar.DAY_OF_YEAR));
		return timestamp(calendar);
	}
	
	public static NSTimestamp firstDayOfYear() {
		return KMITimestampUtilities.firstDayOfYear(ERXTimestampUtilities.today());
	}
	
	public static NSTimestamp lastDayOfYear(NSTimestamp timestamp) {
		GregorianCalendar calendar = calendar(timestamp);
		calendar.set(GregorianCalendar.DAY_OF_YEAR, calendar.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));
		return timestamp(calendar);
	}
	
	
}
