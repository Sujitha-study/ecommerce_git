package EcommercePagePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class details_page {
	WebDriver driver;
	
	@FindBy (how=How.XPATH , using ="//span[@id='product-price-1']/span")
	@CacheLookup WebElement detailspage_price;
			
	public details_page(WebDriver driver)
	{
		this.driver =driver;
	}

	public String getItemPrice()
	{
		return detailspage_price.getText();
	}
}
