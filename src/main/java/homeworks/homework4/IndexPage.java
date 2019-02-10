package homeworks.homework4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework4.enums.IndexPageData;
import homeworks.homework4.enums.Users;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class IndexPage {

    @FindBy(css = "#user-icon")
    private SelenideElement userIcon;

    @FindBy(css = "#name")
    private SelenideElement userField;

    @FindBy(css = "#password")
    private SelenideElement passwordField;

    @FindBy(css = "#login-button")
    private SelenideElement submitButton;

    public void open(IndexPageData indexPageData) {
        Selenide.open(indexPageData.url);
    }

    public void checkTitle(IndexPageData indexPageData) {
        $("title").shouldHave(attribute("text", indexPageData.title));
    }

    public void login(Users users) {
        userIcon.click();
        userField.sendKeys(users.login);
        passwordField.sendKeys(users.password);
        submitButton.click();
    }

    public void checkUsername(Users users) {
        $("#user-name").shouldHave(text(users.username));
    }

    public void checkServiceDropdownListInHeader(List<String> serviceDropdown) {
        $(".dropdown").click();

        List<SelenideElement> serviceElements = $$("dropdown-menu > li");

        for (int i = 0; i < serviceElements.size(); i++) {
            serviceElements.get(i).shouldHave(text(serviceDropdown.get(i)));
        }
    }

    public void checkServiceDropdownListInLeftMenu(List<String> serviceDropdown) {
        $(".sidebar-menu").click();

        List<SelenideElement> serviceElements = $$("sidebar-menu.menu-title");

        for (int i = 0; i < serviceElements.size(); i++) {
            serviceElements.get(i).shouldHave(text(serviceDropdown.get(i)));
        }
    }

    public void openDifferentElementsPage() {
        $(".dropdown").click();
        $(".dropdown-menu > li:nth-child(7)").click();
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

    public void checkCheckboxesLabelsAndUncheckedStatuses(List<String> checkboxesLabelsTexts) {
        List<SelenideElement> checkboxesLabels = $$("sidebar-menu.menu-title");

        for (int i = 0; i < checkboxesLabels.size(); i++) {
            checkboxesLabels.get(i).shouldHave(text(checkboxesLabelsTexts.get(i)));
        }

        $(".label-checkbox:nth-child(1) > input[type=checkbox]").shouldNotBe(checked);
        $(".label-checkbox:nth-child(3) > input[type=checkbox]").shouldNotBe(checked);
    }
}
