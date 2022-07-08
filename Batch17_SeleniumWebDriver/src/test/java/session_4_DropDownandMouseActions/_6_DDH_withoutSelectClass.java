package session_4_DropDownandMouseActions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _6_DDH_withoutSelectClass {

	WebDriver driver;
	
	@Before
	public void setUp()
	{
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			driver.get("https://demo.guru99.com/test/simple_context_menu.html");
	 }
	
	@Test
	public void dropDown() throws InterruptedException
	{
	WebElement rightClickMeButton =driver.findElement(By.xpath("//span[@class=\"context-menu-one btn btn-neutral\"]"));
	
	Thread.sleep(3000);
	
	Actions act = new Actions(driver);
	act.contextClick(rightClickMeButton).build().perform();
    List<WebElement>rightClickMenuOption = driver.findElements(By.xpath("//ul[@class=\"context-menu-list context-menu-root\"]"));
	
    for(int i = 0; i<rightClickMenuOption.size(); i++)
    {
    	System.out.println("option no" + (i+1)+ "is" +rightClickMenuOption.get(i).getText());
    	
    	if(rightClickMenuOption.get(i).getText().equals("copy"))
    	{
    		Thread.sleep(2000);
    		rightClickMenuOption.get(i).click();
    	}
    }		
	}   	
   @After	public void tearDown() throws InterruptedException
	{
   	Thread.sleep(2000);
   	driver.quit();
	}
}	
	

