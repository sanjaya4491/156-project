package com.tbf;

import java.util.List;

public class PortfolioReport {

	public static void main(String args[]) {

		List<Portfolio> portfolio = null;
		List<Asset> assetList = null;
		List<Person> personList = null;

		PortfolioUtils.portfolioSummaryReport(portfolio, assetList, personList);
		PortfolioUtils.portfolioDetails(portfolio, assetList, personList);
	}
}
