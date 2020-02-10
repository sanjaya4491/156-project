package com.tbf;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	
	public static void main(String args[]) {
		
	List <Person> personList = new ArrayList <Person>();
	File file = new File ("data/Persons.dat");
	Scanner sc = null;
	try {
		sc = new Scanner(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	
	}
}
