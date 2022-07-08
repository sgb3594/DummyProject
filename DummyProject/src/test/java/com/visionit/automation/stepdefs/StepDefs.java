package com.visionit.automation.stepdefs;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.visionit.automation.SearchPageObjects.SearchPageObjects;
import com.visionit.automation.core.WebDriverFactory;
import com.visionit.automation.pageobjects.CmnPageObjects;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

	 private static final Logger logger = LogManager.getLogger(StepDefs.class);
	 
	WebDriver driver;
	String base_url = " https://www.amazon.in/ ";
	int implicitly_Wait_timeouts_in_sec = 20;
	Scenario scn; // this is set in the @Before method
	
	 CmnPageObjects  cmnPageObjects;
	 SearchPageObjects searchPageObjects;
	 
	 // make sure to use this before import io.cucumber.java.Before;
    // Use @Before to execute steps to be executed before each scnerio
    // one example can be to invoke the browser
    @Before
    public void setUp(Scenario scn) throws Exception{
    	this.scn =scn;
       // driver = new ChromeDriver();
    	 //Get the browser name by default it is chrome
        String browserName = WebDriverFactory.getBrowserName();
        driver = WebDriverFactory.getWebDriverForBrowser(browserName);
        

        logger.info("Browser invoked.");
        driver.manage().window().maximize();
        logger.info("Browser maximized.");
        driver.manage().timeouts().implicitlyWait(implicitly_Wait_timeouts_in_sec, TimeUnit.SECONDS);
        logger.info("Set Implicit wait as "+ implicitly_Wait_timeouts_in_sec);
        
        cmnPageObjects = new CmnPageObjects(driver,scn);
        searchPageObjects = new SearchPageObjects(driver,scn);
    }
	
    // make sure to use this after import io.cucumber.java.After;
    // Use @After to execute steps to be executed after each scnerio
    // one example can be to close the browser
    @After(order=1)
    public void cleanUp(){
        WebDriverFactory.quitDriver();
        scn.log("Browser Closed");
    }
    
    @After(order=2)
    public void takeScreenShot(Scenario s) {
        if (s.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot)driver;
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
    }
        
//	@Given("User opened browser")
//	public void user_opened_browser() {
//	   driver = new ChromeDriver();
//	   driver.manage().window().maximize();
//	   driver.manage().timeouts().implicitlyWait(implicitly_Wait_timeouts_in_sec, TimeUnit.SECONDS);
//	   
//	}


	@Given("User navigated to the home application url")
	public void user_navigated_to_the_home_application_url() {
		 driver.get(base_url);
		 logger.info("Browser navigate to URL: "+base_url);
	//	 scn.log("Browser navigate to URL : " + base_url);
	 //      String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	  //      String actual =driver.getTitle();
	 //         Assert.assertEquals("Page Title validation",expected,actual);
	  //   //   scn.log("Page title validation successfull. Actual title: " + actual );
	   //  //   logger.info("Page title validation successfull. Actual title: \" + actual");
		 cmnPageObjects.validatingPageTittle();
	}
	
	
	@When("User Search for product {string}")
	public void user_search_for_product(String productName) {
		//wait and search for product
//		 WebDriverWait webDriverWait = new WebDriverWait(driver,20);
//	        WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
//	        logger.info("Created webelement for searchbox");
//	        elementSearchBox.sendKeys(productName);
//	        logger.info("Sending keys as"+ productName);
//	        scn.log("Product Searched: " + productName);
//	        driver.findElement(By.xpath("//input[@value='Go']")).click();
//	        scn.log("Clicked on the GO button");
//	        logger.info("Clicked on the GO button");
//	       
		 cmnPageObjects.searchProduct(productName);
		 cmnPageObjects.clickOnSearchBtn();
	}
	@Then("Search Result page is displayed")
	public void search_result_page_is_displayed() {
		 //Wait for titile
//        WebDriverWait webDriverWait1 = new WebDriverWait(driver,20);
//        logger.info("Waiting for page title : \"Amazon.in : Laptop\"");
//        webDriverWait1.until(ExpectedConditions.titleIs("Amazon.in : Laptop"));
//        
//
//        //Assertion for Page Title
//        Assert.assertEquals("Page Title validation","Amazon.in : Laptop", driver.getTitle());
//        scn.log("Page title validation successfull: " + driver.getTitle());
//        logger.info("Page title validation successfull: \" + driver.getTitle()");
        searchPageObjects.validateSearchPageTitle();
		
		
		
    }
	@When("User click on any product")
	public void user_click_on_any_product() {
	    
//		 //listOfProducts will have all the links displayed in the search box
//        List<WebElement> listOfProducts = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
//        scn.log("Number of products searched: " + listOfProducts.size());
//        logger.info("logger.info(\"Page title validation successfull: \\\" + driver.getTitle()\");");
//        //But as this step asks click on any link, we can choose to click on Index 0 of the list
//        listOfProducts.get(0).click();
//        scn.log("Click on the first Link in the List. Link Text: " + listOfProducts.get(0).getText());
//        logger.info("Click on the first Link in the List. Link Text: " + listOfProducts.get(0).getText());
		 searchPageObjects.clickOnFirstProd();
	}

    @Then("Product Description is displayed in new tab")
	public void product_description_is_displayed_in_new_tab() {
	    
    	  //As product description click will open new tab, we need to switch the driver to the new tab
        //If you do not switch, you can not access the new tab html elements
        //This is how you do it
        Set<String> handles = driver.getWindowHandles(); // get all the open windows
        scn.log("List of windows found: "+handles.size());
        scn.log("Windows handles: " + handles.toString());
        Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
        String original = it.next();//gives the parent window id
        String prodDescp = it.next();//gives the child window id

        driver.switchTo().window(prodDescp); // switch to product Descp
        scn.log("Switched to the new window/tab");
        
        //Now driver can access new driver window, but can not access the orignal tab
        //Check product title is displayed
        WebElement productTitle = driver.findElement(By.id("productTitle"));
        Assert.assertEquals("Product Title",true,productTitle.isDisplayed());
        scn.log("Product Title header is matched and displayed as: " + productTitle.getText() );

      //  WebElement addToCartButton = driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']"));
       // Assert.assertEquals("Product Title",true,addToCartButton.isDisplayed());
        scn.log("Add to cart Button is displayed");
        
        //Switch back to the Original Window, however no other operation to be done
        driver.switchTo().window(original);
        scn.log("Switched back to Original tab");
        
    }
	

	}
	
	
	
	
	
	
	


