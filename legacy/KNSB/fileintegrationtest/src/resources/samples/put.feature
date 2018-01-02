Feature: update
  As a user
  I want to type in a line number in the first input box
  and a name in the second input box and press the submit button
  So that the name will be added to the according line number in an existing file as a new line

  Scenario: Submitting containing correct line number and alphabetic letters in name
    Given I have typed in 3 in the line box
    And I have typed in Aeron in the name box
    When I press the submit button to submit Aeron in line 3
    Then a line equals to Aeron should be added to the file in the according line

  Scenario: Submitting containing incorrect line number
    Given I have typed in a in the line box
    And I have typed in Alfonso in the name box
    When I press the submit button to submit Alfonso in an incorrect line
    Then Alfonso should not be added in the file

  Scenario: Submitting containing incorrect name
    Given I have typed in 4 in the line box
    And I have typed in @!! in the name box
    When I press the submit button to submit an incorrect name
    Then @!! should be added in the file