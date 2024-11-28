package baseClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

public static void loadConfig() throws IOException
{
	prop=new Properties();
	FileInputStream ip=new FileInputStream("src\\test\\resources\\config.properties");
	prop.load(ip);
}

public static void initializeDriver() throws IOException
{
	loadConfig();
	System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverPath"));
	driver=new ChromeDriver();
	driver.manage().window().maximize();
}

public static void quitDriver()
{
	if(driver!=null)
		driver.quit();
}

}
