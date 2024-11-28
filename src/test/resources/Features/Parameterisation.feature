Feature: this features explain parameterisation

  Scenario: Passing parameter to scenrio step
    Given I have 5 and 6
    When i add them
    Then check if the result is prime

  Scenario: Data table example
    Given I have following pair of numbers
    |11|14|
    |45|91|
    |92|83|
    When i add them
    Then check if the result is prime 
