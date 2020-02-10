package com.tbf;

public class Person {
	
	private String personCode;
	private String broker;
	private String lastName;
	private String firstName;
	private Address address;
	private Email email;
	
	public Person(String personCode, String broker, String lastName, String firstName, Address address, Email email) {
		this.personCode = personCode;
		this.broker = broker;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.email = email;
	}
	
	
	public String getPersonCode() {
		return this.personCode;
	}


	public String getBroker() {
		return this.broker;
	}


	public String getLastName() {
		return this.lastName;
	}


	public String getFirstName() {
		return this.firstName;
	}


	public Address getAddress() {
		return this.address;
	}


	public Email getEmail() {
		return this.email;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
	public void setBroker(String broker) {
		this.broker = broker;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setEmail(Email email) {
		this.email = email;
	}

}
