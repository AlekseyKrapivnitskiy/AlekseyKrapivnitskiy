package homeworks.homework4;

import base.lessons.lesson4.SelenideBase;
import org.testng.annotations.Test;

import static homeworks.homework4.IndexPageData.INDEX_PAGE_DATA;
import static homeworks.homework4.Users.PITER_CHAILOVSKII;

public class ServicePageInterfaceCheck extends SelenideBase {

    @Test
    public void servicePageInterfaceTest() {
        IndexPage indexPage = new IndexPage();

        //1.Open test site by URL
        indexPage.open(INDEX_PAGE_DATA.url);

        //2.Assert Browser title
        indexPage.checkTitle(INDEX_PAGE_DATA.title);

        //3.Perform login
        indexPage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4.Assert User name in the left-top side of screen that user is logged in
    }
}
