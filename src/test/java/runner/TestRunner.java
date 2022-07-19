package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty", "html:target/cucumber/cucumber.html"}, glue = {"scenarios", "hooks"}
, features = "src/test/java/scenarios/features/", tags = "@e2e")

public class TestRunner extends AbstractTestNGCucumberTests {

}
