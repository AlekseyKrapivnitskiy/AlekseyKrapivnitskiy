package homeworks.homework3;

import homeworks.homework3.enums.IndexPageData;
import homeworks.homework3.enums.MainHeader;
import homeworks.homework3.enums.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {

    @FindBy(css = "#user-icon")
    private WebElement userIcon;

    @FindBy(css = "#name")
    private WebElement userField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#login-button")
    private WebElement submitButton;

    @FindBy(css = "#user-name")
    private WebElement usernameLabel;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> navigationBar;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitTxt;

    @FindBy(css = "#iframe")
    private WebElement iFrame;

    @FindBy(css = ".main-title.text-center")
    private WebElement mainHeaderTitle;

    @FindBy(css = ".main-txt.text-center")
    private WebElement mainHeaderText;

    @FindBy(css = "#epam_logo")
    private WebElement epamLogo;

    @FindBy(css = ".text-center > a")
    private WebElement jdiGithubLink;

    @FindBy(css = "#mCSB_1")
    private WebElement leftMenu;

    @FindBy(css = "footer")
    private WebElement footer;

    // TODO Why it public? -- changed to private
    private WebDriver driver;

    // TODO Should be after all class variables -- fixed
    public IndexPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(IndexPageData indexPageData) {
        driver.navigate().to(indexPageData.url);
    }

    public void checkTitle(IndexPageData indexPageData) {
        assertEquals(driver.getTitle(), indexPageData.title);
    }

    public void login(Users users) {
        userIcon.click();
        userField.sendKeys(users.login);
        passwordField.sendKeys(users.password);
        submitButton.click();
    }

    public void checkUsername(Users users) {
        assertEquals(usernameLabel.getText(), users.username);
    }

    public void checkHeaderItems(List<String> headerItems) {
        for (int i = 0; i < navigationBar.size(); i ++) {
            assertEquals(navigationBar.get(i).getText(), headerItems.get(i));
        }
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

    public void checkIFrame() {
        assertTrue(iFrame.isDisplayed());
    }

    public void switchToIFrame() {
        driver.switchTo().frame(iFrame);
    }

    public void checkLogoInIframe() {
        assertTrue(epamLogo.isDisplayed());
    }

    public void checkSubHeaderTitle(IndexPageData indexPageData) {
        assertEquals(jdiGithubLink.getText(), indexPageData.title);
    }

    public void checkSubHeaderLink(IndexPageData indexPageData) {
        assertEquals(jdiGithubLink.getAttribute("href"), indexPageData.url);
    }

    public void checkLeftMenu() {
        assertTrue(leftMenu.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }
}
