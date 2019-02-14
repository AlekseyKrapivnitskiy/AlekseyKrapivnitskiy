package homeworks.homework4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework4.enums.Checkboxes;
import homeworks.homework4.enums.Colors;
import homeworks.homework4.enums.LogsMessages;
import homeworks.homework4.enums.RadioButtons;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class DifferentElementsPage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxesList;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtonsList;

    @FindBy(css = "select.uui-form-element")
    private ElementsCollection dropdownList;

    @FindBy(css = "p")
    private ElementsCollection buttonsList;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSection;

    @FindBy(css = "#mCSB_1")
    private SelenideElement leftSection;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement colorsDropdown;

    @FindBy(css = ".logs")
    private SelenideElement logsPanel;

    public void checkDifferentPageElements() {
        checkboxesList.shouldHaveSize(4);
        radioButtonsList.shouldHaveSize(4);
        dropdownList.shouldHaveSize(1);
        buttonsList.shouldHaveSize(2);
    }

    public void checkRightSection() {
        rightSection.isDisplayed();
    }

    public void checkLeftSection() {
        leftSection.isDisplayed();
    }

    public void clickOnCheckbox(Checkboxes checkboxes) {
        // TODO Hardcoded values -- fixed
        checkboxesList.get(checkboxes.index).click();
    }

    public void clickOnRadioButton(RadioButtons radioButtons) {
        radioButtonsList.get(radioButtons.index).click();
    }

    public void selectOptionInDropdown(Colors colors) {
        colorsDropdown.click();
        // TODO Hardcoded values -- fixed
        colorsDropdown.selectOption(colors.index);
    }

    public void checkCheckboxesLogs(Checkboxes checkbox, Boolean status, LogsMessages logsMessages) {
        logsPanel.shouldHave(text(checkbox.label + logsMessages.text + status));
    }

    public void checkRadiosLogs(RadioButtons radioButton, LogsMessages logsMessages) {
        // TODO Hardcoded values -- fixed
        logsPanel.shouldHave(text(logsMessages.text + radioButton));
    }

    public void checkDropdownLogs(Colors colors, LogsMessages logsMessages) {
        // TODO Hardcoded values -- fixed
        logsPanel.shouldHave(text(logsMessages.text + colors.label));
    }
}
