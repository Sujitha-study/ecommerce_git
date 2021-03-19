package EcommerceTestPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_009_CouponCode extends Baseclass {

	
	@Test
	
	public void CheckCouponCode() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h2//a[text()='IPhone']/ancestor::div[@class='product-info']//button[@title='Add to Cart']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("coupon_code")).sendKeys("GURU50");
		driver.findElement(By.xpath("//button[@onclick='discountForm.submit(false)']")).click();
		Thread.sleep(2000);
		String discount =driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']//td[contains(text(),'Discount (GURU50)')]//following::td//span[@class='price']")).getText();
		System.out.println(discount);
		discount=discount.replace("-$", "00");
		Double disc =Double.parseDouble(discount);
		System.out.println(disc); 
		String Originalprice= driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']//td[contains(text(),'Subtotal')]//following-sibling::td//span[@class='price']")).getText();
		System.out.println(Originalprice);
		Originalprice=Originalprice.replace("$", "0");
		Double ori =Double.parseDouble(Originalprice);
		System.out.println("Actual price of product  "+ori);
		Double originaldisc =.05*ori; 
		System.out.println(originaldisc);
		Assert.assertEquals(disc, originaldisc);
		
		
			}
}

