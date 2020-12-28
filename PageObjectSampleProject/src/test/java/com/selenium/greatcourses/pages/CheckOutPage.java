package com.selenium.greatcourses.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.library.Base;

public class CheckOutPage extends Base {

	public CheckOutPage () {
		WebElement nextPageElem = selLib.waitForElementPresence(By.cssSelector("div > div.actions > button.button.btn-checkout"));
		assertNotNull(nextPageElem, "Proceed to check out page is not displayed...");
	}
	
	public CheckOutPage clickProceedToCheckOutButton() {
		WebElement proceedCheckOutBtn = driver.findElement(By.cssSelector("div > div.actions > button.button.btn-checkout"));
		//proceedCheckOutBtn.click();
		//selLib.clickButton(proceedCheckOutBtn);
		selLib.clickHiddenElement(proceedCheckOutBtn);
		return this;
	}
	
	public CheckOutPage verifyCourseIsAddedToTheCart() {
		// locate 'Product-Info' region and pick the first one by index=0
		List<WebElement> productInfoRegions = driver.findElements(By.className("product-info"));
		WebElement productInfoRegion1 = productInfoRegions.get(0);
		selLib.highlightElement(productInfoRegion1);
		String productNameTxt = productInfoRegion1.findElement(By.tagName("h2")).getText();
		System.out.println("Verify Text is: " + productNameTxt);
		assertEquals(productNameTxt, "Our Night Sky");		
		return this;
	}
}// Check out Page


















