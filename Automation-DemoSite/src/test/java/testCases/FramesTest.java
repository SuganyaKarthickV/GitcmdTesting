package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.AlertPage;
import pageObjects.FramesPage;

public class FramesTest extends BaseClass{
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initializeDriver();
		loadConfig();
	}
	
	@Test
	public void testFrame() throws InterruptedException
	{
		driver.get(getProperties().getProperty("Frameurl"));
		FramesPage framepage=new FramesPage(driver);
		framepage.moveToFrame("user");
		framepage.clickNestedFrame();
		
	}
	
	/*@AfterMethod
	public void tearDown()
	{
		quitDriver();
	}*/
	



}
