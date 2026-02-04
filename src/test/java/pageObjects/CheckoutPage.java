package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.DriverManager;
import utility.GenericUtils;

public class CheckoutPage {
    public WebDriver driver = DriverManager.getDriver();
    public GenericUtils utils = new GenericUtils();

    int fiveSeconds = 5;

    WebElement deliveryLocation;

    By location = By.id("country");
    By selectCountry = By.xpath("(//div[@class='suggestions'])[1]");

    public void chooseDeliveryLocation(String myDeliveryLocation) {
        deliveryLocation = driver.findElement(location);
        deliveryLocation.sendKeys(myDeliveryLocation);
        utils.callWaitVisibility(fiveSeconds, selectCountry);
        utils.performClick(selectCountry);
    }
}
