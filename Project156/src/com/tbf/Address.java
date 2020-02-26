package com.tbf;

/**
 * This "Address" class stores the Address of a person. That contains thier
 * street, city, state, zipcode and their country
 */

public class Address {
	
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	
	public Address(String street, String city, String state, String zipCode, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}

	

	@Override
	public String toString() {
		return String.format("%s, %s %s %s", this.getCity(), this.getState(), this.getCountry(), this.getZipCode());
	}



	public String getStreet() {
		return this.street;
	}

	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public String getCountry() {
		return this.country;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
