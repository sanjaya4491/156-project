package com.tbf;

public class Stock {
	
	private String code;
	private String type;
	private String label;
	private String quarterlyDividend;
	private String baseReturn;
	private String betaMeasure;
	private String stockSymbol;
	private String sharePrice;
	
	public Stock(String code, String type, String label, String quarterlyDividend, String baseReturn, String betaMeasure,
			String stockSymbol, String sharePrice) {
		this.code = code;
		this.type = type;
		this.label = label;
		this.quarterlyDividend = quarterlyDividend;
		this.baseReturn = baseReturn;
		this.betaMeasure = betaMeasure;
		this.stockSymbol = stockSymbol;
		this.sharePrice = sharePrice;
	}

	@Override
	public String toString() {
		return "Stock [code=" + code + ", type=" + type + ", label=" + label + ", quarterlyDividend="
				+ quarterlyDividend + ", baseReturn=" + baseReturn + ", betaMeasure=" + betaMeasure + ", stockSymbol="
				+ stockSymbol + ", sharePrice=" + sharePrice + "]";
	}

	public String getCode() {
		return this.code;
	}

	public String getLabel() {
		return label;
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

	public String getBetaMeasure() {
		return this.betaMeasure;
	}

	public String getStockSymbol() {
		return this.stockSymbol;
	}

	public String getSharePrice() {
		return this.sharePrice;
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

	public void setQuarterlyDividend(String quarterlyDividend) {
		this.quarterlyDividend = quarterlyDividend;
	}

	public void setBaseReturn(String baseReturn) {
		this.baseReturn = baseReturn;
	}

	public void setBetaMeasure(String betaMeasure) {
		this.betaMeasure = betaMeasure;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public void setSharePrice(String sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	

}
