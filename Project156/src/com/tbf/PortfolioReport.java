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

		SortedList<Portfolio> listSort = new SortedList<>(new Portfolio.OwnerNameComparator());
		List<Portfolio> list = DatabaseLoader.getAllPortfolio();

		SortedList<Portfolio> listSort1 = new SortedList<>(new Portfolio.TotalValueComparator());
		List<Portfolio> list1 = DatabaseLoader.getAllPortfolio();

		SortedList<Portfolio> listSort2 = new SortedList<>(new Portfolio.ManagerNameComparator());
		List<Portfolio> list2 = DatabaseLoader.getAllPortfolio();


		for(Portfolio p : list) {
			listSort.insert(p);
			//System.out.println(p);
		}

		for(Portfolio p1 : list1) {
			listSort1.insert(p1);
			//System.out.println(p1);
		}

		for(Portfolio p2 : list2) {
			listSort2.insert(p2);
		}


		//sorted with OwnerNameComparator
		PortfolioUtils.portfolioSummaryReport(listSort);

		//sorted with TotalValueComparator
		PortfolioUtils.portfolioSummaryReport(listSort1);

		//sorted with ManagerNameComparator
		PortfolioUtils.portfolioSummaryReport(listSort2);


	}
}
