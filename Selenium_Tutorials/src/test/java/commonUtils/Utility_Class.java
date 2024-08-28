package commonUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import constants.Constants;

public class Utility_Class {
	
	public void loadProperties()
	{
		// Before move the config file into test/resources
		
		/*FileReader reader=null; try { reader=new FileReader("config.properties");
		 
		 } catch (FileNotFoundException e) {
		  
		e.printStackTrace(); }
		 
		Properties properties=new Properties();
		
		try {
			properties.load(reader);
		} catch (IOException e) {
			
			e.printStackTrace();
		}*/
		
		
		//After move the config file into test/resources
		Properties properties=new Properties();
		
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		Constants.App_Url = properties.getProperty("App_Url");
		Constants.Browser = properties.getProperty("Browser");
		Constants.Username =properties.getProperty("Username");
		Constants.Password= properties.getProperty("Password");
		Constants.Chrome_Driver_Location = properties.getProperty("Chrome_Driver_Location");
		
	
	
	
	
	}

	
}
