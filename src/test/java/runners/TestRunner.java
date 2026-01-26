package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "stepDefinitions", // Path to the step definitions
        //tags = "@UI",
        // plugin = {"pretty", "html:target/cucumber-reports.html"} // Reporting option
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        } // Reporting option
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
