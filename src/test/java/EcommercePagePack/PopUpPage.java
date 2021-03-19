package EcommercePagePack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class PopUpPage {

	WebDriver driver;
	@FindBy (how=How.XPATH , using ="//h1[contains(text(),'Compare Products')]")
	@CacheLookup List<WebElement> Comparetext;
	
	@FindBy (how=How.XPATH , using ="//button[@title='Close Window']")
	@CacheLookup WebElement closewindow;
	
	public PopUpPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean CheckingMobiles()
	{
		Boolean Result =false;
		int mob1 =driver.findElements(By.xpath("//a[contains(text(),'Sony Xperia')]")).size();
		int mob2 =driver.findElements(By.xpath("//a[contains(text(),'IPhone')]")).size();
		System.out.println("Mob1 size ="+mob1+"  mob2 size  ="+mob2+"comapre text "+Comparetext.size());
		if((Comparetext.size()>0) && (mob1>0) && (mob2>0))
		{
		
			Result=true;
		}
		return Result;
	}
	
	public void ClickCloseWindow()
	{
		closewindow.click();
	}
	
}
