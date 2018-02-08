package kmi.foundation.extensions;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimeZone;
import com.webobjects.foundation.NSTimestamp;

public class KMITimeUtilities {

	private static Logger log = Logger.getLogger(KMITimeUtilities.class);
	
	public static NSArray<String> hoursOfDayKeys() {
		return new NSArray<String>(new String[]{
				"12 am", "1 am", "2 am", "3 am", "4 am", "5 am", "6 am", "7 am", "8 am", "9 am", "10 am", "11 am",
				"12 pm", "1 pm", "2 pm", "3 pm", "4 pm", "5 pm", "6 pm", "7 pm", "8 pm", "9 pm", "10 pm", "11 pm",
		});
	}

	public static NSArray<Integer> hoursOfDay() {
		return new NSArray<Integer>(new Integer[] {
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
				12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23
		});
	}

	public static NSArray<String> hours() {
		return new NSArray<String>(new String[] {
				"12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"
		});
	}

	public static NSArray<Integer> hoursValues() {
		return new NSArray<Integer>(new Integer[] {
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
		});
	}

	public static NSArray<String> minutesOfHourKeys() {
		return new NSArray<String>(new String[] {
				"0", "5", "10", "15", "20", "25", 
				"30","35", "40", "45", "50", "55"
		});
	}

	public static NSArray<String> meridiems() {
		return new NSArray<String>(new String[] {
				"AM", "PM"
		});
	}

	public static NSArray<String> months() {
		return new NSArray<String>(new String[] {
				"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" 
		});
	}

	public static Calendar convertToGmt(Calendar cal) {

		Date date = cal.getTime();
		TimeZone tz = cal.getTimeZone();
		log.debug("input calendar has date [" + date + "]");
		//Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT 
		long msFromEpochGmt = date.getTime();

		//gives you the current offset in ms from GMT at the current date
		int offsetFromUTC = tz.getOffset(msFromEpochGmt);
		log.debug("offset is " + offsetFromUTC);
		//create a new calendar in GMT timezone, set to this date and add the offset
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.setTime(date);
		gmtCal.add(Calendar.MILLISECOND, offsetFromUTC);
		log.debug("Created GMT cal with date [" + gmtCal.getTime() + "]");

		return gmtCal;
	}

	@Deprecated
	public static NSTimestamp todayAtMidnight() {
		NSTimestamp ts = new NSTimestamp();
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(ts);
		return new NSTimestamp(calendar.get(GregorianCalendar.YEAR), calendar.get(GregorianCalendar.MONTH) + 1, calendar.get(GregorianCalendar.DATE), 0, 0, 0, NSTimeZone.defaultTimeZone());
	}

	@Deprecated
	public static NSTimestamp tomorrowAtMidnight() {
		return nextDay(KMITimeUtilities.todayAtMidnight());
	}

	@Deprecated
	public static NSTimestamp yesterdayAtMidnight() {
		return addDateUnitsToTimestamp(todayAtMidnight(), -1);
	}

	@Deprecated
	public static NSTimestamp twoDaysAgoAtMidnight() {
		return addDateUnitsToTimestamp(todayAtMidnight(), -2);
	}

	public static int numberOfMonthsBetweenDates(NSTimestamp start, NSTimestamp end) { 
		GregorianCalendar startCalendar = new GregorianCalendar();
		startCalendar.setTimeInMillis(start.getTime());
		GregorianCalendar endCalendar = new GregorianCalendar();
		endCalendar.setTimeInMillis(end.getTime());
		return (endCalendar.get(GregorianCalendar.YEAR) * 12 + endCalendar.get(GregorianCalendar.MONTH)) - 
				(startCalendar.get(GregorianCalendar.YEAR) * 12 + startCalendar.get(GregorianCalendar.MONTH));
	}

	public static double numberOfHoursBetweenTimestamps(NSTimestamp start, NSTimestamp end) {
		long secs = (start.getTime() - end.getTime()) / 1000;
		int hours = (int)(secs / (60 * 60));
		double minutes = ((secs % 3600) / 60) / 60.0;
		return new BigDecimal(hours + minutes).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
	}
	
	public static int numberOfDaysBetweenDates(NSTimestamp start, NSTimestamp end) {
		return (int)(start.getTime() - end.getTime()) / (1000 * 60 * 60 * 24);	     
	}

	public static NSDictionary<String, Integer> hoursDictionary() {
		return new NSDictionary<String, Integer>(hoursValues(), hours());
	}

	public static NSDictionary<String, Integer> hoursOfDayDictionary() {
		return new NSDictionary<String, Integer>(hoursOfDay(), hoursOfDayKeys());
	}

	public static TimeZone hawaiiTimeZone() {
		return TimeZone.getTimeZone("HST");
	}

	public static NSTimestamp nextDay(NSTimestamp value) {
		return KMITimeUtilities.addDateUnitsToTimestamp(value, 1);
	}
	
	public static GregorianCalendar endOfDay(GregorianCalendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
		return calendar;
	}
	
	public static NSTimestamp endOfDay(NSTimestamp ts) {
		GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
		calendar.setTime(ts);
		calendar = endOfDay(calendar);
		return new NSTimestamp(calendar.getTime());
	}
	
	public static GregorianCalendar startOfDay(GregorianCalendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getMinimum(Calendar.MILLISECOND));
		return calendar;
	}
	
	public static NSTimestamp startOrDay(NSTimestamp ts) {
		GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
		calendar.setTime(ts);
		calendar = startOfDay(calendar);
		return new NSTimestamp(calendar.getTime());
	}

	public static NSTimestamp addDateUnitsToTimestamp(NSTimestamp value, int units) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(value);
		calendar.add(GregorianCalendar.DATE, units);
		return new NSTimestamp(calendar.getTime());
	}

	public static NSArray<Integer> years(GregorianCalendar calendar, int iterations) {

		NSMutableArray<Integer> years = new NSMutableArray<Integer>();

		if(calendar == null) {
			calendar = new GregorianCalendar();
		}

		for(int i = 0; i < iterations; i++) {
			years.addObject(calendar.get(GregorianCalendar.YEAR));
			calendar.add(GregorianCalendar.YEAR, 1);
		}

		return years;

	}
	
	public static String dateSuffix(int date) {
		
		String suffix = null;
		
		if (date > 10 && date < 14) {
			suffix = "th";
		}

		switch (date % 10) {
		
		case 1:
			suffix = "st";
			break;
		case 2:
			suffix = "nd";
			break;
		case 3:
			suffix = "rd";
			break;
		default:
			suffix = "th";

		}		
		
		return suffix;

	}
	
	
}
