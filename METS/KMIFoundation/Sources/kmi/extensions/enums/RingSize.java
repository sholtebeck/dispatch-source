package kmi.extensions.enums;

import com.webobjects.foundation.NSArray;

public enum RingSize implements ISize {

	ZERO("0\"", 0.00),
	ONE_QUARTER("1/4\"", 0.25),
	ONE_HALF("1/2\"", 0.5),
	THREE_QUARTERS("3/4\"", 0.75),
	ONE("1\"", 1.00),
	ONE_AND_ONE_QUARTER("1 1/4\"", 1.25),
	ONE_AND_ONE_HALF("1 1/2\"", 1.5),
	ONE_AND_THREE_QUARTERS("1 3/4\"", 1.75),
	TWO("2\"", 2.00),
	TWO_AND_ONE_QUARTER("2 1/4\"", 2.25),
	TWO_AND_ONE_HALF("2 1/2\"", 2.5),
	TWO_AND_THREE_QUARTERS("2 3/4\"", 2.75),
	THREE("3\"", 3.00),
	THREE_AND_ONE_QUARTER("3 1/4\"", 3.25),
	THREE_AND_ONE_HALF("3 1/2\"", 3.5),
	THREE_AND_THREE_QUARTERS("3 3/4\"", 3.75),
	FOUR("4\"", 4.00),
	FOUR_AND_ONE_QUARTER("3 1/4\"", 4.25),
	FOUR_AND_ONE_HALF("3 1/2\"", 4.50),
	FOUR_AND_THREE_QUARTERS("3 3/4\"", 4.75),
	FIVE("5\"", 5.00),
	FIVE_AND_ONE_QUARTER("5 1/4\"", 5.25),
	FIVE_AND_ONE_HALF("5 1/2\"", 5.50),
	FIVE_AND_THREE_QUARTERS("5 3/4\"", 5.75),
	SIX("6\"", 6.00),
	SIX_AND_ONE_QUARTER("6 1/4\"", 6.25),
	SIX_AND_ONE_HALF("6 1/2\"", 6.50),
	SIX_AND_THREE_QUARTERS("6 3/4\"", 6.75),
	SEVEN("7\"", 7.00),
	SEVEN_AND_ONE_QUARTER("7 1/4\"", 7.25),
	SEVEN_AND_ONE_HALF("7 1/2\"", 7.50),
	SEVEN_AND_THREE_QUARTERS("7 3/4\"", 7.75),
	EIGHT("8\"", 8.00),
	EIGHT_AND_ONE_QUARTER("8 1/4\"", 8.25),
	EIGHT_AND_ONE_HALF("8 1/2\"", 8.50),
	EIGHT_AND_THREE_QUARTERS("8 3/4\"", 8.75),
	NINE("9\"", 9.00),
	NINE_AND_ONE_QUARTER("9 1/4\"", 9.25),
	NINE_AND_ONE_HALF("9 1/2\"", 9.50),
	NINE_AND_THREE_QUARTERS("9 3/4\"", 9.75),
	TEN("10\"", 10.00),
	TEN_AND_ONE_QUARTER("10 1/4\"", 10.25),
	TEN_AND_ONE_HALF("10 1/2\"", 10.50),
	TEN_AND_THREE_QUARTERS("10 3/4\"", 10.75),
	ELEVEN("11\"", 11.00),
	ELEVEN_AND_ONE_QUARTER("11 1/4\"", 11.25),
	ELEVEN_AND_ONE_HALF("11 1/2\"", 11.50),
	ELEVEN_AND_THREE_QUARTERS("11 3/4\"", 11.75),
	TWELVE("12\"", 12.00),
	TWELVE_AND_ONE_QUARTER("12 1/4\"", 12.25),
	TWELVE_AND_ONE_HALF("12 1/2\"", 12.50),
	TWELVE_AND_THREE_QUARTERS("12 3/4\"", 12.75),
	THIRTEEN("13\"", 13.00),
	THIRTEEN_AND_ONE_QUARTER("13 1/4\"", 13.25),
	THIRTEEN_AND_ONE_HALF("13 1/2\"", 13.50),
	THIRTEEN_AND_THREE_QUARTERS("13 3/4\"", 13.75),
	FOUTREEN("14\"", 14.00),
	FOUTREEN_AND_ONE_QUARTER("14 1/4\"", 14.25),
	FOUTREEN_AND_ONE_HALF("14 1/2\"", 14.50),
	FOUTREEN_AND_THREE_QUARTERS("14 3/4\"", 14.75),
	FIFTEEN("15\"", 15.00),
	FIFTEEN_AND_ONE_QUARTER("15 1/4\"", 15.25),
	FIFTEEN_AND_ONE_HALF("15 1/2\"", 15.50),
	FIFTEEN_AND_THREE_QUARTERS("15 3/4\"", 15.75),
	SIXTEEN("16\"", 16.00);
	
	private String _key;
	private Double _value;
	
	private RingSize(String key, Double value) {
		this._key = key;
		this._value = value;
	}
	
	public String key() {
		return this._key;
	}
	
	public Double value() {
		return this._value;
	}
	
	public static NSArray<RingSize> all() {
		return new NSArray<RingSize>(values());
	}
	
	public static RingSize make(int index) {
		return values()[index];	
	}

}