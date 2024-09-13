package com.eRail.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class utility {

	public static void explicitWait(WebDriver driver, WebElement element, int time) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(time));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    Reporter.log("Explicitly waiting for " + time + "ms until the element is visible", true);
	}
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
	//1. create an object of properties file
	Properties prop= new Properties();
	//2. create object of fileInputStream
	FileInputStream myFile= new
	FileInputStream("C:\\Users\\SUHAS\\eclipse-workspace-1\\eRail\\erail.properties");
	//3. load file
	prop.load(myFile);
	//4.read data from file
	String value = prop.getProperty(key);
	Reporter.log("Reading data from peroperty file", true);
	Reporter.log("data is "+value, true);
	return value;
	}

}
