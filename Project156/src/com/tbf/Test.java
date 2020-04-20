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
		
		SortedList<Portfolio> listSort = new SortedList<>(new Portfolio.TotalValueComparator());
		List<Portfolio> list = DataParser.parsePortfolioDataFile();


		List<Portfolio> list1 = DataParser.parsePortfolioDataFile();
		SortedList<Portfolio> listSort1 = new SortedList<> (new Portfolio.OwnerNameComparator());


		List<Portfolio> list2 = DataParser.parsePortfolioDataFile();
		SortedList<Portfolio> listSort2 = new SortedList<> (new Portfolio.ManagerNameComparator());


		for(Portfolio p : list) {
			listSort.insert(p);
			//System.out.println(p);
		}
		
		System.out.println();

		for(Portfolio p1 : list1) {
			listSort1.insert(p1);
			//System.out.println(p1);
		}

		System.out.println();


		for(Portfolio p2 : list2) {
			listSort2.insert(p2);
			//System.out.println(p1);
		}

		System.out.println();

		System.out.println("Sorted by Total value comparator");
		System.out.println();
		listSort.print();

		System.out.println();
		System.out.println("Sorted by Owner name comparator");
		System.out.println();
		listSort1.print();

		System.out.println();
		System.out.println("Sorted by manager name comparator");
		System.out.println();
		listSort2.print();
	}

}
