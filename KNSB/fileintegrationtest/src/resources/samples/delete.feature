Feature: delete line
  As a user
  I want to put a specific line number in the input box and press the submit button
  So that the corresponding text will be deleted from an existing file

  Scenario: Deleting text that contains a valid line number
    Given I have typed in 2 in the line box
    When I press the submit button to submit 2
    Then the line number equals to the input should be removed from to the file

  Scenario: Deleting text that contains an invalid line number
    Given I have typed in @a in the line box
    When I press the submit button to submit @a
    Then a line equals to Aeron should not be added to the file