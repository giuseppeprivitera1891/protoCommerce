Feature: Shop functionality
  Scenario Outline: The user add products to the cart
    Given the user is on the "<shopPage>"
    When the user adds the products
    And clicks on the checkout button
    Then the user should see the cart page

    Examples:
      | shopPage             |
      | angularpractice/shop |
