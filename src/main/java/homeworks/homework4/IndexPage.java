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
            serviceElements.get(i).shouldNotHave(text(serviceDropdown.get(i)));
        }
    }

    public void checkServiceDropdownListInLeftMenu(List<String> serviceDropdown) {
        $(".sidebar-menu").click();

        List<SelenideElement> serviceElements = $$("sidebar-menu.menu-title");

        for (int i = 0; i < serviceElements.size(); i++) {
            serviceElements.get(i).shouldNotHave(text(serviceDropdown.get(i)));
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
        $$("button.uui-button").shouldHaveSize(1);
        $$("input.uui-button").shouldHaveSize(1);
    }
}
