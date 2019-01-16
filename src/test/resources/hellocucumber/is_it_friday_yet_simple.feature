Feature: When is it Friday?
  Everybody wants to know when it's Friday

  Scenario: Sunday isn't Friday
    Given today is Sunday
    When I ask whether it's Friday yet
    Then I should be told "Nope"

  Scenario: Friday is Friday
    Given today is Friday
    When I ask whether it's Friday yet
    Then I should be told "TGIF"

  Scenario: Today is not Friday
    Given today is something
    When It is not Friday
    Then I should be told "Nope"

  Scenario: Today is Friday
    Given today is something
    When It is Friday
    Then I should be told "TGIF"