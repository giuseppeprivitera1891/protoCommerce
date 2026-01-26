Feature: Login feature
  Scenario Outline: The user logs in with correct credentials
    Given the user is on the login page
    When the user enters valid "<username>" and "<password>"
    And selects the type of user and accept the terms
    And clicks on submit button
    Then the user should see the "<result>"

    Examples:
      | username           | password          |
      | rahulshettyacademy | Learning@830$3mK2 |
