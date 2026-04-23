package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utility.DriverManager;

public class LoginPage extends DriverManager {
    String userTypeLabel = "User";
    String userRadioLabel;
    String actualTextModal;
    String expectedTextAlert = "You will be limited to only fewer functionalities of the app. Proceed?";
    String expectedTitlePage = "ProtoCommerce";
    String errorMessage;
    String getErrorMessageText = "Incorrect";
    int oneSecond = 1;
    int fiveSeconds = 5;
    int thirtySeconds = 30;

    WebElement userRadioButtonClick;
    WebElement termCheckbox;
    WebElement signInButton;

    By username = By.id("username");
    By password = By.id("password");
    By getUserRadioLabel = By.cssSelector("label:nth-child(2) span:nth-child(1)");
    By userRadioButton = By.cssSelector("input[value='user']");
    By modal = By.id("myModal");
    By modalBody = By.cssSelector("div[class='modal-body'] p");
    By okayModalButton = By.id("okayBtn");
    By terms = By.id("terms");
    By submitButton = By.id("signInBtn");
    By getErrorMessage = By.xpath("//strong[normalize-space()='Incorrect']");
    
    
    public void getUrl(String url) {
        driver.get(url);
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        System.out.println("The username is " + user + " and password is " + pass);
    }

    public void select_type_of_user() {
        // Gets the "User" label text
        userRadioLabel = driver.findElement(getUserRadioLabel).getText();
        // Checks if the actual result is the same of expected result
        Assert.assertEquals(userRadioLabel, userTypeLabel);
        userRadioButtonClick = driver.findElement(userRadioButton);
        userRadioButtonClick.click();
        // Checks if the radiobutton is selected
        Assert.assertTrue(userRadioButtonClick.isSelected());
        // Waits the modal is visible
        callWaitVisibility(oneSecond, modal);
        // Gets the text of the modal
        actualTextModal = driver.findElement(modalBody).getText();
        // Prints the text of the modal
        System.out.println("The text of the modal is " + actualTextModal);
        // Checks if the actual result is the same of expected result
        Assert.assertEquals(actualTextModal, expectedTextAlert);
        driver.findElement(okayModalButton).click();
        // Waits the modal is invisible
        callWaitInvisibility(fiveSeconds, modal);
    }

    public void accept_the_terms() {
        // Gets the checkbox
        termCheckbox = driver.findElement(terms);
        // Waits the checkbox i s clickable
        callWaitPollingVisibility(thirtySeconds, fiveSeconds, terms);
        termCheckbox.click();
        // Checks if the checkbox is selected
        Assert.assertTrue(termCheckbox.isSelected());
    }

    public void click_submit_button() {
        signInButton = driver.findElement(submitButton);
        Assert.assertTrue(signInButton.isDisplayed());
        signInButton.click();
    }

    public void shop_page() {
        callWaitTitle(fiveSeconds, expectedTitlePage);
        String titleShopPage = driver.getTitle();
        System.out.println("The title of the shop page is " + titleShopPage);
        Assert.assertEquals(titleShopPage, expectedTitlePage);
    }

    public void see_error_message() {
        callWaitVisibility(fiveSeconds, getErrorMessage);
        errorMessage = driver.findElement(getErrorMessage).getText().trim();
        System.out.println("The error message is :" + errorMessage);
        Assert.assertEquals(errorMessage, getErrorMessageText);
    }
}
