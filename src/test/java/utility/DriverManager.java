package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    // Method to get the driver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            // Initialize the driver
            driver = new ChromeDriver();

            // Basic configuration
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Method to close the driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
