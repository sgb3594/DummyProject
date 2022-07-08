package session_5_AlertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class _1_AlertHandling {

	WebDriver driver;
	
	@Before
	public void setUp()
	{
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.get("http://demo.automationtesting.in/Alerts.html");
	}
    
	
	@Test
	public void dropDown() throws InterruptedException
	{
	  WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),' click the button to display an  alert box:')]"))	;
	  alertButton.click();
	  
	  Alert alert = driver.switchTo().alert();
	  
	  Thread.sleep(2000);
	  
	  System.out.println("Text of alert is : " + alert.getText());
	  
	  Assert.assertEquals("Alert text is matching","I am an alert box!",alert.getText());
	  alert.accept();
	  
	}  
	@After()
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	
	
}