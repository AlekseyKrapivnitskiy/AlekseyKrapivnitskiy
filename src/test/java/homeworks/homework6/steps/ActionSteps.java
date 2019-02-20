package homeworks.homework6.steps;

import cucumber.api.java.en.When;
import homeworks.homework5.DifferentElementsPage;
import homeworks.homework5.IndexPage;

import static homeworks.homework5.enums.Checkboxes.WATER;
import static homeworks.homework5.enums.Service.DIFFERENT_ELEMENTS;
import static homeworks.homework5.enums.Users.PITER_CHAILOVSKII;

public class ActionSteps {

    @When("^I login as user epam with password 1234$")
    public void iLoginAs() {
        new IndexPage().login(PITER_CHAILOVSKII);
    }

    @When("^I click on \"Service\" subcategory in the header$")
    public void iClickOnSubcategoryInTheHeader() {
        new IndexPage().clickOnServiceDropdownInHeader();
    }

    @When("^I click on \"Service\" subcategory in the left menu$")
    public void iClickOnSubcategoryInTheLeftMenu() {
        new IndexPage().clickOnServiceDropdownInLeftMenu();
    }

    @When("^I open \"Different Elements\" page through \"Service\" drop-down list in header$")
    public void iOpenPageThroughDropDownListInHeader() {
        new IndexPage().selectPageInServiceDropdown(DIFFERENT_ELEMENTS);
    }

    @When("^I select checkboxes \"Water\" and \"Wind\"$")
    public void iSelectCheckboxesAnd() {
        new DifferentElementsPage().clickOnCheckbox(WATER);
        new DifferentElementsPage().clickOnCheckbox(WATER);
    }
}
