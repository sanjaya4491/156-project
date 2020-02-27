package com.tbf;

/**
 * Class that produces a report on the portfolio's
 */

import java.util.List;

public class PortfolioReport {

	public static void main(String args[]) {

		List<Portfolio> portfolio = DataParser.parsePortfolioDataFile();
		List<Asset> assetList = DataParser.parseAssetDataFile();

		PortfolioUtils.portfolioSummaryReport(portfolio, assetList);
		PortfolioUtils.portfolioDetails(portfolio, assetList);
	}
}
