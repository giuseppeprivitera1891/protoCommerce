@Regression
Feature: Shop functionality
  Scenario Outline: The user add products to the cart
    Given the user is on the "<urlShopPage>"
    When the user adds the products
    And clicks on the cart button
    Then the user should see the cart page

    Examples:
      | urlShopPage          |
      | angularpractice/shop |

  Scenario: The user adds the quantity for a product
    When the user adds the quantity for a product
    And checks the correctness of the prices
    And clicks on the checkout button
    Then the user should see the checkout page