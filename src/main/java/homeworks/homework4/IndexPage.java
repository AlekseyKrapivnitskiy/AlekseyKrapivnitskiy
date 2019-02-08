package homeworks.homework4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class IndexPage {

    public void open(String url) {
        Selenide.open(url);
    }

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

    public void checkTitle(String title) {
        $("title").shouldHave(attribute("text", title));
    }

    public void checkUsername(String username) {
        $("#user-name").shouldHave(text(username));
    }

  /*  public void checkServiceDropDownList() {
        List<String> serviceDropDown = $(".dropdown-menu > li");

        for (int i = 0; i < serviceDropDown.size(); i ++) {
                  assertEquals(serviceDropDown.get(i).getText(), headerItems.get(i));
        }
    }*/
}
