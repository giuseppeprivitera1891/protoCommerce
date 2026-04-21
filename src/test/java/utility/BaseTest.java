package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    WebDriverWait wait;
    WebElement clickable;

    // Method to get the driver instance
    public static void initDriver() {
        if (driver == null) {
            // Initialize the driver
            driver = new FirefoxDriver();
            // Basic configuration
            driver.manage().window().maximize();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    // Method to close the driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void callWaitVisibility(int seconds, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void callWaitInvisibility(int seconds, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void callWaitPollingVisibility(int seconds, int pollingEvery, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofSeconds(pollingEvery));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void callWaitTitle(int seconds, String title) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void performClick(By locator) {
        clickable = driver.findElement(locator);
        new Actions(driver)
                .click(clickable)
                .perform();
    }
}
