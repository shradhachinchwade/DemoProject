package test1;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class AmazonLoginExp 
{
	
	public static void main(String[] args) throws InterruptedException, IOException 
	{    
	       ChromeDriver driver =new ChromeDriver();  
	       driver.get("https://www.amazon.in/"); 
	       System.out.println(driver.getTitle());
	       driver.manage().window().maximize();
	       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	       driver.findElement(By.linkText("Sign in")).click();
	       driver.findElement(By.name("email")).sendKeys("8237871473");
	       driver.findElement(By.id("continue")).click();
	       driver.findElement(By.id("ap_password")).sendKeys("Shradha@03");
	       driver.findElement(By.id("signInSubmit")).click();
	      
	       
	       TakesScreenshot ts =(TakesScreenshot)driver; // upcasting driver
	       File source=ts.getScreenshotAs(OutputType.FILE);
	       File destination=new File("C:\\Users\\Shradha\\eclipse-workspace\\Selenium\\Screenshot\\Shradha.png");
	       FileUtils.copyFile(source, destination);
	       WebElement signout= driver.findElement(By.xpath("//span[.='Hello, Shradha']"));
	       //to perform Hoverover for signing out//
	       Actions a1= new Actions(driver);
	       a1.moveToElement(signout).perform();
	       driver.findElement(By.linkText("Sign Out")).click();
	}
	       

}


