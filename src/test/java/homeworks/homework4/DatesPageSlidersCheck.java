package homeworks.homework4;

import base.lessons.lesson4.SelenideBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static homeworks.homework4.enums.IndexPageData.INDEX_PAGE_DATA;
import static homeworks.homework4.enums.Service.DATES;
import static homeworks.homework4.enums.Sliders.LEFT;
import static homeworks.homework4.enums.Sliders.RIGHT;
import static homeworks.homework4.enums.Users.PITER_CHAILOVSKII;

public class DatesPageSlidersCheck extends SelenideBase {

    private IndexPage indexPage;
    private DatesPage datesPage;

    @BeforeMethod
    public void beforeMethod() {
        // TODO What is the purpose of current creation page instances? -- fixed
        open(INDEX_PAGE_DATA.url);
        indexPage = page(IndexPage.class);
        datesPage = page(DatesPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void datesPageSlidersTest() {
        //2.Assert Browser title
        indexPage.checkTitle(INDEX_PAGE_DATA);

        //3.Perform login
        indexPage.login(PITER_CHAILOVSKII);

        //4.Assert User name in the left-top side of screen that user is logged in
        indexPage.checkUsername(PITER_CHAILOVSKII);

        //5.Open through the header menu Service -> Dates Page
        // TODO Please parametrize current method -- fixed
        datesPage.selectPageInServiceDropdown(DATES);

        //6.Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position
        datesPage.moveSlider(LEFT, 0);
        datesPage.moveSlider(RIGHT, 100);

        //7.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs("from", 0);
        datesPage.checkLogs("to", 100);

        //8.Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position
        datesPage.moveSlider(LEFT, 0);
        datesPage.moveSlider(RIGHT, 0);

        //9.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs("from", 0);
        datesPage.checkLogs("to", 0);

        //10.Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most right position
        datesPage.moveSlider(LEFT, 100);
        datesPage.moveSlider(RIGHT, 100);

        //11.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs("to", 100);
        datesPage.checkLogs("to", 100);

        //12.Using drag-and-drop set Range sliders.
        datesPage.moveSlider(LEFT, 30);
        datesPage.moveSlider(RIGHT, 70);

        //13.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs("to", 70);
        datesPage.checkLogs("to", 100);
    }
}
