package base.lessons.lesson4;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideIndexPage {

    public void login(String name, String password) {
        SelenideElement userIcon = $("[id='user-icon']");
        userIcon.click();
        SelenideElement userField = $("[id='name']");
        userField.sendKeys(name);
        SelenideElement passwordField = $("[id='password']");
        passwordField.sendKeys(password);
        SelenideElement submitButton = $("[id='login-button']");
        submitButton.click();
    }

    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }
}
