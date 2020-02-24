package com.tbf;

import java.util.List;

public class PortfolioReport {
	
	public static void main(String args[]) {
		
		List <Portfolio> portfolio = DataParser.parsePortfolioDataFile();
		
		   for (Portfolio num : portfolio) { 		      
	           System.out.println(num); 		
	      }
	
	
	}

}
