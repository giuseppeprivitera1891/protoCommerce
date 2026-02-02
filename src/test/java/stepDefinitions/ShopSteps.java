package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.ShopPage;

import java.time.Duration;

public class ShopSteps {
    ShopPage shopPage = new ShopPage();

    String expectedProductTableHead = "Product";
    int twoSeconds = 2;

    @Given("the user is on the {string}")
    public void the_user_is_on_the_shopPage(String urlShopPage) {
        shopPage.theUserIsOnTheShopPage(urlShopPage);
    }

    @When("the user adds the products")
    public void the_user_adds_the_products() {
        shopPage.theUserAddsTheProducts();
    }

    @And("clicks on the cart button")
    public void clicks_on_the_cart_button() {
        shopPage.clickOnTheCartButton();
    }

    @Then("the user should see the cart page")
    public void the_user_should_see_the_cart_page() {
        String actualProductTableHead = driver.findElement(By.xpath("//th[normalize-space()='Product']")).getText();
        WebDriverWait waitTable = new WebDriverWait(driver, Duration.ofSeconds(2));
        waitTable.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[normalize-space()='Product']")));
        Assert.assertEquals(actualProductTableHead, expectedProductTableHead);
    }
}
