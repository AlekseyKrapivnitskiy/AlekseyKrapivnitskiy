package homeworks.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {

    public WebDriver driver;

    // TODO Why you don't use PageFactory?
    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    // TODO Why parameter is String and String
    public void login(String name, String password) {
        WebElement userIcon = driver.findElement(By.cssSelector("#user-icon"));
        userIcon.click();
        WebElement userField = driver.findElement(By.cssSelector("#name"));
        userField.sendKeys(name);
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.cssSelector("#login-button"));
        submitButton.click();
    }

    // TODO Why parameter is String
    public void open(String url) {
        driver.navigate().to(url);
    }

    // TODO Why parameter is String
    public void checkTitle(String homePageTitle) {
        assertEquals(driver.getTitle(), homePageTitle);
    }
    // TODO Why parameter is String
    public void checkUsername(String username) {
        assertEquals(driver.findElement(By.cssSelector("#user-name")).getText(), username);
    }

    public void checkHeaderItems(List<String> headerItems) {
        List<WebElement> navigationBar = driver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));

        for (int i = 0; i < navigationBar.size(); i ++) {
            assertEquals(navigationBar.get(i).getText(), headerItems.get(i));
        }
    }

    public void checkBenefitIcons() {
        List<WebElement> benefitIcons = driver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));

        for (WebElement benefitIcon : benefitIcons) {
            assertTrue(benefitIcon.isDisplayed());
        }
    }

    public void checkBenefitTexts(List<String> benefitTexts) {
        List<WebElement> benefitTxt = driver.findElements(By.cssSelector(".benefit-txt"));

        for (int i = 0; i < benefitTxt.size(); i ++) {
            assertEquals(benefitTxt.get(i).getText(), benefitTexts.get(i));
        }
    }

    public void checkCenterText(String title, String mainText) {
        assertEquals(driver.findElement(By.cssSelector(".main-title.text-center")).getText(), title);
        assertEquals(driver.findElement(By.cssSelector(".main-txt.text-center")).getText(), mainText);
    }

    public void checkIFrame() {
        assertTrue(driver.findElement(By.cssSelector("#iframe")).isDisplayed());
    }

    public void switchToIFrame() {
        driver.switchTo().frame(driver.findElement(By.cssSelector("#iframe")));
    }

    public void checkLogoInIframe() {
        assertTrue(driver.findElement(By.cssSelector("#epam_logo")).isDisplayed());
    }

    public void checkSubHeader(String subHeader) {
        assertEquals(driver.findElement(By.cssSelector(".text-center > a")).getText(), subHeader);
    }

    public void checkSubHeaderLink(String link) {
        assertEquals(driver.findElement(By.cssSelector(".text-center > a")).getAttribute("href"), link);
    }

    public void checkLeftMenu() {
        assertTrue(driver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());
    }

    public void checkFooter() {
        assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());
    }
}
