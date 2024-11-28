package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class BaseClass {

	protected static WebDriver driver;
	protected static Properties prop;
	
	@BeforeClass
	public static void browserSetup() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("src\\test\\resources\\config.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser").toLowerCase();
		switch (browser) {
        case "chrome":
            System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverPath"));
            driver = new ChromeDriver();
            break;

        case "firefox":
            System.setProperty("webdriver.gecko.driver", prop.getProperty("geckodriverPath"));
            driver = new FirefoxDriver();
            break;

        default:
            throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
		/*System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverPath"));
		driver=new ChromeDriver();*/
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void quitDriver()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
	 
}
