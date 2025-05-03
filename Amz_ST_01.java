package test;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import source.Checkout_Payment;
import source.Home;
import source.Login;
import source.Searchresult;
import source.Whishlist;
import testdata.FetchingfromExcelSheet;
//login-->searching-->whishlist-->adding to cart-->ccd payment//
public class Amz_ST_01 extends LaunchQuit
{
	@Test
	public void testcase1() throws InterruptedException, IOException
	{
		FetchingfromExcelSheet f1 =new FetchingfromExcelSheet();
		f1.fetching();
		
		Login l1=new Login(driver);
		l1.username();
		l1.password();
		
		Home h1=new Home(driver);
		h1.search();
		h1.searching_product();
		
		Searchresult sr=new Searchresult(driver);
		String parentWindowId = driver.getWindowHandle();
		sr.firstshoe();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

	        // Switch to the new window
	        Set<String> windowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = windowHandles.iterator();

	        // Switch to the new window (child window)
	        while (iterator.hasNext()) 
	        {
	            String windowHandle = iterator.next();
	            if (!windowHandle.equals(parentWindowId)) 
	            {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }
	        sr.whishlist();
	       
	        Whishlist w1=new Whishlist(driver);
	        String parentWindowId1 = driver.getWindowHandle();
	        w1.viewyourlist();
	        
	        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		        // Switch to the new window
		        Set<String> windowHandles1 = driver.getWindowHandles();
		        Iterator<String> iterator1 = windowHandles.iterator();

		        // Switch to the new window (child window)
		        while (iterator.hasNext()) 
		        {
		            String windowHandle = iterator.next();
		            if (!windowHandle.equals(parentWindowId)) 
		            {
		                driver.switchTo().window(windowHandle);
		                break;
		            }
		        }
		        w1.addtocart();
	        
		        Checkout_Payment cp= new Checkout_Payment(driver);
		        cp.pcheckout();
		        cp.selectaddress();
		        cp.useaddress();
		        cp.changepaymentbutton();
		        cp.ccdb();
	        
	  }
}
	



