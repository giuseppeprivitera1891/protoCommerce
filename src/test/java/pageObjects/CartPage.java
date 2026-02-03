package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utility.DriverManager;
import utility.GenericUtils;

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
    String sendSecondFirstQuantity = "2";
    int twoSeconds = 2;

    WebElement firstProductQuantity;

    By firstProductText = By.xpath("//tr[contains(.,'iphone X')]//input[@type='number']");
    By getFirstProductQuantity = By.cssSelector("input[type='number']");

    public void theUserAddsTheQuantityForAProduct() {
        utils.callWaitVisibility(twoSeconds, firstProductText);
        getFirstProductText = driver.findElement(firstProductText).getText();
        System.out.println("The text of the first product: " + getFirstProductText);
        Assert.assertEquals(getFirstProductText, expectedFirstProductText);
        utils.callWaitVisibility(twoSeconds, getFirstProductQuantity);
        firstProductQuantity = driver.findElement(getFirstProductQuantity);
        firstProductQuantity.clear();
        firstProductQuantity.sendKeys(sendFirstFirstQuantity);
        firstProductQuantity.getText();
        System.out.println("First product quantity is: " + firstProductQuantity);
    }
}
