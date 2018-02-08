package kmi.foundation.ecommerce;

import kmi.foundation.extensions.KMIStringUtilities;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.foundation.ERXTimestampUtilities;

public class KMICreditCard {

	private String _creditCardHolder;
	private String _creditCardNumber;
	private String _expirationMonth;
	private String _expirationYear;
	private String _securityID;

	public static NSArray<String> months = new NSArray<String>(new String[] {
			"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"     
	});

	public KMICreditCard() {

	}

	public KMICreditCard(String creditCardHolder,
			String creditCardNumber,
			String expirationMonth,
			String expirationYear,
			String securityID) {

		_creditCardHolder = creditCardHolder;
		_creditCardNumber = creditCardNumber;
		_expirationMonth = expirationMonth;
		_expirationYear = expirationYear;
		_securityID = securityID;

	}

	public String creditCardNumberHidden() {
		StringBuilder sb = new StringBuilder();
		if(creditCardNumber().length() > 4) {
			for(int i = 0; i < creditCardNumber().length() - 4; i++) {
				sb.append("X");
			}
			sb.append(creditCardNumber().substring(creditCardNumber().length() - 4, creditCardNumber().length()));
		} else {
			sb.append(creditCardNumber());
		}
		return sb.toString();
	}

	public String expirationDate() {

		String expirationDate = "";
		int expirationMonth = -1;

		if(KMIStringUtilities.isDigitsOnly(expirationMonth())) {
			expirationMonth = Integer.valueOf(expirationMonth());
		} else {
			expirationMonth = months.indexOf(expirationMonth()) + 1;
		}
		expirationDate += expirationMonth < 10 ? "0" : "";
		expirationDate += expirationMonth;
		expirationDate += expirationYear();

		return expirationDate;
	}

	public String formattedExpirationDate() {
		String expirationDate = expirationDate();
		StringBuilder sb = new StringBuilder();
		sb.append(expirationDate.substring(0, 2));
		sb.append("/");
		sb.append(expirationDate.substring(2));
		return sb.toString();
	}

	public void setCreditCardHolder(String creditCardHolder) {
		this._creditCardHolder = creditCardHolder;
	}

	public String creditCardHolder() {
		return _creditCardHolder;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this._creditCardNumber = creditCardNumber;
	}

	public String creditCardNumber() {
		return _creditCardNumber;
	}

	public void setExpirationMonth(String expirationMonth) {
		this._expirationMonth = expirationMonth;
	}

	public String expirationMonth() {
		if(_expirationMonth == null) {
			_expirationMonth = String.valueOf(ERXTimestampUtilities.monthOfYear(new NSTimestamp()));
		}
		return _expirationMonth;
	}

	public void setExpirationYear(String expirationYear) {
		this._expirationYear = expirationYear;
	}

	public String expirationYear() {
		if(_expirationYear == null) {
			_expirationYear = String.valueOf(ERXTimestampUtilities.yearOfCommonEra(new NSTimestamp())).substring(2, 4);
		}
		return _expirationYear;
	}

	public void setSecurityID(String securityID) {
		this._securityID = securityID;
	}

	public String securityID() {
		return _securityID;
	}

}
