package step_Definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import commonUtils.Utility_Class;
import constants.Constants;
import io.cucumber.java.Before;

public class Common_Step_Definition {
	
	//launch browser
	
	public static WebDriver driver;
	
	@Before
	public void beforeScenario()
	{
		Utility_Class utils=new Utility_Class();
		utils.loadProperties();
		if (driver==null)
		launchBrowser();
	}

	private void launchBrowser() {

		System.setProperty(Constants.Chromedriver, Constants.Chrome_Driver_Location);
		driver=new ChromeDriver();
		
		
		
	}

}
