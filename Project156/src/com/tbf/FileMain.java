package com.tbf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileMain {

	public static void main(String args[]) {

		List<Person> personList = new ArrayList<Person>();
		List<Stock> stockList = new ArrayList<Stock>();
		List<DepositAccount> depositAccountList = new ArrayList<DepositAccount>();
		List<PrivateInvestment> privateInvestmentList = new ArrayList<PrivateInvestment>();
		
		File file = new File("data/Persons.dat");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
			String firstName = name[1];
			String location[] = line[3].split(",");
			Address address = new Address(location[0], location[1], location[2], location[3], location[4]);
			Email email = null;
			if (line.length == 5) {
				if (line[4].contains(",")) {
					String multipleEmails [] = line[4].split(",");
					for (int j = 0 ; j < multipleEmails.length; j++) {
						email =  new Email (multipleEmails[j]);
					}
				}else {
					email = new Email(line[4]);
				}
				Person person = new Person(personCode, broker, section, lastName, firstName, address, email);
				personList.add(person);
			} else {
				email = null;
				Person person = new Person(personCode, broker, section, lastName, firstName, address, email);
				personList.add(person);
			}
			i++;
		}
		sc.close();
		
		file = new File("data/Assets.dat");
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		numlines = Integer.parseInt(sc.nextLine());
		i = 0;
		while(i < numlines) {
			String line[] = sc.nextLine().split(";");
			if(line.length == 4) {
				String code = line[0];
				String type = line[1];
				String label = line[2];
				String apr = line[3];
				DepositAccount depositAccount = new DepositAccount(code, type, label, apr);
				depositAccountList.add(depositAccount);
			} else if(line.length == 8) {
				String code = line[0];
				String type = line[1];
				String label = line[2];
				String quarterlyDividend = line[3];
				String baseReturn = line[4];
				String betaMeasure = line[5];
				String stockSymbol = line[6];
				String sharePrice = line[7];
				Stock stock = new Stock(code, type, label, quarterlyDividend, baseReturn, betaMeasure, stockSymbol, sharePrice);
				stockList.add(stock);
			} else if(line.length == 7) {
				String code = line[0];
				String type = line[1];
				String label = line[2];
				String quarterlyDividend = line[3];
				String baseReturn = line[4];
				String baseOmegaMeasure = line[5];
				String totalValue = line[6];
				PrivateInvestment privateInvestment = new PrivateInvestment(code, type, label, quarterlyDividend, baseReturn, baseOmegaMeasure, totalValue);
				privateInvestmentList.add(privateInvestment);
			}
			i++;
		}
		sc.close();
		

		for (Person x : personList) {
			System.out.println(x);
		}
		
		for (DepositAccount x : depositAccountList) {
			System.out.println(x);
		}
		
		for (PrivateInvestment x : privateInvestmentList) {
			System.out.println(x);
		}
		
		for (Stock x : stockList) {
			System.out.println(x);
		}

	}
}
