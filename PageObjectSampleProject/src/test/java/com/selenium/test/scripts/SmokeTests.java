package com.selenium.test.scripts;

import org.testng.annotations.Test;

import com.selenium.greatcourses.pages.CheckOutPage;
import com.selenium.greatcourses.pages.CheckOutProgressPage;
import com.selenium.greatcourses.pages.ChooseAFormatPage;
import com.selenium.greatcourses.pages.CoursesPage;
import com.selenium.greatcourses.pages.HomePage;
import com.selenium.library.Base;

public class SmokeTests extends Base {

	@Test
	public void buyNightSkyCourse_Test() {
		HomePage myHomePage = new HomePage();
		myHomePage.goto_theGreatCourseWebsite();
		myHomePage.selectScienceCategory();
		//myHomePage.selectHistoryCategory();
		//myHomePage.selectMusicCategory();		
		
		CoursesPage myCoursesPage = new CoursesPage();
		myCoursesPage.selectOurNightSkyCourse();
		//myCoursesPage.selectTheLearningBrainCourse();
		
		ChooseAFormatPage myChooseAFormatPage = new ChooseAFormatPage();
		myChooseAFormatPage.selectInstantVideoOption();
		myChooseAFormatPage.waitAndClickAddToCart();
		
		CheckOutPage myCheckOutPage = new CheckOutPage();
		myCheckOutPage.verifyCourseIsAddedToTheCart();
		myCheckOutPage.clickProceedToCheckOutButton();
		
		CheckOutProgressPage myProgressPage = new CheckOutProgressPage();
		//myProgressPage.
	}
}












