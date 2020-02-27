package com.tbf;

/**
 * This Asset class stores all the information on a generic asset 
 * 
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
	
	/**
	 * abstract method to get the annual return of an asset
	 * @param that
	 * @return
	 */
	public abstract double getAnnualReturn(Portfolio that);
	
	/**
	 * abstract method to get the return rate of an asset
	 * @param that
	 * @return
	 */
	public abstract double getReturnRate(Portfolio that);
	
	/**
	 * abstract method to the the total value of an asset
	 * @param that
	 * @return
	 */
	public abstract double getTotal(Portfolio that);
	
	/**
	 * abstract method to get the risk of an asset
	 * @return
	 */
	public abstract double getRisk();
	
}
