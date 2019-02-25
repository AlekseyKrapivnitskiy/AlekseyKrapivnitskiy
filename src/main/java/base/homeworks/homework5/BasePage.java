package base.homeworks.homework5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework5.enums.HeaderItems;
import homeworks.homework5.enums.LeftMenuItems;
import homeworks.homework5.enums.Service;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public abstract class BasePage {

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    private ElementsCollection headerItems;

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

    @FindBy(css = ".sidebar-menu > li")
    private ElementsCollection leftMenu;

    public BasePage() {
        page(this);
    }

    @Step("Click on \"Service\" subcategory in the header and check that drop down contains options")
    public void clickOnServiceDropdownInHeader() {
        serviceDropdownInHeader.click();
    }

    public void clickOnItemInHeader(HeaderItems navigationItems) {
        headerItems.get(navigationItems.index).click();
    }

    public void clickOnItemInLeftMenu(LeftMenuItems leftMenuItems) {
        leftMenu.get(leftMenuItems.index).click();
    }

    public void checkServiceDropdownListInHeader(List<String> serviceDropdownItems) {
        for (int i = 0; i < serviceDropdownItemsLabelsInHeader.size(); i++) {
            serviceDropdownItemsLabelsInHeader.get(i).shouldHave(text(serviceDropdownItems.get(i)));
        }
    }

    public void clickOnServiceDropdownInLeftMenu() {
        serviceDropdownInLeftMenu.click();
    }

    @Step("Click on \"Service\" subcategory in the left section and check that drop down contains options")
    public void checkServiceDropdownListInLeftMenu(List<String> serviceDropdownItems) {
        for (int i = 0; i < serviceDropdownItemsInLeftMenu.size(); i++) {
            serviceDropdownItemsInLeftMenu.get(i).shouldHave(text(serviceDropdownItems.get(i)));
        }
    }

    @Step("Open through the header menu Service -> {service}")
    public void selectPageInServiceDropdown(Service service) {
        serviceDropdownInHeader.click();
        serviceDropdownItemsInHeader.get(service.index).click();
    }

    @Step("Assert that there is Right Section")
    public void checkRightSection() {
        rightSection.isDisplayed();
    }
}
