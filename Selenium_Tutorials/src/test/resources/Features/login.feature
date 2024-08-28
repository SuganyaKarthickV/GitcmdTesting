
Feature: To test login scenario
  

 
  Scenario: check login is successful with valid credentials
    Given User is on the login page
    When User enters user name and password
    And clicks on login button
    Then User is navigated to the homepage 