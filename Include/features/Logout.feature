Feature: Logout Functionality

  @Logout
  Scenario: Successful logout
    Given User is loggedin
    When User clicks the menu and selects Logout
    Then User should be redirected to the homepage
