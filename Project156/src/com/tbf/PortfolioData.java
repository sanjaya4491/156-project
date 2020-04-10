package com.tbf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This is a collection of utility methods that define a general API for
 * interacting with the database supporting this application.
 *
 */
public class PortfolioData {
	
	/**
	 * Method that removes every person record from the database
	 */
	public static void removeAllPersons() {
	}

	/**
	 * Removes the person record from the database corresponding to the provided
	 * <code>personCode</code>
	 * 
	 * @param personCode
	 */
	public static void removePerson(String personCode) {
	}

	/**
	 * Method to add a person record to the database with the provided data. The
	 * <code>brokerType</code> will either be "E" or "J" (Expert or Junior) or
	 * <code>null</code> if the person is not a broker.
	 * 
	 * @param personCode
	 * @param firstName
	 * @param lastName
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @param brokerType
	 */
	public static void addPerson(String personCode, String firstName, String lastName, String street, String city,
			String state, String zip, String country, String brokerType, String secBrokerId) {
		
		//establish connection to database
		Connection conn = DatabaseInfo.databaseConnector();
		
		//query to select a country
		String selectCountryQuery = "select countryId from Country where country = ?;";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int countryId = 0;
		try {
			//prepare and execute select country query
			ps = conn.prepareStatement(selectCountryQuery);
			ps.setString(1, country);
			rs = ps.executeQuery();
			//if the country already exists, get the id
			if(rs.next()) {
				countryId = rs.getInt("countryId");
				//else the country does not exist and insert it into the database
			} else {
				String insertCountryQuery = "insert into Country(country) values (?);";
				
				ps = conn.prepareStatement(insertCountryQuery);
				ps.setString(1, country);
				ps.executeUpdate();
				
				//retrieve the countryId
				ps = conn.prepareStatement("select last_insert_id()");
				rs = ps.executeQuery();
				rs.next();
				countryId = rs.getInt("last_insert_id()");
			}
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		//query to select a state
		String selectStateQuery = "select stateId from State where state = ?;";
		
		int stateId = 0;
		try {
			//prepare and execute select state query
			ps = conn.prepareStatement(selectStateQuery);
			ps.setString(1, state);
			rs = ps.executeQuery();
			//if the state already exists, retrieve the id
			if(rs.next()) {
				stateId = rs.getInt("stateId");
				//else insert the state
			} else {
				String insertStateQuery = "insert into State(state, countryId) values (?, ?);";
				
				ps = conn.prepareStatement(insertStateQuery);
				ps.setString(1, state);
				ps.setInt(2, countryId);
				ps.executeUpdate();
				
				//retrieve the state id
				ps = conn.prepareStatement("select last_insert_id()");
				rs = ps.executeQuery();
				rs.next();
				stateId = rs.getInt("last_insert_id()");
			}
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		//query to insert an address
		String insertAddressQuery = "insert into Address(street, city, zipCode, stateId) values (?, ?, ?, ?);";
		
		int addressId = 0;
		try {
			//prepare and execute the insert address query
			ps = conn.prepareStatement(insertAddressQuery);
			ps.setString(1, street);
			ps.setString(2, city);
			ps.setInt(3, Integer.parseInt(zip));
			ps.setInt(4, stateId);
			ps.executeUpdate();
			
			//retrieve the state id
			ps = conn.prepareStatement("select last_insert_id()");
			rs = ps.executeQuery();
			rs.next();
			addressId = rs.getInt("last_insert_id()");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		//query to select a person
		String selectPersonQuery = "select personCode from Person where personCode = ?";
		
		try {
			//prepare and execute the select a person query;
			ps = conn.prepareStatement(selectPersonQuery);
			ps.setString(1, personCode);
			rs = ps.executeQuery();
			//if a person already exists with the given personCode throw an exception
			if(rs.next()) {
				throw new IllegalStateException("a person already exists with personCode = " + personCode);
				//else insert the person record
			} else {
				String insertPersonQuery = "insert into Person(personCode, firstName, lastName, brokerType, "
						+ "brokerSection, addressId) values (?, ?, ?, ?, ?, ?);";
				
				ps = conn.prepareStatement(insertPersonQuery);
				ps.setString(1, personCode);
				ps.setString(2, firstName);
				ps.setString(3, lastName);
				ps.setString(4, brokerType);
				ps.setString(5, secBrokerId);
				ps.setInt(6, addressId);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
			if(ps != null && !ps.isClosed()) {
				ps.close();
			}
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * Adds an email record corresponding person record corresponding to the
	 * provided <code>personCode</code>
	 * 
	 * @param personCode
	 * @param email
	 */
	public static void addEmail(String personCode, String email) {
		
		//establish connection to database
		Connection conn = DatabaseInfo.databaseConnector();
		
		//query to select an email
		String selectEmailQuery = "select email from Email where email = ?;";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//prepare and execute the select email query
			ps = conn.prepareStatement(selectEmailQuery);
			ps.setString(1, email);
			rs = ps.executeQuery();
			//if the email exists, do not duplicate the record and throw an exception
			if(rs.next()) {
				throw new IllegalStateException(email + " already exists");
				//else the email does not exist and add it to the database
			} else {
				//query to insert an email
				String insertEmailQuery = "insert into Email(email, personId) values "
						+ "(?, (select personId from Person where personCode = ?));";
				
				ps = conn.prepareStatement(insertEmailQuery);
				ps.setString(1, email);
				ps.setString(2, personCode);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			//no person exists with the given personCode
			throw new RuntimeException("no such person with personCode = " + personCode, e);
		}
		
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
			if(ps != null && !ps.isClosed()) {
				ps.close();
			}
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * Removes all asset records from the database
	 */
	public static void removeAllAssets() {
	}

	/**
	 * Removes the asset record from the database corresponding to the provided
	 * <code>assetCode</code>
	 * 
	 * @param assetCode
	 */
	public static void removeAsset(String assetCode) {
	}

	/**
	 * Adds a deposit account asset record to the database with the provided data.
	 * 
	 * @param assetCode
	 * @param label
	 * @param apr
	 */
	public static void addDepositAccount(String assetCode, String label, double apr) {
	}

	/**
	 * Adds a private investment asset record to the database with the provided
	 * data.
	 * 
	 * @param assetCode
	 * @param label
	 * @param quarterlyDividend
	 * @param baseRateOfReturn
	 * @param baseOmega
	 * @param totalValue
	 */
	public static void addPrivateInvestment(String assetCode, String label, Double quarterlyDividend,
			Double baseRateOfReturn, Double baseOmega, Double totalValue) {
	}

	/**
	 * Adds a stock asset record to the database with the provided data.
	 * 
	 * @param assetCode
	 * @param label
	 * @param quarterlyDividend
	 * @param baseRateOfReturn
	 * @param beta
	 * @param stockSymbol
	 * @param sharePrice
	 */
	public static void addStock(String assetCode, String label, Double quarterlyDividend, Double baseRateOfReturn,
			Double beta, String stockSymbol, Double sharePrice) {
	}

	/**
	 * Removes all portfolio records from the database
	 */
	public static void removeAllPortfolios() {
	}

	/**
	 * Removes the portfolio record from the database corresponding to the provided
	 * <code>portfolioCode</code>
	 * 
	 * @param portfolioCode
	 */
	public static void removePortfolio(String portfolioCode) {
	}

	/**
	 * Adds a portfolio records to the database with the given data. If the
	 * portfolio has no beneficiary, the <code>beneficiaryCode</code> will be
	 * <code>null</code>
	 * 
	 * @param portfolioCode
	 * @param ownerCode
	 * @param managerCode
	 * @param beneficiaryCode
	 */
	public static void addPortfolio(String portfolioCode, String ownerCode, String managerCode,
			String beneficiaryCode) {
		
	}

	/**
	 * Associates the asset record corresponding to <code>assetCode</code> with the
	 * portfolio corresponding to the provided <code>portfolioCode</code>. The third
	 * parameter, <code>value</code> is interpreted as a <i>balance</i>, <i>number
	 * of shares</i> or <i>stake percentage</i> depending on the type of asset the
	 * <code>assetCode</code> is associated with.
	 * 
	 * @param portfolioCode
	 * @param assetCode
	 * @param value
	 */
	public static void addAsset(String portfolioCode, String assetCode, double value) {
	}
}