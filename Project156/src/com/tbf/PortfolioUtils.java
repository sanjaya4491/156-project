package com.tbf;

/**
 * Class that holds methods that print summary's about portfolio's to the standard output
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortfolioUtils {
	
	/**
	 * Method thats lists of portfolios, assets, and people and prints the portfolio code, owner,
	 * manager, the fees and commissions for the manager, and the weighted risk, return, and total of each
	 * portfolio
	 * @param portfolio
	 * @param assetList
	 * @param personList
	 */
	public static void portfolioSummaryReport(List<Portfolio> portfolioList, List<Asset> assetList) {
		
		//empty variables to store totals to print later
		double feesTotal = 0;
		double commisionsTotal = 0;
		double returnTotal = 0;
		double totalTotal = 0;
		
		//create a map for all the assets in the asset file
		Map<String, Asset> assetMap = new HashMap<String, Asset>();
		for(Asset a : assetList) {
			String assetCode = a.getCode();
			assetMap.put(assetCode, a);
		}

		System.out.println("Portfolio Summary Report");
		System.out.println(
				"============================================================================================================================================");
		System.out.println(String.format("%-10s %-20s %-26s %-16s %-13s %-19s %-16s %-16s", "Portfolio", "Owner",
				"Manager", "Fees", "Commisions", "Weighted Risk", "Return", "Total"));
		
		//iterate over each portfolio
		for (Portfolio portfolio : portfolioList) {
			//create list for the asset codes in the portfolio
			List<String> assetCodes = new ArrayList<String>();
			//loop to get the asset codes
			for (String entry : portfolio.getAssetList().keySet()) {
				assetCodes.add(entry);
			}
			//create a list of assets in the portfolio
			List<Asset> portfolioAssets = new ArrayList<Asset>();
			//for each code in the asset codes list, find it in the map with all the assets
			//and put it into the portfolio assets list
			for(String code : assetCodes) {
				Asset asset = assetMap.get(code);
				portfolioAssets.add(asset);
			}
			//adding the cumulative totals for all the portfolios
			feesTotal += portfolio.getManager().getFee(portfolioAssets);
			commisionsTotal += portfolio.getManager().getCommission(portfolioAssets, portfolio);
			returnTotal += Portfolio.getTotalRateOfReturn(portfolioAssets, portfolio);
			totalTotal += Portfolio.getTotalPortfolioValue(portfolioAssets, portfolio);

			System.out.printf("%-10s %-20s %-20s %-5s %-10.2f %-5s %-13.2f %-13.4f %-5s %-10.2f %-5s %-10.2f\n",
					portfolio.getPortfolioCode(), portfolio.getOwner().toString(), portfolio.getManager().toString(), "$", portfolio.getManager().getFee(portfolioAssets), "$",
					portfolio.getManager().getCommission(portfolioAssets, portfolio), Portfolio.getWeightedRisk(portfolioAssets, portfolio), "$",
					Portfolio.getTotalRateOfReturn(portfolioAssets, portfolio), "$", Portfolio.getTotalPortfolioValue(portfolioAssets, portfolio), "$",
					Portfolio.getWeightedRisk(portfolioAssets, portfolio), "$", Portfolio.getTotalRateOfReturn(portfolioAssets, portfolio));
		}

		System.out.println(
				"                                                     ========================================================================================");

		System.out.printf(" %50s  $ %10.2f     $ %10.2f   %20s %12.2f   $ %12.2f\n\n\n", "Total", feesTotal, commisionsTotal,
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
	public static void portfolioDetails(List<Portfolio> portfolioList, List<Asset> assetList) {
		
		System.out.println("Portfolio Details");
		System.out.println("==================================================================================================================");
		//create a map for all the assets in the asset file
		Map<String, Asset> assetMap = new HashMap<String, Asset>();
		for(Asset a : assetList) {
			String assetCode = a.getCode();
			assetMap.put(assetCode, a);
		}
		//iterate for each portfolio
		for (Portfolio portfolio : portfolioList) {
			System.out.println("Portfolio " + portfolio.getPortfolioCode());
			System.out.println("-------------------------------------------------------------");
			//create list for the asset codes in the portfolio
			List<String> assetCodes = new ArrayList<String>();
			//loop to get the asset codes
			for (String entry : portfolio.getAssetList().keySet()) {
				assetCodes.add(entry);
			}
			//create a list of assets in the portfolio
			List<Asset> portfolioAssets = new ArrayList<Asset>();
			//for each code in the asset codes list, find it in the map with all the assets
			//and put it into the portfolio assets list
			for(String code : assetCodes) {
				Asset asset = assetMap.get(code);
				portfolioAssets.add(asset);
			}
			System.out.println("Owner:");
			System.out.println(portfolio.getOwner().toString());
			System.out.println(portfolio.getOwner().getEmail().toString());
			System.out.println(portfolio.getOwner().getAddress().getStreet());
			System.out.println(portfolio.getOwner().getAddress().toString());
			System.out.println("Manager:");
			System.out.println(portfolio.getManager().toString());
			System.out.println("Beneficiary:");
			if(portfolio.getBeneficiary() == null) {
				System.out.println("none");
			} else if(portfolio.getBeneficiary() instanceof JuniorBroker) {
				System.out.println(portfolio.getBeneficiary().toString());
				System.out.println("Junior Broker");
				System.out.println(portfolio.getBeneficiary().getEmail().toString());
				System.out.println(portfolio.getBeneficiary().getAddress().getStreet());
				System.out.println(portfolio.getBeneficiary().getAddress().toString());
			} else if(portfolio.getBeneficiary() instanceof ExpertBroker) {
				System.out.println(portfolio.getBeneficiary().toString());
				System.out.println("Expert Broker");
				System.out.println(portfolio.getBeneficiary().getEmail().toString());
				System.out.println(portfolio.getBeneficiary().getAddress().getStreet());
				System.out.println(portfolio.getBeneficiary().getAddress().toString());
			} else if(portfolio.getBeneficiary() != null) {
				System.out.println(portfolio.getBeneficiary().toString());
				System.out.println(portfolio.getBeneficiary().getEmail());
				System.out.println(portfolio.getBeneficiary().getAddress().getStreet());
				System.out.println(portfolio.getBeneficiary().getAddress().toString());
			}
			System.out.println("Assets");
			System.out.println(String.format("%-10s %-38s %-18s %-10s %-22s %-16s", "Code", "Asset",
					"Return Rate", "Risk", "Annual Return", "Value"));
			for(Asset a : portfolioAssets) {
				System.out.printf("%-10s %-35s %12.2f %%  %10.2f  $ %16.2f  $ %11.2f\n", a.getCode(), a.getLabel(), a.getReturnRate(portfolio), a.getRisk(),a.getAnnualReturn(portfolio), a.getTotal(portfolio));
			}
			System.out.println();
			System.out.println("                                                    ---------------------------------------------------------------------");
			System.out.printf("%60s %12.4f  $  %15.2f  $  %10.2f", "Totals" ,Portfolio.getWeightedRisk(portfolioAssets, portfolio) , Portfolio.getTotalRateOfReturn(portfolioAssets, portfolio) , Portfolio.getTotalPortfolioValue(portfolioAssets, portfolio));
			System.out.println();
		}
	}

}
