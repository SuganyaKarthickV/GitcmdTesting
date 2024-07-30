package testCases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.DatePickerPage;



public class DatePickerTest extends BaseClass{

	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initializeDriver();
		loadConfig();
	}
	
	@Test
	public void testDatePicker() throws InterruptedException
	{
		driver.get(getProperties().getProperty("datepickerurl"));
		DatePickerPage dppage=new DatePickerPage(driver);
		//dppage.inputBox("01/10/2021" +Keys.ENTER);
		dppage.datePickerEnabledInputBox();
		dppage.datePickerDisabledInputBox();
		
	}
	
	/*@AfterMethod
	public void tearDown()
	{
		quitDriver();
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
}
