package EcommercePagePack;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class TVPage {

	@FindBy (how=How.XPATH ,using ="//div/h2/a[text()='LG LCD']//ancestor::h2[@class='product-name']//following-sibling::div//a[text()='Add to Wishlist']")
	@CacheLookup WebElement TVmodel;
	
	@FindBy (how=How.NAME , using ="save_and_share")
	@CacheLookup WebElement Wishlistbtn;
	
	@FindBy (how=How.ID , using ="email_address")
	@CacheLookup WebElement email;
	
	@FindBy (how=How.XPATH , using ="//button[@title='Share Wishlist']")
	@CacheLookup WebElement ShareWishlist;
	
	@FindBy (how=How.XPATH , using ="//span[contains(text(),'Your Wishlist has been shared.')]")
	@CacheLookup List<WebElement> MsgShared;
	
	@FindBy (how=How.XPATH , using ="//button[contains(@title,'Add to Cart')]")
	@CacheLookup WebElement ADDtoCArt;

 public void AddTVmodeltowishlist()
 {
	 TVmodel.click();
 }
 public void ClickWishlist()
 {
	 Wishlistbtn.click();
 }
 
 public void ClickAddtoCart()
 {
	 ADDtoCArt.click();
 }
 public void EnterEmail()
 {
	 email.sendKeys("suji.aaruraja@gmail.com");
 }
 public void SharingWishlist()
 {
	 ShareWishlist.click();
 }
 public Boolean Checkingmsg()
 {
	 return (MsgShared.size()>0?true:false);
 }
}