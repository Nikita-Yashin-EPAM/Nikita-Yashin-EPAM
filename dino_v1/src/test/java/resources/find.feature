Feature: Find User of a Company

  Scenario Outline: As a registered company I want to be able to find user of the company by correct credentials
    Given I go to find page
    When I search user "Nikita"
    Then I have been successfully  get a data of the user
    Examples:

  Scenario Outline: As a registered company I want to be able to get only member of my own company
    Given I go to find page
    And I search user "<name>"
    Then I have not been successfully get a data of the user

    Examples:
    |name |
    |name1|
    |name2|

