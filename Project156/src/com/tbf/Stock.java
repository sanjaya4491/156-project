package com.tbf;
/**
 * This class stores all the informating about the stock for ex the name and the symbol and the price.
 */
public class Stock extends Asset {
	private String quarterlyDividend;
	private String baseReturn;
	private String betaMeasure;
	private String stockSymbol;
	private String sharePrice;
	
	public Stock(String code, String type, String label, String quarterlyDividend, String baseReturn,
			String betaMeasure, String stockSymbol, String sharePrice) {
		super(code, type, label);
		this.quarterlyDividend = quarterlyDividend;
		this.baseReturn = baseReturn;
		this.betaMeasure = betaMeasure;
		this.stockSymbol = stockSymbol;
		this.sharePrice = sharePrice;
	}

	public String getQuarterlyDividend() {
		return this.quarterlyDividend;
	}

	public void setQuarterlyDividend(String quarterlyDividend) {
		this.quarterlyDividend = quarterlyDividend;
	}

	public String getBaseReturn() {
		return this.baseReturn;
	}

	public void setBaseReturn(String baseReturn) {
		this.baseReturn = baseReturn;
	}

	public String getBetaMeasure() {
		return this.betaMeasure;
	}

	public void setBetaMeasure(String betaMeasure) {
		this.betaMeasure = betaMeasure;
	}

	public String getStockSymbol() {
		return this.stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public String getSharePrice() {
		return this.sharePrice;
	}

	public void setSharePrice(String sharePrice) {
		this.sharePrice = sharePrice;
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
	
}