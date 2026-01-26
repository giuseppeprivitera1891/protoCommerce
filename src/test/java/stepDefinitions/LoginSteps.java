package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.DriverManager;

public class LoginSteps {
    private final WebDriver driver = DriverManager.getDriver();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page()  {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
    }

    @When("the user enters valid {string} and {string}")
    public void the_user_enters_valid_username_and_password (String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }
}
