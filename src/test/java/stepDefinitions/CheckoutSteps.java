package stepDefinitions;

import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;

public class CheckoutSteps {
    CheckoutPage checkoutPage = new CheckoutPage();

    @When("the user chooses the {string}")
    public void the_user_chooses_the_class(String string) {}
}
