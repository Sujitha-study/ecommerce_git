package EcommercePagePack;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddToCartPage {

	@FindBy (how=How.XPATH , using ="//td[@class='product-cart-actions']//a[text()='Edit']")
	@CacheLookup WebElement EditBtn;
	
	@FindBy (how=How.NAME , using ="qty")
	@CacheLookup WebElement NumofMob;
	
	@FindBy (how=How.XPATH , using ="//button[@title='Update Cart']")
	@CacheLookup WebElement Updatebtn;
	
	@FindBy (how= How.XPATH ,using ="//span[contains(text(),'The maximum quantity allowed for purchase is 500')]" )
	@CacheLookup List<WebElement> errormsgs;
	
	public void ClickUpdate()
	{
		Updatebtn.click();
	}
	
	public void AddNumber() throws Exception
	{
		EditBtn.click();
		Thread.sleep(3000);
		NumofMob.sendKeys("1000");
	}
	public Boolean CheckforErrorMsg ()
	{
		Boolean result =false;
		
		if(errormsgs.size()>0)
		{
			System.out.println("messgaes "+errormsgs.size());
		result =true;
		}
		return result;
	}
}
