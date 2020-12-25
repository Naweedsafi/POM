package com.selenium.test.scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.library.Base;
import com.selenium.library.ExcelManager;

public class DataDrivenTests extends Base {

	final static Logger logger = Logger.getLogger(DataDrivenTests.class);
	private int counter = 0;

	// Read the Excel data file
	@DataProvider(name = "MortgageTestDataSet4")
	private Object[][] calculatorData() {
		Object[][] data = null;
		ExcelManager excel = new ExcelManager("src/test/resources/testData/CalculaterTestData2.xls", 0);
		data = excel.getExcelData();
		return data;
	}

	// We will pass the Excel data to Mortgage Calculator Test suite
	@Test(dataProvider = "MortgageTestDataSet4")
	public void dataDrivenTests(String amount, String Myear, String Mmonth, String intYear, String intMonth,
			String intType, String intRate, String startMonth, String startYear, String paymentPeriod,
			String expectedResult) {
		try {
			counter++;

			driver.get("https://www.mortgagecalculator.net/");
			selLib.enterText(By.id("amount"), amount);
			selLib.enterText(By.xpath("//*[@id='amortizationYears']"), Myear);
			selLib.enterText(By.cssSelector("#amortizationMonths"), Mmonth);
			selLib.enterText(By.id("interestTermYears"), intYear);
			selLib.enterText(By.cssSelector("#interestTermMonths"), intMonth);
			selLib.selectDropDown(By.id("interestType"), intType);
			selLib.enterText(By.xpath("//*[@id='rate']"), intRate);
			selLib.selectDropDown(By.id("startMonth"), Integer.valueOf(startMonth));
			selLib.selectDropDown(By.id("startYear"), startYear);
			selLib.selectDropDown(By.cssSelector("#paymentMode"), paymentPeriod);
			// selLib.clickButton(By.cssSelector("#button"));
			selLib.clickHiddenElement(By.cssSelector("#button"));
			selLib.customWait(5);

			WebElement monthlyPaymentResult = driver.findElement(By.id("summaryMonthly"));
			// String monthlyPaymentTxt = monthlyPaymentResult.getText();
			String monthlyPaymentTxt = monthlyPaymentResult.getAttribute("value");
			logger.info("Test Scenario: " + counter + ",  Monthly payment amount is: " + monthlyPaymentTxt
					+ ", Expected: [" + expectedResult + "]");
			assertEquals(monthlyPaymentTxt, expectedResult);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
}
