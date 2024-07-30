package testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.RegisterPage;

public class RegisterTest extends BaseClass{
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initializeDriver();
		loadConfig();
	}

	@Test
	public void testRegister() throws IOException, AWTException
	{
		// Initialize the driver
		//BaseClass.initializeDriver();
		
		//BaseClass.loadConfig();
		
		// Navigate to the base URL
		driver.get(getProperties().getProperty("RegUrl"));
		
		// Create an instance of RegisterPage
		RegisterPage register=new RegisterPage(driver);
		
		//String username = BaseClass.prop.getProperty("username");
        //String password = BaseClass.prop.getProperty("password");
        //String gender = BaseClass.prop.getProperty("gender");
		
		register.enterFirstName("xxxx");
		register.enterLastName("AAAA");
		register.enterAddress("chennai");
		register.enterEmail("ss@gmail.com");
		register.enterPhone("9658472458");
		register.selectGenderRadioButton("Male");
		register.selectHobbiesCheckbox(Arrays.asList("Cricket","Hockey"));
		//register.selectLanguages(Arrays.asList("English","Dutch"));
		register.selectLanguages("Czech");
		register.selectSkills("C");
		register.selectSelectCountry("India");
		register.selectDOB("1991", "May", "1");
		register.enterPassword("1234");
		register.enterConfirmPassword("1234");
		register.selectChooseFile(getProperties().getProperty("uploadedFilePath"));
		//register.selectChooseFile();
		//register.clickSubmitButton();
		//register.selectRefresh();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		quitDriver();
	}
	
	
}
