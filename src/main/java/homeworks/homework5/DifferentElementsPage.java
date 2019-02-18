package homeworks.homework5;

import base.homeworks.homework5.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework5.enums.Checkboxes;
import homeworks.homework5.enums.Colors;
import homeworks.homework5.enums.LogsMessages;
import homeworks.homework5.enums.RadioButtons;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class DifferentElementsPage extends BasePage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxesList;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtonsList;

    @FindBy(css = "select.uui-form-element")
    private ElementsCollection dropdownList;

    @FindBy(css = "p")
    private ElementsCollection buttonsList;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement colorsDropdown;

    @FindBy(css = ".logs")
    private SelenideElement logsPanel;

    @Step("8.Check interface on Different elements page, it contains all needed elements")
    @Severity(SeverityLevel.BLOCKER)
    public void checkDifferentPageElements() {
        checkboxesList.shouldHaveSize(4);
        radioButtonsList.shouldHaveSize(4);
        dropdownList.shouldHaveSize(1);
        buttonsList.shouldHaveSize(2);
    }

    @Step("11.Select checkboxes: {checkboxes}")
    public void clickOnCheckbox(Checkboxes checkboxes) {
        // TODO Hardcoded values -- fixed
        checkboxesList.get(checkboxes.index).click();
    }

    @Step("13.Select radio: {radioButtons}")
    public void clickOnRadioButton(RadioButtons radioButtons) {
        radioButtonsList.get(radioButtons.index).click();
    }

    @Step("15.Select in dropdown: {colors}")
    public void selectOptionInDropdown(Colors colors) {
        colorsDropdown.click();
        // TODO Hardcoded values -- fixed
        colorsDropdown.selectOption(colors.index);
    }

    @Step("12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox")
    public void checkCheckboxesLogs(Checkboxes checkbox, Boolean status, LogsMessages logsMessages) {
        logsPanel.shouldHave(text(checkbox.label + logsMessages.text + status));
    }

    @Step("14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton")
    public void checkRadiosLogs(RadioButtons radioButton, LogsMessages logsMessages) {
        // TODO Hardcoded values -- fixed
        logsPanel.shouldHave(text(logsMessages.text + radioButton));
    }

    @Step("16.Assert that for dropdown there is a log row and value is corresponded to the selected value")
    public void checkDropdownLogs(Colors colors, LogsMessages logsMessages) {
        // TODO Hardcoded values -- fixed
        logsPanel.shouldHave(text(logsMessages.text + colors.label));
    }
}
