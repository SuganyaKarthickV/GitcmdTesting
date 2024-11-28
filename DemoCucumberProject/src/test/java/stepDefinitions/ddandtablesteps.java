package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DDandTablepage;

public class ddandtablesteps extends BaseClass{
	
	//WebDriver driver;
	DDandTablepage dpage;
	
	@Given("User is logged into the OrangeHRM demo site")
	public void user_is_logged_into_the_orange_hrm_demo_site() {
		try {
	        // Check if the user is already logged in
	        if (driver == null || !driver.getCurrentUrl().contains("Dashboard")) {
	            // Initialize LoginSteps to reuse login functionality
	            LoginSteps loginSteps = new LoginSteps();
	            loginSteps.user_is_on_the_login_page();

	            // Read username and password from properties file
	            String username = prop.getProperty("username");
	            String password = prop.getProperty("password");

	            // Login using dynamic data
	            loginSteps.user_enters_the_and(username, password);
	            loginSteps.user_clicks_the_login_button();
	        }
	        System.out.println("User is already logged into the OrangeHRM demo site.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@When("User navigates to the Admin module")
	public void user_navigates_to_the_admin_module() {
	    dpage=new DDandTablepage(driver);
		dpage.clickAdmin();
	    
	}
	
	@When("User selects Admin from the UserRole dropdown")
	public void user_selects_admin_from_the_user_role_dropdown() throws InterruptedException {
		dpage.ddclick();
		System.out.println("dd clicked");
		dpage.optionClick();
		System.out.println("option selected");
	}


	@When("User clicks the Search button")
	public void user_clicks_the_search_button() {
	    dpage.searchButton();
	    System.out.println("search button clicked");
	}
	

	@Then("User verifies that all results in the {string} column contain {string}")
	public void user_verifies_that_all_results_in_the_column_contain(String columnName, String expectedValue) {
		boolean result = dpage.verifyColumnResults(columnName, expectedValue); // Verify column data
        Assert.assertTrue("Not all rows in column " + columnName + " contain the expected value: " + expectedValue, result);
	}




	/*@Then("User verifies that all results in the {string} column contain {string}")
	public void user_verifies_that_all_results_in_the_column_contain(String columnName, String expectedValue) {
		boolean result = dpage.verifyColumnResults(columnName, expectedValue); // Verify column data
        Assert.assertTrue("Not all rows in column " + columnName + " contain the expected value: " + expectedValue, result);
	}*/

	@Then("User calculates the total number of rows displayed in the table")
	public void user_calculates_the_total_number_of_rows_displayed_in_the_table() {
		int rowCount = dpage.getTotalRowCount(); // Calculate total rows
        System.out.println("Total rows displayed: " + rowCount);
	}

}
