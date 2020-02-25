package com.tbf;

/**
 * Class that contains methods that read in from flat data files and parse
 * the records into objects which are then put into usable lists 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DataParser {

	/**
	 * Method that reads from a flat data file containing person information and
	 * returns a list of person objects
	 * 
	 * @return
	 */
	public static List<Person> parsePersonDataFile() {
		//create empty list of people
		List<Person> result = new ArrayList<Person>();
		//open file
		File file = new File("data/Persons.dat");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//first line in the file is the number of records in the file
		int numlines = Integer.parseInt(sc.nextLine());
		int i = 0;
		while (i < numlines) {
			//tokenize the record
			String line[] = sc.nextLine().split(";");
			String personCode = line[0];
			String brok[] = line[1].split(",");
			//the person could be a client or a broker
			//assume its a client and set to null
			Broker broker = null;
			//check if the person is a broker 
			if (brok.length == 2) {
				//check if the broker is a junior broker
				if(brok[0].compareTo("J") == 0) {
					broker = new JuniorBroker(brok[0], brok[1]);
				} else {
					//else its an expert broker
					broker = new ExpertBroker(brok[0], brok[1]);
				}
			}
			String name[] = line[2].split(",");
			String lastName = name[0];
			//remove the space in the first name that is not needed
			String firstName = name[1].replaceAll("\\s+", "");
			String location[] = line[3].split(",");
			Address address = new Address(location[0], location[1], location[2], location[3], location[4]);
			List<Email> emails = new ArrayList<>();
			//if there are 5 tokens then its a complete record with email(s)
			if (line.length == 5) {
				String email[] = line[4].split(",");
				//iterate over how many email's the person has and them to the email array
				for (int j = 0; j < email.length; j++) {
					emails.add(new Email(email[j]));
				}
				//create the person object
				Person person = new Person(personCode, broker, lastName, firstName, address, emails);
				//add it to the list
				result.add(person);
				//the person has no email's 
			} else {
				Person person = new Person(personCode, broker, lastName, firstName, address, emails);
				result.add(person);
			}
			i++;
		}
		//close the file
		sc.close();
		return result;
	}

	/**
	 * Method that reads from a flat data file containing asset information and
	 * returns a list of asset objects
	 * 
	 * @return
	 */
	public static List<Asset> parseAssetDataFile() {
		//create list of assets
		List<Asset> result = new ArrayList<Asset>();
		//open file
		File file = new File("data/Assets.dat");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//first line is the number of records in the file
		int numlines = Integer.parseInt(sc.nextLine());
		int i = 0;
		while (i < numlines) {
			//generic asset
			Asset a = null;
			//tokenize the record
			String line[] = sc.nextLine().split(";");
			//code, type, label are all common to the 3 types of assets
			String code = line[0];
			String type = line[1];
			String label = line[2];
			//checks if the record is a deposit account
			if (line.length == 4) {
				String apr = line[3];
				//create deposit account
				a = new DepositAccount(code, type, label, apr);
				//checks if the record is a stock
			} else if (line.length == 8) {
				String quarterlyDividend = line[3];
				String baseReturn = line[4];
				String betaMeasure = line[5];
				String stockSymbol = line[6];
				String sharePrice = line[7];
				//create stock
				a = new Stock(code, type, label, quarterlyDividend, baseReturn, betaMeasure, stockSymbol, sharePrice);
				//checks if the record is a private investment
			} else if (line.length == 7) {
				String quarterlyDividend = line[3];
				String baseReturn = line[4];
				String baseOmegaMeasure = line[5];
				String totalValue = line[6];
				//create private investment
				a = new PrivateInvestment(code, type, label, quarterlyDividend, baseReturn, baseOmegaMeasure,
						totalValue);
			}
			//add the asset to the asset list
			result.add(a);
			i++;
		}
		//close the file
		sc.close();
		return result;
	}

	public static List<Portfolio> parsePortfolioDataFile() {
		//create list of porfolio's
		List<Portfolio> result = new ArrayList<Portfolio>();
		//open file
		File file = new File("data/Portfolios.dat");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//first line is the number of records
		int numlines = Integer.parseInt(sc.nextLine());
		int i = 0;
		while (i < numlines) {
			//tokenize the record
			String line[] = sc.nextLine().split(";");
			String portfolioCode = line[0];
			String ownerCode = line[1];
			String managerCode = line[2];
			//the record may or may not have a beneficiary 
			//assume there is not a beneficiary
			String beneficiaryCode = null;
			//a complete record has 5 tokens and also checks if there are 4
			//tokens and no assets
			if (line.length == 4 || line.length == 5) {
				beneficiaryCode = line[3];
				//if the record has 4 tokens but no beneficiary
				if(line[3].isEmpty() == true) {
					beneficiaryCode = null;
				}
			}
			//may or may not have assets
			//assume there are no assets so set to null;
			String assetsList[] = null;
			//create an empty map for assets
			Map<String, Double> assetsMap = new HashMap<String, Double>();
			//checks if it is a complete record
			if (line.length == 5) {
				//tokenize the assets if there are multiple assets
				assetsList = line[4].split(",");
				for (int j = 0; j < assetsList.length; j++) {
					//tokenize the individual assets to get the asset code and numeric value
					String assets[] = assetsList[j].split(":");
					//put it into the map
					assetsMap.put(assets[0], Double.parseDouble(assets[1]));
				}
				//create the portfolio
				Portfolio portfolio = new Portfolio(portfolioCode, ownerCode, managerCode, beneficiaryCode, assetsMap);
				//add it to the portfolio list
				result.add(portfolio);
				//if the record does not have any assets
			} else {
				Portfolio portfolio = new Portfolio(portfolioCode, ownerCode, managerCode, beneficiaryCode, assetsMap);
				result.add(portfolio);
			}
			i++;
		}
		//close the file
		sc.close();
		return result;
	}

}
