package EcommerceTestPack;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import EcommercePagePack.HomePage;
import EcommercePagePack.*;

public class Test_006_Billing extends Baseclass {

	@Test
	public void BilltheWishList() throws InterruptedException
	{
		HomePage hp =PageFactory.initElements(driver, HomePage.class);
		LoginPage lp =PageFactory.initElements(driver, LoginPage.class);
		TVPage TVp=PageFactory.initElements(driver,TVPage.class);
		BillingPage bp =PageFactory.initElements(driver, BillingPage.class);
		OrderConfirmPage op =PageFactory.initElements(driver, OrderConfirmPage.class);
		ShoppingCartPage sp=PageFactory.initElements(driver, ShoppingCartPage.class);
		JavascriptExecutor js=(JavascriptExecutor )driver;
		hp.clickAccountbtn();
		hp.ClickLogInbtn();
		System.out.println("click Login button");
		lp.LoggingIn();
		System.out.println("Clicked Logging button");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='skip-link skip-account']")).click();
		
		Thread.sleep(2000);
		hp.clickWishListBtn();
		Thread.sleep(2000);
		System.out.println("Clicked WishList button");
		Thread.sleep(3000);
		TVp.ClickAddtoCart();
		System.out.println("Clicked Add tocart ");
		Thread.sleep(2000);
		sp.clickProceedtoCheckout();
		System.out.println("Click proceed to checkout");
		Thread.sleep(3000);
		bp.EnterBillingDetails();
		System.out.println("finished billind details");
		bp.clickContinue();
		//js.executeScript("window.scrollBy(100,300)");
		//js.executeScript("arguments[0].scrollIntoView()", product);
		js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.id("billing:telephone")));
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[@title='Continue' and @onclick='billing.save()']")));
		
		bp.ClickShippingContinue();
		System.out.println("clicked shipping continue");
		//js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//input[@id='p_method_checkmo']")));
		Thread.sleep(1000);
		System.out.println("moved to money webelement");
		bp.ClickShippingMethod();
		Thread.sleep(2000);
		
		Assert.assertTrue((op.getOrderId()!="")?true:false);
		
	}
}
