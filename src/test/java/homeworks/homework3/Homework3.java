package homeworks.homework3;

import base.lessons.lesson3.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static homeworks.homework3.enums.BenefitTexts.*;
import static homeworks.homework3.enums.HeaderItems.*;
import static homeworks.homework3.enums.IndexPageData.*;
import static homeworks.homework3.enums.MainHeader.MAIN_TEXT;
import static homeworks.homework3.enums.MainHeader.TITLE;
import static homeworks.homework3.enums.Users.PITER_CHAILOVSKII;

public class Homework3 extends SeleniumBase {

    private WebDriver driver;
    private IndexPage indexPage;


    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // TODO What is the purpose of two lines below? -- fixed
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void indexPageTest() {
        //1.Open test site by URL
        indexPage.open(INDEX_PAGE_DATA);

        //2.Assert Browser title
        indexPage.checkTitle(INDEX_PAGE_DATA);

        //3.Perform login
        indexPage.login(PITER_CHAILOVSKII);

        //4.Assert User name in the left-top side of screen that user is logged in
        indexPage.checkUsername(PITER_CHAILOVSKII);

        //5.Assert Browser title
        indexPage.checkTitle(INDEX_PAGE_DATA);

        //6.Assert that there are 4 items on the header section are displayed and they have proper texts
        // TODO Is it possible get list of values from the enum? -- fixed
        indexPage.checkHeaderItems(getHeaderItemsList());

        //7.Assert that there are 4 images on the Index Page and they are displayed
        indexPage.checkBenefitIcons();

        //8.Assert that there are 4 texts on the Index Page under icons and they have proper text
        indexPage.checkBenefitTexts(getBenefitTextsList());

        //9.Assert a text of the main headers
        indexPage.checkMainHeaderTitle(TITLE);
        indexPage.checkMainHeaderText(MAIN_TEXT);

        //10.Assert that there is the iframe in the center of page
        indexPage.checkIFrame();

        //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        indexPage.switchToIFrame();
        indexPage.checkLogoInIframe();

        //12.Switch to original window back
        driver.switchTo().defaultContent();

        //13.Assert a text of the sub header
        indexPage.checkSubHeaderTitle(JDI_GITHUB);

        //14.Assert that JDI GITHUB is a link and has a proper URL
        indexPage.checkSubHeaderLink(JDI_GITHUB);

        // 15.Assert that there is Left Section
        indexPage.checkLeftMenu();

        //16.Assert that there is Footer
        indexPage.checkFooter();
    }
}

