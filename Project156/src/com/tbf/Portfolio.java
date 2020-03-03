package com.tbf;

/**
 * Class that holds information of a clients portfolio
 */
import java.util.List;
import java.util.Map;

public class Portfolio {

	private String portfolioCode;
	private Person owner;
	private Broker manager;
	private Person beneficiary;
	private Map<String, Double> assetList;

	public Portfolio(String portfolioCode, Person owner, Broker manager, Person beneficiary,
			Map<String, Double> assetList) {
		this.portfolioCode = portfolioCode;
		this.owner = owner;
		this.manager = manager;
		this.beneficiary = beneficiary;
		this.assetList = assetList;
	}

	public String getPortfolioCode() {
		return portfolioCode;
	}

	public void setPortfolioCode(String portfolioCode) {
		this.portfolioCode = portfolioCode;
	}

	public Person getOwner() {
		return this.owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public Broker getManager() {
		return manager;
	}

	public void setManager(Broker manager) {
		this.manager = manager;
	}

	public Person getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiaryCode(Person beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Map<String, Double> getAssetList() {
		return this.assetList;
	}

	public void setAssestList(Map<String, Double> assetList) {
		this.assetList = assetList;
	}

	/**
	 * This calculates the  value of all the assets in the portfolio.
	 */
	public static double getTotalPortfolioValue(List<Asset> assetList, Portfolio that) {
		double total = 0;
		for (Asset a : assetList) {
			total = total + a.getTotal(that);
		}
		return total;
	}
	
	/**
	 * This calculates risk of all assets in the portfolio.
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
	 * This gets the rateofReturn of  the assets in the portfolio.
	 */
	public static double getTotalRateOfReturn(List<Asset> assetList, Portfolio that) {
		double total = 0;
		for (Asset a : assetList) {
			total = total + a.getAnnualReturn(that);
		}
		return total;
	}

}
