package com.tbf;

import java.util.List;

public class Test {

	public static void main(String args[]) {
		
		int personId = 3;
		Person p = DatabaseLoader.getPerson(personId);
		
		int assetId = 7;
		Asset a = DatabaseLoader.getAsset(assetId);
		
		List<Person> people = DatabaseLoader.getAllPerson();
		List<Asset> assets = DatabaseLoader.getAllAsset();
		List<Portfolio> portfolios = DatabaseLoader.getAllPortfolio();
		
		System.out.println("Code: " + p.getPersonCode() + " Name: " + p.getFirstName() + ", " + p.getLastName() + " " + p.getAddress() + " " + p.getEmail());
	
		for(Person pe : people) {
			System.out.println(pe.getPersonCode());
		}
	}
	
}
