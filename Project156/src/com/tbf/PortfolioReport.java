package com.tbf;

import java.util.List;

public class PortfolioReport {
	
	public static void main(String args[]) {
		
		List <Portfolio> portfolio = DataParser.parsePortfolioDataFile();
		List<Asset> assetList = DataParser.parseAssetDataFile();
		
		   for (Portfolio num : portfolio) {
			   for(Asset asset : assetList) {
				   num.getAssetList();
			   }
	           System.out.println(num);
	      }
		  
		   
	
	
	}

}
