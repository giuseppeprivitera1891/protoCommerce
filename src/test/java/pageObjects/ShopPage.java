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
    int  twoSeconds = 2;

    List<WebElement> products;
    WebElement checkoutButton;

    By cardProducts = By.xpath("//div[@class='card h-100']");
    By cardTitle = By.cssSelector("h4[class='card-title']");
    By cardFooterButton = By.cssSelector(".card-footer button");
    By actualTextCheckoutButton = By.xpath("(//a[@class='nav-link btn btn-primary'])[1]");
    By actualTextProductTableHead = By.xpath("//th[normalize-space()='Product']");

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
        utils.callWaitVisibility(twoSeconds, actualTextCheckoutButton);
        Assert.assertEquals(actualProductTableHead, expectedProductTableHead);
    }
}
