package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;


public class LoginSteps extends BaseClass{

	LoginPage loginpage;
	//WebDriver driver;

	@Given("User is on the login page")
	public void user_is_on_the_login_page() throws IOException {
		//if (driver == null) {
		browserSetup();

		driver.get(prop.getProperty("loginUrl"));
		System.out.println("Navigated to URL: " + driver.getCurrentUrl());
		loginpage=new LoginPage(driver);
	    
	}
	
	@When("User enters the {string} and {string}")
	public void user_enters_the_and(String username, String password) {
	    loginpage.enterUsername(username);
	    loginpage.enterPassword(password);
	}
	
	@And("User clicks the Login button")
	public void user_clicks_the_login_button() {
		loginpage.clickLogin();
		
		String message = loginpage.getLoginMessage();
	    if (message.equals("Dashboard")) { 
	        System.out.println("Login successful: User has successfully logged in.");
	    } else {
	        System.out.println("Login failed: " + message);
	    }
		
	}
	
	@Then("User should see the {string}")
	public void user_should_see_the(String message) {
	    String actualmsg=loginpage.getLoginMessage();
	    Assert.assertEquals("The login message doesn't not match!",message,actualmsg);
	    System.out.println("Expected Message" + message);
	    System.out.println("Actual Message" + actualmsg);
	}



}
