package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utility.DriverManager;

import java.util.Arrays;
import java.util.List;

public class ShopDefinitions {
    private final WebDriver driver = DriverManager.getDriver();
    List<String> myProduct = Arrays.asList("iphone X", "Nokia Edge");

    @Given("the user is on the {string}")
    public void the_user_is_on_the_shopPage(String shopPage) {
        String urlShopPage = driver.getCurrentUrl();
        System.out.println("The URL of shop page is " + urlShopPage);
        Assert.assertTrue(urlShopPage.contains(shopPage));
    }

    @When("the user adds the products")
    public void the_user_adds_the_products() {
        List<WebElement> products = driver.findElements(By.cssSelector("card h-100"));
        WebElement addButton = driver.findElement(By.cssSelector("button[class='btn btn-info']"));

        for (String addProduct : myProduct) {
            for (WebElement product : products) {
                String productName = product.findElement(By.cssSelector("h4[class='card-title']")).getText();
                if (productName.equalsIgnoreCase(addProduct)) {
                    addButton.click();
                    break;
                }
            }
        }
    }
}
