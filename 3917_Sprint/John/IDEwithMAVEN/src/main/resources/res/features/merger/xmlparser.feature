Feature: xmlparser

  Scenario: Files has same number of lines
    Given files from multithread with singlethreaded xmlparser is generated
    Then the number of lines in files is same

  Scenario: Same content
    Given files from multithread with singlethreaded xmlparser is generated
    When file lines are sorted
    Then the contents if files is same
