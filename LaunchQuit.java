package test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class LaunchQuit 
{
	WebDriver driver;  //globally declared
	@BeforeMethod
	@Parameters("browser")
	public void launch(String nameofbrowser)
	{
		if(nameofbrowser.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		if(nameofbrowser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
	
			
		}
	@AfterMethod
	public void quit() throws InterruptedException, IOException
	{
		   TakesScreenshot ts = (TakesScreenshot)driver; // upcasting driver
	       File source=ts.getScreenshotAs(OutputType.FILE);
	       File destination=new File("C:\\Users\\Shradha\\eclipse-workspace\\Amazon_POM\\Excelsheet\\Screenshot\\Shradha"+Math.random()+".png");
	       FileUtils.copyFile(source, destination);
		   Thread.sleep(3000);
		   driver.quit();
	}

}
