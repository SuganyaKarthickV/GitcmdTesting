#Author: suganya
Feature: Validate dynamic table and dropdown functionality on the Admin page of OrangeHRM

  Background: 
    Given User is logged into the OrangeHRM demo site

  @DynamicTableAndDropdown
  Scenario: Validate table and dropdown interaction on the Admin page
    When User navigates to the Admin module
    And User selects Admin from the UserRole dropdown
    And User clicks the Search button
    Then User verifies that all results in the "User Role" column contain "Admin"
    And User calculates the total number of rows displayed in the table
