package EcommercePagePack;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartPage {

	@FindBy (how=How.XPATH ,using ="//button[@title='Empty Cart']")
	@CacheLookup WebElement emptycart;
	
	@FindBy (how = How.XPATH , using ="//h1[contains(text(),'Shopping Cart is Empty')]")
	@CacheLookup List<WebElement> cartemptymsg;
	
	@FindBy (how=How.XPATH , using ="//button[contains(@title,'Proceed to Checkout')]")
	@CacheLookup WebElement checkoutbtn;
	
	public void clickemptycart()
	{
		emptycart.click();
	}
	
	public void clickProceedtoCheckout()
	{
		checkoutbtn.click();
	}
	
	public boolean CheckCartEmpty()
	{
		Boolean result =false;
		if(cartemptymsg.size() >0)
		{
			result=true;
		}
		return result;
	}
}
