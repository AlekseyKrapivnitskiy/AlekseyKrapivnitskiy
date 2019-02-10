package homeworks.homework4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework4.enums.IndexPageData;
import homeworks.homework4.enums.Users;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class IndexPage {

    @FindBy(css = "#user-icon")
    private SelenideElement userIcon;

    @FindBy(css = "#name")
    private SelenideElement userField;

    @FindBy(css = "#password")
    private SelenideElement passwordField;

    @FindBy(css = "#login-button")
    private SelenideElement submitButton;

    @FindBy(css = "title")
    private SelenideElement pageTitle;

    @FindBy(css = "#user-name")
    private SelenideElement usernameLabel;

    @FindBy(css = ".dropdown")
    private SelenideElement serviceDropdownInHeader;

    @FindBy(css = "dropdown-menu > li")
    private List<SelenideElement> serviceDropdownItemsInHeader;

    @FindBy(css = ".menu-title")
    private SelenideElement serviceDropdownInLeftMenu;

    @FindBy(css = "sub > li")
    private List<SelenideElement> serviceDropdownItemsInLeftMenu;

    @FindBy(css = ".dropdown-menu > li:nth-child(7)")
    private SelenideElement differentElementsPageItem;

    @FindBy(css = ".dropdown-menu > li:nth-child(2)")
    private SelenideElement datesPageItem;

    public void open(IndexPageData indexPageData) {
        Selenide.open(indexPageData.url);
    }

    public void checkTitle(IndexPageData indexPageData) {
        pageTitle.shouldHave(attribute("text", indexPageData.title));
    }

    public void login(Users users) {
        userIcon.click();
        userField.sendKeys(users.login);
        passwordField.sendKeys(users.password);
        submitButton.click();
    }

    public void checkUsername(Users users) {
        usernameLabel.shouldHave(text(users.username));
    }

    public void checkServiceDropdownListInHeader(List<String> serviceDropdownItems) {
        serviceDropdownInHeader.click();

        for (int i = 0; i < serviceDropdownItemsInHeader.size(); i++) {
            serviceDropdownItemsInHeader.get(i).shouldHave(text(serviceDropdownItems.get(i)));
        }
    }

    public void checkServiceDropdownListInLeftMenu(List<String> serviceDropdownItems) {
        serviceDropdownInLeftMenu.click();

        for (int i = 0; i < serviceDropdownItemsInLeftMenu.size(); i++) {
            serviceDropdownItemsInLeftMenu.get(i).shouldHave(text(serviceDropdownItems.get(i)));
        }
    }

    public void openDifferentElementsPage() {
        serviceDropdownInHeader.click();
        differentElementsPageItem.click();
    }

    public void openDatesPage() {
        serviceDropdownInHeader.click();
        datesPageItem.click();
    }
}
