package Session_2_Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_PageElementInteractById {
	
	public static void main(String [] args)
	{
		//set path of browser driver
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/chromedriver.exe");
		
		//Topcastin or upcasting - object of chromedriver class with webdriver interface
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Invoking the browser with given URL
		
		driver.get("http://demo.automationtesting.in/index.html");
		
		System.out.println("landing pagetitle" + driver.getTitle());
		
		//Finding the webElement of SearchBox for username field
		WebElement userNameField = driver.findElement(By.id("email"));
		
		//Entering text into userNameField
		userNameField.sendKeys("test@gmail.com");
		
		//clicking on procced button
		WebElement proccedButton = driver.findElement(By.id("enterimg"));
		proccedButton.click();
		
		//fetching the next page title
		String nextPageTitle = driver.getTitle();
		
		//printing the next page title
		System.out.println(nextPageTitle);
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
