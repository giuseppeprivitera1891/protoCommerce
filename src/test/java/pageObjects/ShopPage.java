package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utility.DriverManager;
import utility.GenericUtils;

import java.util.Arrays;
import java.util.List;

public class ShopPage {
    public WebDriver driver = DriverManager.getDriver();
    public GenericUtils utils = new GenericUtils();

    // List of our products
    List<String> myProduct = Arrays.asList("iphone X", "Nokia Edge");
    String urlShopPage;
    String actualCheckoutButton;
    String expectedCheckoutTextButton = "Checkout ( 2 )\n(current)";
    String actualProductTableHead;
    String expectedProductTableHead = "Product";
    String getFirstProductText;
    String expectedFirstProductText = "iphone X";
    String expectedUnitPriceFirstProduct = "₹. 100000";
    String expectedTotalPriceFirstProduct = "₹. 300000";
    String expectedSecondProductQuantity = "1";
    String expectedUnitPriceSecondProduct = "₹. 65000";
    String expectedTotalPriceSecondProduct = "₹. 65000";
    String expectedTotalPrice = "₹. 365000";
    String expectedCheckoutFinalTextButton = "Checkout";
    String expectedDeliveryText = "Please choose your delivery location.\n" +
            "Then click on purchase button ";
    String sendFirstFirstQuantity = "3";
    int  twoSeconds = 2;
    int fiveSeconds = 5;
    int tenSeconds = 10;
    int thirtySeconds = 30;

    List<WebElement> products;
    WebElement checkoutButton;
    WebElement firstProductQuantity;

    By cardProducts = By.xpath("//div[@class='card h-100']");
    By cardTitle = By.cssSelector("h4[class='card-title']");
    By cardFooterButton = By.cssSelector(".card-footer button");
    By actualTextCheckoutButton = By.xpath("(//a[@class='nav-link btn btn-primary'])[1]");
    By actualTextProductTableHead = By.xpath("//th[normalize-space()='Product']");
    By firstProductText = By.xpath("//a[normalize-space()='iphone X'][1]");
    By getFirstProductQuantity = By.xpath("//a[normalize-space()='iphone X']/ancestor::tr//input");

    public void theUserIsOnTheShopPage(String url) {
        urlShopPage = driver.getCurrentUrl();
        System.out.println("The URL of shop page is " + urlShopPage);
        Assert.assertTrue(urlShopPage.contains(url));
        utils.callWaitVisibility(twoSeconds, cardProducts);
    }

    public void theUserAddsTheProducts() {
        // Gets the list of products
        products = driver.findElements(cardProducts);

        for (String addProduct : myProduct) {
            for (WebElement product : products) {
                String productName = product.findElement(cardTitle).getText();
                if (productName.equalsIgnoreCase(addProduct)) {
                    product.findElement(cardFooterButton).click();
                    break;
                }
            }
        }
    }

    public void clickOnTheCartButton() {
        actualCheckoutButton = driver.findElement(actualTextCheckoutButton).getText();
        System.out.println("The text of checkout button is " + actualCheckoutButton);
        Assert.assertEquals(actualCheckoutButton, expectedCheckoutTextButton);
        checkoutButton = driver.findElement(actualTextCheckoutButton);
        checkoutButton.click();
    }

    public void theUserShouldSeeTheCartPage() {
        actualProductTableHead = driver.findElement(actualTextProductTableHead).getText();
        utils.callWaitPollingVisibility(thirtySeconds, fiveSeconds, actualTextProductTableHead);
        Assert.assertEquals(actualProductTableHead, expectedProductTableHead);
    }

    public void theUserAddsTheQuantityForAProduct() {
        utils.callWaitPresenceElement(tenSeconds, firstProductText);
        getFirstProductText = driver.findElement(firstProductText).getText();
        System.out.println("The text of the first product: " + getFirstProductText);
        Assert.assertEquals(getFirstProductText, expectedFirstProductText);
        utils.callWaitPresenceElement(tenSeconds, getFirstProductQuantity);
      //  String pageSource = driver.getPageSource();
      //  System.out.println("L'elemento 'iphone X' è presente nel sorgente? " + pageSource.contains("iphone X"));
        firstProductQuantity = driver.findElement(getFirstProductQuantity);
        firstProductQuantity.clear();
        firstProductQuantity.sendKeys(sendFirstFirstQuantity);
        firstProductQuantity.getText();
        System.out.println("First product quantity is: " + firstProductQuantity);
    }
}
