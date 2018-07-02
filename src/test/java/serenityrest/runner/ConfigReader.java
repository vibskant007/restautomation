package serenityrest.runner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {
	
	public static Map<String,String> configRead(String propFileName)
	{
		Map<String,String> hmap = new HashMap<String,String>();
		String result = "";
		InputStream inputStream;

		try {
			Properties prop = new Properties();
 
			inputStream = new FileInputStream(propFileName);
			
			if (inputStream != null) {
				prop.load(inputStream);
				
			} 
			hmap.put("api.endpoint", prop.getProperty("api.endpoint"));
			
          
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} 
		
		return hmap;
	}

}

