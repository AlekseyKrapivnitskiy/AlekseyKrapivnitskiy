package homeworks.homework6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.homework5.DifferentElementsPage;
import homeworks.homework5.IndexPage;

import static homeworks.homework3.enums.BenefitTexts.getBenefitTextsList;
import static homeworks.homework3.enums.HeaderItems.getHeaderItemsList;
import static homeworks.homework3.enums.MainHeader.MAIN_TEXT;
import static homeworks.homework3.enums.MainHeader.TITLE;
import static homeworks.homework5.enums.Checkboxes.WATER;
import static homeworks.homework5.enums.Checkboxes.WIND;
import static homeworks.homework5.enums.Colors.YELLOW;
import static homeworks.homework5.enums.IndexPageData.INDEX_PAGE_DATA;
import static homeworks.homework5.enums.LogsMessages.CHECKBOX_LOG;
import static homeworks.homework5.enums.LogsMessages.RADIOBUTTON_LOG;
import static homeworks.homework5.enums.RadioButtons.SELEN;
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

    @Then("^Corresponding log appears according to selected checkboxes:$")
    public void correspondingLogAppearsAccordingToSelectedCheckboxes() {
        new DifferentElementsPage().checkCheckboxesLogs(WATER, true, CHECKBOX_LOG);
        new DifferentElementsPage().checkCheckboxesLogs(WIND, true, CHECKBOX_LOG);
    }

    @Then("^Corresponding log appears according to selected radiobutton$")
    public void correspondingLogAppearsAccordingToSelectedRadiobutton() {
        new DifferentElementsPage().checkRadiosLogs(SELEN, RADIOBUTTON_LOG);
    }

    @Then("^Corresponding log appears according to selected option in drop-down list$")
    public void correspondingLogAppearsAccordingToSelectedOptionInDropDownList() {
        new DifferentElementsPage().checkDropdownLogs(YELLOW, RADIOBUTTON_LOG);
    }
}
