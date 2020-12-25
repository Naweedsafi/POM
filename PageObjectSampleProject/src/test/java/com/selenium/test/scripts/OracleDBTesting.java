package com.selenium.test.scripts;

import static org.testng.Assert.assertTrue;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.selenium.library.DatabaseManager;

public class OracleDBTesting {

	final static Logger logger = Logger.getLogger(OracleDBTesting.class);

	/*public static void main(String[] args) {
		try {
			DatabaseManager dbManager = new DatabaseManager();
			ResultSet myDataResultSet = dbManager.runSQLQuery("select * from COUNTRIES");

			logger.info("my query result data set: ----------");

			while (myDataResultSet.next()) {
				String myCountryID = myDataResultSet.getString("COUNTRY_ID");
				String myCountryName = myDataResultSet.getString("COUNTRY_NAME");
				int myRegionID = myDataResultSet.getInt("REGION_ID");

				System.out.println(myCountryID + " \t" + myCountryName + " \t" + myRegionID);

			}

			
			
			
			logger.info(myDataResultSet);

		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}*/
	
	public static void main(String[] args) {
		OracleDBTesting myTest = new OracleDBTesting();
		String data1 = myTest.getRegionID("United States of America");
		logger.info("USA region id is: " + data1);
		
		String data2 = myTest.getRegionID("Singapore");
		logger.info("Singapore region id is: " + data2);
		
	}

	// United States of America

	public String getRegionID(String countryName) {
		String regionIDData = null;
		try {

			DatabaseManager dbm = new DatabaseManager();
			String query = "select REGION_ID from COUNTRIES where COUNTRY_NAME in ('" + countryName + "')";
			ResultSet reSet = dbm.runSQLQuery(query);
			if (reSet.next()) {
				Object data = reSet.getObject(1);
				regionIDData = data.toString();
			}

		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
		return regionIDData;
	}

}
