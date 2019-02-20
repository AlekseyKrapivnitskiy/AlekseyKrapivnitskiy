Feature: Service Page Interface BDD

  Scenario: Check Service Page Interface using Cucumber
    Given I am on "Home Page"
    Then Browser title is "Home Page"
    When I login as user epam with password 1234
    Then User name is "PITER CHAILOVSKII"
    And Page contains all needed elements
    When I click on "Service" subcategory in the header
    Then Service drop-down list in header contains options:
      |Support|
      |Dates|
      |Complex Table|
      |Simple Table|
      |User Table|
      |Table with pages|
      |Different Elements|
      |Performance|
    When I click on "Service" subcategory in the left menu
    Then Service drop-down list in left menu contains options:
      |Support|
      |Dates|
      |Complex Table|
      |Simple Table|
      |User Table|
      |Table with pages|
      |Different Elements|
      |Performance|