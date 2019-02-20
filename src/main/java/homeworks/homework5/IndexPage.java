package homeworks.homework5;

import base.homeworks.homework5.BasePage;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework3.enums.MainHeader;
import homeworks.homework5.enums.IndexPageData;
import homeworks.homework5.enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> navigationBar;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitTxt;

    @FindBy(css = ".main-title.text-center")
    private WebElement mainHeaderTitle;

    @FindBy(css = ".main-txt.text-center")
    private WebElement mainHeaderText;

    @Step("Assert Browser title")
    public void checkTitle(IndexPageData indexPageData) {
        assertEquals(getWebDriver().getTitle(), indexPageData.title);
    }

    @Step("Perform login")
    public void login(Users users) {
        userIcon.click();
        userField.sendKeys(users.login);
        passwordField.sendKeys(users.password);
        submitButton.click();
    }

    @Step("Assert User name in the left-top side of screen that user is logged in")
    public void checkUsername(Users users) {
        usernameLabel.shouldHave(text(users.username));
    }

    public void checkBenefitIcons() {
        for (WebElement benefitIcon : benefitIcons) {
            assertTrue(benefitIcon.isDisplayed());
        }
    }

    public void checkBenefitTexts(List<String> benefitTexts) {
        for (int i = 0; i < benefitTxt.size(); i ++) {
            assertEquals(benefitTxt.get(i).getText(), benefitTexts.get(i));
        }
    }

    public void checkMainHeaderTitle(MainHeader mainHeader) {
        assertEquals(mainHeaderTitle.getText(), mainHeader.text);
    }

    public void checkMainHeaderText(MainHeader mainHeader) {
        assertEquals(mainHeaderText.getText(), mainHeader.text);
    }
}
