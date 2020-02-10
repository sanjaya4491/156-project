package com.tbf;

public class DepositAccount {
	
	private String code;
	private String type;
	private String label;
	private String apr;
	
	public DepositAccount(String code, String type, String label, String apr) {
		this.code = code;
		this.type = type;
		this.label = label;
		this.apr = apr;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setApr(String apr) {
		this.apr = apr;
	}

	public String getCode() {
		return this.code;
	}

	public String getType() {
		return this.type;
	}

	public String getLabel() {
		return this.label;
	}

	public String getApr() {
		return this.apr;
	}
	
	
	
	

}
