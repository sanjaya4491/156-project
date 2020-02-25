package com.tbf;

import java.util.List;

public interface Payable {
	
	public abstract double getFee(List<Asset> assetList);
	
	public abstract double getCommission(List<Asset> assetList, Portfolio that);

}
