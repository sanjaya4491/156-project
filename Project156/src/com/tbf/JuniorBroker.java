package com.tbf;

/**
 * Class that holds information on a junior broker.
 * Extends super class Broker
 * 
 */

import java.util.List;

public class JuniorBroker extends Broker {
	
	public JuniorBroker(String personCode, String lastName, String firstName, Address address, List<Email> email,
			String title, String section) {
		super(personCode, lastName, firstName, address, email, title, section);
	}

	/**
	 * Method that gets the fees of a junior broker.
	 * $75 is the base rate for each asset
	 */
	@Override
	public double getFee(List<Asset> assetList) {
		int size = assetList.size();
		return (75 * size);
	}

	/**
	 * Method that gets the commissions of a junior broker
	 * 1.25% is the base rate
	 */
	@Override
	public double getCommission(List<Asset> assetList, Portfolio that) {
		double totalRateOfReturn = Portfolio.getTotalRateOfReturn(assetList, that);
		return .0125 * totalRateOfReturn;
	}

}
