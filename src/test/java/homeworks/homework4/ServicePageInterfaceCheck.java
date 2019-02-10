package homeworks.homework4;

import base.lessons.lesson4.SelenideBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static homeworks.homework4.enums.Colors.*;
import static homeworks.homework4.enums.IndexPageData.INDEX_PAGE_DATA;
import static homeworks.homework4.enums.Service.*;
import static homeworks.homework4.enums.Checkboxes.*;
import static homeworks.homework4.enums.Radios.*;
import static homeworks.homework4.enums.Users.PITER_CHAILOVSKII;

public class ServicePageInterfaceCheck extends SelenideBase {

    private IndexPage indexPage;
    private DifferentElementsPage differentElementsPage;

    @BeforeMethod
    public void beforeMethod() {
        indexPage = new IndexPage();
        differentElementsPage = new DifferentElementsPage();

        //1.Open test site by URL
        indexPage.open(INDEX_PAGE_DATA);

        page(indexPage);
        page(differentElementsPage);
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
        List<String> serviceDropdownInHeader = new ArrayList<>();
        serviceDropdownInHeader.add(SUPPORT.text);
        serviceDropdownInHeader.add(DATES.text);
        serviceDropdownInHeader.add(COMPLEX_TABLE.text);
        serviceDropdownInHeader.add(SIMPLE_TABLE.text);
        serviceDropdownInHeader.add(TABLES_WITH_PAGE.text);
        serviceDropdownInHeader.add(DIFFERENT_ELEMENTS.text);

        indexPage.checkServiceDropdownListInHeader(serviceDropdownInHeader);

        //6.Click on Service subcategory in the left section and check that drop down contains options
        List<String> serviceDropdownInLeftMenu = new ArrayList<>();
        serviceDropdownInLeftMenu.add(SUPPORT.text);
        serviceDropdownInLeftMenu.add(DATES.text);
        serviceDropdownInLeftMenu.add(COMPLEX_TABLE.text);
        serviceDropdownInLeftMenu.add(SIMPLE_TABLE.text);
        serviceDropdownInLeftMenu.add(TABLES_WITH_PAGE.text);
        serviceDropdownInLeftMenu.add(DIFFERENT_ELEMENTS.text);

        indexPage.checkServiceDropdownListInLeftMenu(serviceDropdownInLeftMenu);

        //7.Open through the header menu Service -> Different Elements Page
        differentElementsPage.openDifferentElementsPage();

        //8.Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkDifferentPageElements();

        //9.Assert that there is Right Section
        differentElementsPage.checkRightSection();

        //10.Assert that there is Left Section
        differentElementsPage.checkLeftSection();

        //11.Select checkboxes
        differentElementsPage.clickOnWaterAndWindCheckboxes();

        //12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        List<String> checkboxesLabels = new ArrayList<>();
        checkboxesLabels.add(WATER.text);
        checkboxesLabels.add(EARTH.text);
        checkboxesLabels.add(WIND.text);
        checkboxesLabels.add(FIRE.text);

        differentElementsPage.checkCheckboxesLabelsAndCheckedStatuses(checkboxesLabels);

        //13.Select radio
        differentElementsPage.selectSelenRadio();

        //14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton
        List<String> radiosLabels = new ArrayList<>();
        radiosLabels.add(GOLD.text);
        radiosLabels.add(SILVER.text);
        radiosLabels.add(BRONZE.text);
        radiosLabels.add(SELEN.text);

        differentElementsPage.checkRadiosLabelsAndStatus(radiosLabels);

        //15.Select in dropdown
        differentElementsPage.selectYellowInDropdown();

        //16.Assert that for dropdown there is a log row and value is corresponded to the selected value
        List<String> colorsList = new ArrayList<>();
        radiosLabels.add(RED.text);
        radiosLabels.add(GREEN.text);
        radiosLabels.add(BLUE.text);
        radiosLabels.add(YELLOW.text);

        differentElementsPage.checkDropdownOptionsAndStatus(colorsList);

        //17.Unselect and assert checkboxes
        differentElementsPage.clickOnWaterAndWindCheckboxes();

        //18.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        differentElementsPage.checkCheckboxesLabelsAndUncheckedStatuses(checkboxesLabels);
    }
}
