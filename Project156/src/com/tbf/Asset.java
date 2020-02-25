package com.tbf;

import java.util.List;

/**
 * This Asset class stores all the information about the
 * including code, type, and label. 
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
	
	public abstract double getAnnualReturn(Portfolio that);
	
	public abstract double getReturnRate(Portfolio that);
	
	public abstract double getTotal(Portfolio that);
	
	public abstract double getRisk();
	
	public static double getTotalPortfolioValue(List<Asset> assetList, Portfolio that) {
		double total = 0;
		for(Asset a : assetList) {
			total = total + a.getTotal(that);
		}
		return total;
	}
	
	public static double getWeightedRisk(List<Asset> assetList, Portfolio that) {
		double totalRisk = 0;
		for(Asset a : assetList) {
			totalRisk = totalRisk + (a.getRisk() * (a.getTotal(that) / Asset.getTotalPortfolioValue(assetList, that)));
		}
		return totalRisk;
	}
	
	public static double getTotalRateOfReturn(List<Asset> assetList, Portfolio that) {
		double total = 0;
		for(Asset a : assetList) {
			total = total + a.getAnnualReturn(that);
		}
		return total;
	}
}
