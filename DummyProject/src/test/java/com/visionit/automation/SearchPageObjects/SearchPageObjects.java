package com.visionit.automation.SearchPageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.visionit.automation.pageobjects.CmnPageObjects;

import io.cucumber.java.Scenario;

public class SearchPageObjects {

	private static final Logger logger = LogManager.getLogger(CmnPageObjects.class);
	WebDriver driver;
	Scenario scn;
	
	public SearchPageObjects(WebDriver driver,Scenario scn) {
		this.driver = driver;
		this.scn =scn;
	}
	
	//Locators
	//private By searchBoxElement = By.id("twotabsearchtextbox");
	private By ListOfElement = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	
	//search page methods
	public void validateSearchPageTitle()
	{
		//Wait for titile
        WebDriverWait webDriverWait1 = new WebDriverWait(driver,20);
  //      logger.info("Waiting for page title : \"Amazon.in : Laptop\"");
        webDriverWait1.until(ExpectedConditions.titleContains("Amazon.in"));
    //    logger.info("Waiting for page title : \"Amazon.in \"");
        //Assertion for Page Title
        Assert.assertEquals("Page Title validation",true, driver.getTitle().contains("Amazon.in"));
        scn.log("Page title validation successfull: " + driver.getTitle());
        logger.info("Page title validation successfull: \" + driver.getTitle()");
	}
	
	public void clickOnFirstProd()
	{
		List<WebElement> listOfProducts = driver.findElements(ListOfElement);
        scn.log("Number of products searched: " + listOfProducts.size());
        logger.info("logger.info(\"Page title validation successfull: \\\" + driver.getTitle()\");");
        //But as this step asks click on any link, we can choose to click on Index 0 of the list
        listOfProducts.get(0).click();
       scn.log("Click on the first Link in the List. Link Text: " + listOfProducts.get(0).getText());
       logger.info("Click on the first Link in the List. Link Text: " + listOfProducts.get(0).getText());
	}
	
	
}
