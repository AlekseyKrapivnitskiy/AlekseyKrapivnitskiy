package homeworks.homework6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.homework5.DifferentElementsPage;
import homeworks.homework5.IndexPage;
import homeworks.homework5.enums.UserTablePage;

import static homeworks.homework3.enums.BenefitTexts.getBenefitTextsList;
import static homeworks.homework3.enums.HeaderItems.getHeaderItemsList;
import static homeworks.homework3.enums.MainHeader.MAIN_TEXT;
import static homeworks.homework3.enums.MainHeader.TITLE;
import static homeworks.homework5.enums.Checkboxes.*;
import static homeworks.homework5.enums.Colors.getDropdownItem;
import static homeworks.homework5.enums.IndexPageData.getIndexPageDataByTtitle;
import static homeworks.homework5.enums.LogsMessages.*;
import static homeworks.homework5.enums.RadioButtons.getRadiobutton;

public class AssertionSteps {

    // TODO Why is it hardcoded? -- fixed
    @Then("^Browser title is ([^\"]*)")
    public void browserTitleIs(String title) {
        new IndexPage().checkTitle(getIndexPageDataByTtitle(title));
    }

    // TODO Why is it hardcoded? -- fixed
    @Then("^User name is ([^\"]*)$")
    public void userNameIsPITERCHAILOVSKII(String username) {
        new IndexPage().checkUsernameByName(username);
    }

    // TODO What does 'And' mean?
    // TODO Which elements needed? -- fixed
    @And("^Page contains all needed elements: 4 pictures, 4 texts under them, 2 texts above - headline and description$")
    public void pageContainsAllNeededElements() {
        new IndexPage().checkBenefitIcons();
        new IndexPage().checkBenefitTexts(getBenefitTextsList());
        new IndexPage().checkMainHeaderTitle(TITLE);
        new IndexPage().checkMainHeaderText(MAIN_TEXT);
    }

    @Then("^Service drop-down list in header contains options:$")
    public void serviceDropDownListContainsOptions(DataTable headerItems) {
        new IndexPage().checkServiceDropdownListInHeader(headerItems.asList(String.class));
    }

    @Then("^Service drop-down list in left menu contains options:$")
    public void serviceDropDownListInLeftMenuContainsOptions(DataTable leftMenuItems) {
        new IndexPage().checkServiceDropdownListInLeftMenu(leftMenuItems.asList(String.class));
    }

    @Then("^Page contains left section$")
    public void pageContainsLeftSection() {
        new homeworks.homework5.DifferentElementsPage().checkServiceDropdownListInLeftMenu(getHeaderItemsList());
    }

    @And("^Page contains right section$")
    public void pageContainsRightSection() {
        new DifferentElementsPage().checkRightSection();
    }

    /* TODO -- fixed
        * Corresponding log appears according to selected checkbox:
        * Corresponding log appears according to selected radiobutton:
        * Corresponding log appears according to selected option in drop-down list:
        * Could be combined into one step
     */
    @Then("^Corresponding log appears according to selected ([^\"]*) - ([^\"]*): condition changed to ([^\"]*)$")
    public void correspondingLogAppearsAccordingToSelectedRadiobutton(String element, String elementValue, String condition) {

        if (element.equals("checkbox")) {
            new DifferentElementsPage().checkCheckboxesLogs(getCheckbox(elementValue), condition, CHECKBOX_LOG);
        }

        if (element.equals("radiobutton")) {
            new DifferentElementsPage().checkRadiosLogs(getRadiobutton(elementValue), RADIOBUTTON_LOG);
        }

        if (element.equals("option in drop-down list")) {
            new DifferentElementsPage().checkDropdownLogs(getDropdownItem(elementValue), DROPDOWN_LOG);
        }
    }

    @Then("^([^\"]*) page is opened$")
    public void pageIsOpened(String title) {
        new IndexPage().checkTitleOfAnyPage(title);
    }

    // TODO Why is it hardcoded? -- fixed
    @And("^(.+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numbertypeDropdownsAreDisplayedOnUsersTableOnUserTablePage(int amount) {
        new UserTablePage().checkAmountOfDropdowns(amount);
    }

    // TODO Why is it hardcoded? -- fixed
    @And("^(.+) User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayedOnUsersTableOnUserTablePage(int amount) {
        new UserTablePage().checkAmountOfUsernames(amount);
    }

    // TODO Why is it hardcoded? -- fixed
    @And("^(.+) Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayedOnUsersTableOnUserTablePage(int amount) {
        new UserTablePage().checkAmountOfUserImages(amount);
    }

    // TODO Why is it hardcoded? -- fixed
    @And("^(.+) Description texts under images are displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayedOnUsersTableOnUserTablePage(int amount) {
        new UserTablePage().checkAmountOfUserDescriptions(amount);
    }

    // TODO Why is it hardcoded? -- fixed
    @And("^(.+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayedOnUsersTableOnUserTablePage(int amount) {
        new UserTablePage().checkAmountOfCheckboxes(amount);
    }

    @And("^User table contains following values:$")
    public void userTableContainsFollowingValues(DataTable usersTable) {
        new UserTablePage().checkUsersTable(usersTable);
    }

    // TODO Why is it hardcoded? -- fixed
    @Then("^(.+) log row has '([^\"]*)''([^\"]*)' text in log section$")
    public void logRowHasTextInLogSection(int amount, String logMessage, String status)  {
        new UserTablePage().checkLogs(getLogMessage(logMessage), status, amount);
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(DataTable userRolesList) {
        new UserTablePage().checkUserRolesInDropdown(userRolesList.asList(String.class));
    }
}
