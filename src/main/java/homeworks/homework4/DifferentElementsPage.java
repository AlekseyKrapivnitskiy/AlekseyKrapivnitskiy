package homeworks.homework4;

import base.homeworks.homework4.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework4.enums.Checkboxes;
import homeworks.homework4.enums.Colors;
import homeworks.homework4.enums.LogsMessages;
import homeworks.homework4.enums.Radiobuttons;
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

    public void checkDifferentPageElements() {
        checkboxesList.shouldHaveSize(4);
        radioButtonsList.shouldHaveSize(4);
        dropdownList.shouldHaveSize(1);
        buttonsList.shouldHaveSize(2);
    }

    public void clickOnCheckbox(Checkboxes checkboxes) {
        // TODO Hardcoded values -- fixed
        checkboxesList.get(checkboxes.index).click();
    }

    public void clickOnRadioButton(Radiobuttons radioButtons) {
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

    public void checkRadiosLogs(Radiobuttons radioButton, LogsMessages logsMessages) {
        // TODO Hardcoded values -- fixed
        logsPanel.shouldHave(text(logsMessages.text + radioButton));
    }

    public void checkDropdownLogs(Colors colors, LogsMessages logsMessages) {
        // TODO Hardcoded values -- fixed
        logsPanel.shouldHave(text(logsMessages.text + colors.label));
    }
}
