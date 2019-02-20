package homeworks.homework6.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homeworks.homework5.DifferentElementsPage;
import homeworks.homework5.IndexPage;

import static homeworks.homework5.enums.Checkboxes.WATER;
import static homeworks.homework5.enums.Checkboxes.getCheckbox;
import static homeworks.homework5.enums.Colors.YELLOW;
import static homeworks.homework5.enums.RadioButtons.SELEN;
import static homeworks.homework5.enums.RadioButtons.getRadiobutton;
import static homeworks.homework5.enums.Service.getServiceDropdownItem;
import static homeworks.homework5.enums.Users.PITER_CHAILOVSKII;

public class ActionSteps {

    @When("^I login as user '([^\"]*)' with password '([^\"]*)'$")
    public void iLoginAs(String login, String password) {
        new IndexPage().loginAs(login, password);
    }

    @And("^I login as user \"Piter Chailovskii\"$")
    public void iLoginAsPiterChailovskii() {
        new IndexPage().login(PITER_CHAILOVSKII);
    }

    @When("^I click on \"Service\" button in Header$")
    public void iClickOnSubcategoryInTheHeader() {
        new IndexPage().clickOnServiceDropdownInHeader();
    }

    @When("^I click on \"Service\" subcategory in the left menu$")
    public void iClickOnSubcategoryInTheLeftMenu() {
        new IndexPage().clickOnServiceDropdownInLeftMenu();
    }

    @When("^I open '([^\"]*)' page through \"Service\" drop-down list in header$")
    public void iOpenPageThroughDropDownListInHeader(String item) {
        new IndexPage().selectPageInServiceDropdown(getServiceDropdownItem(item));
    }

    @When("^I click on checkbox: '([^\"]*)'$")
    public void iSelectCheckbox(String checkbox) {
        new DifferentElementsPage().clickOnCheckbox(getCheckbox(checkbox));
    }

    @When("^I select '([^\"]*)' radiobutton$")
    public void iSelectRadiobutton(String radiobuttonName) {
        new DifferentElementsPage().clickOnRadioButton(getRadiobutton(radiobuttonName));
    }

    @When("^I select \"Yellow\" in drop-down list$")
    public void iSelectInDropDownList() {
        new DifferentElementsPage().selectOptionInDropdown(YELLOW);
    }
}
