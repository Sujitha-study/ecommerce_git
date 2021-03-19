package EcommerceTestPack;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import EcommercePagePack.*;

public class Test_004_compareMobile extends Baseclass {

	@Test
	public void Compare2Mobiles() throws Exception
	{
		HomePage hp =PageFactory.initElements(driver, HomePage.class);
		MobilePage mp =PageFactory.initElements(driver, MobilePage.class);
		PopUpPage pp =PageFactory.initElements(driver, PopUpPage.class);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		hp.clickMobilebutton();
		js.executeScript("window.scrollBy(0,300)");
		mp.AddmobiletoCompare("Sony Xperia");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)");
		mp.AddmobiletoCompare("IPhone");
		takeSnapShot(driver ,"C:\\Users\\sujia\\OneDrive\\Desktop\\screenshot.jpg");
		Thread.sleep(5000);
		String windowmain =driver.getWindowHandle();
		System.out.println(windowmain);
		mp.ClickCompareBtn();
		Set<String> windows =driver.getWindowHandles();
		System.out.println(windows);
		Iterator<String> i = windows.iterator();
		while(i.hasNext())
		{
			String child = i.next();
			System.out.println(child);
			if(!windowmain.equalsIgnoreCase(child))
			{
				
				driver.switchTo().window(child);
				System.out.println("Shifted to child window" +driver.getTitle());
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				break;
			}
			
		}
		
		Assert.assertTrue(pp.CheckingMobiles());
		System.out.println("Passed Checking mobiles");
		Thread.sleep(3000);
		pp.ClickCloseWindow();
		Thread.sleep(2000);
		Set<String> windowlast =driver.getWindowHandles();
		if(windowlast.size()==1)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);	
		}
		
		
		
	}
}
