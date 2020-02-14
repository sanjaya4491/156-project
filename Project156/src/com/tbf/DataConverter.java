package com.tbf;

/**
 * This class Converts a list of person and a asset into a Josn format Then it
 * is written in output file.
 */

public class DataConverter {
	
	public static void main(String args[]) {
		
		FileUtils.personListToJsonFile();
		FileUtils.assetListToJsonFile();

		
	}
	
}
