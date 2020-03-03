package com.tbf;

import java.util.List;

public class Broker extends Person implements Payable {
	
	private String title;
	private String section;
	
	public Broker(String personCode, String lastName, String firstName, Address address, List<Email> email,
			String title, String section) {
		super(personCode, lastName, firstName, address, email);
		this.title = title;
		this.section = section;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSection() {
		return this.section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	/**
	 * This method gets the fees for the broker
	 * An expert broker has 0 fees
	 */
	@Override
	public double getFee(List<Asset> assetList) {
		return 0;
	}

	/**
	 * This method gets the commission for the broker
	 */
	@Override
	public double getCommission(List<Asset> assetList, Portfolio that) {
		return 0;
	}
	
}
