Feature: Cart functionality
  Scenario: The user adds the quantity for a product
    When the user adds the quantity for a product
    And checks the correctness of the prices
    And clicks on the checkout button
    Then the user should see the checkout page