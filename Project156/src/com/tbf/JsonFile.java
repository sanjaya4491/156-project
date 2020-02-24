package com.tbf;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonFile {
	
	/**
	 *	Method that converts a list of person objects into Json strings and prints them to a file
	 */
	public static void personListToJsonFile() {
		List<Person> personList = DataParser.parsePersonDataFile();
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
	
	/**
	 * Method that converts a list of asset objects into Json strings and prints them to a file
	 */
	public static void assetListToJsonFile() {
		List<Asset> assetList = DataParser.parseAssetDataFile();
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
