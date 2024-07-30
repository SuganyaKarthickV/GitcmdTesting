package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.DatePickerPage;
import pageObjects.SelectablePage;

public class SelectableTest extends BaseClass{
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initializeDriver();
		loadConfig();
	}
	
	@Test
	public void testSelectable() throws InterruptedException
	{
		driver.get(getProperties().getProperty("selectableurl"));
		SelectablePage spage=new SelectablePage(driver);
		spage.defaultOption();
		spage.serializeOption();
	}
	
	/*@AfterMethod
	public void tearDown()
	{
		quitDriver();
	}*/
	

}
