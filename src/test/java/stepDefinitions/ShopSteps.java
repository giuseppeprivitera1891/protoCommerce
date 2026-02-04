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
        shopPage.shop_page(urlShopPage);
    }

    @When("the user adds the products")
    public void the_user_adds_the_products() {
        shopPage.add_products();
    }

    @And("clicks on the cart button")
    public void clicks_on_the_cart_button() {
        shopPage.click_on_the_cart_button();
    }

    @Then("the user should see the cart page")
    public void the_user_should_see_the_cart_page() {
        shopPage.cart_page();
    }

    @When("the user adds the quantity for a product")
    public void the_user_adds_the_quantity_for_a_product() {
        shopPage.add_quantity_for_a_product();
    }

    @And("checks the correctness of the prices")
    public void checks_the_correctness_of_the_prices() {
        shopPage.correctness_of_the_prices();
    }

    @And("clicks on the checkout button")
    public void clicks_on_the_checkout_button() {
        shopPage.click_on_the_checkout_button();
    }

    @Then("the user should see the checkout page")
    public void the_user_should_see_the_checkout_page() {
        shopPage.checkout_page();
    }

    @When("the user chooses the {string}")
    public void the_user_chooses_the_class(String deliveryLocation) {
        shopPage.choose_delivery_location(deliveryLocation);
    }

    @And("accepts the terms")
    public void accepts_the_terms() {
        shopPage.accept_the_terms();
    }

    @And("clicks on purchase button")
    public void clicks_on_purchase_button() {
        shopPage.click_purchase_button();
    }
}
