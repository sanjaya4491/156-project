package com.tbf;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class DataConverter {
	
	public static void main(String args[]) {
		
		List<Person> personList = FileUtils.parsePersonDataFile();
		List<Asset> assetList = FileUtils.parseAssetDataFile();
		
		PrintWriter outPerson = null;
		PrintWriter outAsset = null;
		try {
			outPerson = new PrintWriter("data/Persons.json");
			outAsset = new PrintWriter("data/Assets.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String json = "{" + "\n" + "\"persons\": " + gson.toJson(personList)  + " }";
		outPerson.write(json);
		
		String json2 = "{" + "\n" + "\"assets\": " + gson.toJson(assetList) + " }";
		outAsset.write(json2);
		
		outPerson.close();
		outAsset.close();
	}
	

}
