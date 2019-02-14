package homeworks.homework4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework4.enums.IndexPageData;
import homeworks.homework4.enums.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class IndexPage extends Navigation {

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

    public void open(IndexPageData indexPageData) {
        Selenide.open(indexPageData.url);
    }

    public void checkTitle(IndexPageData indexPageData) {
        // TODO Why you use this method? What was the concern with the getTitle()? -- fixed
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
