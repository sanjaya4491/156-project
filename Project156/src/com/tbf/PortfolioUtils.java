package com.tbf;

import java.util.ArrayList;
import java.util.List;

public class PortfolioUtils {
	
	public static void portfolioSummaryReport(List<Portfolio> portfolio, List<Asset> assetList,
			List<Person> personList) {
		portfolio = DataParser.parsePortfolioDataFile();
		assetList = DataParser.parseAssetDataFile();
		personList = DataParser.parsePersonDataFile();

		double feesTotal = 0;
		double commisionsTotal = 0;
		double returnTotal = 0;
		double totalTotal = 0;

		System.out.println("Portfolio Summary Report");
		System.out.println(
				"============================================================================================================================================");
		System.out.println(String.format("%-10s %-20s %-26s %-16s %-16s %-16s %-16s %-16s", "Portfolio", "Owner",
				"Manager", "Fees", "Commisions", "Weighted Risk", "Return", "Total"));

		for (Portfolio x : portfolio) {
			List<String> assetCodes = new ArrayList<String>();
			String ownerCode = x.getOwnerCode();
			String managerCode = x.getManagerCode();
			Broker broker = null;
			Person owner = null;
			Person manager = null;
			for (String entry : x.getAssetList().keySet()) {
				assetCodes.add(entry);
			}
			for (Person p : personList) {
				if (p.getBroker() == null) {
				} else if (managerCode.compareTo(p.getPersonCode().toString()) == 0) {
					manager = p;
					broker = p.getBroker();
					break;
				}
			}
			for (Person p : personList) {
				if (ownerCode.compareTo(p.getPersonCode().toString()) == 0) {
					owner = p;
					break;
				}
			}
			List<Asset> tempAssets = new ArrayList<Asset>();
			for (String y : assetCodes) {
				for (Asset z : assetList) {
					if (y.compareTo(z.getCode()) == 0) {
						tempAssets.add(z);
						break;
					}
				}
			}
			feesTotal += broker.getFee(tempAssets);
			commisionsTotal += broker.getCommission(tempAssets, x);
			returnTotal += Portfolio.getTotalRateOfReturn(tempAssets, x);
			totalTotal += Portfolio.getTotalPortfolioValue(tempAssets, x);

			System.out.printf("%-10s %-20s %-20s %-5s %-10.2f %-5s %-10.2f %-5s %-10.4f %-5s %-10.2f %-5s %-10.2f\n",
					x.getPortfolioCode(), owner.toString(), manager.toString(), "$", broker.getFee(tempAssets), "$",
					broker.getCommission(tempAssets, x), "$", Portfolio.getWeightedRisk(tempAssets, x), "$",
					Portfolio.getTotalRateOfReturn(tempAssets, x), "$", Portfolio.getTotalPortfolioValue(tempAssets, x), "$",
					Portfolio.getWeightedRisk(tempAssets, x), "$", Portfolio.getTotalRateOfReturn(tempAssets, x));
		}

		System.out.println(
				"                                                     ========================================================================================");

		System.out.printf(" %50s  $  %10.2f    $ %12.2f   %18s %13.2f  $ %14.2f\n\n\n", "Total", feesTotal, commisionsTotal,
				"$", returnTotal, totalTotal);
	}
	
	public static void portfolioDetails(List<Portfolio> portfolio, List<Asset> assetList,
			List<Person> personList) {
		portfolio = DataParser.parsePortfolioDataFile();
		assetList = DataParser.parseAssetDataFile();
		personList = DataParser.parsePersonDataFile();
		
		System.out.println("Portfolio Details");
		System.out.println("==================================================================================================================");
		for (Portfolio x : portfolio) {
			System.out.println("Portfolio " + x.getPortfolioCode());
			System.out.println("-------------------------------------------------------------");
			List<String> assetCodes = new ArrayList<String>();
			String ownerCode = x.getOwnerCode();
			String managerCode = x.getManagerCode();
			String beneficiaryCode = x.getBeneficiaryCode();
			Person owner = null;
			Person manager = null;
			Person beneficiary = null;
			for (String entry : x.getAssetList().keySet()) {
				assetCodes.add(entry);
			}
			for (Person p : personList) {
				if (p.getBroker() == null) {
				} else if (managerCode.compareTo(p.getPersonCode().toString()) == 0) {
					manager = p;
					break;
				}
			}
			for (Person p : personList) {
				if (ownerCode.compareTo(p.getPersonCode().toString()) == 0) {
					owner = p;
					break;
				}
			}
			if(beneficiaryCode == null) {
				beneficiary = null;
			} else {
				for (Person p : personList) {
					if (beneficiaryCode.compareTo(p.getPersonCode().toString()) == 0) {
						beneficiary = p;
						break;
					}
				}
			}
			List<Asset> tempAssets = new ArrayList<Asset>();
			for (String y : assetCodes) {
				for (Asset z : assetList) {
					if (y.compareTo(z.getCode()) == 0) {
						tempAssets.add(z);
						break;
					}
				}
			}
			System.out.println("Owner:");
			System.out.println(owner.toString());
			System.out.println(owner.getEmail().toString());
			System.out.println(owner.getAddress().getStreet());
			System.out.println(owner.getAddress().toString());
			System.out.println("Manager:");
			System.out.println(manager.toString());
			System.out.println("Beneficiary:");
			if(beneficiary == null) {
				System.out.println("none");
			} else if(beneficiary.getBroker() != null) {
				System.out.println(beneficiary.toString());
				if(beneficiary.getBroker().getTitle().equals("J") == true) {
					System.out.println("Junior Broker");
				} else {
					System.out.println("Expert Broker");
				}
				System.out.println(beneficiary.getEmail().toString());
				System.out.println(beneficiary.getAddress().getStreet());
				System.out.println(beneficiary.getAddress().toString());
			} else if(beneficiary.getBroker() == null) {
				System.out.println(beneficiary.toString());
				System.out.println(beneficiary.getEmail());
				System.out.println(beneficiary.getAddress().getStreet());
				System.out.println(beneficiary.getAddress().toString());
			}
			System.out.println("Assets");
			System.out.println(String.format("%-10s %-38s %-23s %-10s %-27s %-16s", "Code", "Asset",
					"Return Rate", "Risk", "Annual Return", "Value"));
			for(Asset a : tempAssets) {
				System.out.printf("%-10s %-30s %17.2f %%  %15.2f  $ %16.2f  $ %16.2f\n", a.getCode(), a.getLabel(), a.getReturnRate(x), a.getRisk(),a.getAnnualReturn(x), a.getTotal(x));
			}
			System.out.println();
			System.out.println("                                                    ---------------------------------------------------------------------");
			System.out.printf("%60s %17.4f  $  %15.2f  $  %15.2f", "Totals" ,Portfolio.getWeightedRisk(tempAssets, x) , Portfolio.getTotalRateOfReturn(tempAssets, x) , Portfolio.getTotalPortfolioValue(tempAssets, x));
			System.out.println();


		}
	}

}
