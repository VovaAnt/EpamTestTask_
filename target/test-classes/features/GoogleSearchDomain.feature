Feature: Test Google Search Functionality

  Scenario: Two
    Given We are on Google Search page
    When make Search in google for "automation"
    Then Verifying Title on 5 pages "testautomationday.com"