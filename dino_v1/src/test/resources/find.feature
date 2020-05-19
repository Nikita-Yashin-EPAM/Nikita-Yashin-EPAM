Feature: Find User of a Company

  Scenario: As a registered company I want to be able to find user of the company by correct credentials
    Given I go to start page
    When I feel search field by "test"
    And I press the search button
    Then I successfully  get a data of the user
#    Examples:
#
#  Scenario Outline: As a registered company I want to be able to get only member of my own company
#    Given I go to find page
#    And I search user "<name>"
#    Then I have not been successfully get a data of the user
#
#    Examples:
#    |name |
#    |name1|
#    |name2|

