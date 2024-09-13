package com.eRail.testCases;

import org.testng.annotations.Test;

import com.eRail.baseClass.baseClass;
import com.eRail.pages.homePage_page;

import io.qameta.allure.Step;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class checkFourthPositionAndCompareDestinationAndSortDate extends baseClass {

	homePage_page hp;

	@BeforeMethod
	public void beforeMethod() throws IOException {

		launchThebrowser();

		hp = new homePage_page(driver);

	}

	@Test (enabled =true,priority = -3)
	
	public void selectFourthPositionFromDropdownAndPrint() throws EncryptedDocumentException, IOException, InterruptedException {
		hp.fromField(driver);
	}
	
	@Test (enabled =true,priority = -2)

	public void compareDestinationsWithExcelSheet() throws EncryptedDocumentException, IOException, InterruptedException {
	
		hp.compareDestinationsWithExcelSheet(driver);
	
	}
	
	@Test (enabled =true,priority = -1)
	
	public void sortingAndSelectDate() throws EncryptedDocumentException, IOException, InterruptedException {
	
		hp.sortingAndSelectDate(driver);
	

	}
	
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(8000);
		driver.quit();
	}

}
