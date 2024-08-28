package step_Definitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;






@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"step_Definitions"})
public class TestRunner {

}
