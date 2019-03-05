package homeworks.homework7;

import homeworks.homework7.site.JDISite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.close;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static homeworks.homework7.entities.User.piterChailovskii;
import static homeworks.homework7.enums.Colors.RED;
import static homeworks.homework7.enums.Elements.*;
import static homeworks.homework7.enums.HeaderItems.METALS_AND_COLORS;
import static homeworks.homework7.enums.Metals.SELEN;
import static homeworks.homework7.enums.Results.*;
import static homeworks.homework7.enums.Summary.EIGHT;
import static homeworks.homework7.enums.Summary.THREE;
import static homeworks.homework7.enums.VegetablesList.*;

public class MetalsAndColorsPageTest extends JDISite {

    @BeforeSuite
    public void beforeSuite() {
        initElements(JDISite.class);
    }

    @AfterSuite
    public void afterSuite() {
        close();
    }

    // TODO This test should be written in according to entity driving testing.
    @Test
    public void metalsAndColorsPageTest() {
        //1.Login on JDI site as User
        homePage.open();
        homePage.checkOpened();
        homePage.login(piterChailovskii);
        homePage.checkUsername(piterChailovskii);

        //2.Open Metals & Colors page by HeaderMenu menu
        homePage.clickOnItemInHeader(METALS_AND_COLORS);
        metalsAndColorsPage.checkOpened();

        //3.Fill form Metals & Colors by data below:  Summary: 3, 8, Elements: Water, Fire, Colors: Red, Metals: Selen,
        // VegetablesList: Cucumber,Tomato


        //4.Submit form Metals & Colors
        metalsAndColorsPage.submitMetalsAndColorsForm();

        //5.Result sections should contains data  below:  Summary: 11, Elements: Water, Fire, Color: Red, Metal: Selen,
        // VegetablesList: Cucumber, Tomato
        metalsAndColorsPage.checkResults(SUMMARY, "11");
        metalsAndColorsPage.checkResults(ELEMENTS, WATER.label + ", " + FIRE.label);
        metalsAndColorsPage.checkResults(COLOR, RED.label);
        metalsAndColorsPage.checkResults(METAL, SELEN.label);
        metalsAndColorsPage.checkResults(VEGETABLES, CUCUMBER.label + ", " + TOMATO.label);
    }
}
