package com.tbf;

/**
 * Class that produces a report on the portfolio's
 */

import java.util.List;

public class PortfolioReport {
	
	/**
	 * main to retrieve the portfolio list and create the summary of it
	 * @param args
	 */
	public static void main(String args[]) {

		List<Portfolio> portfolio = DataParser.parsePortfolioDataFile();
		
		PortfolioUtils.portfolioSummaryReport(portfolio);
		PortfolioUtils.portfolioDetails(portfolio);
	}
}
