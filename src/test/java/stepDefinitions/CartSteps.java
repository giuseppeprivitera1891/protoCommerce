package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.DriverManager;

public class CartSteps {
    private final WebDriver driver = DriverManager.getDriver();

    @When("the user adds the quantity for a product")
    public void the_user_adds_the_quantity_for_a_product() {
        WebElement firstProductQuantity = driver.findElement(By.id("exampleInputEmail1"));
        firstProductQuantity.sendKeys(Keys.BACK_SPACE);
        firstProductQuantity.sendKeys("3");
    }


}
