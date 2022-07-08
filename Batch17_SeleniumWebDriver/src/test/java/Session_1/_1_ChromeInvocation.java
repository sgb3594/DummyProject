package Session_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_ChromeInvocation {
	public static void main(String []args)
	{
		//set the path of browser driver
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/chromedriver.exe");
		//no need to write this line if driver is in root folder
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		//topcasting or upcasting - object of chromedriver class with WebDriver interfcae
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//entering the URL
		
		driver.get("https://www.facebook.com/");
		//fetching the page title
		
		String title = driver.getTitle();
		String titleExpected = "Facebook – log in or sign up";
		System.out.println("web page title is :" + title);
		
		//Validation
		if(title.equals(titleExpected))
		{
			System.out.println("Title matched");
		}
		else
		{
			System.out.println("Title mismatched");
		}
		
		driver.quit();
		
		
		
		
		
		
	}

}
