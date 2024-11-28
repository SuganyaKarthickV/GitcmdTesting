package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;



import baseClasses.BaseClass;
import baseClasses.ExcelUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.LoginPage;

public class LoginSteps {
	
	
	WebDriver driver=BaseClass.driver;
	LoginPage loginPage;
	
	
	@Given("User is on Flipkart homepage")
	public void user_is_on_flipkart_homepage() {
		
		driver.get(BaseClass.prop.getProperty("url"));
        loginPage = new LoginPage(driver);
	    
	}
	@When("User clicks on login text")
	public void user_clicks_on_login_text() {
		loginPage.clickLoginText();
	    
	}
	@And("User logs in with credentials from excel")
	public void user_logs_in_with_credentials_from_excel() throws IOException {
		String loginExcelPath=BaseClass.prop.getProperty("loginExcelPath");
		ExcelUtils.setExcelFile(loginExcelPath, "Sheet1");
		String mobileNo=ExcelUtils.getCellData(1, 0);
		loginPage.enterMobileNo(mobileNo);
		System.out.println("Mobile Number: " + mobileNo);
		loginPage.clickRequestOTP();
	    
	}
	@Then("User is redirected to the Flipkart home page")
	public void user_is_redirected_to_the_flipkart_home_page() {
		System.out.println("Successfully logged in");
	}


	
}
