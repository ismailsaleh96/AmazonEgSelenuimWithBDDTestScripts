@regression
Feature: Check behaviour when User open (Your Orders, Your Addresses, Your Lists) pages while be not logged in

  Background: User open the browser & is in Amazon home page
    Given User Navigate to "https://www.amazon.eg/"

  Scenario Outline: Open your orders/Addresses page while not logged in
    When user hover over Hello,sign in Account & Lists in the top right corner
    And Click on "<page>"
    Then Sign in form displayed
    Examples:
      | page           |
      | Your Orders    |
      | Your Addresses |

  Scenario: Open your Lists page while not logged in
    When user hover over Hello,sign in Account & Lists in the top right corner
    And Click on "Your Lists"
    Then Lists screen are displayed with different benefits
