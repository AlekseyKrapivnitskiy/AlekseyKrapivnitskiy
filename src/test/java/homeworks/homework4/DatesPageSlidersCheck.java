package homeworks.homework4;

import base.lessons.lesson4.SelenideBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static homeworks.homework4.enums.IndexPageData.INDEX_PAGE_DATA;
import static homeworks.homework4.enums.Users.PITER_CHAILOVSKII;

public class DatesPageSlidersCheck extends SelenideBase {

    private IndexPage indexPage;
    private DatesPage datesPage;

    @BeforeMethod
    public void beforeMethod() {
        indexPage = new IndexPage();
        datesPage = new DatesPage();

        //1.Open test site by URL
        indexPage.open(INDEX_PAGE_DATA);

        page(indexPage);
    }

    @Test
    public void servicePageInterfaceTest() {
        //2.Assert Browser title
        indexPage.checkTitle(INDEX_PAGE_DATA);

        //3.Perform login
        indexPage.login(PITER_CHAILOVSKII);

        //4.Assert User name in the left-top side of screen that user is logged in
        indexPage.checkUsername(PITER_CHAILOVSKII);

        //5.Open through the header menu Service -> Dates Page
        datesPage.openDatesPage();

        //6.Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.setRangeMaxLeftAndMaxRitght();

        //7.Assert that for "From" and "To" sliders there are logs rows with corresponding values

        //8.Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position
        datesPage.setRangeMaxLeftForBothSliders();

        //9.Assert that for "From" and "To" sliders there are logs rows with corresponding values

        //10.Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position

        //11.Assert that for "From" and "To" sliders there are logs rows with corresponding values

        //12.Using drag-and-drop set Range sliders.

        //13.Assert that for "From" and "To" sliders there are logs rows with corresponding values
    }
}
