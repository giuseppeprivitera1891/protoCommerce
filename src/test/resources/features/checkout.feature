Feature: Checkout feature
  @Regression
  Scenario Outline: The user chooses the "<deliveryLocation>" and proceeds with the purchase
    When the user chooses the delivery location and accepts the terms
    And clicks on purchase button
    Then the user should see a success message

    Examples:
      | deliveryLocation |
      | India            |
