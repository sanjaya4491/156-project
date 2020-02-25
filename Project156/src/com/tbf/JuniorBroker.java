package com.tbf;

import java.util.List;

public class JuniorBroker extends Broker {

	public JuniorBroker(String title, String section) {
		super(title, section);
	}

	@Override
	public double getFee(List<Asset> assetList) {
		// TODO Auto-generated method stub
		int size = assetList.size();
		return (75 * size);
	}

	@Override
	public double getCommission(List<Asset> assetList, Portfolio that) {
		// TODO Auto-generated method stub
		double totalRateOfReturn = Asset.getTotalRateOfReturn(assetList, that);
		return .0125 * totalRateOfReturn;
	}

}
