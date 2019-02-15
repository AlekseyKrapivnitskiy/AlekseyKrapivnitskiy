package homeworks.homework5;

import base.lessons.lesson4.SelenideBase;
import homeworks.homework4.DifferentElementsPage;
import homeworks.homework4.IndexPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static homeworks.homework4.enums.Checkboxes.*;
import static homeworks.homework4.enums.Colors.YELLOW;
import static homeworks.homework4.enums.IndexPageData.INDEX_PAGE_DATA;
import static homeworks.homework4.enums.LogsMessages.*;
import static homeworks.homework4.enums.RadioButtons.SELEN;
import static homeworks.homework4.enums.Service.DIFFERENT_ELEMENTS;
import static homeworks.homework4.enums.Service.getServiceDropdownList;
import static homeworks.homework4.enums.Users.PITER_CHAILOVSKII;

public class ServicePageInterfaceCheck extends SelenideBase {

    private IndexPage indexPage;
    private DifferentElementsPage differentElementsPage;

    @BeforeMethod
    public void beforeMethod() {
        open(INDEX_PAGE_DATA.url);
        indexPage = page(IndexPage.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
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
        indexPage.clickOnServiceDropdownInHeader();
        indexPage.checkServiceDropdownListInHeader(getServiceDropdownList());

        //6.Click on Service subcategory in the left section and check that drop down contains options
        indexPage.clickOnServiceDropdownInLeftMenu();
        indexPage.checkServiceDropdownListInLeftMenu(getServiceDropdownList());

        //7.Open through the header menu Service -> Different Elements Page
        indexPage.selectPageInServiceDropdown(DIFFERENT_ELEMENTS);

        //8.Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkDifferentPageElements();

        //9.Assert that there is Right Section
        differentElementsPage.checkRightSection();

        //10.Assert that there is Left Section
        indexPage.checkServiceDropdownListInLeftMenu(getServiceDropdownList());

        //11.Select checkboxes
        differentElementsPage.clickOnCheckbox(WATER);
        differentElementsPage.clickOnCheckbox(WIND);

        //12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        differentElementsPage.checkCheckboxesLogs(WATER, true, CHECKBOX_LOG);
        differentElementsPage.checkCheckboxesLogs(WIND, true, CHECKBOX_LOG);

        //13.Select radio
        differentElementsPage.clickOnRadioButton(SELEN);

        //14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton
        differentElementsPage.checkRadiosLogs(SELEN, RADIOBUTTON_LOG);

        //15.Select in dropdown
        differentElementsPage.selectOptionInDropdown(YELLOW);

        //16.Assert that for dropdown there is a log row and value is corresponded to the selected value
        differentElementsPage.checkDropdownLogs(YELLOW, DROPDOWN_LOG);

        //17.Unselect and assert checkboxes
        differentElementsPage.clickOnCheckbox(WATER);
        differentElementsPage.clickOnCheckbox(WIND);

        //18.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        differentElementsPage.checkCheckboxesLogs(FIRE, false, CHECKBOX_LOG);
        differentElementsPage.checkCheckboxesLogs(WIND, false, CHECKBOX_LOG);
    }
}
