package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ShopPage;

public class ShopSteps {
    ShopPage shopPage = new ShopPage();

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
        shopPage.theUserShouldSeeTheCartPage();
    }

    @When("the user adds the quantity for a product")
    public void the_user_adds_the_quantity_for_a_product() {
        shopPage.theUserAddsTheQuantityForAProduct();
    }


    @And("checks the correctness of the prices")
    public void checks_the_correctness_of_the_prices() {
        shopPage.correctnessOfThePrices();
    }

    /* @And("clicks on the checkout button")
    public void clicks_on_the_checkout_button() {
        // Gets the text checkout button and checks it with expected text
        String actualCheckoutTextButton =  driver.findElement(By.cssSelector("button[class='btn btn-success']")).getText();
        System.out.println("The text of the Checkout button: " + actualCheckoutTextButton);
        Assert.assertEquals(actualCheckoutTextButton, expectedCheckoutTextButton);
        // Clicks on the Checkout button
        WebElement checkoutButon = driver.findElement(By.cssSelector("button[class='btn btn-success']"));
        checkoutButon.click();
    }

    @Then("the user should see the checkout page")
    public void the_user_should_see_the_checkout_page() {
        // Gets the text delivery and checks it with expected text
        String actualDeliveryText = driver.findElement(By.cssSelector("label[for='country']")).getText();
        System.out.println("The delivery text: " + actualDeliveryText);
        Assert.assertEquals(actualDeliveryText, expectedDeliveryText);
    }*/
}
