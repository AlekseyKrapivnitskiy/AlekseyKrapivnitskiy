package homeworks.homework4;

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

    public void openDifferentElementsPage() {
        serviceDropdownInHeader.click();
        differentElementsPageItem.click();
    }

    public void checkDifferentPageElements() {
        $$(".label-checkbox").shouldHaveSize(4);
        $$(".label-radio").shouldHaveSize(4);
        $$("select.uui-form-element").shouldHaveSize(1);
        $$("p").shouldHaveSize(2);
    }

    public void checkRightSection() {
        $(".uui-side-bar.right-fix-panel.mCustomScrollbar._mCS_2 mCS_no_scrollbar").isDisplayed();
    }

    public void checkLeftSection() {
        $(".mCustomScrollBox.mCS-light.mCSB_vertical.mCSB_inside").isDisplayed();
    }

    public void clickOnWaterAndWindCheckboxes() {
        $(".label-checkbox:nth-child(1)").click();
        $(".label-checkbox:nth-child(3)").click();
    }

    public void checkCheckboxesLabelsAndCheckedStatuses(List<String> checkboxesLabelsTexts) {
        List<SelenideElement> checkboxesLabels = $$("sidebar-menu.menu-title");

        for (int i = 0; i < checkboxesLabels.size(); i++) {
            checkboxesLabels.get(i).shouldHave(text(checkboxesLabelsTexts.get(i)));
        }

        $(".label-checkbox:nth-child(1) > input[type=checkbox]").shouldBe(checked);
        $(".label-checkbox:nth-child(3) > input[type=checkbox]").shouldBe(checked);
    }

    public void selectSelenRadio() {
        $(".label-radio:nth-child(4)").click();
    }

    public void checkRadiosLabelsAndStatus(List<String> radiosLabelsTexts) {
        List<SelenideElement> radiosLabels = $$("checkbox-row.label-checkbox");

        for (int i = 0; i < radiosLabels.size(); i++) {
            radiosLabels.get(i).shouldHave(text(radiosLabelsTexts.get(i)));
        }

        $(".label-radio:nth-child(4) > input[type=radio]").shouldBe(checked);
    }

    public void selectYellowInDropdown() {
        $("select.uui-form-element").click();
        $("select.uui-form-element").selectOption("Yellow");
    }

    public void checkDropdownOptionsAndStatus(List<String> colorsList) {
        $("select.uui-form-element").click();
        List<SelenideElement> colorsListInDropdown = $$("colors.uui-form-element");

        for (int i = 0; i < colorsListInDropdown.size(); i++) {
            colorsListInDropdown.get(i).shouldHave(text(colorsList.get(i)));
        }

        $("select.uui-form-element > option:nth-child(4)").isSelected();
    }

    public void checkCheckboxesLabelsAndUncheckedStatuses(List<String> checkboxesLabelsTexts) {
        List<SelenideElement> checkboxesLabels = $$("sidebar-menu.menu-title");

        for (int i = 1; i < checkboxesLabels.size(); i++) {
            checkboxesLabels.get(i).shouldHave(text(checkboxesLabelsTexts.get(i)));
        }

        $(".label-checkbox:nth-child(1) > input[type=checkbox]").shouldNotBe(checked);
        $(".label-checkbox:nth-child(3) > input[type=checkbox]").shouldNotBe(checked);
    }
}
