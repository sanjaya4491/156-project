package com.tbf;

import java.util.List;

public class Test {

	public static void main(String args[]) {

		//PortfolioData.addEmail("YMCA", "HELLODANIEL@nnnnn.com");
		//PortfolioData.addPerson("NNNN", "Howard", "Stark", "llll", "llll", "llll", "68025", "llll", null, null);
		//PortfolioData.addDepositAccount("YMCA", "DANIEL DA", .5);
		//PortfolioData.addPrivateInvestment("YOLO", "DANIEL PI", 500., .2, .3, 10000.);
		//PortfolioData.addStock("LLLL", "DANIEL STOCK", 777., .5, .1, "IDGAF", 12345.);
		//PortfolioData.addPortfolio("PT005", "AAAA", "BBBB", "CCCC");
		//PortfolioData.addAsset("PT001", "google", 50);
		//PortfolioData.removePerson("UIMG");
		//PortfolioData.removeAllPersons();
		//PortfolioData.removeAsset("apple");
		//PortfolioData.removeAllAssets();
		//PortfolioData.removePortfolio("PT002");
		//PortfolioData.removeAllPortfolios();
		SortedList<Portfolio> listSort = new SortedList<>(new Portfolio.ManagerNameComparator());
		List<Portfolio> list = DataParser.parsePortfolioDataFile();
		for(Portfolio p : list) {
			listSort.insert(p);
			System.out.println(p);
		}
		System.out.println();
		listSort.print();
	}

}
