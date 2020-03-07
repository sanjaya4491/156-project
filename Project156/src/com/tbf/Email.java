package com.tbf;

/**
 * This class stores a persons email
 */

public class Email {
	
	private String address;

	public Email(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return String.format("%s", this.address);
	}
	
	

}
