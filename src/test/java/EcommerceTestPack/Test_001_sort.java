package EcommerceTestPack;
import EcommerceUtilityPack.ReadconfigFile;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.*;
import org.testng.annotations.*;
import EcommercePagePack.*;

public class Test_001_sort extends Baseclass {
		
	
	@Test
	void sorting_Mobile()
	{
		System.out.println("entered sorting mobile");
		System.out.println(driver.getTitle());
		List<String> productnames,sortedlist,sortBylist;
		MobilePage mp= PageFactory.initElements(driver, MobilePage.class);
		
		if(driver.getTitle().contains("Home page"))
		{
			System.out.println("entered after checking Title");
		//	HomePage hp= new HomePage(driver);
			HomePage hp =PageFactory.initElements(driver, HomePage.class);
			System.out.println("after homepage constructor");
			driver.manage().window().maximize();
			hp.clickMobilebutton();
			if(driver.getTitle().contains("Mobile"))
			{
				
			
			
			productnames =mp.elementfromPage();
			
			sortedlist=mp.gettingProductssorted(productnames);
			mp.clicksortBybtn();
			sortBylist =mp.elementfromPage();
			System.out.println("SortBylist from page"+sortBylist);
			System.out.println("productinitial names"+productnames);
			System.out.println("product sorted names"+sortedlist);
			Assert.assertEquals(sortBylist, sortedlist);
			System.out.println("products displayed");
			
			}
			
		}
		
	}

}
