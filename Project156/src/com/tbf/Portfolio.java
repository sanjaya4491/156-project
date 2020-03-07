package com.tbf;

/**
 * Class that holds information of a clients portfolio
 */
import java.util.List;

public class Portfolio {

	private String portfolioCode;
	private Person owner;
	private Broker manager;
	private Person beneficiary;
	private List<Asset> assetList;

	public Portfolio(String portfolioCode, Person owner, Broker manager, Person beneficiary,
			List<Asset> assetList) {
		this.portfolioCode = portfolioCode;
		this.owner = owner;
		this.manager = manager;
		this.beneficiary = beneficiary;
		this.assetList = assetList;
	}

	public String getPortfolioCode() {
		return portfolioCode;
	}

	public Person getOwner() {
		return this.owner;
	}

	public Broker getManager() {
		return manager;
	}

	public Person getBeneficiary() {
		return this.beneficiary;
	}

	public List<Asset> getAssetList() {
		return this.assetList;
	}

	/**
	 * This calculates the value of all the assets in the portfolio.
	 */
	public double getTotalPortfolioValue() {
		double total = 0;
		for (Asset a : this.assetList) {
			total = total + a.getTotal();
		}
		return total;
	}
	
	/**
	 * This calculates risk of all assets in the portfolio.
	 */
	public double getWeightedRisk() {
		double totalRisk = 0;
		for (Asset a : this.assetList) {
			totalRisk = totalRisk
					+ (a.getRisk() * (a.getTotal() / getTotalPortfolioValue()));
		}
		return totalRisk;
	}
	
	/**
	 * This gets the rateofReturn of all the assets in the portfolio.
	 */
	public double getTotalRateOfReturn() {
		double total = 0;
		for (Asset a : this.assetList) {
			total = total + a.getAnnualReturn();
		}
		return total;
	}

}
