package com.selenium.test.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.library.Base;

public class WindowHandleTests extends Base {

	@Test(enabled = false)
	public void tryWindowHandlesTest() {
		driver.get("https://www.enterprise.com/");
		driver.findElement(By.partialLinkText("Careers")).click();
		selLib.switchToWindow(0);
		driver.findElement(By.partialLinkText("Careers")).click();
		selLib.customWait(5);
	}

	// file upload test
	@Test(enabled = false)
	public void fileUploadTesting() {
		driver.get("https://html.com/input-type-file/");
		selLib.customWait(5);
		// WebElement fileUploadElem = driver.findElement(By.id("fileupload"));
		// fileUploadElem.sendKeys("C:/training2016/feb_2020/PageObjectSampleProject/src/test/resources/testData/sampleTestData.txt");
		// selLib.customWait(5);

		String fullPath = "C:/training2016/feb_2020/PageObjectSampleProject/src/test/resources/testData/sampleTestData.txt";
		selLib.fileUpload(By.id("fileupload"), fullPath);
		selLib.customWait(5);
	}

	@Test
	public void testingPopupAlerts() {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement alertBtn = driver.findElement(By.id("alertbtn"));
		alertBtn.click();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Frank");
		selLib.customWait(3);
		selLib.acceptAlert();
		// selLib.closeAlert();

		// Alert myAlert = selLib.isAlertPresent();
		// myAlert.accept();
		selLib.customWait(5);
		// myAlert.dismiss();
	}

}
