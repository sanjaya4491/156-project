package com.tbf;

/**
 * This is a collection of utility methods that define a general API for
 * interacting with the database supporting this application.
 *
 */
public class PortfolioData {

	/**
	 * Method that removes every person record from the database
	 */
	public static void removeAllPersons() {}

	/**
	 * Removes the person record from the database corresponding to the
	 * provided <code>personCode</code>
	 * @param personCode
	 */
	public static void removePerson(String personCode) {}

	/**
	 * Method to add a person record to the database with the provided data. The
	 * <code>brokerType</code> will either be "E" or "J" (Expert or Junior) or
	 * <code>null</code> if the person is not a broker.
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
	public static void addPerson(String personCode, String firstName, String lastName, String street, String city, String state, String zip, String country, String brokerType, String secBrokerId) {}

	/**
	 * Adds an email record corresponding person record corresponding to the
	 * provided <code>personCode</code>
	 * @param personCode
	 * @param email
	 */
	public static void addEmail(String personCode, String email) {}

	/**
	 * Removes all asset records from the database
	 */
	public static void removeAllAssets() {}

	/**
	 * Removes the asset record from the database corresponding to the
	 * provided <code>assetCode</code>
	 * @param assetCode
	 */
	public static void removeAsset(String assetCode) {}

	/**
	 * Adds a deposit account asset record to the database with the
	 * provided data.
	 * @param assetCode
	 * @param label
	 * @param apr
	 */
	public static void addDepositAccount(String assetCode, String label, double apr) {

		//establish connection to database
		Connection conn = DatabaseInfo.databaseConnector();

		//query to select an asset
		String selectAssetQuery = "select assetCode from Asset where assetCode = ?;";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			//prepare and execute select an asset query
			ps = conn.prepareStatement(selectAssetQuery);
			ps.setString(1, assetCode);
			rs = ps.executeQuery();
			//if an asset exists with the given asset code, throw an exception
			if(rs.next()) {
				throw new IllegalStateException("an asset already exists with assetCode = " + assetCode);
				//else insert the deposit account
			} else {
				String insertDepositAccountQuery = "insert into Asset(assetName, assetType, assetCode, apr) "
						+ "values (?, ?, ?, ?);";

				ps = conn.prepareStatement(insertDepositAccountQuery);
				ps.setString(1, label);
				ps.setString(2, "D");
				ps.setString(3, assetCode);
				ps.setDouble(4, apr);
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
	 * Adds a private investment asset record to the database with the
	 * provided data.
	 * @param assetCode
	 * @param label
	 * @param quarterlyDividend
	 * @param baseRateOfReturn
	 * @param baseOmega
	 * @param totalValue
	 */
	public static void addPrivateInvestment(String assetCode, String label, Double quarterlyDividend,
			Double baseRateOfReturn, Double baseOmega, Double totalValue) {

		//establish connection to database
		Connection conn = DatabaseInfo.databaseConnector();

		//query to select an asset
		String selectAssetQuery = "select assetCode from Asset where assetCode = ?;";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			//prepare and execute the select an asset query
			ps = conn.prepareStatement(selectAssetQuery);
			ps.setString(1, assetCode);
			rs = ps.executeQuery();
			//if the asset exists with the given assetCode, throw an exception
			if(rs.next()) {
				throw new IllegalStateException("an asset already exists with assetCode = " + assetCode);
				//else insert a private investment
			} else {
				String insertPrivateInvestmentQuery = "insert into Asset(assetName, assetType, assetCode, "
						+ "quarterlyDividend, baseReturn, omegaMeasure, totalValue) values (?, ?, ?, ?, ?, ?, ?);";

				ps = conn.prepareStatement(insertPrivateInvestmentQuery);
				ps.setString(1, label);
				ps.setString(2, "P");
				ps.setString(3, assetCode);
				ps.setDouble(4, quarterlyDividend);
				ps.setDouble(5, baseRateOfReturn);
				ps.setDouble(6, baseOmega);
				ps.setDouble(7, totalValue);
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
	 * Adds a stock asset record to the database with the
	 * provided data.
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

		//establish a connection to database
		Connection conn = DatabaseInfo.databaseConnector();

		//query to select an asset
		String selectAssetQuery = "select assetCode from Asset where assetCode = ?;";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			//prepare and execute the select asset query
			ps = conn.prepareStatement(selectAssetQuery);
			ps.setString(1, assetCode);
			rs = ps.executeQuery();
			//if an asset exists with the given assetCode, throw an exception
			if(rs.next()) {
				throw new IllegalStateException("an asset already exists with assetCode = " + assetCode);
				//else insert a stock
			} else {
				String insertStockQuery = "insert into Asset(assetName, assetType, assetCode, "
						+ "quarterlyDividend, baseReturn, omegaMeasure, stockSymbol, sharePrice) values "
						+ "(?, ?, ?, ?, ?, ?, ?, ?);";

				ps = conn.prepareStatement(insertStockQuery);
				ps.setString(1, label);
				ps.setString(2, "S");
				ps.setString(3, assetCode);
				ps.setDouble(4, quarterlyDividend);
				ps.setDouble(5, baseRateOfReturn);
				ps.setDouble(6, beta);
				ps.setString(7, stockSymbol);
				ps.setDouble(8, sharePrice);
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
	 * Removes all portfolio records from the database
	 */
	public static void removeAllPortfolios() {}

	/**
	 * Removes the portfolio record from the database corresponding to the
	 * provided <code>portfolioCode</code>
	 * @param portfolioCode
	 */
	public static void removePortfolio(String portfolioCode) {}

	/**
	 * Adds a portfolio records to the database with the given data.  If the portfolio has no
	 * beneficiary, the <code>beneficiaryCode</code> will be <code>null</code>
	 * @param portfolioCode
	 * @param ownerCode
	 * @param managerCode
	 * @param beneficiaryCode
	 */
	public static void addPortfolio(String portfolioCode, String ownerCode, String managerCode,
			String beneficiaryCode) {

		//establish connection to database
		Connection conn = DatabaseInfo.databaseConnector();

		//query to select a portfolio
		String selectPortfolioQuery = "select portfolioCode from Portfolio where portfolioCode = ?;";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			//prepare and execute select portfolio query
			ps = conn.prepareStatement(selectPortfolioQuery);
			ps.setString(1, portfolioCode);
			rs = ps.executeQuery();
			//if a portfolio already exists with the given portfolioCode, throw an exception
			if(rs.next()) {
				throw new IllegalStateException("a portfolio already exists with portfolioCode = " + portfolioCode);
				//else insert a portfolio
			} else {
				String insertPortfolioQuery = "insert into Portfolio(portfolioCode, personId, brokerId, beneficiaryId) values "
						+ "(?, (select personId from Person where personCode = ?), "
						+ "(select personId from Person where personCode = ?), "
						+ "(select personId from Person where personCode = ?));";

				ps = conn.prepareStatement(insertPortfolioQuery);
				ps.setString(1, portfolioCode);
				ps.setString(2, ownerCode);
				ps.setString(3, managerCode);
				ps.setString(4, beneficiaryCode);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			//if one or more codes given do not match to any people in the database
			throw new RuntimeException("one or more codes do not associate with any people", e);
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
	 * Associates the asset record corresponding to <code>assetCode</code> with the
	 * portfolio corresponding to the provided <code>portfolioCode</code>.  The third
	 * parameter, <code>value</code> is interpreted as a <i>balance</i>, <i>number of shares</i>
	 * or <i>stake percentage</i> depending on the type of asset the <code>assetCode</code> is
	 * associated with.
	 * @param portfolioCode
	 * @param assetCode
	 * @param value
	 */
	public static void addAsset(String portfolioCode, String assetCode, double value) {

		//establish connection database
		Connection conn = DatabaseInfo.databaseConnector();

		//query to select an asset
		String selectAssetQuery = "select assetId from Asset where assetCode = ?;";

		PreparedStatement ps = null;
		ResultSet rs = null;

		int assetId = 0;
		try {
			//prepare and execute the select asset query
			ps = conn.prepareStatement(selectAssetQuery);
			ps.setString(1, assetCode);
			rs = ps.executeQuery();
			//if an asset does not exist with the given assetCode, throw an exception
			if(!rs.next()) {
				throw new IllegalStateException("an asset does not exist with assetCode = " + assetCode);
				//else get the assetId
			} else {
				assetId = rs.getInt("assetId");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		//query to select a portfolio
		String selectPortfolioQuery = "select portfolioId from Portfolio where portfolioCode = ?;";

		int portfolioId = 0;
		try {
			//prepare and execute the select portfolio query
			ps = conn.prepareStatement(selectPortfolioQuery);
			ps.setString(1, portfolioCode);
			rs = ps.executeQuery();
			//if the portfolio does not exist with the given portfolioCode, throw an exception
			if(!rs.next()) {
				throw new IllegalStateException("a portfolio does not exist with portfolioCode = " + portfolioCode);
				//else get the portfolioId
			} else {
				portfolioId = rs.getInt("portfolioId");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		//query to insert a portfolio asset
		String insertPortfolioAssetQuery = "insert into PortfolioAsset(portfolioId, assetId, value) values (?, ?, ?);";

		try {
			//prepare and execute insert portfolio asset query
			ps = conn.prepareStatement(insertPortfolioAssetQuery);
			ps.setInt(1, portfolioId);
			ps.setInt(2, assetId);
			ps.setDouble(3, value);
			ps.executeUpdate();
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

}
