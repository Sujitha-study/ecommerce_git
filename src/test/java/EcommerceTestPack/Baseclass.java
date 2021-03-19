package EcommerceTestPack;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import EcommerceUtilityPack.ReadconfigFile;

public class Baseclass {
	String baseURL;
	WebDriver driver;
	@BeforeClass
	void getURLfromConfig() throws IOException
	{
		ReadconfigFile rFile= new ReadconfigFile();
		
	//	System.out.println(rFile.getURL());
		baseURL=rFile.getURL();
		System.out.println(System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		
	}
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }
	@AfterClass
	void teardown()
	{
		driver.quit();
	}
}
