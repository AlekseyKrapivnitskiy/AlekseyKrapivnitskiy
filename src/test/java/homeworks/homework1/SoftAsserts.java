package homeworks.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SoftAsserts {

    private WebDriver driver;
    private SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void indexPageTest() {
        //1.Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2.Assert Browser title
        String homePageTitle = "Home Page";
        softAssert.assertEquals(driver.getTitle(), homePageTitle);

        //3.Perform login
        driver.findElement(By.cssSelector("#user-icon")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
        driver.findElement(By.cssSelector("#login-button")).click();

        //4.Assert User name in the left-top side of screen that user is logged in
        String username = "PITER CHAILOVSKII";
        softAssert.assertEquals(driver.findElement(By.cssSelector("#user-name")).getText(), username);

        //5.Assert Browser title
        softAssert.assertEquals(driver.getTitle(), homePageTitle);

        //6.Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> headerItems = new ArrayList<String>();
        headerItems.add("HOME");
        headerItems.add("CONTACT FORM");
        headerItems.add("SERVICE");
        headerItems.add("METALS & COLORS");

        List<WebElement> navigationBar = driver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));

        for (int i = 0; i < navigationBar.size(); i ++) {
            softAssert.assertEquals(navigationBar.get(i).getText(), headerItems.get(i));
        }

        //7.Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = driver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));

        for (WebElement benefitIcon : benefitIcons) {
            softAssert.assertTrue(benefitIcon.isDisplayed());
        }

        //8.Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> benefitTexts = new ArrayList<String>();
        benefitTexts.add("To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        benefitTexts.add("To be flexible and\n" + "customizable");
        benefitTexts.add("To be multiplatform");
        benefitTexts.add("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" +
                "wish to get more…");

        List<WebElement> benefitTxt = driver.findElements(By.cssSelector(".benefit-txt"));

        for (int i = 0; i < benefitTxt.size(); i ++) {
            softAssert.assertEquals(benefitTxt.get(i).getText(), benefitTexts.get(i));
        }

        //9.Assert a text of the main headers
        softAssert.assertEquals(driver.findElement(By.cssSelector(".main-title.text-center")).getText(), "EPAM FRAMEWORK WISHES…");
        softAssert.assertEquals(driver.findElement(By.cssSelector(".main-txt.text-center")).getText(), "LOREM IPSUM DOLOR SIT AMET, " +
                "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA " +
                "COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE " +
                "EU FUGIAT NULLA PARIATUR.");

        //10.Assert that there is the iframe in the center of page
        softAssert.assertTrue(driver.findElement(By.cssSelector("#iframe")).isDisplayed());

        //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("#iframe")));
        softAssert.assertTrue(driver.findElement(By.cssSelector("#epam_logo")).isDisplayed());

        //12.Switch to original window back
        driver.switchTo().defaultContent();

        //13.Assert a text of the sub header
        softAssert.assertEquals(driver.findElement(By.cssSelector(".text-center > a")).getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertEquals(driver.findElement(By.cssSelector(".text-center > a")).getAttribute("href"), "https://github.com/epam/JDI");

        // 15.Assert that there is Left Section
        softAssert.assertTrue(driver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16.Assert that there is Footer
        softAssert.assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());

        //17.Close Browser
        driver.close();
    }
}

