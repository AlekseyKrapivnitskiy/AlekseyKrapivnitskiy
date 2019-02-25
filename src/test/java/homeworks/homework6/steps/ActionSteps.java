package homeworks.homework6.steps;

import cucumber.api.java.en.When;
import homeworks.homework5.DifferentElementsPage;
import homeworks.homework5.IndexPage;
import homeworks.homework5.enums.LeftMenuItems;
import homeworks.homework5.enums.UserTablePage;
import homeworks.homework5.enums.UsersInTable;

import static homeworks.homework5.enums.Checkboxes.getCheckbox;
import static homeworks.homework5.enums.Colors.getDropdownItem;
import static homeworks.homework5.enums.HeaderItems.getNavigationItem;
import static homeworks.homework5.enums.LeftMenuItems.getItemInLeftMenu;
import static homeworks.homework5.enums.RadioButtons.getRadiobutton;
import static homeworks.homework5.enums.Service.getServiceDropdownItem;
import static homeworks.homework5.enums.Users.getUser;

public class ActionSteps {

    // TODO Why did you decide not pass on user as enum? -- fixed
    @When("^I login as user ([^\"]*)$")
    public void iLoginAs(String user) {
        new IndexPage().login(getUser(user));
    }

    // TODO Why is it hardcoded? -- fixed
    @When("^I click on ([^\"]*) button in Header$")
    public void iClickOnSubcategoryInTheHeader(String navigationItem) {
        new IndexPage().clickOnItemInHeader(getNavigationItem(navigationItem));
    }

    // TODO Why is it hardcoded? -- fixed
    @When("^I click on ([^\"]*) subcategory in the left menu$")
    public void iClickOnSubcategoryInTheLeftMenu(String itemInLeftMenu) {
        new IndexPage().clickOnItemInLeftMenu(getItemInLeftMenu(itemInLeftMenu));
    }

    @When("^I open ([^\"]*) page through \"Service\" drop-down list in header$")
    public void iOpenPageThroughDropDownListInHeader(String item) {
        new IndexPage().selectPageInServiceDropdown(getServiceDropdownItem(item));
    }

    @When("^I click on checkbox: ([^\"]*)$")
    public void iSelectCheckbox(String checkbox) {
        new DifferentElementsPage().clickOnCheckbox(getCheckbox(checkbox));
    }

    @When("^I select ([^\"]*) radiobutton$")
    public void iSelectRadiobutton(String radiobuttonName) {
        new DifferentElementsPage().clickOnRadioButton(getRadiobutton(radiobuttonName));
    }

    @When("^I select ([^\"]*) in drop-down list$")
    public void iSelectInDropDownList(String color) {
        new DifferentElementsPage().selectOptionInDropdown(getDropdownItem(color));
    }

    // TODO Why is it hardcoded? -- fixed
    @When("^I select 'vip' checkbox for ([^\"]*)$")
    public void iSelectVipCheckboxForUser(String user) {
        new UserTablePage().selectCheckbox(UsersInTable.getUserInTable(user));
    }

    @When("^I click on dropdown in column Type for user ([^\"]*)$")
    public void iClickOnDropdownInColumnTypeForUserRoman(String user) {
        new UserTablePage().openDropdownList(UsersInTable.getUserInTable(user));
    }
}
