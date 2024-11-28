#Author: suganya
Feature: Validate the Login functionality for success and failure scenarios using different data sets.

  @SmokeTest
  Scenario Outline: Login with different credentials
    Given User is on the login page
    When User enters the "<username>" and "<password>"
    And User clicks the Login button
    Then User should see the "<message>"

    Examples: 
      | username | password   | message             |
      | Admin    | admin123   | Dashboard           |
      | Admin123 | admin123   | Invalid credentials |
      | Admin    | admin12345 | Invalid credentials |
