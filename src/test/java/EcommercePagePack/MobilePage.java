package EcommercePagePack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class MobilePage {
	WebDriver driver;
	@FindBy (how=How.XPATH ,using ="//div[@class='category-products']/div[@class='toolbar']//select[@title='Sort By']")
	@CacheLookup WebElement sortbybtn1;
	
	@FindBy (how=How.XPATH ,using ="//ul[contains(@class,'products-grid')]/li")
	@CacheLookup List<WebElement> products;

	@FindBy (how=How.XPATH , using ="//h2[@class='product-name']/a[contains(text(),'Sony Xperia')]//following::span[@id='product-price-1']/span[@class='price']")
	@CacheLookup WebElement itemprice; 
	
	@FindBy (how=How.XPATH , using ="//h2[@class='product-name']/a[contains(text(),'Sony Xperia')]")
	@CacheLookup WebElement sonyitem; 
	
	@FindBy (how=How.XPATH ,using = "//a[contains(text(),'Mobile')]")
	@CacheLookup WebElement mobilebtn;
	
	@FindBy (how=How.XPATH , using ="//h2//a[contains(text(),\"Sony Xperia\")]//following::div/button")
	@CacheLookup WebElement sonyXperiaadd;
	
	@FindBy (how=How.XPATH , using ="//button[@title='Compare']")
	@CacheLookup WebElement Comparebtn;
	
	public MobilePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clicksortBybtn()
	{
		Select sel =new Select(sortbybtn1);
		//sortbybtn.click();
		System.out.println("select statement set");
		String textfromselect =driver.findElement(By.xpath("//select[@title='Sort By']//option[contains(text(),'Name')]")).getText();
		System.out.println(textfromselect);
		sel.selectByVisibleText(textfromselect);
	}
	
	/*	List<WebElement> product =driver.findElements(By.xpath("//ul[contains(@class,'products-grid')]/li"));
		for(int i=0;i<product.size();i++)
		{
			System.out.println("i  " +i);
			System.out.println(product.get(i).findElement(By.xpath("//h2//a")).getText());
		}
		
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'IPhone')]")).getText());
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Sony Xperia')]")).getText());
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Samsung Galaxy')]")).getText());
		for(WebElement pr:products)
		{
			
			//String prname= pr.findElement(By.xpath("//h2")).getAttribute("title");
			String prname= pr.findElement(By.xpath("//a")).getText();
			String prnames= pr.findElement(By.xpath("//a")).getAttribute("title");
			
			System.out.println(prname);
			System.out.println(prnames);*/
	public List<String> gettingProductssorted(List<String> productname)
	{
				
		Collections.sort(productname);
		System.out.println(productname);
		
		return productname;
	}
	public List<String> elementfromPage()
	{
		
		List<String> productnames = new ArrayList<String>();

		
		
		for (int i=1;i<=products.size();i++)
		{
			///html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li["+i+"]/div[1]/h2[1]/a[1]
			String prname = driver.findElement(By.xpath("//ul/li["+i+"]//h2//a")).getText();     
			System.out.println(prname);
			productnames.add(prname);
			
			
		}
		
		System.out.println(productnames);
		
		return productnames;

	}
	public String getItemPrice ()
	{
		String MobPageprice = itemprice.getText();
		return MobPageprice;
	}
	public void clickdetails()
	{
		sonyitem.click();
	}
	public void addtocart()
	{
		for (int i=1;i<=products.size();i++)
		{
			///html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li["+i+"]/div[1]/h2[1]/a[1]
			String prname = driver.findElement(By.xpath("//ul/li["+i+"]//h2//a")).getText();     
			System.out.println(prname);
			if(prname.equalsIgnoreCase("Sony Xperia"))
			{
				sonyXperiaadd.click();
				break;
			}
						
		}
	}
	
	public void AddmobiletoCompare(String mobName)
	{
		for (int i=1;i<=products.size();i++)
		{
			///html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li["+i+"]/div[1]/h2[1]/a[1]
			String prname = driver.findElement(By.xpath("//ul/li["+i+"]//h2//a")).getText();     
			System.out.println(prname);
			if(prname.equalsIgnoreCase(mobName))
			{
				System.out.println("prname equals mobile name and the 1 value is"+i);
				////ul/li["+i+"]//descendant::a[text()='Add to Compare']
				driver.findElement(By.xpath("//ul/li["+i+"]//following-sibling::div//descendant::a[text()='Add to Compare']")).click();
				break;
			}
						
		}
	}
	public void ClickCompareBtn()
	{
		Comparebtn.click();
	}
	
	
}
