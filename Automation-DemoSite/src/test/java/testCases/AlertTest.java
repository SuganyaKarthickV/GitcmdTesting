package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.AlertPage;

public class AlertTest extends BaseClass{
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initializeDriver();
		loadConfig();
	}
	@Test
	public void testAlert()
	{
		driver.get(getProperties().getProperty("RegUrl"));
		AlertPage alertpage=new AlertPage(driver);
		alertpage.clickSwitchTo();
		alertpage.clickAlert();
		alertpage.clickDisplayAlertBox();
		alertpage.selectOkAndCancel();
		alertpage.clickConfirmBox();
		alertpage.clickTextAlert();
		alertpage.clickPromptBox();
	}
	
	@AfterMethod
	public void tearDown()
	{
		quitDriver();
	}
	

}
