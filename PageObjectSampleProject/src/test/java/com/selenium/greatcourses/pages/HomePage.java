package com.selenium.greatcourses.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.library.Base;

public class HomePage extends Base {
	final static Logger logger = Logger.getLogger(HomePage.class);

	public HomePage goto_theGreatCourseWebsite() {
		try {
			driver.get("https://www.thegreatcourses.com/");
			String pageTitle = driver.getTitle();
			String expactedTitle = "Online Courses & Lectures for Home Study and Lifelong Learning";
			assertEquals(pageTitle, expactedTitle);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
		return this;
	}

	public HomePage selectScienceCategory() {
		selectACategory("Science");
		return this;
	}

	public HomePage selectHistoryCategory() {
		selectACategory("History");
		return this;
	}

	public HomePage selectMusicCategory() {
		selectACategory("Music");
		return this;
	}

	/***
	 * This method locates only the categories visible to the user when user
	 * land on homepage, Thinking homework: you need to check the element
	 * visibility before you select the category element if, element is not
	 * visible then you need to click the arrow icon to the right one time and
	 * Search and check visibility of element again,, finally, if element is
	 * visible then you need to click it.
	 */
	private void selectACategory(String courseCategoryName) {
		try {
			WebElement categoriesRegion = driver
					.findElement(By.cssSelector(".itemslider-wrapper.itemslider-categories"));
			List<WebElement> categoriesElems = categoriesRegion.findElements(By.tagName("a"));
			for (WebElement categoryATag : categoriesElems) {
				WebElement categoryElem = categoryATag.findElements(By.tagName("img")).get(0);
				String categoryNameTxt = categoryElem.getAttribute("alt");
				logger.debug("Category Text: " + categoryNameTxt);
				if (courseCategoryName.contains(categoryNameTxt)) {
					selLib.highlightElement(categoryElem);
					categoryElem.click();
					break;
				}
			}
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}

}// Class ending  // I am adding 
