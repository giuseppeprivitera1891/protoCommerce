package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericUtils {
    public WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait;

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

}
