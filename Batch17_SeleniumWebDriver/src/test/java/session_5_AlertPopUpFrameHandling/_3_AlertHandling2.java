package session_5_AlertPopUpFrameHandling;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_AlertHandling2 {

	
WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/digest_auth");
		
	}
	
	@Test
	public void dropDown()
	{
		String username = "admine";
		String password = "admine";
		String URL = "http://" + username + ";" + password + "@" + "the-internet.herokuapp.com/digest_auth";
		driver.get(URL);
      
		Assert.assertEquals(true,driver.findElement(By.xpath("//p[contains(text(),' Congratulations! ' )]")).getText().contains( "Congratulations!"));
		
	}
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
}
	
}	
	
	
	

