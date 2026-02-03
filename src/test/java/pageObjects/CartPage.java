package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utility.DriverManager;
import utility.GenericUtils;

import java.util.List;

public class CartPage {
    public WebDriver driver = DriverManager.getDriver();
    GenericUtils utils = new GenericUtils();

    String getFirstProductText;
    String expectedFirstProductText = "iphone X";
    String expectedUnitPriceFirstProduct = "₹. 100000";
    String expectedTotalPriceFirstProduct = "₹. 300000";
    String expectedSecondProductQuantity = "1";
    String expectedUnitPriceSecondProduct = "₹. 65000";
    String expectedTotalPriceSecondProduct = "₹. 65000";
    String expectedTotalPrice = "₹. 365000";
    String expectedCheckoutTextButton = "Checkout";
    String expectedDeliveryText = "Please choose your delivery location.\n" +
            "Then click on purchase button ";
    String sendFirstFirstQuantity = "3";
    int twoSeconds = 2;
    int fiveSeconds = 5;
    int tenSeconds = 10;
    int thirtySeconds = 30;

    WebElement firstProductQuantity;

    By firstProductText = By.xpath("//a[normalize-space()='iphone X'][1]");
    By getFirstProductQuantity = By.xpath("//a[normalize-space()='iphone X']/ancestor::tr//input");

    public void theUserAddsTheQuantityForAProduct() {
      //  utils.callWaitPresenceElement(tenSeconds, firstProductText);
      //  getFirstProductText = driver.findElement(firstProductText).getText();
      //  System.out.println("The text of the first product: " + getFirstProductText);
      //  Assert.assertEquals(getFirstProductText, expectedFirstProductText);
        driver.navigate().refresh();
        utils.callWaitPresenceElement(tenSeconds, getFirstProductQuantity);
        String pageSource = driver.getPageSource();
        System.out.println("L'elemento 'iphone X' è presente nel sorgente? " + pageSource.contains("iphone X"));
        firstProductQuantity = driver.findElement(getFirstProductQuantity);
        firstProductQuantity.clear();
        firstProductQuantity.sendKeys(sendFirstFirstQuantity);
        firstProductQuantity.getText();
        System.out.println("First product quantity is: " + firstProductQuantity);
    }
}
