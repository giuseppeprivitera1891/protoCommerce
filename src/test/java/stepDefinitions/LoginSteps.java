package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    String url = "https://rahulshettyacademy.com/loginpagePractise/";

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page()  {
        loginPage.getUrl(url);
    }

    @When("the user enters valid {string} and {string}")
    public void the_user_enters_valid_username_and_password (String username, String password) {
        loginPage.login(username, password);
    }

    @And("selects the type of user and accept the terms")
    public void selects_the_type_of_user_and_accept_the_terms() {
        loginPage.select_type_of_user();
        loginPage.accept_the_terms();
    }

    @And("clicks on submit button")
    public void clicks_on_submit_button() {
        loginPage.click_submit_button();
    }

    @Then("the user should see the shop page")
    public void the_user_should_see_the_shop_page() {
        loginPage.shop_page();
    }
}
