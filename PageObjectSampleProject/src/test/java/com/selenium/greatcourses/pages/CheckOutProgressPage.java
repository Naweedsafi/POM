package com.selenium.greatcourses.pages;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.library.Base;

public class CheckOutProgressPage extends Base{
	
	public CheckOutProgressPage() {
		WebElement nextPageElem = selLib.waitForElementPresence(By.cssSelector("#login-email"));
		assertNotNull(nextPageElem, "CheckOut Progress page is not displayed...");
	}
	
	
}
