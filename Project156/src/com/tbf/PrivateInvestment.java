package com.tbf;

public class PrivateInvestment {
	
	private String code;
	private String type;
	private String quarterlyDividend;
	private String baseReturn;
	private String baseOmegaMeasure;
	private String totalValue;
	
	public PrivateInvestment(String code, String type, String quarterlyDividend, String baseReturn,
			String baseOmegaMeasure, String totalValue) {
		this.code = code;
		this.type = type;
		this.quarterlyDividend = quarterlyDividend;
		this.baseReturn = baseReturn;
		this.baseOmegaMeasure = baseOmegaMeasure;
		this.totalValue = totalValue;
	}

	public String getCode() {
		return this.code;
	}

	public String getType() {
		return this.type;
	}

	public String getQuarterlyDividend() {
		return this.quarterlyDividend;
	}

	public String getBaseReturn() {
		return this.baseReturn;
	}

	public String getBaseOmegaMeasure() {
		return this.baseOmegaMeasure;
	}

	public String getTotalValue() {
		return this.totalValue;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setQuarterlyDividend(String quarterlyDividend) {
		this.quarterlyDividend = quarterlyDividend;
	}

	public void setBaseReturn(String baseReturn) {
		this.baseReturn = baseReturn;
	}

	public void setBaseOmegaMeasure(String baseOmegaMeasure) {
		this.baseOmegaMeasure = baseOmegaMeasure;
	}

	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}
	
	
	
	
	
	

}
