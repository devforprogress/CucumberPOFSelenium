Feature: LogIn Test
#  Scenario: Successful login with Valid Credential
#    Given User  Launch Crome browser
#    When User Navigate to URL "https://admin-demo.nopcommerce.com/login"
#    And User enters email as "admin@yourstore.com" and password as "admin"
#    And Click Login
#    Then Page title Should be "Dashboard / nopCommerce administration"
#    When User clicks on LogOut Link
#    Then Page title should be "Your store. Login"
#    And Close browser
@NonReg
  Scenario Outline: Successful login with Valid Credential
    Given User  Launch Crome browser
    When User Navigate to URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "<emailAdd>" and password as "<passwd>"
    And Click Login
    Then Page title Should be "Dashboard / nopCommerce administration"
    When User clicks on LogOut Link
    Then Page title should be "Your store. Login"
    And Close browser

  Examples:
    | emailAdd            | passwd |
    | admin@yourstore.com | admin  |
    | test@yourstore.com  | admin  |