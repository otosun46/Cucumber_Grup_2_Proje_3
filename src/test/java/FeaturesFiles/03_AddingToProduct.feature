Feature: Add to cart

  Background:
    Given Navigate to automationpractice
    When Enter username and password,  click Login button
    Then User should  login successfully

  @Regression
  Scenario: Add product
    Given Navigate to Dresses
    And Add an item to the cart
      | $30.50        |
      | $50.99        |
      | 2             |
      | Chiffon Dress |
    When Empty the items in the cart
    And Verify cart is empty


