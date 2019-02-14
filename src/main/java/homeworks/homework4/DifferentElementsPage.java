package homeworks.homework4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework4.enums.Checkboxes;
import homeworks.homework4.enums.Colors;
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
    private ElementsCollection logsPanel;

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

    public void clickOnCheckbox(int indexOfCheckbox) {
        // TODO Hardcoded values -- fixed
        checkboxesList.get(indexOfCheckbox).click();
    }

    public void checkCheckboxesLogs(Checkboxes checkbox, Boolean status) {
        logsPanel.shouldHave(text(checkbox.label + ": condition changed to " + status));
    }

    public void clickOnRadioButton(int indexOfRadioButton) {
        radioButtonsList.get(indexOfRadioButton).click();
    }

    public void checkRadiosLogs(RadioButtons radioButton) {
        // TODO Hardcoded values
        logsPanel.shouldHave(text("metal: value changed to " + radioButton));
    }

    public void selectOptionInDropdown(int indexOfOption) {
        colorsDropdown.click();
        // TODO Hardcoded values -- fixed
        colorsDropdown.selectOption(indexOfOption);
    }

    public void checkDropdownLogs(Colors colors) {
        // TODO Hardcoded values
        logsPanel.shouldHave(text("Colors: value changed to " + colors.label));
    }
}
