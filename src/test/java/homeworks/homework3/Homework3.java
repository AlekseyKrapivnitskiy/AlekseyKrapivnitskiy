package homeworks.homework3;

import base.lessons.lesson3.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static homeworks.homework3.BenefitTexts.BENEFIT_TEXTS;
import static homeworks.homework3.CenterTexts.CENTER_TEXTS;
import static homeworks.homework3.HeaderItems.HEADER_ITEMS;
import static homeworks.homework3.IndexPageData.INDEX_PAGE_DATA;
import static homeworks.homework3.JdiGithub.JDI_GITHUB;
import static homeworks.homework3.Users.PITER_CHAILOVSKII;

public class Homework3 extends SeleniumBase {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void indexPageTest() {
        IndexPage indexPage = new IndexPage(driver);

        //1.Open test site by URL
        indexPage.open(INDEX_PAGE_DATA.url);

        //2.Assert Browser title
        indexPage.checkTitle(INDEX_PAGE_DATA.title);

        //3.Perform login
        indexPage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4.Assert User name in the left-top side of screen that user is logged in
        indexPage.checkUsername(PITER_CHAILOVSKII.username);

        //5.Assert Browser title
        indexPage.open(INDEX_PAGE_DATA.url);

        //6.Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> headerItems = new ArrayList<String>();
        headerItems.add(HEADER_ITEMS.home);
        headerItems.add(HEADER_ITEMS.contactForm);
        headerItems.add(HEADER_ITEMS.service);
        headerItems.add(HEADER_ITEMS.metalsAndColors);

        indexPage.checkHeaderItems(headerItems);

        //7.Assert that there are 4 images on the Index Page and they are displayed
        indexPage.checkBenefitIcons();

        //8.Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> benefitTexts = new ArrayList<String>();
        benefitTexts.add(BENEFIT_TEXTS.practise);
        benefitTexts.add(BENEFIT_TEXTS.custom);
        benefitTexts.add(BENEFIT_TEXTS.multiplatform);
        benefitTexts.add(BENEFIT_TEXTS.base);

        indexPage.checkBenefitTexts(benefitTexts);

        //9.Assert a text of the main headers
        indexPage.checkCenterText(CENTER_TEXTS.title, CENTER_TEXTS.text);

        //10.Assert that there is the iframe in the center of page
        indexPage.checkIFrame();

        //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        indexPage.switchToIFrame();
        indexPage.checkLogoInIframe();

        //12.Switch to original window back
        driver.switchTo().defaultContent();

        //13.Assert a text of the sub header
        indexPage.checkSubHeader(JDI_GITHUB.title);

        //14.Assert that JDI GITHUB is a link and has a proper URL
        indexPage.checkSubHeaderLink(JDI_GITHUB.link);

        // 15.Assert that there is Left Section
        indexPage.checkLeftMenu();

        //16.Assert that there is Footer
        indexPage.checkFooter();
    }
}

