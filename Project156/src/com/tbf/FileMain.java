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
			Email email;
			if (line.length == 5) {
				email = new Email(line[4]);
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
		

		for (Person x : personList) {
			System.out.println(x);
		}

	}
}
