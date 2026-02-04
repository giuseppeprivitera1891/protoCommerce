Feature: Login feature
  @Regression
  Scenario Outline: The user logs in with correct credentials
    Given the user is on the login page
    When the user enters valid "<username>" and "<password>"
    And selects the type of user and accept the terms
    And clicks on submit button
    Then the user should see the shop page

    Examples:
      | username           | password          |
      | rahulshettyacademy | Learning@830$3mK2 |

    @Negative
    Scenario Outline: The user inserts invalid credentials
      Given the user is on the login page
      When the user enters valid "<username>" and "<password>"
      And selects the type of user and accept the terms
      And clicks on submit button
      Then the user should see an error message

      Examples:
      | username           | password          |
      | rahulshettyacademy | myWorld@124       |
      | rahulshetty        | Learning@830$3mK2 |
      | academy            | Learning@83K2     |

