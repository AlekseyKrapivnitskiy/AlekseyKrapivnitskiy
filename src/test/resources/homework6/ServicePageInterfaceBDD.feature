Feature: Service Page Interface BDD

  Scenario: Check Service Page Interface using Cucumber
    Given I am on "Home Page"
    Then Browser title is "Home Page"
    When I login as user epam with password 1234
    Then User name is 'PITER CHAILOVSKII'
    And Page contains all needed elements