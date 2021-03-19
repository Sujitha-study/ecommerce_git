package EcommerceTestPack;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aspose.cells.FileFormatType;
import com.aspose.cells.LoadOptions;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;

import EcommerceUtilityPack.ReadconfigFile;

public class Test_010_ExportDetails {

	WebDriver driver;
	@Test
	public void exportingdetails() throws Exception
	{
		System.out.println(System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("http://live.demoguru99.com/index.php/backendlogin");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("user01");
		driver.findElement(By.id("login")).sendKeys("guru99com");
		driver.findElement(By.xpath("//input[@title='Login']")).click();
		Thread.sleep(3000);
		//if(isAlertPresent())
		//{
			driver.findElement(By.xpath("//a[@title='close']")).click();
		Actions act =new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a//span[text()='Sales']")));
		act.build().perform();
		driver.findElement(By.xpath("//a//span[text()='Orders']")).click();
		WebElement selectingCSV =driver.findElement(By.id("sales_order_grid_export"));
		Select sel= new Select(selectingCSV);
		sel.selectByVisibleText("CSV");
		driver.findElement(By.xpath("//button//span[text()='Export']")).click();
		Thread.sleep(5000);
		gettingOrderDetails();
	//	}
	//	else
	//		System.out.println("Alert not present");
		
		
	}
	
	
	public Object[][] gettingOrderDetails() throws Exception
	{
		
		ConvertToXL();
		File orderfile = new File("C:\\Users\\sujia\\Downloads\\CSVtoExcel.xlsx");
		FileInputStream fis = new FileInputStream (orderfile);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		int rowcount =book.getSheetAt(0).getLastRowNum();
		//rowcount=rowcount+1;
		System.out.println(rowcount);
		Object[][] orderitems =new Object[rowcount][7];
		System.out.println("object created");
		for(int i=0;i<10;i++)
		{
			if(book.getSheetAt(0).getRow(i).getCell(0).getCellType() ==CellType.NUMERIC)
			orderitems[i][0]=book.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue();
			else
				orderitems[i][0]=book.getSheetAt(0).getRow(i).getCell(0).getStringCellValue();
			//System.out.println("Column 1 done"+book.getSheetAt(0).getRow(i).getCell(0).getCellType());
			if(book.getSheetAt(0).getRow(i).getCell(1).getCellType() ==CellType.NUMERIC)
				orderitems[i][1]=book.getSheetAt(0).getRow(i).getCell(1).getNumericCellValue();
				else
					orderitems[i][1]=book.getSheetAt(0).getRow(i).getCell(1).getStringCellValue();
			//System.out.println("Column 2 done"+book.getSheetAt(0).getRow(i).getCell(1).getCellType());
			if(book.getSheetAt(0).getRow(i).getCell(2).getCellType() ==CellType.NUMERIC)
				orderitems[i][2]=book.getSheetAt(0).getRow(i).getCell(2).getNumericCellValue();
				else
					orderitems[i][2]=book.getSheetAt(0).getRow(i).getCell(2).getStringCellValue();
			//System.out.println("Column 3 done"+book.getSheetAt(0).getRow(i).getCell(2).getCellType());
			if(book.getSheetAt(0).getRow(i).getCell(3).getCellType() ==CellType.NUMERIC)
				orderitems[i][3]=book.getSheetAt(0).getRow(i).getCell(3).getNumericCellValue();
				else
					orderitems[i][3]=book.getSheetAt(0).getRow(i).getCell(3).getStringCellValue();
			//System.out.println("Column 4 done"+book.getSheetAt(0).getRow(i).getCell(3).getCellType());
			if(book.getSheetAt(0).getRow(i).getCell(4).getCellType() ==CellType.NUMERIC)
				orderitems[i][4]=book.getSheetAt(0).getRow(i).getCell(4).getNumericCellValue();
				else
					orderitems[i][4]=book.getSheetAt(0).getRow(i).getCell(4).getStringCellValue();
		//	System.out.println("Column 5 done"+book.getSheetAt(0).getRow(i).getCell(4).getCellType());
			if(book.getSheetAt(0).getRow(i).getCell(5).getCellType() ==CellType.NUMERIC)
				orderitems[i][5]=book.getSheetAt(0).getRow(i).getCell(5).getNumericCellValue();
				else
					orderitems[i][5]=book.getSheetAt(0).getRow(i).getCell(5).getStringCellValue();
		//	System.out.println("Column 6 done"+book.getSheetAt(0).getRow(i).getCell(5).getCellType());
			if(book.getSheetAt(0).getRow(i).getCell(6).getCellType() ==CellType.NUMERIC)
				orderitems[i][6]=book.getSheetAt(0).getRow(i).getCell(6).getNumericCellValue();
				else
					orderitems[i][6]=book.getSheetAt(0).getRow(i).getCell(6).getStringCellValue();
		//	System.out.println("Column 7 done"+book.getSheetAt(0).getRow(i).getCell(6).getCellType());
			//System.out.println("First column"+book.getSheetAt(0).getRow(i).getCell(0).getCellType());
			System.out.println(orderitems[i][0]+"  "+orderitems[i][1]+"  "+orderitems[i][2]+"  "+orderitems[i][3]+"  "+orderitems[i][4]+"  "+orderitems[i][5]+"  "+orderitems[i][6]);
		}
		book.close();
		EmailUtil.emailUtil("C:\\Users\\sujia\\Downloads\\orders.csv");
		return orderitems;
	}
	

public void ConvertToXL() throws Exception
{
	// Opening CSV Files
	// Creating CSV LoadOptions object
	LoadOptions loadOptions = new LoadOptions(FileFormatType.CSV);
	// Creating an Workbook object with CSV file path and the loadOptions
	// object
	Workbook workbook = new Workbook( "C:\\Users\\sujia\\Downloads\\orders.csv", loadOptions);
	workbook.save("C:\\Users\\sujia\\Downloads\\" + "CSVtoExcel.xlsx" , SaveFormat.XLSX);
	//return true;
}
}
