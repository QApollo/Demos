Feature: person

  Scenario: homeless person
    Given a person without an address
    When I ask the person if he is homeless
    Then I expect the answer to be YES

  Scenario: not a homeless person
    Given a person with an address
    When I ask the person if he is homeless
    Then I expect the answer to be NO