package kmi.extensions.enums;

import java.text.DateFormatSymbols;
import java.util.GregorianCalendar;

import com.webobjects.foundation.NSArray;

public enum Month {

	JANUARY(GregorianCalendar.JANUARY), 
	FEBRUARY(GregorianCalendar.FEBRUARY), 
	MARCH(GregorianCalendar.MARCH),
	APRIL(GregorianCalendar.APRIL),
	MAY(GregorianCalendar.MAY),
	JUNE(GregorianCalendar.JUNE),
	JULY(GregorianCalendar.JULY),    
	AUGUST(GregorianCalendar.AUGUST),   
	SEPTEMBER(GregorianCalendar.SEPTEMBER),
	OCTOBER(GregorianCalendar.OCTOBER),
	NOVEMBER(GregorianCalendar.NOVEMBER),
	DECEMBER(GregorianCalendar.DECEMBER);

	private final int _index;
	private static DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
	
	private Month(int index) {
		this._index = index;
	}
	
	public static Month make(int monthIndex) {
		for(Month m : Month.values()) {
			if(m._index == monthIndex) {
				return m;
			}
		}
		throw new IllegalArgumentException("Invalid month index: " + monthIndex);
	}
	
	public String toString() {
		return dateFormatSymbols.getMonths()[this._index];
	}
	
	public String toShortString() {
		return dateFormatSymbols.getShortMonths()[this._index];		
	}
	
	public int value() {
		return this._index;
	}
	
	public static NSArray<Month> all() {
		return new NSArray<Month>(values());
	}
	
}
