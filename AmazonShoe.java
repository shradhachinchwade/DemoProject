package test1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class AmazonShoe  extends LaunchQuit   //Creditcard
{
@Test
public void addshoe() throws InterruptedException, EncryptedDocumentException, IOException 
{
FileInputStream fis=new FileInputStream("C:\\Users\\Shradha\\eclipse-workspace\\Selenium\\Excelsheet\\ShradhaExcelsheet.xlsx");
Workbook wb=WorkbookFactory.create(fis);
Sheet s1=wb.getSheet("Login");
//numeric value fetch//
username=NumberToTextConverter.toText(s1.getRow(1).getCell(0).getNumericCellValue());
//String username=s1.getRow(1).getCell(0).getStringCellValue();
System.out.println(username);
password=s1.getRow(1).getCell(1).getStringCellValue();		   
driver.findElement(By.linkText("Sign in")).click();
driver.findElement(By.name("email")).sendKeys(username);
driver.findElement(By.id("continue")).click();
//driver.findElement(By.id("ap_password")).sendKeys(password);
driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
driver.findElement(By.id("signInSubmit")).click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
search.sendKeys("Shoes");
search.sendKeys(Keys.ENTER);
driver.findElement(By.className("s-image")).click();
Set<String>pandc=driver.getWindowHandles();
Iterator<String>pc =pandc.iterator();
String parentid=pc.next();
String childid=pc.next();
driver.switchTo().window(childid);
/*driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='a-icon a-icon-cart']")));
driver.findElement(By.xpath("//input[@id='add-to-cart-button']/following-sibling::span[@id='submit.add-to-cart-announce']"));*/
driver.findElement(By.id("add-to-wishlist-button")).click();
driver.findElement(By.id("atwl-list-name-3S9Z1L10R12G7")).click();
Set<String>pandc1=driver.getWindowHandles();
Iterator<String>pc1 =pandc.iterator();
String parentid1=pc1.next();
String childid1=pc1.next();
driver.switchTo().window(childid1);
driver.findElement(By.linkText("View Your List")).click();
driver.findElement(By.linkText("Add to Cart")).click();
driver.findElement(By.linkText("Proceed to checkout")).click();
driver.findElement(By.xpath("//*[@id=\"address-list\"]/div/div[1]/div/fieldset[1]/div[2]/span/div/label/input")).click();
driver.findElement(By.xpath("//input[@data-testid='Address_selectShipToThisAddress']")).click();
Thread.sleep(6000);
//WebDriverWait wdw=new WebDriverWait(driver, Duration.ofSeconds(20));
//wdw.until(ExpectedConditions.titleIs("Pay on delivery"));
driver.findElement(By.id("payChangeButtonId")).click();
// credit card//
driver.findElement(By.xpath("//input[@value='SelectableAddCreditCard']")).click();
driver.close();
  
}

}
