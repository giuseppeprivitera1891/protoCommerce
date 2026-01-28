package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.DriverManager;

public class LoginPage {
    private final WebDriver driver = DriverManager.getDriver();

    By username = By.id("username");
    By password = By.id("password");

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        System.out.println("The username is " + user + " and password is " + pass);
    }
}
