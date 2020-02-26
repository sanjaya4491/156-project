package com.tbf;

/**
 * Persons class with their names, address, email's, broker, and personCode.
 */

import java.util.List;
public class Person {
	
	private String personCode;
	private Broker broker;
	private String lastName;
	private String firstName;
	private Address address;
	private List<Email> emails;

	public Person(String personCode, Broker broker, String lastName, String firstName, Address address,
			List<Email> email) {
		this.personCode = personCode;
		this.broker = broker;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.emails = email;
	}

	

	@Override
	public String toString() {
		return String.format("%s, %s", this.lastName, this.firstName);
	}



	public String getPersonCode() {
		return this.personCode;
	}


	public Broker getBroker() {
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


	public List<Email> getEmail() {
		return this.emails;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
	public void setBroker(Broker broker) {
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
	public void setEmail(List<Email> email) {
		this.emails = email;
	}
	
	

}
