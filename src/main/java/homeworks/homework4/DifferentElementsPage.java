package homeworks.homework4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DifferentElementsPage {

    @FindBy(css = ".dropdown")
    private SelenideElement serviceDropdownInHeader;

    @FindBy(css = ".dropdown-menu > li:nth-child(7)")
    private SelenideElement differentElementsPageItem;

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxesList;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtonsList;

    @FindBy(css = "select.uui-form-element")
    private ElementsCollection dropdownList;

    @FindBy(css = "p")
    private ElementsCollection buttonesList;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSection;

    @FindBy(css = "#mCSB_1")
    private SelenideElement leftSection;

    @FindBy(css = ".label-checkbox:nth-child(1) > input[type=checkbox]")
    private SelenideElement waterCheckbox;

    @FindBy(css = ".label-checkbox:nth-child(3) > input[type=checkbox]")
    private SelenideElement windCheckbox;

    @FindBy(css = ".label-radio:nth-child(4)")
    private SelenideElement selenRadio;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement colorsDropdown;

    public void openDifferentElementsPage() {
        serviceDropdownInHeader.click();
        differentElementsPageItem.click();
    }

    public void checkDifferentPageElements() {
        checkboxesList.shouldHaveSize(4);
        radioButtonsList.shouldHaveSize(4);
        dropdownList.shouldHaveSize(1);
        buttonesList.shouldHaveSize(2);
    }

    public void checkRightSection() {
        rightSection.isDisplayed();
    }

    public void checkLeftSection() {
        leftSection.isDisplayed();
    }

    public void clickOnWaterAndWindCheckboxes() {
        waterCheckbox.click();
        windCheckbox.click();
    }

    public void checkCheckboxesLogs() {

    }

    public void selectSelenRadio() {
        selenRadio.click();
    }

    public void checkRadiosLogs() {
    }

    public void selectYellowInDropdown() {
        colorsDropdown.click();
        colorsDropdown.selectOption("Yellow");
    }

    public void checkDropdownLogs() {

    }

    public void checkCheckboxesLabelsAndUncheckedStatuses() {

    }
}
