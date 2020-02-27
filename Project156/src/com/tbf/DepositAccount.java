package com.tbf;

/**
 * This Stores the the deposit account of the assets
 */

public class DepositAccount extends Asset {

	private String apr;

	public DepositAccount(String code, String type, String label, String apr) {
		super(code, type, label);
		this.apr = apr;
	}

	public String getApr() {
		return this.apr;
	}

	public void setApr(String apr) {
		this.apr = apr;
	}
	
	/**
	 * This method returns a annualReturn of a deposit account
	 */
	@Override
	public double getAnnualReturn(Portfolio that) {
		Double assetValue = this.getTotal(that);
		return ((Math.pow (Math.E, (Double.parseDouble(this.getApr()))/100)) - 1) * assetValue ;
	}

	/**
	 * This method returns a returnRate of a deposit account
	 */
	@Override
	public double getReturnRate(Portfolio that) {
		Double assetValue = this.getTotal(that);
		double annualReturn = this.getAnnualReturn(that);
		return (annualReturn / assetValue) * 100;
	}

	/**
	 * This method returns the value of a deposit account
	 */
	@Override
	public double getTotal(Portfolio that) {
		String assetCode = this.getCode(); 
		Double assetValue = that.getAssetList().get(assetCode);
		return assetValue;
	}

	/**
	 * This method returns the risk of a deposit account.
	 * Risk is always 0 for a deposit account
	 */
	@Override
	public double getRisk() {
		return 0;
	}
	
}