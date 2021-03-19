package EcommercePagePack;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class CreateAccountPage {

	
	@FindBy (how=How.ID ,using="firstname")
	@CacheLookup WebElement Firstname;
	
	@FindBy (how=How.ID ,using="lastname")
	@CacheLookup WebElement lastname;
	
	@FindBy (how=How.ID ,using="email_address")
	@CacheLookup WebElement email_address;
	
	@FindBy (how=How.ID ,using="password")
	@CacheLookup WebElement password;
	
	@FindBy (how=How.ID ,using="confirmation")
	@CacheLookup WebElement confirmation;
	
	@FindBy (how=How.XPATH ,using="//button[@title='Register']")
	@CacheLookup WebElement Register;
	
	@FindBy (how=How.XPATH ,using ="//span[contains(text(),'Thank you for registering with Main Website Store')]")
	@CacheLookup List<WebElement> confirmmsg;
	
	public Boolean RegisterAccount() throws InterruptedException
	{
		Boolean Result= false;
		Firstname.sendKeys("Sujitha11");
		lastname.sendKeys("Thiyagarajan1");
		email_address.sendKeys("Sujitha.study3@gmail.com");
		password.sendKeys("Raja#123");
		confirmation.sendKeys("Raja#123");
		Register.click();
		Thread.sleep(3000);
		if (confirmmsg.size()>0)
		{
			Result=true;
		}
		return Result;
		
	}
}
