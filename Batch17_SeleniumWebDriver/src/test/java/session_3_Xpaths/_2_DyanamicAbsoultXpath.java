package session_3_Xpaths;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_DyanamicAbsoultXpath {
	
	WebDriver driver;
	String TextToBeClicked = "Pepe Jeans Tshirts";
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.myntra.com/");
		
	}
	
	@Test
	public void searchBoxTest() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]"));
	     searchBox.sendKeys("pepe");
	     
	     Thread.sleep(4000);
	     
	    WebElement searchItem = driver.findElement(By.xpath("//ul[@class=\"desktop-group\"]//li[@class=\"desktop-suggestion null\" and text()='Pepe Jeans Shirts']"));
	     searchItem.click();
	     Thread.sleep(3000);
	}     
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
