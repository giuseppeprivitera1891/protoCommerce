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
import pageObjects.LoginPage;
import utility.DriverManager;

import java.time.Duration;

public class LoginSteps {
    private final WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage();
    String expectedTitlePage = "ProtoCommerce";

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page()  {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
    }

    @When("the user enters valid {string} and {string}")
    public void the_user_enters_valid_username_and_password (String username, String password) {
        loginPage.login(username, password);
    }

    @And("selects the type of user and accept the terms")
    public void selects_the_type_of_user_and_accept_the_terms() {
        loginPage.selectsTypeOfUser();
        loginPage.acceptTheTerms();
    }

    @And("clicks on submit button")
    public void clicks_on_submit_button() {
        loginPage.clickSubmitButton();
    }

    @Then("the user should see the shop page")
    public void the_user_should_see_the_shop_page() {
        WebDriverWait waitLoaPage = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitLoaPage.until(ExpectedConditions.titleIs(expectedTitlePage));
        String titleShopPage = driver.getTitle();
        System.out.println("The title of the shop page is " + titleShopPage);
        Assert.assertEquals(titleShopPage, expectedTitlePage);
    }
}
