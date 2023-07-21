@regression
Feature: SignIn

  Background: User open the browser & is in Amazon home page
    Given User Navigate to "https://www.amazon.eg/"

  Scenario Outline: User Login without email & with valid but no registered Email
    When User Click on Hello Sign in
    And Enter "<email>" in Email field
    And Click continue
    Then Validation "<validation>"

    Examples:
      | email                  | validation                                        |
      |                        | Enter your email or mobile phone number           |
      | mfazaa@victorylink.com | We cannot find an account with that email address |

