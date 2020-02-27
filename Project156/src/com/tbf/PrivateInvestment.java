package com.tbf;
/**
 * This class has the total value of the investment , qurterlyDividend, baseReturn, and baseOmegaMeasure.
 */
public class PrivateInvestment extends Asset {
	
	private String quarterlyDividend;
	private String baseReturn;
	private String baseOmegaMeasure;
	private String totalValue;
	
	public PrivateInvestment(String code, String type, String label, String quarterlyDividend, String baseReturn,
			String baseOmegaMeasure, String totalValue) {
		super(code, type, label);
		this.quarterlyDividend = quarterlyDividend;
		this.baseReturn = baseReturn;
		this.baseOmegaMeasure = baseOmegaMeasure;
		this.totalValue = totalValue;
	}

	public String getQuarterlyDividend() {
		return this.quarterlyDividend;
	}

	public void setQuarterlyDividend(String quarterlyDividend) {
	}

	public String getBaseReturn() {
		return this.baseReturn;
	}

	public void setBaseReturn(String baseReturn) {
		this.baseReturn = baseReturn;
	}

	public String getBaseOmegaMeasure() {
		return this.baseOmegaMeasure;
	}

	public void setBaseOmegaMeasure(String baseOmegaMeasure) {
		this.baseOmegaMeasure = baseOmegaMeasure;
	}

	public String getTotalValue() {
		return this.totalValue;
	}

	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}
	
	/**
	 * Method that return the annual return of a private investment given the portfolio
	 */
	@Override
	public double getAnnualReturn(Portfolio that) {
		String assetCode = this.getCode(); 
		Double assetValue = that.getAssetList().get(assetCode);
		return ((((Double.parseDouble(this.getBaseReturn()) / 100) * Double.parseDouble(this.getTotalValue())) + 
				(4 * Double.parseDouble(this.getQuarterlyDividend()))) * (assetValue / 100));
	}
	
	/**
	 * Method that returns the return rate of a private investment given a portfolio
	 */
	@Override
	public double getReturnRate(Portfolio that) {
		String assetCode = this.getCode(); 
		Double assetValue = that.getAssetList().get(assetCode);
		double annualReturn = this.getAnnualReturn(that);
		return (annualReturn / (Double.parseDouble(this.getTotalValue()) * (assetValue / 100))) * 100;
	}
	
	/**
	 * Method that returns the total value of a private investment given a portfolio
	 */
	@Override
	public double getTotal(Portfolio that) {
		String assetCode = this.getCode(); 
		Double assetValue = that.getAssetList().get(assetCode);
		return Double.parseDouble(this.getTotalValue()) * (assetValue / 100);
	}
	
	/**
	 * Method that returns the risk of a private investment given a portfolio
	 */
	@Override
	public double getRisk() {
		return (Double.parseDouble(this.getBaseOmegaMeasure()) + Math.pow(Math.E, (-125500 / Double.parseDouble(this.getTotalValue()))));
	}
	
}