package session_3_Xpaths;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_DyanamicAbsoluteXpath {

	WebDriver driver;
	
	String TextToBeClicked = "Pepe Jeans Jackets Men";
	
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
	public void searchBoxText() throws InterruptedException
	{
		WebElement searchBoxText = driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]"));
		searchBoxText.sendKeys("Pepe");
		
		Thread.sleep(3000);
		
		List<WebElement>searchList = driver.findElements(By.xpath("//ul[@class= 'desktop-group']//li[@class=\"desktop-suggestion null\"]"));
		
		System.out.println("The search result count is : "+ searchList.size());
		

	for(int i =0; i<searchList.size(); i++)
		{
			//System.out.println(searchList.get(i).getText());
		if(searchList.get(i).getText().equals(TextToBeClicked))
		{
			searchList.get(i).click();
		}
		}
	Thread.sleep(3000);
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
}
	
