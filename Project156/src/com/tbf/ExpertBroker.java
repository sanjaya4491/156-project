package com.tbf;

/**
 * Class that holds the information of an expert broker.
 * Extends the super class Broker
 * Method to get the fees is the same method in the Broker class
 */

import java.util.List;

public class ExpertBroker extends Broker {

	public ExpertBroker(String personCode, String lastName, String firstName, Address address, List<Email> email,
			String title, String section) {
		super(personCode, lastName, firstName, address, email, title, section);
	}

	/**
	 * method that returns the commission of an expert broker given the assets of the portfolio
	 * 3.75% is the base commission rate
	 */
	@Override
	public double getCommission(List<Asset> assetList, Portfolio that) {
		double totalRateOfReturn = Portfolio.getTotalRateOfReturn(assetList, that);
		return .0375 * totalRateOfReturn;
	}

}
