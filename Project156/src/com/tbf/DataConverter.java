package com.tbf;

import java.util.Arrays;
import java.util.List;

/**
 * This class Converts a list of person and a asset into a Json format Then it
 * is written in output file.
 */

public class DataConverter {
	
	public static void main(String args[]) {
		
		JsonFile.personListToJsonFile();
		JsonFile.assetListToJsonFile();
		
		List <Portfolio> portfollio = DataParser.parsePortfolioDataFile();
		
		   for (Portfolio num : portfollio) { 		      
	           System.out.println(num); 		
	      }
	}
	
}
