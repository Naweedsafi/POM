package com.selenium.test.scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import com.selenium.library.Base;

public class LoggingTests extends Base{

	final static Logger logger = Logger.getLogger(LoggingTests.class);
	
	@Test(enabled = false)
	public void myFirstTest(){
		logger.debug("This is debug message from my first test..");
		logger.info("This is my first test running...");
	}
	
	@Test (enabled = false)
	public void mySecondTest(){
		logger.info("This is my second test running...");
		logger.debug("This is debug message from my second test..");
	}
	
	@Test
	public void testWithFailure(){
		driver.get("https://www.walmart.com/");
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, "Apple");
	}
	
}











