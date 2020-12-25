package com.selenium.greatcourses.pages;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.library.Base;

public class ChooseAFormatPage extends Base {

	public ChooseAFormatPage() {
		// page navigation synchronization
		// Explicit wait - waiting for an element condition dynamically
		WebElement nextPageElem = selLib.waitForElementPresence(By.id("product-options-wrapper"));
		assertNotNull(nextPageElem, "Choose A Format page is not displayed...");
	}

	public ChooseAFormatPage selectInstantVideoOption() {
		// select 'instance video' radio option
		WebElement instanceVideoElem = driver
				.findElement(By.cssSelector("#media-format-radio > div:nth-child(1) > label"));
		//instanceVideoElem.click();
		selLib.clickButton(instanceVideoElem);
		return this;
	}

	public ChooseAFormatPage waitAndClickAddToCart() {
		WebElement addToCart = selLib.waitForElementToBeClickable(By.cssSelector("#add-to-cart-btn > span > span"));
		//addToCart.click();
		selLib.clickButton(addToCart);
		return this;
	}
	
	
	
}








