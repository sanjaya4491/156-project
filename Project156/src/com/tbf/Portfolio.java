package com.tbf;

import java.util.List;
import java.util.Map;

public class Portfolio {

	private String portfolioCode;
	private String ownerCode;
	private String managerCode;
	private String beneficiaryCode;
	private Map<String, Double> assetList;

	public Portfolio(String portfolioCode, String ownerCode, String managerCode, String beneficiaryCode,
			Map<String, Double> assetList) {
		this.portfolioCode = portfolioCode;
		this.ownerCode = ownerCode;
		this.managerCode = managerCode;
		this.beneficiaryCode = beneficiaryCode;
		this.assetList = assetList;
	}

	public String getPortfolioCode() {
		return portfolioCode;
	}

	public void setPortfolioCode(String portfolioCode) {
		this.portfolioCode = portfolioCode;
	}

	public String getOwnerCode() {
		return ownerCode;
	}

	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}

	public String getManagerCode() {
		return managerCode;
	}

	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	public String getBeneficiaryCode() {
		return beneficiaryCode;
	}

	public void setBeneficiaryCode(String beneficiaryCode) {
		this.beneficiaryCode = beneficiaryCode;
	}

	public Map<String, Double> getAssetList() {
		return assetList;
	}

	public void setAssestList(Map<String, Double> assetList) {
		this.assetList = assetList;
	}

	/**
	 * This calculates the  value of all the asset in the portfolio.
	 */
	public static double getTotalPortfolioValue(List<Asset> assetList, Portfolio that) {
		double total = 0;
		for (Asset a : assetList) {
			total = total + a.getTotal(that);
		}
		return total;
	}
	
	/**
	 * This calculates risk of  the asset in the portfolio.
	 */
	public static double getWeightedRisk(List<Asset> assetList, Portfolio that) {
		double totalRisk = 0;
		for (Asset a : assetList) {
			totalRisk = totalRisk
					+ (a.getRisk() * (a.getTotal(that) / Portfolio.getTotalPortfolioValue(assetList, that)));
		}
		return totalRisk;
	}
	/**
	 * This gets the rateofReturn of  the asset in the portfolio.
	 */
	public static double getTotalRateOfReturn(List<Asset> assetList, Portfolio that) {
		double total = 0;
		for (Asset a : assetList) {
			total = total + a.getAnnualReturn(that);
		}
		return total;
	}

}
