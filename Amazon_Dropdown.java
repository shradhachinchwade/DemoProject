package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon_Dropdown 
{

	public static void main(String[] args) 
	{
             ChromeDriver driver = new ChromeDriver();
             driver.get("https://www.amazon.in/");
             driver.manage().window().maximize();
             System.out.println(driver.getTitle());
             WebElement dropdown=driver.findElement(By.xpath("//select[@name='url']"));
             Select s1=new Select(dropdown);
             s1.selectByVisibleText("Books");
             s1.selectByValue("search-alias=baby");
            // s1.selectByIndex(11);
             
	}

}
