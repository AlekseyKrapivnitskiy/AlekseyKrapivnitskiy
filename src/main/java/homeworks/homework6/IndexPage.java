package homeworks.homework6;

import base.homeworks.homework6.BasePage;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework6.enums.IndexPageData;
import homeworks.homework6.enums.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class IndexPage extends BasePage {

    @FindBy(css = "#user-icon")
    private SelenideElement userIcon;

    @FindBy(css = "#name")
    private SelenideElement userField;

    @FindBy(css = "#password")
    private SelenideElement passwordField;

    @FindBy(css = "#login-button")
    private SelenideElement submitButton;

    @FindBy(css = "#user-name")
    private SelenideElement usernameLabel;

    public void checkTitle(IndexPageData indexPageData) {
        assertEquals(getWebDriver().getTitle(), indexPageData.title);
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
}
