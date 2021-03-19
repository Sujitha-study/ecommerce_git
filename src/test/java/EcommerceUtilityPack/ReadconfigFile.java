package EcommerceUtilityPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadconfigFile {
	Properties prop;
	
	public ReadconfigFile() throws IOException
	{
		File src= new File("./Configuration/config.properties");
		
		FileInputStream fis= new FileInputStream(src);
		prop= new Properties();
		prop.load(fis);
	}
	public String getURL()
	{

		System.out.println(prop.getProperty("baseURL"));
		return prop.getProperty("baseURL");
		
	}
	}
	


