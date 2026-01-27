package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.DriverManager;

public class ShopDefinitions {
    private final WebDriver driver = DriverManager.getDriver();

    @Given("the user is on the {string}")
    public void the_user_is_on_the_shopPage(String shopPage) {
        String urlShopPage = driver.getCurrentUrl();
        System.out.println("The URL of shop page is " + urlShopPage);
        Assert.assertTrue(urlShopPage.contains(shopPage));
    }
}
