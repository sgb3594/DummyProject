package com.visionit.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class CmnPageObjects {
	private static final Logger logger = LogManager.getLogger(CmnPageObjects.class);
	WebDriver driver;
	Scenario scn;
	
	//locators
	//private By search_text_box = By.id("twotabsearchtextbox");
	private By searchBoxElement = By.id("twotabsearchtextbox");
	private By searchBtnElement = (By.xpath("//input[@value='Go']"));
	//constructor
	public CmnPageObjects(WebDriver driver,Scenario scn) {
		this.driver = driver;
		this.scn =scn;
	}

	//page methods
	public void validatingPageTittle()
	{
		 String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	        String actual =driver.getTitle();
	        Assert.assertEquals("Page Title validation",expected,actual);
	        scn.log("Page title validation successfull. Actual title: " + actual );
	        logger.info("Page title validation successfull. Actual title: \" + actual");
	}
	
	public void searchProduct(String productName)
	{
		 WebDriverWait webDriverWait = new WebDriverWait(driver,20);
	     WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
	     logger.info("Created webelement for searchbox");
	     elementSearchBox.sendKeys(productName);
	     logger.info("Sending keys as"+ productName);
	     scn.log("Product Searched: " + productName);
	}
	
	public void clickOnSearchBtn()
	{
		  driver.findElement(searchBtnElement).click();
	      scn.log("Clicked on the GO button");
	      logger.info("Clicked on the GO button");
	        
	}
}
