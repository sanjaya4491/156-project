package com.tbf;

import java.util.ArrayList;
import java.util.List;

public class PortfolioReport {
	
	public static void main(String args[]) {
		
		List <Portfolio> portfolio = DataParser.parsePortfolioDataFile();
		List<Asset> assetList = DataParser.parseAssetDataFile();
		
		for(Portfolio x : portfolio) {
			List<String> assetCodes = new ArrayList<String>();
			for(String entry : x.getAssetList().keySet()) {
				assetCodes.add(entry);
			}
			List<Asset> tempAssets = new ArrayList<Asset>();
			for(String y : assetCodes) {
				for(Asset z : assetList) {
					if(y.compareTo(z.getCode()) == 0)  {
						tempAssets.add(z);
					}
				}
			}
			for(Asset a : tempAssets) {
				System.out.printf("%f\n", a.getAnnualReturn(x));
			}
		}
		  
		   
	
	
	}

}
