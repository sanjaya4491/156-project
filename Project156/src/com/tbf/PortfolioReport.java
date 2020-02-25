package com.tbf;

import java.util.ArrayList;
import java.util.List;

public class PortfolioReport {

	public static void main(String args[]) {
		
		List <Portfolio> portfolio = DataParser.parsePortfolioDataFile();
		List<Asset> assetList = DataParser.parseAssetDataFile();
		List<Person> personList = DataParser.parsePersonDataFile();
		
		for(Portfolio x : portfolio) {
			List<String> assetCodes = new ArrayList<String>();
			String manager = x.getManagerCode();
			Broker broker = null;
			for(String entry : x.getAssetList().keySet()) {
				assetCodes.add(entry);
			}
			for(Person p : personList) {
				if(p.getBroker() == null) {
				} else if(manager.compareTo(p.getPersonCode().toString()) == 0) {
					broker = p.getBroker();
					break;
				}
			}
			List<Asset> tempAssets = new ArrayList<Asset>();
			for(String y : assetCodes) {
				for(Asset z : assetList) {
					if(y.compareTo(z.getCode()) == 0)  {
						tempAssets.add(z);
						break;
					}
				}
			}
			System.out.println("===============================================");
			if (tempAssets.isEmpty() == true) {
				System.out.println("0, 0, 0, 0, 0, 0, 0");
			} else {
				for (Asset a : tempAssets) {
					System.out.println(a.getCode());
					System.out.printf("%f, %f, %f, %f, %f, %f, %f\n", a.getAnnualReturn(x), a.getReturnRate(x),
							a.getTotal(x), a.getRisk(), Asset.getTotalPortfolioValue(tempAssets, x),
							Asset.getWeightedRisk(tempAssets, x), Asset.getTotalRateOfReturn(tempAssets, x));
				}
			}
			System.out.printf("%f, %f\n", broker.getFee(tempAssets), broker.getCommission(tempAssets, x));
		}

	}

}
