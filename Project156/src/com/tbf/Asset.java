package com.tbf;

/**
 * This Asset class stores all the information about the
 * including code, type, and label. 
 */

public abstract class Asset {
	private String code;
	private String type;
	private String label;
	
	public Asset(String code, String type, String label) {
		this.code = code;
		this.type = type;
		this.label = label;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public abstract double getAnnualReturn();
	
	public abstract double getReturnRate();
	
	public abstract double getTotal();
	
	public abstract double getRisk();

}
