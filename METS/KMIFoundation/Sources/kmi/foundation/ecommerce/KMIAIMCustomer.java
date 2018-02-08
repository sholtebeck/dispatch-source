package kmi.foundation.ecommerce;

import com.webobjects.foundation.NSValidation;

import er.extensions.foundation.ERXStringUtilities;

public class KMIAIMCustomer {

    private String _firstName;
    private String _lastName;
    private String _addressOne;
    private String _addressTwo;
    private String _city;
    private String _region;
    private String _country;
    private String _zipCode;
    private String _phone;
    private String _email;

    public KMIAIMCustomer() {
    	
    }
    
    public KMIAIMCustomer(String firstName,
            String lastName,
            String address,
            String addressTwo,
            String city,
            String region,
            String country,
            String zipCode,
            String phone,
            String email) {
    	
    	this._firstName = firstName;
    	this._lastName = lastName;
    	this._addressOne = address;
    	this._addressTwo = addressTwo;
    	this._city = city;
    	this._region = region;
    	this._country = country;
    	this._zipCode = zipCode;
    	this._phone = phone;
    	this._email = email;
    	
    }

    public void validateForKey(String key) throws NSValidation.ValidationException {
    	
    }
    
    public String address() {
         String address = addressOne();
         if(! ERXStringUtilities.stringIsNullOrEmpty(addressTwo())) {
              address += " ";
              address += addressTwo();
         }
         return address;
    }
    
    public String fullName() {
    	return firstName() + " " + lastName();
    }
    
    public void setFirstName(String firstName) {
         this._firstName = firstName;
    }

    public String firstName() {
         return _firstName;
    }

    public void setLastName(String lastName) {
         this._lastName = lastName;
    }

    public String lastName() {
         return _lastName;
    }

    public void setAddressOne(String address) {
         this._addressOne = address;
    }

    public String addressOne() {
         return _addressOne;
    }

    public void setCity(String city) {
         this._city = city;
    }

    public String city() {
         return _city;
    }

    public void setRegion(String region) {
         this._region = region;
    }

    public String region() {
         return _region;
    }

    public void setCountry(String country) {
         this._country = country;
    }

    public String country() {
         return _country;
    }

    public void setZipCode(String zipCode) {
         this._zipCode = zipCode;
    }

    public String zipCode() {
         return _zipCode;
    }

    public void setPhone(String phone) {
         this._phone = phone;
    }

    public String phone() {
         return _phone;
    }

    public void setEmail(String email) {
         this._email = email;
    }

    public String email() {
         return _email;
    }

    public void setAddressTwo(String addressTwo) {
         this._addressTwo = addressTwo;
    }

    public String addressTwo() {
         return _addressTwo;
    }
    
}
