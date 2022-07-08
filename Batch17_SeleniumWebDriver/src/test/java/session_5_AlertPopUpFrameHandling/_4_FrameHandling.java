package session_5_AlertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_FrameHandling {

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
		WebElement singleFrameBtn = driver.findElement(By.xpath("//li[@class='active']//a[@class='analystic']"));
		singleFrameBtn.click();
		
		//Switching to frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id = 'singleframe']")));
		
		WebElement textBoxInFrame = driver.findElement(By.xpath("//input[@type='text']"));
		textBoxInFrame.sendKeys("text test test");
		
		//Switching back to main frame
		driver.switchTo().defaultContent();
		
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
