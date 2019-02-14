package homeworks.homework2.exercise2;

import base.lessons.lesson3.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Smoke extends SeleniumBase {

    // TODO Why you cteate ThreadLocal in this way? -- fixed
    // TODO how much instatnces will be set in it? -- fixed
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver driver() {
        return driver.get();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        driver.set(webDriver);
    }

    @Test(groups = "Smoke")
    public void indexPageTest1() {
        //1.Open test site by URL
        driver().navigate().to("https://epam.github.io/JDI/index.html");

        //2.Assert Browser title
        String homePageTitle = "Home Page";
        assertEquals(driver().getTitle(), homePageTitle);

        //3.Perform login
        driver().findElement(By.cssSelector("#user-icon")).click();
        driver().findElement(By.cssSelector("#name")).sendKeys("epam");
        driver().findElement(By.cssSelector("#password")).sendKeys("1234");
        driver().findElement(By.cssSelector("#login-button")).click();

        //4.Assert User name in the left-top side of screen that user is logged in
        String username = "PITER CHAILOVSKII";
        assertEquals(driver().findElement(By.cssSelector("#user-name")).getText(), username);

        //5.Assert Browser title
        assertEquals(driver().getTitle(), homePageTitle);

        //6.Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> headerItems = new ArrayList<String>();
        headerItems.add("HOME");
        headerItems.add("CONTACT FORM");
        headerItems.add("SERVICE");
        headerItems.add("METALS & COLORS");

        List<WebElement> navigationBar = driver().findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));

        for (int i = 0; i < navigationBar.size(); i ++) {
            assertEquals(navigationBar.get(i).getText(), headerItems.get(i));
        }

        //7.Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = driver().findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));

        for (WebElement benefitIcon : benefitIcons) {
            assertTrue(benefitIcon.isDisplayed());
        }

        //8.Assert that there are 4 texts on the Index Page under icons and they have proper label
        List<String> benefitTexts = new ArrayList<String>();
        benefitTexts.add("To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        benefitTexts.add("To be flexible and\n" + "customizable");
        benefitTexts.add("To be multiplatform");
        benefitTexts.add("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" +
                "wish to get more…");

        List<WebElement> benefitTxt = driver().findElements(By.cssSelector(".benefit-txt"));

        for (int i = 0; i < benefitTxt.size(); i ++) {
            assertEquals(benefitTxt.get(i).getText(), benefitTexts.get(i));
        }

        //9.Assert a label of the main headers
        assertEquals(driver().findElement(By.cssSelector(".main-title.label-center")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver().findElement(By.cssSelector(".main-txt.label-center")).getText(), "LOREM IPSUM DOLOR SIT AMET, " +
                "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA " +
                "COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE " +
                "EU FUGIAT NULLA PARIATUR.");

        //10.Assert that there is the iframe in the center of page
        assertTrue(driver().findElement(By.cssSelector("#iframe")).isDisplayed());

        //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver().switchTo().frame(driver().findElement(By.cssSelector("#iframe")));
        assertTrue(driver().findElement(By.cssSelector("#epam_logo")).isDisplayed());

        //12.Switch to original window back
        driver().switchTo().defaultContent();

        //13.Assert a label of the sub header
        assertEquals(driver().findElement(By.cssSelector(".label-center > a")).getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver().findElement(By.cssSelector(".label-center > a")).getAttribute("href"), "https://github.com/epam/JDI");

        // 15.Assert that there is Left Section
        assertTrue(driver().findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16.Assert that there is Footer
        assertTrue(driver().findElement(By.cssSelector("footer")).isDisplayed());

        // TODO Why it close here? Please check all methods and classes
        //17.Close Browser
        driver().close();
    }

    @Test(groups = "Smoke")
    public void indexPageTest2() {
        //1.Open test site by URL
        driver().navigate().to("https://epam.github.io/JDI/index.html");

        //2.Assert Browser title
        String homePageTitle = "Home Page";
        assertEquals(driver().getTitle(), homePageTitle);

        //3.Perform login
        driver().findElement(By.cssSelector("#user-icon")).click();
        driver().findElement(By.cssSelector("#name")).sendKeys("epam");
        driver().findElement(By.cssSelector("#password")).sendKeys("1234");
        driver().findElement(By.cssSelector("#login-button")).click();

        //4.Assert User name in the left-top side of screen that user is logged in
        String username = "PITER CHAILOVSKII";
        assertEquals(driver().findElement(By.cssSelector("#user-name")).getText(), username);

        //5.Assert Browser title
        assertEquals(driver().getTitle(), homePageTitle);

        //6.Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> headerItems = new ArrayList<String>();
        headerItems.add("HOME");
        headerItems.add("CONTACT FORM");
        headerItems.add("SERVICE");
        headerItems.add("METALS & COLORS");

        List<WebElement> navigationBar = driver().findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));

        for (int i = 0; i < navigationBar.size(); i ++) {
            assertEquals(navigationBar.get(i).getText(), headerItems.get(i));
        }

        //7.Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = driver().findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));

        for (WebElement benefitIcon : benefitIcons) {
            assertTrue(benefitIcon.isDisplayed());
        }

        //8.Assert that there are 4 texts on the Index Page under icons and they have proper label
        List<String> benefitTexts = new ArrayList<String>();
        benefitTexts.add("To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        benefitTexts.add("To be flexible and\n" + "customizable");
        benefitTexts.add("To be multiplatform");
        benefitTexts.add("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" +
                "wish to get more…");

        List<WebElement> benefitTxt = driver().findElements(By.cssSelector(".benefit-txt"));

        for (int i = 0; i < benefitTxt.size(); i ++) {
            assertEquals(benefitTxt.get(i).getText(), benefitTexts.get(i));
        }

        //9.Assert a label of the main headers
        assertEquals(driver().findElement(By.cssSelector(".main-title.label-center")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver().findElement(By.cssSelector(".main-txt.label-center")).getText(), "LOREM IPSUM DOLOR SIT AMET, " +
                "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA " +
                "COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE " +
                "EU FUGIAT NULLA PARIATUR.");

        //10.Assert that there is the iframe in the center of page
        assertTrue(driver().findElement(By.cssSelector("#iframe")).isDisplayed());

        //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver().switchTo().frame(driver().findElement(By.cssSelector("#iframe")));
        assertTrue(driver().findElement(By.cssSelector("#epam_logo")).isDisplayed());

        //12.Switch to original window back
        driver().switchTo().defaultContent();

        //13.Assert a label of the sub header
        assertEquals(driver().findElement(By.cssSelector(".label-center > a")).getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver().findElement(By.cssSelector(".label-center > a")).getAttribute("href"), "https://github.com/epam/JDI");

        // 15.Assert that there is Left Section
        assertTrue(driver().findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16.Assert that there is Footer
        assertTrue(driver().findElement(By.cssSelector("footer")).isDisplayed());

        //17.Close Browser
        driver().close();
    }

    @Test(groups = "Smoke")
    public void indexPageTest3() {
        //1.Open test site by URL
        driver().navigate().to("https://epam.github.io/JDI/index.html");

        //2.Assert Browser title
        String homePageTitle = "Home Page";
        assertEquals(driver().getTitle(), homePageTitle);

        //3.Perform login
        driver().findElement(By.cssSelector("#user-icon")).click();
        driver().findElement(By.cssSelector("#name")).sendKeys("epam");
        driver().findElement(By.cssSelector("#password")).sendKeys("1234");
        driver().findElement(By.cssSelector("#login-button")).click();

        //4.Assert User name in the left-top side of screen that user is logged in
        String username = "PITER CHAILOVSKII";
        assertEquals(driver().findElement(By.cssSelector("#user-name")).getText(), username);

        //5.Assert Browser title
        assertEquals(driver().getTitle(), homePageTitle);

        //6.Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> headerItems = new ArrayList<String>();
        headerItems.add("HOME");
        headerItems.add("CONTACT FORM");
        headerItems.add("SERVICE");
        headerItems.add("METALS & COLORS");

        List<WebElement> navigationBar = driver().findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));

        for (int i = 0; i < navigationBar.size(); i ++) {
            assertEquals(navigationBar.get(i).getText(), headerItems.get(i));
        }

        //7.Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = driver().findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));

        for (WebElement benefitIcon : benefitIcons) {
            assertTrue(benefitIcon.isDisplayed());
        }

        //8.Assert that there are 4 texts on the Index Page under icons and they have proper label
        List<String> benefitTexts = new ArrayList<String>();
        benefitTexts.add("To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        benefitTexts.add("To be flexible and\n" + "customizable");
        benefitTexts.add("To be multiplatform");
        benefitTexts.add("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" +
                "wish to get more…");

        List<WebElement> benefitTxt = driver().findElements(By.cssSelector(".benefit-txt"));

        for (int i = 0; i < benefitTxt.size(); i ++) {
            assertEquals(benefitTxt.get(i).getText(), benefitTexts.get(i));
        }

        //9.Assert a label of the main headers
        assertEquals(driver().findElement(By.cssSelector(".main-title.label-center")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver().findElement(By.cssSelector(".main-txt.label-center")).getText(), "LOREM IPSUM DOLOR SIT AMET, " +
                "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA " +
                "COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE " +
                "EU FUGIAT NULLA PARIATUR.");

        //10.Assert that there is the iframe in the center of page
        assertTrue(driver().findElement(By.cssSelector("#iframe")).isDisplayed());

        //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver().switchTo().frame(driver().findElement(By.cssSelector("#iframe")));
        assertTrue(driver().findElement(By.cssSelector("#epam_logo")).isDisplayed());

        //12.Switch to original window back
        driver().switchTo().defaultContent();

        //13.Assert a label of the sub header
        assertEquals(driver().findElement(By.cssSelector(".label-center > a")).getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver().findElement(By.cssSelector(".label-center > a")).getAttribute("href"), "https://github.com/epam/JDI");

        // 15.Assert that there is Left Section
        assertTrue(driver().findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16.Assert that there is Footer
        assertTrue(driver().findElement(By.cssSelector("footer")).isDisplayed());

        //17.Close Browser
        driver().close();
    }
}