package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.DriverManager;
import utility.GenericUtils;

public class ShopPage {
    public WebDriver driver = DriverManager.getDriver();
    public GenericUtils utils = new GenericUtils();
    String urlShopPage;
    int oneSecond = 1;
    int  twoSeconds = 2;
    int fiveSeconds = 5;
    int thirtySeconds = 30;

    By cardProducts = By.xpath("//div[@class='card h-100']");

    public void theUserIsOnTheShopPage(String url) {
        urlShopPage = driver.getCurrentUrl();
        System.out.println("The URL of shop page is " + urlShopPage);
        Assert.assertTrue(urlShopPage.contains(url));
        utils.callWaitVisibility(twoSeconds, cardProducts);
    }
}
