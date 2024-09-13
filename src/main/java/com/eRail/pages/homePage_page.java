package com.eRail.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage_page {

	// DESTINATION
	@FindBy(xpath = "//input[@id='txtStationFrom']")
	private WebElement from;
	@FindBy(xpath = "//div[@title='Delhi Azadpur']//div[1]")
	private WebElement del;
	@FindBy(xpath = "(//div[@style='width:240px;float:left;overflow:hidden'])[2]")
	private WebElement delan;
	@FindBy(xpath = "//div[text()='Denduluru']")
	private WebElement denduluru;
	@FindBy(xpath = "(//div[@style='width:240px;float:left;overflow:hidden'])[1]")
	private WebElement puneJn;
	@FindBy(xpath = "(//div[@style='width:240px;float:left;overflow:hidden'])[3]")
	private WebElement naviMumbai;

	// sorting on date

	@FindBy(xpath = "(//input[@type='button'])[2]")
	private WebElement sort;
	@FindBy(xpath = "(//td[text()='3'])[2]")
	private WebElement date;

	// for css values
	@FindBy(xpath = "//a[text()='IRCTC eTicket']")
	private WebElement eTicket;

	public homePage_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void fromField(WebDriver driver) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		w.until(ExpectedConditions.elementToBeClickable(from)).click();
		Reporter.log("Click on the from textfield", true);
		w.until(ExpectedConditions.elementToBeClickable(from)).clear();
		Reporter.log("Clear the from textfield", true);
		w.until(ExpectedConditions.elementToBeClickable(from)).sendKeys("DEL");
		Reporter.log("User enter text in From textfield", true);
		System.err.println(del.getText());
		w.until(ExpectedConditions.elementToBeClickable(del)).click();
		Reporter.log("Click on the 4th position from 'From' textfield", true);

	}

	public void compareDestinationsWithExcelSheet(WebDriver driver)
			throws EncryptedDocumentException, IOException, InterruptedException {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		w.until(ExpectedConditions.elementToBeClickable(from)).click();
		Reporter.log("Click on the from textfield", true);
		w.until(ExpectedConditions.elementToBeClickable(from)).clear();
		Reporter.log("Clear the from textfield", true);
		w.until(ExpectedConditions.elementToBeClickable(from)).sendKeys("DEL");
		Reporter.log("User enter text in From textfield-DEL", true);

		// how to read excel sheet
		File myFile = new File("D:\\excel\\dest.xlsx");

		String dend = WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();

		String delang = WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(0).getCell(2).getStringCellValue();

		String delhi = WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(0).getCell(3).getStringCellValue();

		String pune = WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(0).getCell(4).getStringCellValue();

		String navi = WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(0).getCell(5).getStringCellValue();

		String Dend = denduluru.getText();
		String Delhi = del.getText();
		String Delang = delan.getText();
		System.out.println(denduluru.getText());
		System.out.println(del.getText());
		System.out.println(delan.getText());

		Assert.assertEquals(Dend, dend, "if act and exp is not match then our test cases if Failed");
		Reporter.log("Check Dendluru city name in from textfield", true);
		Assert.assertEquals(Delhi, delhi, "if act and exp is not match then our test cases if Failed");
		Reporter.log("Check Delhi city name in from textfield", true);
		Assert.assertEquals(Delang, delang, "if act and exp is not match then our test cases if Failed");
		Reporter.log("Check Delang city name in from textfield", true);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		from.click();
		Reporter.log("Click on the from textfield", true);

		from.sendKeys("Pune");
		Reporter.log("User enter text in From textfield-pune", true);
		// with the help of action class -- Ctrl+c and ctrl v -- Actions class ?

//	  from.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//      from.sendKeys("Pune");
		String Pune = puneJn.getText();
		Assert.assertEquals(Pune, pune, "if act and exp is not match then our test cases if Failed");
		Reporter.log("Check pune city name in from textfield", true);
		from.click();
		Reporter.log("Click on the from textfield", true);
		from.sendKeys("Mumbai");
		Reporter.log("User enter text in From textfield-mumbai", true);
//		 from.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//	      from.sendKeys("Mumbai");
		String Navi = naviMumbai.getText();

		Assert.assertEquals(Navi, navi, "if act and exp is not match then our test cases if Failed");
		Reporter.log("Check pune city name in from textfield", true);
	}

	public void sortingAndSelectDate(WebDriver driver) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(sort)).click();
		Reporter.log("Click on the 'Sort on Date' textfield", true);
		w.until(ExpectedConditions.elementToBeClickable(date)).click();
		Reporter.log("select date from sort on date field", true);

	}

}
