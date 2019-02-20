package homeworks.homework6.steps;

import com.fasterxml.jackson.databind.node.BooleanNode;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.homework5.DifferentElementsPage;
import homeworks.homework5.IndexPage;
import homeworks.homework5.enums.UserTablePage;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static homeworks.homework3.enums.BenefitTexts.getBenefitTextsList;
import static homeworks.homework3.enums.HeaderItems.getHeaderItemsList;
import static homeworks.homework3.enums.MainHeader.MAIN_TEXT;
import static homeworks.homework3.enums.MainHeader.TITLE;
import static homeworks.homework5.enums.Checkboxes.*;
import static homeworks.homework5.enums.Colors.getDropdownItem;
import static homeworks.homework5.enums.IndexPageData.INDEX_PAGE_DATA;
import static homeworks.homework5.enums.LogsMessages.*;
import static homeworks.homework5.enums.RadioButtons.getRadiobutton;
import static homeworks.homework5.enums.UserRoles.getUserRoles;
import static homeworks.homework5.enums.Users.PITER_CHAILOVSKII;

public class AssertionSteps {

    @Then("^Browser title is \"Home Page\"$")
    public void browserTitleIs() {
        new IndexPage().checkTitle(INDEX_PAGE_DATA);
    }

    @Then("^User name is \"PITER CHAILOVSKII\"$")
    public void userNameIsPITERCHAILOVSKII() {
        new IndexPage().checkUsername(PITER_CHAILOVSKII);
    }

    @And("^Page contains all needed elements$")
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
    public void serviceDropDownListInLeftMenuContainsOptions(DataTable leftmenuItems) {
        new IndexPage().checkServiceDropdownListInLeftMenu(leftmenuItems.asList(String.class));
    }

    @Then("^Page contains left section$")
    public void pageContainsLeftSection() {
        new homeworks.homework5.DifferentElementsPage().checkServiceDropdownListInLeftMenu(getHeaderItemsList());
    }

    @And("^Page contains right section$")
    public void pageContainsRightSection() {
        new DifferentElementsPage().checkRightSection();
    }

    @Then("^Corresponding log appears according to selected checkbox: '([^\"]*)''([^\"]*)''([^\"]*)'$")
    public void correspondingLogAppearsAccordingToSelectedCheckboxes(String checkbox, String logMessage, String status) {
        new DifferentElementsPage().checkCheckboxesLogs(getCheckbox(checkbox), status, getLogMessage(logMessage));
    }

    @Then("^Corresponding log appears according to selected radiobutton: '([^\"]*)''([^\"]*)'$")
    public void correspondingLogAppearsAccordingToSelectedRadiobutton(String logMessage, String radiobutton) {
        new DifferentElementsPage().checkRadiosLogs(getRadiobutton(radiobutton), getLogMessage(logMessage));
    }

    @Then("^Corresponding log appears according to selected option in drop-down list: '([^\"]*)''([^\"]*)'$")
    public void correspondingLogAppearsAccordingToSelectedOptionInDropDownList(String logMessage, String color) {
        new DifferentElementsPage().checkDropdownLogs(getDropdownItem(color), getLogMessage(logMessage));
    }

    @Then("^'([^\"]*)\' page is opened$")
    public void pageIsOpened(String title) {
        new IndexPage().checkTitleOfAnyPage(title);
    }

    @And("^6 NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numbertypeDropdownsAreDisplayedOnUsersTableOnUserTablePage() {
        new UserTablePage().checkAmountOfDropdowns();
    }

    @And("^6 User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayedOnUsersTableOnUserTablePage() {
        new UserTablePage().checkAmountOfUsernames();
    }

    @And("^6 Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayedOnUsersTableOnUserTablePage() {
        new UserTablePage().checkAmountOfUserImages();
    }

    @And("^6 Description texts under images are displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayedOnUsersTableOnUserTablePage() {
        new UserTablePage().checkAmountOfUserDescriptions();
    }

    @And("^6 checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayedOnUsersTableOnUserTablePage() {
        new UserTablePage().checkAmountOfCheckboxes();
    }

    @And("^User table contains following values:$")
    public void userTableContainsFollowingValues(DataTable usersTable) {
        new UserTablePage().checkUsersTable(usersTable);
    }

    @Then("^1 log row has '([^\"]*)''([^\"]*)' text in log section$")
    public void logRowHasTextInLogSection(String logMessage, String status)  {
        new UserTablePage().checkLogs(getLogMessage(logMessage), status);
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(DataTable userRolesList) {
        new UserTablePage().checkUserRolesInDropdown(userRolesList.asList(String.class));
    }
}
