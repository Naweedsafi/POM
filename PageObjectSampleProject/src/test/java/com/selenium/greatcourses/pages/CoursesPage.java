package com.selenium.greatcourses.pages;



import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.library.Base;

public class CoursesPage extends Base{

	public CoursesPage() {
		// page navigation synchronization
		// Explicit wait - waiting for an element condition dynamically		
		WebElement nextPageElem = selLib.waitForElementVisibility(By.cssSelector(".category-products-container"));
		assertNotNull(nextPageElem, "Courses page is not displayed...");
	}

	public void selectOurNightSkyCourse() {
		selectACourse("Our Night Sky");		
	}

	public void selectTheLearningBrainCourse() {
		selectACourse("The Learning Brain");		
	}	
	
	
	private void selectACourse(String courseName) {
		WebElement coursesRegion = driver.findElement(By.cssSelector(".category-products-container"));
		List<WebElement> allCourses = coursesRegion.findElements(By.tagName("a"));
		for(WebElement aCourse : allCourses) {
			WebElement h2Elem = aCourse.findElement(By.tagName("h2"));
			String courseText = h2Elem.getText();
			//System.out.println("course name: -----------------");
			//System.out.println("[ " + courseText + " ]");
			if(courseName.contains(courseText)) {
				selLib.highlightElement(h2Elem);
				h2Elem.click();
				break;
			}
		}		
	}	
}

























































