package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.DriverManager;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait;
    String userTypeLabel = "User";
    String userRadioLabel;
    WebElement userRadioButtonClick;
    String actualTextModal;
    String expectedTextAlert = "You will be limited to only fewer functionalities of the app. Proceed?";

    By username = By.id("username");
    By password = By.id("password");
    By getUserRadioLabel = By.cssSelector("label:nth-child(2) span:nth-child(1)");
    By userRadioButton = By.cssSelector("input[value='user']");
    By modal = By.id("myModal");
    By okayModalButton = By.id("okayBtn");


    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        System.out.println("The username is " + user + " and password is " + pass);
    }

    public void selectsTypeOfUser() {
        // Gets the "User" label text
        userRadioLabel = driver.findElement(getUserRadioLabel).getText();
        // Checks if the actual result is the same of expected result
        Assert.assertEquals(userRadioLabel, userTypeLabel);
        userRadioButtonClick = driver.findElement(userRadioButton);
        userRadioButtonClick.click();
        // Checks if the radiobutton is selected
        Assert.assertTrue(userRadioButtonClick.isSelected());
        // Waits the modal is visible
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
        // Gets the text of the modal
        actualTextModal = driver.findElement(By.cssSelector("div[class='modal-body'] p")).getText();
        // Prints the text of the modal
        System.out.println("The text of the modal is " + actualTextModal);
        // Checks if the actual result is the same of expected result
        Assert.assertEquals(actualTextModal, expectedTextAlert);
        driver.findElement(okayModalButton).click();
        // Waits the modal is invisible
        wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
    }

    public void acceptTheTerms() {

    }
}
