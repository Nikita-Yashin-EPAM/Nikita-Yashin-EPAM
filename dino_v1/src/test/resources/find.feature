Feature: Find User of a Company

  Scenario: As a registered company I want to be able to find user of the company by correct name
    Given I go to start page
    When I feel search field by "test"
    And I press the search button
    Then I should see a data of the user

  Scenario Outline: As a registered company I want to be able to get only member of my own company
    Given I go to start page
    When I feel search field by "<name>"
    And I press the search button
    Then I should not see a data of the user

    Examples:
      | name  |
      | name1 |
      | name2 |