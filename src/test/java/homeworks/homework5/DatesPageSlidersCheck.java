package homeworks.homework5;

import base.lessons.lesson4.SelenideBase;
import homeworks.homework4.DatesPage;
import homeworks.homework4.IndexPage;
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
        open(INDEX_PAGE_DATA.url);
        indexPage = page(IndexPage.class);
        datesPage = page(DatesPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test(description = "Dates Page Sliders Check")
    public void datesPageSlidersTest() {
        //2.Assert Browser title
        indexPage.checkTitle(INDEX_PAGE_DATA);

        //3.Perform login
        indexPage.login(PITER_CHAILOVSKII);

        //4.Assert User name in the left-top side of screen that user is logged in
        indexPage.checkUsername(PITER_CHAILOVSKII);

        //5.Open through the header menu Service -> Dates Page
        datesPage.selectPageInServiceDropdown(DATES);

        //6.Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position
        datesPage.moveSlider(LEFT, 0);
        datesPage.moveSlider(RIGHT, 100);

        //7.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkSliderLogs("from", 0);
        datesPage.checkSliderLogs("to", 100);

        //8.Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position
        datesPage.moveSlider(LEFT, 0);
        datesPage.moveSlider(RIGHT, 0);

        //9.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkSliderLogs("from", 0);
        datesPage.checkSliderLogs("to", 0);

        //10.Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most right position
        datesPage.moveSlider(LEFT, 100);
        datesPage.moveSlider(RIGHT, 100);

        //11.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkSliderLogs("to", 100);
        datesPage.checkSliderLogs("to", 100);

        //12.Using drag-and-drop set Range sliders.
        datesPage.moveSlider(LEFT, 30);
        datesPage.moveSlider(RIGHT, 70);

        //13.Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkSliderLogs("to", 70);
        datesPage.checkSliderLogs("to", 100);
    }
}
