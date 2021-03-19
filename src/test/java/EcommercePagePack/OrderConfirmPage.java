package EcommercePagePack;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class OrderConfirmPage {

	@FindBy (how=How.XPATH , using ="//*[text()='Your order has been received.']")
	@CacheLookup List<WebElement> Order_confirm_msg;
	
	@FindBy (how=How.XPATH , using ="//p[text()='Your order # is: ']/a")
	@CacheLookup WebElement Orderid;
	
	public String getOrderId()
	{
		String orderid ="";
		if(Order_confirm_msg.size()>0)
		{
			orderid =Orderid.getText();
			System.out.println(orderid);
		}
		return orderid;
	}
}
