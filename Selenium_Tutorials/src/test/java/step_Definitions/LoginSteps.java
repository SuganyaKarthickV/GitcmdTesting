package step_Definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	    System.out.println("Login Page");
	}

	@When("User enters user name and password")
	public void user_enters_user_name_and_password() {
		System.out.println("credentials");
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("Login");
	}

	@Then("User is navigated to the homepage")
	public void user_is_navigated_to_the_homepage() {
		System.out.println("Homepage");
	}
}
