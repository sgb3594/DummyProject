package session_3_Xpaths;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListOfLinksFromWebPage {
	
	@Test
	public void findLinks() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		List<WebElement>LinksOnPage = driver.findElements(By.tagName("a"));
		
		System.out.println("Print all text without blank value");
		
		for(int i = 0; i < LinksOnPage.size(); i++)
		{
			if(LinksOnPage.get(i).getText().isEmpty())
			{
				//noyhing
			}
			else
			{
				System.out.println((i+1)+ " " + LinksOnPage.get(i).getText());
			}
		}
		Thread.sleep(3000);
		driver.quit();
	}

}
