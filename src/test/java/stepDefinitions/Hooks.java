package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.DriverManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hooks extends DriverManager {
    @BeforeAll
    public static void beforeAll() {
        initDriver();
    }

    @AfterAll
    public static void afterAll() {
        DriverManager.quitDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            driver = getDriver();

            // Take a screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            // Add the screenshot in the report Cucumber
            scenario.attach(screenshot, "image/png", "screenshot-failed");

            // Optional: save the screenshot on local system
            saveScreenshotToFile(screenshot, scenario.getName());
        }
    }

    private void saveScreenshotToFile(byte[] screenshot, String scenarioName) {
        try {
            String sanitizedScenarioName = scenarioName.replaceAll("[^a-zA-Z0-9\\-]", "_");
            Path destination = Paths.get("target/screenshots/" + sanitizedScenarioName + ".png");
            Files.createDirectories(destination.getParent());
            Files.write(destination, screenshot);
            System.out.println("Screenshot saved in: " + destination.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving screenshot: " + e.getMessage());
        }
    }
}
