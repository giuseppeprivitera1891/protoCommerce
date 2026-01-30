package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.DriverManager;
import utility.GenericUtils;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver = DriverManager.getDriver();
    public GenericUtils utils = new GenericUtils();
    WebDriverWait waitModal;
    WebDriverWait waitModalClose;
    WebDriverWait waitPolling;
    WebDriverWait waitLogin;
    WebElement userRadioButtonClick;
    WebElement termCheckbox;
    WebElement signInButton;
    String userTypeLabel = "User";
    String userRadioLabel;
    String actualTextModal;
    String expectedTextAlert = "You will be limited to only fewer functionalities of the app. Proceed?";
    String expectedTitlePage = "ProtoCommerce";
    int oneSecond = 1;
    int fiveSeconds = 5;
    int thirtySeconds = 30;

    By username = By.id("username");
    By password = By.id("password");
    By getUserRadioLabel = By.cssSelector("label:nth-child(2) span:nth-child(1)");
    By userRadioButton = By.cssSelector("input[value='user']");
    By modal = By.id("myModal");
    By okayModalButton = By.id("okayBtn");
    By terms = By.id("terms");
    By submitButton = By.id("signInBtn");
    
    
    public void getUrl(String url) {
        driver.get(url);
    }

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
        utils.callWaitVisibilityElement(oneSecond, modal);
        // Gets the text of the modal
        actualTextModal = driver.findElement(By.cssSelector("div[class='modal-body'] p")).getText();
        // Prints the text of the modal
        System.out.println("The text of the modal is " + actualTextModal);
        // Checks if the actual result is the same of expected result
        Assert.assertEquals(actualTextModal, expectedTextAlert);
        driver.findElement(okayModalButton).click();
        // Waits the modal is invisible
        utils.callWaitInvisibilityElement(oneSecond, modal);
    }

    public void acceptTheTerms() {
        // Gets the checkbox
        termCheckbox = driver.findElement(terms);
        // Waits the checkbox i s clickable
        waitPolling = new WebDriverWait(driver, Duration.ofSeconds(thirtySeconds));
        waitPolling.pollingEvery(Duration.ofSeconds(fiveSeconds));
        waitPolling.until(ExpectedConditions.visibilityOfElementLocated(terms));
        termCheckbox.click();
        // Checks if the checkbox is selected
        Assert.assertTrue(termCheckbox.isSelected());
    }

    public void clickSubmitButton() {
        signInButton = driver.findElement(submitButton);
        Assert.assertTrue(signInButton.isDisplayed());
        signInButton.click();
    }

    public void shopPage() {
        waitLogin = new WebDriverWait(driver, Duration.ofSeconds(fiveSeconds));
        waitLogin.until(ExpectedConditions.titleIs(expectedTitlePage));
        String titleShopPage = driver.getTitle();
        System.out.println("The title of the shop page is " + titleShopPage);
        Assert.assertEquals(titleShopPage, expectedTitlePage);
    }
}
