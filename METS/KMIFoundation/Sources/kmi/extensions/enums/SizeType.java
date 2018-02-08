package kmi.extensions.enums;

import com.webobjects.foundation.NSArray;

public enum SizeType {

	BRACELET("Bracelet", 2),
	CLOTHING("Clothing", 0),
	RING("Ring", 1);
	
	private String _key;
	private int _value;
	
	SizeType(String key, int value) {
		_key = key;
		_value = value;
	}
	
	public String key() {
		return _key;
	}
	
	public int value() {
		return _value;
	}
	
	public static SizeType sizeTypeForValue(int value) {
		SizeType type = null;
		for(SizeType aSizeType : SizeType.values()) {
			if(aSizeType.value() == value) {
				type = aSizeType;
				break;
			}
		}
		return type;
	}

	public static NSArray<SizeType> all() {
		return new NSArray<SizeType>(SizeType.values());
	}
	
}
