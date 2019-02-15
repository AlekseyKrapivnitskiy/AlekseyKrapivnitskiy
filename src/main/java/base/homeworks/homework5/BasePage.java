package base.homeworks.homework5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework4.enums.Service;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;

public abstract class BasePage {

    @FindBy(css = ".dropdown")
    private SelenideElement serviceDropdownInHeader;

    @FindBy(css = ".dropdown-menu > li")
    private ElementsCollection serviceDropdownItemsInHeader;

    @FindBy(css = "dropdown-menu > li")
    private ElementsCollection serviceDropdownItemsLabelsInHeader;

    @FindBy(css = ".menu-title")
    private SelenideElement serviceDropdownInLeftMenu;

    @FindBy(css = "sub > li")
    private ElementsCollection serviceDropdownItemsInLeftMenu;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSection;

    @Step("5.Click on \"Service\" subcategory in the header and check that drop down contains options")
    public void clickOnServiceDropdownInHeader() {
        serviceDropdownInHeader.click();
    }

    public void checkServiceDropdownListInHeader(List<String> serviceDropdownItems) {
        for (int i = 0; i < serviceDropdownItemsLabelsInHeader.size(); i++) {
            serviceDropdownItemsLabelsInHeader.get(i).shouldHave(text(serviceDropdownItems.get(i)));
        }
    }

    public void clickOnServiceDropdownInLeftMenu() {
        serviceDropdownInLeftMenu.click();
    }

    @Step("6.Click on \"Service\" subcategory in the left section and check that drop down contains options")
    public void checkServiceDropdownListInLeftMenu(List<String> serviceDropdownItems) {
        for (int i = 0; i < serviceDropdownItemsInLeftMenu.size(); i++) {
            serviceDropdownItemsInLeftMenu.get(i).shouldHave(text(serviceDropdownItems.get(i)));
        }
    }

    @Step("7.Open through the header menu Service -> Different Elements Page")
    public void selectPageInServiceDropdown(Service service) {
        serviceDropdownInHeader.click();
        serviceDropdownItemsInHeader.get(service.index).click();
    }

    @Step("9.Assert that there is Right Section")
    public void checkRightSection() {
        rightSection.isDisplayed();
    }
}
