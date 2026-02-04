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
    String actualUnitPriceFirstProduct;
    String actualTotalPriceFirstProduct;
    String actualUnitPriceSecondProduct;
    String actualTotalPriceSecondProduct;
    String actualTotalPrice;
    String expectedProductTableHead = "Product";
    String getFirstProductText;
    String expectedFirstProductText = "iphone X";
    String expectedUnitPriceFirstProduct = "₹. 100000";
    String expectedTotalPriceFirstProduct = "₹. 300000";
    String expectedUnitPriceSecondProduct = "₹. 65000";
    String expectedTotalPriceSecondProduct = "₹. 65000";
    String expectedTotalPrice = "₹. 365000";
    String actualCheckoutTextButton;
    String expectedCheckoutFinalTextButton = "Checkout";
    String actualDeliveryText;
    String expectedDeliveryText = "Please choose your delivery location.\n" +
            "Then click on purchase button";
    String sendFirstFirstQuantity = "3";
    int  twoSeconds = 2;
    int fiveSeconds = 5;
    int tenSeconds = 10;
    int thirtySeconds = 30;

    List<WebElement> products;
    WebElement checkoutButton, firstProductQuantity, checkoutFinalButton, deliveryLocation;

    By cardProducts = By.xpath("//div[@class='card h-100']");
    By cardTitle = By.cssSelector("h4[class='card-title']");
    By cardFooterButton = By.cssSelector(".card-footer button");
    By actualTextCheckoutButton = By.xpath("(//a[@class='nav-link btn btn-primary'])[1]");
    By actualTextProductTableHead = By.xpath("//th[normalize-space()='Product']");
    By firstProductText = By.xpath("//a[normalize-space()='iphone X'][1]");
    By getFirstProductQuantity = By.xpath("//a[normalize-space()='iphone X']/ancestor::tr//input");
    By unitPriceFirstProduct = By.xpath("//strong[text() = '₹. 100000']");
    By unitPriceSecondProduct = By.xpath("(//strong[text() = '₹. 65000'])[1]");
    By totalPriceFirstProduct = By.xpath(("//strong[text() = '₹. 300000']"));
    By totalPriceSecondProduct = By.xpath("(//strong[text() = '₹. 65000'])[2]");
    By getTotalPrice = By.xpath("//strong[text() ='₹. 365000']");
    By getCheckoutFinaTextButton = By.cssSelector("button[class='btn btn-success']");
    By getCheckoutFinalButton = By.cssSelector("button[class='btn btn-success']");
    By getDeliveryText = By.cssSelector("label[for='country']");
    By location = By.id("country");
    By selectCountry = By.xpath("(//div[@class='suggestions'])[1]");

    public void shop_page(String url) {
        urlShopPage = driver.getCurrentUrl();
        System.out.println("The URL of shop page is " + urlShopPage);
        Assert.assertTrue(urlShopPage.contains(url));
        utils.callWaitVisibility(twoSeconds, cardProducts);
    }

    public void add_products() {
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

    public void click_on_the_cart_button() {
        actualCheckoutButton = driver.findElement(actualTextCheckoutButton).getText();
        System.out.println("The text of checkout button is " + actualCheckoutButton);
        Assert.assertEquals(actualCheckoutButton, expectedCheckoutTextButton);
        checkoutButton = driver.findElement(actualTextCheckoutButton);
        checkoutButton.click();
    }

    public void cart_page() {
        actualProductTableHead = driver.findElement(actualTextProductTableHead).getText();
        utils.callWaitPollingVisibility(thirtySeconds, fiveSeconds, actualTextProductTableHead);
        Assert.assertEquals(actualProductTableHead, expectedProductTableHead);
    }

    public void add_quantity_for_a_product() {
        utils.callWaitVisibility(tenSeconds, firstProductText);
        getFirstProductText = driver.findElement(firstProductText).getText();
        System.out.println("The text of the first product: " + getFirstProductText);
        Assert.assertEquals(getFirstProductText, expectedFirstProductText);
        firstProductQuantity = driver.findElement(getFirstProductQuantity);
        firstProductQuantity.clear();
        firstProductQuantity.sendKeys(sendFirstFirstQuantity);
    }

    public void correctness_of_the_prices() {
        // Gets the unit price of the first product and checks it with expected unit price
        actualUnitPriceFirstProduct = driver.findElement(unitPriceFirstProduct).getText();
        System.out.println("The actual price first product: " + actualUnitPriceFirstProduct);
        Assert.assertEquals(actualUnitPriceFirstProduct, expectedUnitPriceFirstProduct);
        // Gets the total price of the first product and checks it with expected total price
        actualTotalPriceFirstProduct = driver.findElement(totalPriceFirstProduct).getText();
        System.out.println("The actual total price first product: " + actualTotalPriceFirstProduct);
        Assert.assertEquals(actualTotalPriceFirstProduct, expectedTotalPriceFirstProduct);
        // Gets the unit price of the second product and checks it with expected unit price
        actualUnitPriceSecondProduct = driver.findElement(unitPriceSecondProduct).getText();
        System.out.println("The actual unit price second product: " + actualUnitPriceSecondProduct);
        Assert.assertEquals(actualUnitPriceSecondProduct, expectedUnitPriceSecondProduct);
        // Gets the total price of the second product and checks it with expected total price
        actualTotalPriceSecondProduct = driver.findElement(totalPriceSecondProduct).getText();
        System.out.println("The actual total price of the second product: " + actualTotalPriceSecondProduct);
        Assert.assertEquals(actualTotalPriceSecondProduct, expectedTotalPriceSecondProduct);
        // Gets the total price and checks it with expected total price
        actualTotalPrice = driver.findElement(getTotalPrice).getText();
        System.out.println("The actual total price: " + actualTotalPrice);
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }

    public void click_on_the_checkout_button() {
        // Gets the text checkout button and checks it with expected text
        actualCheckoutTextButton =  driver.findElement(getCheckoutFinaTextButton).getText();
        System.out.println("The text of the Checkout button: " + actualCheckoutTextButton);
        Assert.assertEquals(actualCheckoutTextButton, expectedCheckoutFinalTextButton);
        // Clicks on the Checkout button
        checkoutFinalButton = driver.findElement(getCheckoutFinalButton);
        checkoutFinalButton.click();
    }

    public void checkout_page() {
        // Gets the text delivery and checks it with expected text
        actualDeliveryText = driver.findElement(getDeliveryText).getText();
        System.out.println("The delivery text: " + actualDeliveryText);
        Assert.assertEquals(actualDeliveryText, expectedDeliveryText);
    }

    public void choose_delivery_location(String myDeliveryLocation) {
        deliveryLocation = driver.findElement(location);
        deliveryLocation.sendKeys(myDeliveryLocation);
        utils.callWaitVisibility(fiveSeconds, selectCountry);
        utils.performClick(selectCountry);
    }
}
