@allTests @UI @regression
Feature: Random Date Generator
@smoke
  Scenario: Verify Functionality of "How Many Dates To Generate" Area
    When User enters 5 dates to generate
    And User clicks on Generate Random Date button
    Then Verify that the system created the specified number of dates


  Scenario: Verify Functionality of "Start date" Area
    When User enters start date as "2021-10-10"
    And User clicks on Generate Random Date button
    Then Verify that the selected start date should be the same as entered date


  Scenario: Verify functionality of "End date" Area
    When User enters end date as "2021-02-10"
    And User clicks on Generate Random Date button
    Then Verify that the selected end date should be the same as entered date


  Scenario: System creates the specified number of dates
    When User enters 5 dates to generate
    And User chooses date format as "MM-DD-YYYY"
    And User enters start date as "2021-02-02"
    And User enters end date as "2021-02-10"
    And User clicks on Generate Random Date button
    Then Verify that the system created the specified number of dates


  Scenario: Dates should be within the specified range
    When User enters 4 dates to generate
    And User chooses date format as "MM-DD-YYYY"
    And User enters start date as "2021-02-25"
    And User enters end date as "2021-02-27"
    And User clicks on Generate Random Date button
    Then Verify that the system generated dates within the expected range


  @negative
  Scenario: The start year should not be later than the end year
    When User enters start date as "2022-10-10"
    And User enters end date as "2021-02-10"
    And User clicks on Generate Random Date button
    Then Verify that the system does not allow generating the start year be later than the end year