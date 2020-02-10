package com.tbf;

public class Stock {
	
	private String code;
	private String type;
	private String quarterlyDividend;
	private String baseReturn;
	private String betaMeasure;
	private String stockSymbol;
	private String sharePrice;
	
	public Stock(String code, String type, String quarterlyDividend, String baseReturn, String betaMeasure,
			String stockSymbol, String sharePrice) {
		this.code = code;
		this.type = type;
		this.quarterlyDividend = quarterlyDividend;
		this.baseReturn = baseReturn;
		this.betaMeasure = betaMeasure;
		this.stockSymbol = stockSymbol;
		this.sharePrice = sharePrice;
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
