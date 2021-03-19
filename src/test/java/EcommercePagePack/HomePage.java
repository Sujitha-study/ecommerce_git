package EcommercePagePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Mobile')]")
	@CacheLookup WebElement Mobilebtn;
	
	@FindBy (how=How.XPATH ,using="//a[@class='skip-link skip-account']")
	@CacheLookup WebElement Accountbtn;
	
	@FindBy (how=How.XPATH , using ="//div[@id='header-account']//a[text()='My Account']")
	@CacheLookup WebElement MyAccountbtn;
	
	@FindBy (how=How.XPATH , using="//a[@title='Create an Account']")
	@CacheLookup WebElement CreateAccountbtn;
	
	@FindBy (how=How.XPATH, using ="//a[text()='TV']")
	@CacheLookup WebElement TVbtn;
	
	@FindBy (how=How.XPATH ,using ="//a[text()='Log In']")
	@CacheLookup WebElement Login;
	
	@FindBy (how=How.XPATH , using ="//a[contains(@title,'My Wishlist')]")
	@CacheLookup WebElement wishlistbtn;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void ClickLogInbtn()
	{
		Login.click();
		System.out.println("Login button clicked from account");
	}
	
	public void clickMobilebutton()
	{
		Mobilebtn.click();
	}
	public void clickAccountbtn()
	{
		System.out.println("entered click account btn");
		//driver.findElement(By.xpath("//a[@class='skip-link skip-account skip-active']")).click();
		Accountbtn.click();
	}
	
	public void ClickTVbtn()
	{
	TVbtn.click();
	}
	public void clickMyAccountbtn()
	{
		MyAccountbtn.click();
	}
	public void clickCreateAccount()
	{
		CreateAccountbtn.click();
	}
	
	public void clickWishListBtn()
	{
		System.out.println("Before Clicking Wishlist");
		wishlistbtn.click();
		System.out.println("After Clicking Wishlist");
	}
}
