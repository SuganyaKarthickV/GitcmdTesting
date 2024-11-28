
Feature: Flipkart Application Testing



  Scenario: Login to Flipkart
   Given User is on Flipkart homepage
    When User clicks on login text
    And User logs in with credentials from excel
   Then User is redirected to the Flipkart home page

   Scenario: Extract details from Electronics category
    When User navigates to Electronics category
    Then User selects a product and writes its details to excel
    
    Scenario: Extract details from Home and Furniture category
    When User navigates to Home and Furniture category
    Then User selects products and writes its details to excel