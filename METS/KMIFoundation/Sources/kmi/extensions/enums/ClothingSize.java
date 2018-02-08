package kmi.extensions.enums;

import com.webobjects.foundation.NSArray;

public enum ClothingSize implements ISize {

	EXTRA_EXTRA_SMALL("Extra-Extra Small", "XXS"),
	EXTRA_SMALL("Extra Small", "XS"),
	SMALL("Small", "S"),
	MEDIUM("Medium", "M"),
	LARGE("Large", "L"),
	EXTRA_LARGE("Extra-Large", "XL"),
	EXTRA_EXTRA_LARGE("Extra-Extra Large", "XXL"),
	EXTRA_EXTRA_EXTRA_LARGE("Extra-Extra Large", "XXXL");
	
	private final String _key;
	private final String _value;
	
	private ClothingSize(String key, String value) {
		this._key = key;
		this._value = value;
	}
	
	public String key() {
		return this._key;
	}
	
	public String value() {
		return this._value;
	}
	
	public static NSArray<ClothingSize> all() {
		return new NSArray<ClothingSize>(ClothingSize.values());
	}
	
	public static ClothingSize make(int index) {
		return values()[index];
	}
	
}
