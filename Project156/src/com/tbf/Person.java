package com.tbf;

/**
 * Persons class with their names, address, email's, broker, and personCode.
 */

import java.util.List;
public class Person {
	
	private String personCode;
	private String lastName;
	private String firstName;
	private Address address;
	private List<Email> emails;

	public Person(String personCode, String lastName, String firstName, Address address,
			List<Email> email) {
		this.personCode = personCode;
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

}
