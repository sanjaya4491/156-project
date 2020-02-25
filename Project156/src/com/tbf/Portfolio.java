package com.tbf;

import java.util.Map;

public class Portfolio {
	
	private String portfolioCode;
	private String ownerCode;
	private String managerCode;
	private String beneficiaryCode;
	private Map <String, Double> assetList ;

	public Portfolio(String portfolioCode, String ownerCode, String managerCode, String beneficiaryCode,
			Map<String, Double> assetList) {
		this.portfolioCode = portfolioCode;
		this.ownerCode = ownerCode;
		this.managerCode = managerCode;
		this.beneficiaryCode = beneficiaryCode;
		this.assetList = assetList;
	}
	
	
	public String getPortfolioCode() {
		return portfolioCode;
	}
	public void setPortfolioCode(String portfolioCode) {
		this.portfolioCode = portfolioCode;
	}
	public String getOwnerCode() {
		return ownerCode;
	}
	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}
	public String getManagerCode() {
		return managerCode;
	}
	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}
	public String getBeneficiaryCode() {
		return beneficiaryCode;
	}
	public void setBeneficiaryCode(String beneficiaryCode) {
		this.beneficiaryCode = beneficiaryCode;
	}
	public Map<String, Double> getAssetList() {
		return assetList;
	}
	public void setAssestList(Map<String, Double> assetList) {
		this.assetList = assetList;
	}


	@Override
	public String toString() {
		return "Portfolio [portfolioCode=" + portfolioCode + ", ownerCode=" + ownerCode + ", managerCode=" + managerCode
				+ ", beneficiaryCode=" + beneficiaryCode + ", assestList=" + assetList + "]";
	}
	
	
	
	
	
	

}
