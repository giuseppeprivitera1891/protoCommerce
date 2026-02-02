package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.DriverManager;
import utility.GenericUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ShopSteps {
    private final WebDriver driver = DriverManager.getDriver();
    public GenericUtils utils = new GenericUtils();
    // List of our products
    List<String> myProduct = Arrays.asList("iphone X", "Nokia Edge");
    String expectedCheckoutTextButton = "Checkout ( 2 )\n(current)";
    String expectedProductTableHead = "Product";
    int twoSeconds = 2;

    By cardProducts = By.xpath("//div[@class='card h-100']");
    By cardTitle = By.cssSelector("h4[class='card-title']");
    By cardFooterButton = By.cssSelector(".card-footer button");

    @Given("the user is on the {string}")
    public void the_user_is_on_the_shopPage(String shopPage) {
        String urlShopPage = driver.getCurrentUrl();
        System.out.println("The URL of shop page is " + urlShopPage);
        Assert.assertTrue(urlShopPage.contains(shopPage));
        utils.callWaitVisibility(twoSeconds, cardProducts);
    }

    @When("the user adds the products")
    public void the_user_adds_the_products() {
        // Gets the list of products
        List<WebElement> products = driver.findElements(cardProducts);

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

    @And("clicks on the cart button")
    public void clicks_on_the_cart_button() {
        String actualCheckoutButton = driver.findElement(By.xpath("(//a[@class='nav-link btn btn-primary'])[1]")).getText();
        System.out.println("The text of checkout button is " + actualCheckoutButton);
        Assert.assertEquals(actualCheckoutButton, expectedCheckoutTextButton);
        WebElement checkoutButton = driver.findElement(By.xpath("(//a[@class='nav-link btn btn-primary'])[1]"));
        checkoutButton.click();
    }

    @Then("the user should see the cart page")
    public void the_user_should_see_the_cart_page() {
        String actualProductTableHead = driver.findElement(By.xpath("//th[normalize-space()='Product']")).getText();
        WebDriverWait waitTable = new WebDriverWait(driver, Duration.ofSeconds(2));
        waitTable.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[normalize-space()='Product']")));
        Assert.assertEquals(actualProductTableHead, expectedProductTableHead);
    }
}
