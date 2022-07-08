package session_5_AlertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_AlertHandling {
	
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
		WebElement alertTypeSelection = driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox ')]"));
		alertTypeSelection.click();
		
		WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box ')]"));
		alertButton.click();
		
		Alert alertBtn = driver.switchTo(). alert();
		alertBtn. sendKeys("Tom Petter");
		Thread.sleep(2000);
		
		 alertBtn.accept();
		 
		 WebElement alertconfirmMsg = driver.findElement(By.xpath("//p[@id='demo1']"));
		 
		 Assert.assertEquals(true, alertconfirmMsg.getText().contains("Tom Petter"));
	
		
	}
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
}
}