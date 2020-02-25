package com.tbf;

/**
 * This Stores the the deposit account of the assets a
 * and gets the apr.
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

	@Override
	public double getAnnualReturn(Portfolio that) {
		// TODO Auto-generated method stub
		String assetCode = this.getCode(); 
		Double assetValue = that.getAssetList().get(assetCode);
		System.out.println(assetCode);
		return ((Math.pow (Math.E, (Double.parseDouble(this.getApr()))/100)) - 1) * assetValue ;
	}

	@Override
	public double getReturnRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRisk() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}