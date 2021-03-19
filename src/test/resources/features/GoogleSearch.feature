Feature: Test Google Search Functionality

  Scenario: One
    Given We are on Google Search page
    When make Search in google for "automation"
    Then Verifying Title "automation"

