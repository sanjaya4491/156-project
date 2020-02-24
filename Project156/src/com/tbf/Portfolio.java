package com.tbf;

import java.util.Map;

public class Portfolio {
	
	private String portfolioCode;
	private String ownerCode;
	private String managerCode;
	private String beneficiaryCode;
	private Map <String, Double> assestList ;

	public Portfolio(String portfolioCode, String ownerCode, String managerCode, String beneficiaryCode,
			Map<String, Double> assestList) {
		this.portfolioCode = portfolioCode;
		this.ownerCode = ownerCode;
		this.managerCode = managerCode;
		this.beneficiaryCode = beneficiaryCode;
		this.assestList = assestList;
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
	public Map<String, Double> getAssestList() {
		return assestList;
	}
	public void setAssestList(Map<String, Double> assestList) {
		this.assestList = assestList;
	}


	@Override
	public String toString() {
		return "Portfolio [portfolioCode=" + portfolioCode + ", ownerCode=" + ownerCode + ", managerCode=" + managerCode
				+ ", beneficiaryCode=" + beneficiaryCode + ", assestList=" + assestList + "]";
	}
	
	
	
	
	
	

}
