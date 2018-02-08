package kmi.extensions.enums;

import com.webobjects.foundation.NSArray;

public enum BraceletSize implements ISize {
	
	NEWBORN("Child 0-6 months", 4.00),
	BABY("Child 6-12 months", 4.50),
	TODDLER("Child 12-24 months", 5.00),
	CHILD("Child 2-5 years", 5.50),
	YOUTH("Child 6-8 years", 6.00),
	PRE_TEEN("Child 9-13 years", 6.50),
	WOMENS_PETITE("Women's Petite", 7.00),
	WOMENS_SMALL("Women's Medium", 7.50),
	WOMENS_MEDIUM("Women's Medium", 8.00),
	WOMENS_LARGE("Women's Large", 8.50),
	WOMENS_PLUS_SIZE("Women's Plus Size", 9.00),
	MENS_SMALL("Men's Small", 8.00),
	MENS_MEDIUM("Men's Medium", 8.50),
	MENS_LARGE("Men's Large", 9.0),
	MENS_PLUS_SIZE("Men's Plus Size", 9.5);

	private final String _key;
	private final Double _value;
	
	private BraceletSize(String key, Double value) {
		this._key = key;
		this._value = value;
	}
	
	public String key() {
		return this._key;
	}
	
	public Double value() {
		return this._value;
	}

	public static NSArray<BraceletSize> all() {
		return new NSArray<BraceletSize>(values());
	}

	public static BraceletSize make(int index) {
		return values()[index];
	}
	
}
