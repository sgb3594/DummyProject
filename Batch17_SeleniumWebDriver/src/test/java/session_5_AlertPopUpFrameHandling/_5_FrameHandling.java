package session_5_AlertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _5_FrameHandling {

	

WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Frames.html");
		
	}
	
	@Test
	public void dropDown()
	{
		WebElement multiFrameBtn = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
		multiFrameBtn.click();
		
		//switching to frame1
		WebElement frame1 = driver.findElement(By.xpath("//div[@id='Multiple']//iframe"));
		driver.switchTo().frame(frame1);
		
		//switching to frame inside frame
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='row']/iframe")));
		
		WebElement textBoxInFrame = driver.findElement(By.xpath("//input[@type='text']"));
		textBoxInFrame.sendKeys("text test test");
		
		//switching back to main window
	//driver.switchTo().defaultContent();
		//or
     	driver.switchTo().parentFrame();   //switch back tp F 1
		driver.switchTo().parentFrame();     //switch back frome frame 1 to main window
		
		WebElement pageCenterText = driver.findElement(By.xpath("//h1[contains(text(),'Automation Demo Site ')]"));
		System.out.println(pageCenterText.getText());
		
	}
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
    }
	
}
