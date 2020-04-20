package com.tbf;


public class SortedUtils {

    public static void sortedArrayReport(SortedList<Portfolio> portfolioList) {
        //empty variables to store totals to print later
        double feesTotal = 0;
        double commissionsTotal = 0;
        double returnTotal = 0;
        double totalTotal = 0;

        System.out.println("Portfolio Summary Report");
        System.out.println(
                "============================================================================================================================================");
        System.out.println(String.format("%-10s %-20s %-26s %-16s %-13s %-19s %-16s %-16s", "Portfolio", "Owner",
                "Manager", "Fees", "Commissions", "Weighted Risk", "Return", "Total"));

        //iterate over each portfolio

        for (Portfolio portfolio : portfolioList) {
            //get the size of the list
            int portfolioAssetListSize = portfolio.getAssetList().size();
            //adding the cumulative totals for all the portfolios
            feesTotal += portfolio.getManager().getFee() * portfolioAssetListSize;
            commissionsTotal += portfolio.getManager().getCommission() * portfolio.getTotalRateOfReturn();
            returnTotal += portfolio.getTotalRateOfReturn();
            totalTotal += portfolio.getTotalPortfolioValue();

            System.out.printf(String.format("%-10s %-20s %-20s %-5s %-10.2f %-5s %-13.2f %-13.4f %-5s %-10.2f %-5s %-10.2f\n",
                    portfolio.getPortfolioCode(), portfolio.getOwner().toString(), portfolio.getManager().toString(), "$", portfolio.getManager().getFee() * portfolioAssetListSize, "$",
                    portfolio.getManager().getCommission() * portfolio.getTotalRateOfReturn(), portfolio.getWeightedRisk(), "$",
                    portfolio.getTotalRateOfReturn(), "$", portfolio.getTotalPortfolioValue(), "$",
                    portfolio.getWeightedRisk(), "$", portfolio.getTotalRateOfReturn()));
        }

        System.out.println(
                "                                                     ========================================================================================");

        System.out.printf(String.format(" %50s  $ %10.2f     $ %10.2f   %20s %12.2f   $ %12.2f\n\n\n", "Total", feesTotal, commissionsTotal,
                "$", returnTotal, totalTotal));
    }

    }
