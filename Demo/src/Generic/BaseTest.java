package Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest implements AutoConst
{
	public WebDriver driver;
	@BeforeClass
	public  void openApplication()
	{
		System.setProperty(key, value);
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
	} 
	
}
