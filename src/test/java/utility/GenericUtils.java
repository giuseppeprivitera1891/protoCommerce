package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericUtils {
    public WebDriver driver = DriverManager.getDriver();

    public void callWaitVisibilityElement(int seconds, By locator) {
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }



}
