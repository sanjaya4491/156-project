package com.tbf;

/**
 * This Asset class stores all the information on a generic asset 
 * 
 */

public abstract class Asset {
	protected String code;
	protected String type;
	protected String label;
	
	public Asset(String code, String type, String label) {
		this.code = code;
		this.type = type;
		this.label = label;
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

	/**
	 * abstract method to get the annual return of an asset
	 * @param that
	 * @return
	 */
	public abstract double getAnnualReturn();
	
	/**
	 * abstract method to get the return rate of an asset
	 * @param that
	 * @return
	 */
	public abstract double getReturnRate();
	
	/**
	 * abstract method to the the total value of an asset
	 * @param that
	 * @return
	 */
	public abstract double getTotal();
	
	/**
	 * abstract method to get the risk of an asset
	 * @return
	 */
	public abstract double getRisk();
	
	/**
	 * abstract method to set the asset value of an asset
	 * @param assetValue
	 * @return
	 */
	public abstract double setValue(double assetValue);
	
}
