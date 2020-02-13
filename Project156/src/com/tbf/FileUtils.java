package com.tbf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileUtils {

	public static List<Person> parsePersonDataFile() {
		List<Person> result = new ArrayList<Person>();
		File file = new File("data/Persons.dat");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int numlines = Integer.parseInt(sc.nextLine());
		int i = 0;
		while (i < numlines - 1) {
			String line[] = sc.nextLine().split(";");
			String personCode = line[0];
			String brok[] = line[1].split(",");
			String broker;
			String section;
			if (brok.length == 2) {
				broker = brok[0];
				section = brok[1];
			} else {
				broker = null;
				section = null;
			}
			String name[] = line[2].split(",");
			String lastName = name[0];
			String firstName = name[1].replaceAll("\\s+", "");
			String location[] = line[3].split(",");
			Address address = new Address(location[0], location[1], location[2], location[3], location[4]);
			List<Email> emails = new ArrayList<>();
			if (line.length == 5) {
				String email[] = line[4].split(",");
				for (int j = 0; j < email.length; j++) {
					emails.add(new Email(email[j]));
				}
				Person person = new Person(personCode, broker, section, lastName, firstName, address, emails);
				result.add(person);
			} else {
				Person person = new Person(personCode, broker, section, lastName, firstName, address, emails);
				result.add(person);
			}
			i++;
		}
		sc.close();
		return result;
	}

	public static List<Asset> parseAssetDataFile() {
		List<Asset> result = new ArrayList<Asset>();
		File file = new File("data/Assets.dat");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int numlines = Integer.parseInt(sc.nextLine());
		int i = 0;
		while (i < numlines) {
			Asset a = null;
			String line[] = sc.nextLine().split(";");
			String code = line[0];
			String type = line[1];
			String label = line[2];
			if (line.length == 4) {
				String apr = line[3];
				a = new DepositAccount(code, type, label, apr);
			} else if (line.length == 8) {
				String quarterlyDividend = line[3];
				String baseReturn = line[4];
				String betaMeasure = line[5];
				String stockSymbol = line[6];
				String sharePrice = line[7];
				a = new Stock(code, type, label, quarterlyDividend, baseReturn, betaMeasure, stockSymbol, sharePrice);
			} else if (line.length == 7) {
				String quarterlyDividend = line[3];
				String baseReturn = line[4];
				String baseOmegaMeasure = line[5];
				String totalValue = line[6];
				a = new PrivateInvestment(code, type, label, quarterlyDividend, baseReturn, baseOmegaMeasure,
						totalValue);
			}
			result.add(a);
			i++;
		}
		sc.close();
		return result;
	}
	
	public static void personListToJsonFile() {
		List<Person> personList = FileUtils.parsePersonDataFile();
		PrintWriter out = null;
		try {
			out = new PrintWriter("data/Persons.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = "{" + "\n" + "\"persons\": " + gson.toJson(personList)  + "}";
		out.write(json);
		out.close();
	}
	
	public static void assetListToJsonFile() {
		List<Asset> assetList = FileUtils.parseAssetDataFile();
		PrintWriter out = null;
		try {
			out = new PrintWriter("data/Assets.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = "{" + "\n" + "\"assets\": " + gson.toJson(assetList) + "}";
		out.write(json);
		out.close();
	}

}
