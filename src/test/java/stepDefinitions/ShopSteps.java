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
}
