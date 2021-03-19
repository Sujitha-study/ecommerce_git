package EcommerceTestPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import EcommercePagePack.HomePage;
import EcommercePagePack.MobilePage;
import EcommercePagePack.details_page;

public class Test_002_compareprice extends Baseclass {
WebDriver driver;
	
	@Test
	public void CompareBothPrice()
	{
		String mobilepage_price,detailspage_price;
		driver.manage().window().maximize();
		HomePage hp =PageFactory.initElements(driver, HomePage.class);
		MobilePage mp= PageFactory.initElements(driver, MobilePage.class);
		details_page dp =PageFactory.initElements(driver, details_page.class);
		hp.clickMobilebutton();
		if(driver.getTitle().contains("Mobile"))
		{
			mobilepage_price =mp.getItemPrice();
			mp.clickdetails();
			detailspage_price =dp.getItemPrice();
			System.out.println("mobilepage price"+mobilepage_price);
			System.out.println("detailspage_price"+detailspage_price);
			Assert.assertEquals(mobilepage_price, detailspage_price);
		}
	}
}
