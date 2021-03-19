package EcommerceTestPack;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import EcommercePagePack.AddToCartPage;
import EcommercePagePack.HomePage;
import EcommercePagePack.MobilePage;
import EcommercePagePack.ShoppingCartPage;


public class Test_003_addtocart extends Baseclass {
	
@Test
public void addtocartMobile() throws Exception
{
	HomePage hp =PageFactory.initElements(driver, HomePage.class);
	MobilePage mp =PageFactory.initElements(driver, MobilePage.class);
	AddToCartPage ap =PageFactory.initElements(driver, AddToCartPage.class);
	ShoppingCartPage sp =PageFactory.initElements(driver, ShoppingCartPage.class);
	hp.clickMobilebutton();
	Thread.sleep(3000);
	mp.addtocart();
	Thread.sleep(3000);
	ap.AddNumber();
	Thread.sleep(3000);
	ap.ClickUpdate();
	Thread.sleep(3000);
	Assert.assertTrue(ap.CheckforErrorMsg());
	sp.clickemptycart();
	Thread.sleep(2000);
	Assert.assertTrue(sp.CheckCartEmpty());	
	
}
}
