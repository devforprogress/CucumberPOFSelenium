Feature: Customer Management
  Scenario: Add new Customer
    Given User  Launch Crome browser
    When User Navigate to URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Click Login
    Then Page title Should be "Dashboard / nopCommerce administration"
    Then User clicks on Customer Menu
    And User click on Customers menu item
    And user click on Add New Button
    Then User can view Add new Customer page
    When User enters Customers info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully"
#    And Close Browser
