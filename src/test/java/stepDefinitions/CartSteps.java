package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.CartPage;
import utility.DriverManager;

public class CartSteps {
    CartPage cartPage = new CartPage();
    public WebDriver driver = DriverManager.getDriver();

    String expectedUnitPriceFirstProduct = "₹. 100000";
    String expectedTotalPriceFirstProduct = "₹. 300000";
    String expectedSecondProductQuantity = "1";
    String expectedUnitPriceSecondProduct = "₹. 65000";
    String expectedTotalPriceSecondProduct = "₹. 65000";
    String expectedTotalPrice = "₹. 365000";
    String expectedCheckoutTextButton = "Checkout";
    String expectedDeliveryText = "Please choose your delivery location.\n" +
            "Then click on purchase button ";

    @When("the user adds the quantity for a product")
    public void the_user_adds_the_quantity_for_a_product() {
        cartPage.theUserAddsTheQuantityForAProduct();
    }

    @And("checks the correctness of the prices")
    public void checks_the_correctness_of_the_prices() {
        // Gets the unit price of the first product and checks it with expected unit price
        String actualUnitPriceFirstProduct = driver.findElement(By.xpath("//strong[text() = '₹. 100000']")).getText();
        System.out.println("The actual price first product: " + actualUnitPriceFirstProduct);
        Assert.assertEquals(actualUnitPriceFirstProduct, expectedUnitPriceFirstProduct);
        // Gets the total price of the first product and checks it with expected total price
        String actualTotalPriceFirstProduct = driver.findElement(By.xpath(("//strong[text() = '₹. 300000']"))).getText();
        System.out.println("The actual total price first product: " + actualTotalPriceFirstProduct);
        Assert.assertEquals(actualTotalPriceFirstProduct, expectedTotalPriceFirstProduct);
        // Gets the quantity of the second product and checks it with expected quantity
        String secondProductQuantity = driver.findElement(By.xpath("(//input[@id='exampleInputEmail1'])[2])")).getText();
        System.out.println("The second product quantity: " + secondProductQuantity);
        Assert.assertEquals(secondProductQuantity, expectedSecondProductQuantity);
        // Gets the unit price of the second product and checks it with expected unit price
        String actualUnitPriceSecondProduct = driver.findElement(By.xpath("(//strong[text() = '₹. 65000'])[1]")).getText();
        System.out.println("The actual unit price second product: " + actualUnitPriceSecondProduct);
        Assert.assertEquals(actualUnitPriceSecondProduct, expectedUnitPriceSecondProduct);
        // Gets the total price of the second product and checks it with expected total price
        String actualTotalPriceSecondProduct = driver.findElement(By.xpath("(//strong[text() = '₹. 65000'])[2]")).getText();
        System.out.println("The actual total price of the second product: " + actualTotalPriceSecondProduct);
        Assert.assertEquals(actualTotalPriceSecondProduct, expectedTotalPriceSecondProduct);
        // Gets the total price and checks it with expected total price
        String actualTotalPrice = driver.findElement(By.cssSelector("//strong[text() = '₹. 365000']")).getText();
        System.out.println("The actual total price: " + actualTotalPrice);
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }

    @And("clicks on the checkout button")
    public void clicks_on_the_checkout_button() {
        // Gets the text checkout button and checks it with expected text
        String actualCheckoutTextButton =  driver.findElement(By.cssSelector("button[class='btn btn-success']")).getText();
        System.out.println("The text of the Checkout button: " + actualCheckoutTextButton);
        Assert.assertEquals(actualCheckoutTextButton, expectedCheckoutTextButton);
        // Clicks on the Checkout button
        WebElement checkoutButon = driver.findElement(By.cssSelector("button[class='btn btn-success']"));
        checkoutButon.click();
    }

    @Then("the user should see the checkout page")
    public void the_user_should_see_the_checkout_page() {
        // Gets the text delivery and checks it with expected text
        String actualDeliveryText = driver.findElement(By.cssSelector("label[for='country']")).getText();
        System.out.println("The delivery text: " + actualDeliveryText);
        Assert.assertEquals(actualDeliveryText, expectedDeliveryText);
    }
}
