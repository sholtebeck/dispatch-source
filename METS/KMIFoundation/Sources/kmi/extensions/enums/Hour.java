package kmi.extensions.enums;

import com.webobjects.foundation.NSArray;

public enum Hour {

	NOON(12, 0),
	ONE(1, 1),
	TWO(2, 2),
	THREE(3, 3),
	FOUR(4, 4),
	FIVE(5, 5),
	SIX(6, 6),
	SEVEN(7, 7),
	EIGHT(8, 8),
	NINE(9, 9),
	TEN(10, 10),
	ELEVEN(11, 11);
	
	private int _key;
	private int _value;
	
	Hour(int key, int value) {
		this._key = key;
		this._value = value;
	}
	
	public static Hour make(int value) {

		for(Hour h: Hour.values()) {
			if(h.value() == value) {
				return h;
			}
		}
		
		throw new IllegalArgumentException("Invalid hour: " + value);

	}
	
	public int value() {
		return this._value;
	}
	
	public String toString() {
		return String.valueOf(this._key);
	}
	
	public static NSArray<Hour> all() {
		return new NSArray<Hour>(values());
	}
	
}
