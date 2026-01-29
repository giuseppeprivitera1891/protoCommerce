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
    String userTypeLabel = "User";
    String expectedTextAlert = "You will be limited to only fewer functionalities of the app. Proceed?";
    String expectedTitlePage = "ProtoCommerce";

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page()  {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
    }

    @When("the user enters valid {string} and {string}")
    public void the_user_enters_valid_username_and_password (String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @And("selects the type of user and accept the terms")
    public void selects_the_type_of_user_and_accept_the_terms() {
        // Gets the "User" label text
        String userRadioLabel = driver.findElement(By.cssSelector("label:nth-child(2) span:nth-child(1)")).getText();
        // Checks if the actual result is the same of expected result
        Assert.assertEquals(userRadioLabel, userTypeLabel);
        // Get the "User" radiobutton
        WebElement userRadioButton = driver.findElement(By.cssSelector("input[value='user']"));
        userRadioButton.click();
        // Checks if the radiobutton is selected
        Assert.assertTrue(userRadioButton.isSelected());
        // Waits the modal is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModal")));
        // Gets the text of the modal
        String actualTextModal = driver.findElement(By.cssSelector("div[class='modal-body'] p")).getText();
        // Prints the text of the modal
        System.out.println("The text of the modal is " + actualTextModal);
        // Checks if the actual result is the same of expected result
        Assert.assertEquals(actualTextModal, expectedTextAlert);
        driver.findElement(By.id("okayBtn")).click();
        // Waits the modal is invisible
        WebDriverWait waitCloseModal = new WebDriverWait(driver, Duration.ofSeconds(1));
        waitCloseModal.until(ExpectedConditions.invisibilityOfElementLocated(By.id("myModal")));
        // Gets the checkbox
        WebElement termCheckbox = driver.findElement(By.id("terms"));
        // // Waits the checkbox is clickable
       WebDriverWait waitCheckbox = new WebDriverWait(driver, Duration.ofSeconds(30));
       waitCheckbox.pollingEvery(Duration.ofSeconds(2));
       waitCheckbox.until(ExpectedConditions.visibilityOfElementLocated(By.id("terms")));
        termCheckbox.click();
        // Checks if the checkbox is selected
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
        WebDriverWait waitLoaPage = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitLoaPage.until(ExpectedConditions.titleIs(expectedTitlePage));
        String titleShopPage = driver.getTitle();
        System.out.println("The title of the shop page is " + titleShopPage);
        Assert.assertEquals(titleShopPage, expectedTitlePage);
    }
}
