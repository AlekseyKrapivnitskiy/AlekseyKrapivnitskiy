package homeworks.homework4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework4.enums.IndexPageData;
import homeworks.homework4.enums.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

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

  /*  public void checkServiceDropDownList() {
        List<String> serviceDropDown = $(".dropdown-menu > li");

        for (int i = 0; i < serviceDropDown.size(); i ++) {
                  assertEquals(serviceDropDown.get(i).getText(), headerItems.get(i));
        }
    }*/
}
