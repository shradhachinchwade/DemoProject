package phptest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launch_PhpTravel 
{
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver= new ChromeDriver();
	    driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void openurl()
	{
		driver.get("https://www.phptravels.net/");
		String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL of new tab: " + currentUrl);
		Assert.assertTrue(currentUrl.contains("https://www.phptravels.net/"));

	}

}
