package com.tbf;

import java.util.List;

public class ExpertBroker extends Broker {

	public ExpertBroker(String title, String section) {
		super(title, section);
	}

	@Override
	public double getCommission(List<Asset> assetList, Portfolio that) {
		// TODO Auto-generated method stub
		double totalRateOfReturn = Portfolio.getTotalRateOfReturn(assetList, that);
		return .0375 * totalRateOfReturn;
	}

}
