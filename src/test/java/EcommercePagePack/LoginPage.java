package EcommercePagePack;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage {

	
	@FindBy (how=How.XPATH , using ="//input[@title='Email Address']")
	@CacheLookup WebElement Email;
	
	@FindBy (how=How.XPATH ,using ="//input[@title='Password']")
	@CacheLookup WebElement Password;
	
	@FindBy (how=How.XPATH , using ="//button[@title='Login']")
	@CacheLookup WebElement Login; 
	
	public void LoggingIn()
	{
		Email.sendKeys("Sreesha@gmail.com");
		Password.sendKeys("Raja#123");
		Login.click();
	}
	
	
	
}
