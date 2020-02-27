package com.tbf;

/**
 * Class that holds methods that print summary's about portfolios to the standard output
 */
import java.util.ArrayList;
import java.util.List;

public class PortfolioUtils {
	
	/**
	 * Method thats lists of portfolios, assets, and people and prints the portfolio code, owner,
	 * manager, the fees and commissions for the manager, and the weighted risk, return, and total of each
	 * porfolio
	 * @param portfolio
	 * @param assetList
	 * @param personList
	 */
	public static void portfolioSummaryReport(List<Portfolio> portfolio, List<Asset> assetList,
			List<Person> personList) {
		//get lists from data files
		portfolio = DataParser.parsePortfolioDataFile();
		assetList = DataParser.parseAssetDataFile();
		personList = DataParser.parsePersonDataFile();
		
		//empty variables to store totals to print later
		double feesTotal = 0;
		double commisionsTotal = 0;
		double returnTotal = 0;
		double totalTotal = 0;

		System.out.println("Portfolio Summary Report");
		System.out.println(
				"============================================================================================================================================");
		System.out.println(String.format("%-10s %-20s %-26s %-16s %-16s %-16s %-16s %-16s", "Portfolio", "Owner",
				"Manager", "Fees", "Commisions", "Weighted Risk", "Return", "Total"));
		
		//iterate over each portfolio
		for (Portfolio x : portfolio) {
			//create list for the asset codes in the portfolio
			List<String> assetCodes = new ArrayList<String>();
			String ownerCode = x.getOwnerCode();
			String managerCode = x.getManagerCode();
			//initialize broker, owner, and manager
			Broker broker = null;
			Person owner = null;
			Person manager = null;
			//loop to get the asset codes
			for (String entry : x.getAssetList().keySet()) {
				assetCodes.add(entry);
			}
			//loop to get the manager and broker of the portfolio
			//use the person list to match them and get them
			for (Person p : personList) {
				if (p.getBroker() == null) {
				} else if (managerCode.compareTo(p.getPersonCode().toString()) == 0) {
					manager = p;
					broker = p.getBroker();
					break;
				}
			}
			//loop to get the owner of the portfolio
			//use the person list to match them and get them
			for (Person p : personList) {
				if (ownerCode.compareTo(p.getPersonCode().toString()) == 0) {
					owner = p;
					break;
				}
			}
			//create a list of assets in the portfolio
			List<Asset> tempAssets = new ArrayList<Asset>();
			//loop uses the asset codes and the asset list to match them and get them
			for (String y : assetCodes) {
				for (Asset z : assetList) {
					if (y.compareTo(z.getCode()) == 0) {
						tempAssets.add(z);
						break;
					}
				}
			}
			//adding the total for all the portfolios
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
	
	/**
	 * Method that uses lists of portfolios, assets and people.
	 * Prints detailed information about the portfolio that includes information on the
	 * owner, manager, beneficiary and the owners assets
	 * @param portfolio
	 * @param assetList
	 * @param personList
	 */
	public static void portfolioDetails(List<Portfolio> portfolio, List<Asset> assetList,
			List<Person> personList) {
		//get lists from data files
		portfolio = DataParser.parsePortfolioDataFile();
		assetList = DataParser.parseAssetDataFile();
		personList = DataParser.parsePersonDataFile();
		
		System.out.println("Portfolio Details");
		System.out.println("==================================================================================================================");
		//iterate for each portfolio
		for (Portfolio x : portfolio) {
			System.out.println("Portfolio " + x.getPortfolioCode());
			System.out.println("-------------------------------------------------------------");
			List<String> assetCodes = new ArrayList<String>();
			String ownerCode = x.getOwnerCode();
			String managerCode = x.getManagerCode();
			String beneficiaryCode = x.getBeneficiaryCode();
			//initialize owner, manager, and beneficiary
			Person owner = null;
			Person manager = null;
			Person beneficiary = null;
			//loop to get the asset codes
			for (String entry : x.getAssetList().keySet()) {
				assetCodes.add(entry);
			}
			//loop to get the manager of the portfolio
			//use the person list to match them and get them
			for (Person p : personList) {
				if (p.getBroker() == null) {
				} else if (managerCode.compareTo(p.getPersonCode().toString()) == 0) {
					manager = p;
					break;
				}
			}
			//loop to get the owner of the portfolio
			//use the person list to match them and get them
			for (Person p : personList) {
				if (ownerCode.compareTo(p.getPersonCode().toString()) == 0) {
					owner = p;
					break;
				}
			}
			//there could be no beneficary for the portfolio
			if(beneficiaryCode == null) {
				beneficiary = null;
			} else {
				//else use loop to get the beneficiary of the portfolio
				for (Person p : personList) {
					if (beneficiaryCode.compareTo(p.getPersonCode().toString()) == 0) {
						beneficiary = p;
						break;
					}
				}
			}
			//create a list of assets in the portfolio
			List<Asset> tempAssets = new ArrayList<Asset>();
			//loop uses the asset codes and the asset list to match them and get them
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
