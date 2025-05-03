package test1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class AmazonLoginWithDDT extends LaunchQuit
{
	@Test
	public void Login() throws InterruptedException
	{
		ChromeDriver driver =new ChromeDriver();  
		driver.get("https://www.amazon.in/"); 
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);
		WebElement signout= driver.findElement(By.xpath("//span[.='Hello, Shradha']"));
		//to perform Hoverover for signing out//
		Actions a1= new Actions(driver);
		a1.moveToElement(signout).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
	}
	

}
