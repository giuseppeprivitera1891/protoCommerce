package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.DriverManager;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ShopSteps {
    private final WebDriver driver = DriverManager.getDriver();
    // List of our products
    List<String> myProduct = Arrays.asList("iphone X", "Nokia Edge");
    String expectedCheckoutTextButton = "Checkout ( 2 )";

    @Given("the user is on the {string}")
    public void the_user_is_on_the_shopPage(String shopPage) {
        String urlShopPage = driver.getCurrentUrl();
        System.out.println("The URL of shop page is " + urlShopPage);
        Assert.assertTrue(urlShopPage.contains(shopPage));
        WebDriverWait waitProduct = new WebDriverWait(driver, Duration.ofSeconds(2));
        waitProduct.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card h-100']")));
    }

    @When("the user adds the products")
    public void the_user_adds_the_products() {
        // Gets the list of products
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='card h-100']"));

        for (String addProduct : myProduct) {
            for (WebElement product : products) {
                String productName = product.findElement(By.cssSelector("h4[class='card-title']")).getText();
                if (productName.equalsIgnoreCase(addProduct)) {
                    product.findElement(By.cssSelector(".card-footer button")).click();
                    break;
                }
            }
        }
    }

    @And("clicks on the checkout button")
    public void clicks_on_the_checkout_button() {
        String actualCheckoutButton = driver.findElement(By.xpath("(//a[@class='nav-link btn btn-primary'])[1]")).getText();
        System.out.println("The text of checkout button is " + actualCheckoutButton);
        Assert.assertEquals(actualCheckoutButton, expectedCheckoutTextButton);
    }
}
