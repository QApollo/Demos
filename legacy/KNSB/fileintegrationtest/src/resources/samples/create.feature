Feature: create
  As a user
  I want to type in a name in the input box and press the submit button
  So that the name will be added to an existing file as a new line

  Scenario: Submitting containing alphabetic letters in name
    Given I have typed in Yung in the name box
    When I press the submit button to submit Yung
    Then a name equals to Yung should be added to the file

  Scenario: Submitting containing invalid symbols in name
    Given I have typed in %%% in the name box
    When I press the submit button to submit %%%
    Then %%% should not be added to the file