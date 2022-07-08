package Demo;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
//TEST PUSH TO CHECK
public class CopyAssignment {
	
	public class PracticePage_with_LinearWay {
		
		WebDriver driver;
		WebDriverWait wait;
		String url="https://www.rahulshettyacademy.com/AutomationPractice/";
		
		@Before
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wait= new WebDriverWait(driver,20);
			driver.get(url);
			
		}
		
		@Test
		//1.  Radio Button selection 
		public void  radioButtonValidation()
		{
		     WebElement radioBtn =driver.findElement(By.xpath("//input[@value='radio2']"));
		     radioBtn.click();
		     Assert.assertEquals("Radio button not selected", true, radioBtn.isSelected());
		     System.out.println("TestCase_1 => Assertion for Radio button get passed");
		}
		
		@Test
		//2. Drop Down Handling (using Select class)
		public void dropDown()
		{
			WebElement dropDownBtn =driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
			Select optionSelect =new Select(dropDownBtn);
			optionSelect.selectByValue("option3");
			System.out.println("TestCase_2 => Drop down \"Option3\" get selected");
			
		}
		
		@Test
		//3.  Check box selection 
		public void checkBoxValidation()
		{
			WebElement checkBox = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
			checkBox.click();
			Assert.assertEquals("CheckBox is not selected", true, checkBox.isSelected());
			System.out.println("TestCase_3 => Assertion for checkbox get passed");
		}
		
		@Test
		//4. Switch to new browser window 
		public void windowHandling() throws InterruptedException
		{         
			driver.findElement(By.xpath("//button[@id='openwindow']")).click();
			          //1. (Using ArrayList)
			ArrayList <String> arr= new ArrayList <String> (driver.getWindowHandles());
			//String parentWindowId= arr.get(0);
			String childWindowId= arr.get(1);
			          //2. (Using Set)
//			Set <String> set= driver.getWindowHandles();
//			Iterator <String> itr= set.iterator();
//			String parentWindowId=itr.next();
//			String childWindowId= itr.next();
			
			driver.switchTo().window(childWindowId);
			wait.until(ExpectedConditions.urlContains("qaclickacademy"));
			Assert.assertEquals("URL on new window is not matched", "http://www.qaclickacademy.com/", driver.getCurrentUrl());
			System.out.println("URL on new window is: "+ driver.getCurrentUrl());
			System.out.println("TestCase_4 => Assertion for window handling get passed");
			
		//	String ParentID=windowHandle.get(0);
		//	String ChildID=windowHandle.get(1);
		//	String ParentID=windowHandle.get(0);
		//	String ChildID=windowHandle.get(1);
			
			driver.switchTo().window(childWindowId);
		//	driver.switchTo().window(ChildID);
			Thread.sleep(3000);			
			Thread.sleep(3000);
		}
		
		@Test
		//5. Alert Handling (Using Alert class)
		public void alertHandling() throws InterruptedException
		{
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hi");
			driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
			Alert alt = driver.switchTo().alert();
			System.out.println("Text on alert popUp is: "+ alt.getText());
			Assert.assertEquals("Text on alert popup is not matched", "Hello Hi, share this practice page and share your knowledge", alt.getText());
			alt.accept();
			System.out.println("TestCase_5 => Assertion for alert popUp get passed");
			
		}
		@After
		public void tearDown() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.quit();
		}

	}


}
