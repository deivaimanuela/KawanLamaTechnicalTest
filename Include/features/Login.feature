 Feature: Login Feature

  @Valid
  Scenario Outline: Login with a valid credential
    Given User navigate to CURA Healthcare Service
    When User click Make Appointment button
    Then User can enter username <username> and password <password>
    And User click login button
    Then User should be able to login successfully

    Examples: 
      | username | password           |
      | Jhon Doe | ThisIsNotAPassword |

  @Invalid
  Scenario Outline: Login with a valid credential
    Given User navigate to CURA Healthcare Service
    When User click Make Appointment button
    Then User can enter invalid username <invalid_username> and invalid password <invalid_password>
    And User click login button
    Then User should NOT be able to login successfully

    Examples: 
      | invalid_username | invalid_password |
      | Dee Ella         | Password12@      |
