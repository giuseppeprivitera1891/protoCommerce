Feature: Shop functionality
  @Regression
  Scenario Outline: The user add products to the cart
    Given the user is on the "<urlShopPage>"
    When the user adds the products
    And clicks on the cart button
    Then the user should see the cart page

    Examples:
      | urlShopPage             |
      | angularpractice/shop |
