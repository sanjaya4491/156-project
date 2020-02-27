package com.tbf;

import java.util.List;

public class Broker implements Payable {
	
	private String title;
	private String section;
	
	public Broker(String title, String section) {
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
