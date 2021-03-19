package EcommerceTestPack;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import EcommercePagePack.*;

public class Test_005_SendingWishlist extends Baseclass {
	@Test
	public void SendWishlist() throws InterruptedException
	{
		HomePage hp =PageFactory.initElements(driver, HomePage.class);
		CreateAccountPage cap =PageFactory.initElements(driver, CreateAccountPage.class);
		TVPage TVp =PageFactory.initElements(driver, TVPage.class);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		Thread.sleep(3000);
		hp.clickAccountbtn();
		
		Thread.sleep(3000);
		hp.clickMyAccountbtn();
		Thread.sleep(2000);
		hp.clickCreateAccount();
		Thread.sleep(3000);
		Assert.assertTrue(cap.RegisterAccount());
		Thread.sleep(3000);
		hp.ClickTVbtn();
		//js.executeScript("window.scrollby(0,300)");
		//js.executeScript("window.scrollBy(0,300)");
		TVp.AddTVmodeltowishlist();
		Thread.sleep(2000);
		TVp.ClickWishlist();
		TVp.EnterEmail();
		Thread.sleep(3000);
		TVp.SharingWishlist();
		Thread.sleep(2000);
		Assert.assertTrue(TVp.Checkingmsg());
		
	}
}
