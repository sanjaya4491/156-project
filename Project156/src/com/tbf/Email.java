package com.tbf;

/**
 * This class stores the lists of persons emails
 */
public class Email {
	
	private String address;

	public Email(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return String.format("%s", this.address);
	}
	
	

}
