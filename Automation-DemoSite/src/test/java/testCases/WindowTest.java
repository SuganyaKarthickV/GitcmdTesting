package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.WindowsPage;

public class WindowTest extends BaseClass{
	
	@BeforeMethod
	public void driverSetUp() throws IOException
	{
		initializeDriver();
		loadConfig();
	}
	
	@Test
	public void testWindows() throws InterruptedException
	{
		driver.get(getProperties().getProperty("Windowurl"));
		WindowsPage windowspage=new WindowsPage(driver);
		//windowspage.selectSwitchTo();
		//windowspage.selectWindowsOption();
		windowspage.firstClickButton();
		windowspage.selectNewSeperateWindow();
		windowspage.clickSecondButton();
		windowspage.selectMultipleWindows();
		try {
			windowspage.clickThirdButton();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
			
	@AfterMethod
	public void tearDown()
	{
		quitDriver();
	}
}
