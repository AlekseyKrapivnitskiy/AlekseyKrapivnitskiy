Feature: Service Page Interface BDD

  Scenario: Check Service Page Interface using Cucumber
    Given I am on "Home Page"
    Then Browser title is "Home Page"
    When I login as user 'epam' with password '1234'
    Then User name is "PITER CHAILOVSKII"
    And Page contains all needed elements

    When I click on "Service" button in Header
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

    When I open "Different Elements" page through "Service" drop-down list in header
    Then Page contains left section
    And Page contains right section
    When I click on checkboxes "Water" and "Wind"
    Then Corresponding log appears according to selected checkboxes:
    When I select "Selen" radiobutton
    Then Corresponding log appears according to selected radiobutton
    When I select "Yellow" in drop-down list
    Then Corresponding log appears according to selected option in drop-down list
    When I click on checkboxes "Water" and "Wind"
    Then Corresponding log appears according to selected checkboxes: