Feature: Make Appointment Functionality

@makeAppointment
  Scenario: User makes an appointment successfully
    Given User is logged in
    When User selects "Tokyo CURA Healthcare Center" as facility
    And User checks hospital readmission
    And User selects Medicaid
    And User enters visit date "30/05/2025"
    And User adds comment "Check-up for routine"
    And User clicks Book Appointment
    Then Appointment confirmation should be displayed

  Scenario: User tries to make appointment without selecting facility
    Given User is logged in
    When User leaves facility empty
    And User enters visit date "30/05/2025"
    And User clicks Book Appointment
    Then System should stay on appointment page or show error

  Scenario: User tries to make appointment without entering visit date
    Given User is logged in
    When User selects "Tokyo CURA Healthcare Center" as facility
    And User selects Medicaid
    And User clicks Book Appointment
    Then System should stay on appointment page or show error

  Scenario: User clicks Book Appointment without filling any field
    Given User is logged in
    When User clicks Book Appointment without filling any field
    Then System should stay on appointment page or show error
