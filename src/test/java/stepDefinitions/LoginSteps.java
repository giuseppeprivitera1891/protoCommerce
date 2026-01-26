package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.DriverManager;

import java.time.Duration;

public class LoginSteps {
    private final WebDriver driver = DriverManager.getDriver();
    String userTypeLabel = "User";

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page()  {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
    }

    @When("the user enters valid {string} and {string}")
    public void the_user_enters_valid_username_and_password (String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
        System.out.println("The username is " + usernameField);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        System.out.println("The password is " + passwordField);
    }

    @And("selects the type of user and accept the terms")
    public void selects_the_type_of_user_and_accept_the_terms() {
        String userRadioLabel = driver.findElement(By.cssSelector("label:nth-child(2) span:nth-child(1)")).getText();
        Assert.assertEquals(userRadioLabel, userTypeLabel);
        WebElement userRadioButton = driver.findElement(By.cssSelector("input[value='user']"));
        userRadioButton.click();
        Assert.assertTrue(userRadioButton.isSelected());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement selectRole = driver.findElement(By.className("form-control"));
        Select select = new Select(selectRole);
        Assert.assertTrue(select.getFirstSelectedOption().isDisplayed());
        WebElement termCheckbox = driver.findElement(By.id("terms"));
        termCheckbox.click();
        Assert.assertTrue(termCheckbox.isSelected());
    }

    @And("clicks on submit button")
    public void clicks_on_submit_button() {
        WebElement signInButton = driver.findElement(By.id("signInBtn"));
        Assert.assertTrue(signInButton.isDisplayed());
        signInButton.click();
    }

    @Then("the user should see the shop page")
    public void the_user_should_see_the_shop_page() {
        String getShopURL = driver.getCurrentUrl();
        System.out.println("The shop URL is " + getShopURL);
        Assert.assertTrue(getShopURL.contains("shop"));
    }
}
