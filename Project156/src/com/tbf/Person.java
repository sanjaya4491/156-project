package com.tbf;
/**
 * Persons class with their names, address, emails, broker, and personCode.
 */

import java.util.List;
public class Person {
	
	private String personCode;
	private String broker;
	private String section;
	private String lastName;
	private String firstName;
	private Address address;
	private List<Email> emails;

	public Person(String personCode, String broker, String section, String lastName, String firstName, Address address,
			List<Email> email) {
		this.personCode = personCode;
		this.broker = broker;
		this.section = section;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.emails = email;
	}
	
	
	@Override
	public String toString() {
		return "Person [personCode=" + personCode + ", broker=" + broker + ", section=" + section + ", lastName="
				+ lastName + ", firstName=" + firstName + ", address=" + address + ", email=" + emails + "]";
	}


	public String getPersonCode() {
		return this.personCode;
	}


	public String getBroker() {
		return this.broker;
	}
	

	public String getSection() {
		return section;
	}


	public void setSection(String section) {
		this.section = section;
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
	public void setEmail(List<Email> email) {
		this.emails = email;
	}

}
