Feature: Customer Management
  Background: Login
    Given User  Launch Crome browser
    When User Navigate to URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Click Login
    Then Page title Should be "Dashboard / nopCommerce administration"


  Scenario: Add new Customer
    Then User clicks on Customer Menu
    And User click on Customers menu item
    And user click on Add New Button
    Then User can view Add new Customer page
    When User enters Customers information
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully"
    Then Close browser

  Scenario: Search existing Customer

    Then User clicks on Customer Menu
    And User click on Customers menu item
    And User enter emailID as "abc2@xyz.com"
    When User hit on Search button
    Then User Email should be listed in the table
    And Close browser