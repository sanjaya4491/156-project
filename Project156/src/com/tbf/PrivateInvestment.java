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

	@Override
	public double getAnnualReturn() {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public double getAnnualReturn(Portfolio that) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}