Feature: Object verification

  Background:
    Given Navigate to automationpractice
    When Enter username and password,  click Login button
    Then User should  login successfully

  @Regression
  Scenario:Click link end verify
    Given Click on the element in the Dialog Content class
      | facebook         |
      | facebooklogosu   |
      | twitter          |
      | twitterlogosu    |
      | youTube          |
      | youTubelogosu    |
      | googlePlus       |
      | googlePlusLogosu |
#      | facebook                   |
#      | www.facebook.com           |
#      | twitter                    |
#      | twitter.com/seleniumfrmwrk |
#      | youTube                    |
#      | youtube.com/channel/       |
#      | googlePlus                 |
#      | accounts.google.com        |

