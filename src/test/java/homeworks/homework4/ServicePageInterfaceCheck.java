package homeworks.homework4;

import base.lessons.lesson4.SelenideBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static homeworks.homework4.enums.IndexPageData.INDEX_PAGE_DATA;
import static homeworks.homework4.enums.Users.PITER_CHAILOVSKII;

public class ServicePageInterfaceCheck extends SelenideBase {

    private IndexPage indexPage;

    @BeforeMethod
    public void beforeMethod() {
        indexPage = new IndexPage();

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

        //5.Click on "Service" subcategory in the header and check that drop down contains options

        //6.Click on Service subcategory in the left section and check that drop down contains options

        //7.Open through the header menu Service -> Different Elements Page

        //8.Check interface on Different elements page, it contains all needed elements

        //9.Assert that there is Right Section

        //10.Assert that there is Left Section

        //11.Select checkboxes

        //12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox

        //13.Select radio

        //14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton

        //15.Select in dropdown

        //16.Assert that for dropdown there is a log row and value is corresponded to the selected value

        //17.Unselect and assert checkboxes

        //18.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    }
}
