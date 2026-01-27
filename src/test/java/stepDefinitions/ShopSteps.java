package stepDefinitions;

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
    List<String> myProduct = Arrays.asList("iphone X", "Nokia Edge");

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
}
