Feature: Login Functionality

  @Regression
Scenario: Login with valid username and password
  Given Navigate to automationpractice
  When Enter username and password,  click Login button
  Then User should  login successfully


