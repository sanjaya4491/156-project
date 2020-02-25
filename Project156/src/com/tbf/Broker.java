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

	@Override
	public double getFee(List<Asset> assetList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCommission(List<Asset> assetList, Portfolio that) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
