package baseClasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\resources\\FeatureFile\\flipkart.feature",
		glue="stepDefinitions",
		plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		//plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"},
	    monochrome = true
		)
public class TestRunner {

}










