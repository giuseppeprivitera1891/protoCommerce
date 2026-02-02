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
    int oneSecond = 1;
    int  twoSeconds = 2;
    int fiveSeconds = 5;
    int thirtySeconds = 30;

    List<WebElement> products;

    By cardProducts = By.xpath("//div[@class='card h-100']");
    By cardTitle = By.cssSelector("h4[class='card-title']");
    By cardFooterButton = By.cssSelector(".card-footer button");

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

}
