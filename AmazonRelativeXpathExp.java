package test1;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonRelativeXpathExp 
{

	public static void main(String[] args) throws InterruptedException 
	{
		   ChromeDriver driver = new ChromeDriver();
		   driver.get("https://www.amazon.in/"); 
	       System.out.println(driver.getTitle());
	       driver.manage().window().maximize();
	       WebElement Signin= driver.findElement(By.xpath("//span[.='Hello, sign in']"));
	       Actions a1= new Actions(driver);
	       a1.moveToElement(Signin).perform();
	       driver.findElement(By.xpath("(//span[.='Sign in'])[1]")).click();
	       Thread.sleep(5000);
	       driver.findElement(By.xpath("(//input)[7]")).sendKeys("8237871473");
	       driver.findElement(By.xpath("(//input)[10]")).click();
	       driver.findElement(By.xpath("(//input)[9]")).sendKeys("*********");
	       driver.findElement(By.xpath("(//input)[10]")).click();

	}

}
