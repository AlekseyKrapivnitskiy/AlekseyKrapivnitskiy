package homeworks.homework4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

public class IndexPage {

    public void login(String name, String password) {
        SelenideElement userIcon = $("#user-icon");
        userIcon.click();
        SelenideElement userField = $("#name");
        userField.sendKeys(name);
        SelenideElement passwordField = $("#password");
        passwordField.sendKeys(password);
        SelenideElement submitButton = $("#login-button");
        submitButton.click();
    }

    public void open(String url) {
        Selenide.open(url);
    }

    public void checkTitle(String title) {
        $("title").shouldHave(attribute("text", title));
    }
}
