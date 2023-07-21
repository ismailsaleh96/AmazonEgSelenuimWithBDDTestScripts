@regression
Feature: Add Item to cart

  Background: User open the browser & is in Amazon home page
    Given User Navigate to "https://www.amazon.eg/"

  Scenario: Items are added to cart correctly
    When User Click on All 3 Dashes menu and Select Today's deal
    And Click first product under The second category
    And Click second item if visible & Select Regular price radio
    And Select Quantity if displayed & Add to cart
    And discard extended warranty if displayed
    Then Item is presented in cart with The correct name, price, price and subtotal
