package com.tbf;

public class Email {
	
	private String email;
	
	

	@Override
	public String toString() {
		return "Email [email=" + email + "]";
	}

	public Email(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
