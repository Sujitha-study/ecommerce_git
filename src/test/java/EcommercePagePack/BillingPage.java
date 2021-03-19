package EcommercePagePack;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class BillingPage {
@FindBy (how=How.ID , using ="billing:firstname")
@CacheLookup WebElement Firstname;

@FindBy (how=How.ID , using ="billing:lastname")
@CacheLookup WebElement lastname;

@FindBy (how=How.ID , using ="billing:street1")
@CacheLookup WebElement Address;

@FindBy (how=How.ID , using ="billing:city")
@CacheLookup WebElement City;

@FindBy (how=How.ID , using ="billing:region_id")
@CacheLookup WebElement ListRegion;

@FindBy (how=How.ID , using ="billing:postcode")
@CacheLookup WebElement Postcode;

@FindBy (how=How.ID , using ="billing:country_id")
@CacheLookup WebElement ListCountry;

@FindBy (how=How.ID , using ="billing:telephone")
@CacheLookup WebElement telephone;

@FindBy (how=How.XPATH , using ="//button[@title='Continue' and @onclick='billing.save()']")
@CacheLookup WebElement BillingContinue;

@FindBy (how=How.XPATH , using ="//button[@onclick='shippingMethod.save()']")
@CacheLookup WebElement shippingMethod;

@FindBy (how=How.XPATH,  using="//input[@id='p_method_checkmo']")
@CacheLookup WebElement Money;

@FindBy (how=How.XPATH , using ="payment.save()']")
@CacheLookup WebElement payment_continue;

@FindBy(how=How.XPATH, using ="//button[@title='Place Order']")
@CacheLookup WebElement place_order;

public void EnterBillingDetails()
{
	Firstname.clear();
Firstname.sendKeys("Sreesha");
lastname.clear();
lastname.sendKeys("Raja");
Address.clear();
Address.sendKeys("375bv3475be74enb");
City.clear();
City.sendKeys("Kovilpatti");
/*
 * Select sel =new Select(ListRegion); sel.selectByVisibleText("Florida");
 */
System.out.println("Done up to city");
Postcode.clear();
Postcode.sendKeys("2121");
System.out.println("postcode is done");
Select sel1 =new Select(ListCountry);

sel1.selectByVisibleText("Australia");
System.out.println("Country is done");
}
public void clickContinue()
{
telephone.clear();
telephone.sendKeys("7656543356");
System.out.println("telephone is done");
BillingContinue.click();
System.out.println("Billing continue done");

}

public void ClickShippingContinue()
{
	shippingMethod.click();
}
public void ClickShippingMethod() throws InterruptedException
{
	
	Thread.sleep(2000);
	Money.click();
	payment_continue.click();
	Thread.sleep(1000);
	place_order.click();
}


}
