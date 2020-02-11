package com.tbf;

public class Email {
	
	private String address[];
	
	

	@Override
	public String toString() {
		return "Email [email=" + address + "]";
	}

	public Email(String[] email) {
		this.address = email;
	}

	public String[] getEmail() {
		return this.address;
	}

	public void setEmail(String[] email) {
		this.address = email;
	}
	
}
