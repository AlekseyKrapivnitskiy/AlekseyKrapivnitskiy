package homeworks.homework7;

import homeworks.homework7.site.JDISite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.close;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static homeworks.homework7.entities.User.PITER_CHAILOVSKII;
import static homeworks.homework7.enums.HeaderItems.METALS_AND_COLORS;

public class MetalsAndColorsPageTest extends JDISite{

    @BeforeSuite
    public void beforeSuite() {
        initElements(JDISite.class);
    }

    @AfterSuite
    public void afterSuite() {
        close();
    }

    @Test
    public void metalsAndColorsPageTest() {
        //1.Login on JDI site as User
        homePage.open();
        homePage.checkOpened();
        homePage.login(PITER_CHAILOVSKII);
        homePage.checkUsername(PITER_CHAILOVSKII);

        //2.Open Metals & Colors page by HeaderMenu menu
        homePage.clickOnItemInHeader(METALS_AND_COLORS);
        metalsAndColosPage.checkOpened();

        //3.Fill form Metals & Colors by data below:  Summary: 3, 8, Elements: Water, Fire, Colors: Red, Metals: Selen,
        // Vegetables: Cucumber,Tomato
        metalsAndColosPage.selectSummary(3);
        metalsAndColosPage.selectSummary(8);

        //4.Result sections should contains data  below:  Summary: 11, Elements: Water, Fire, Color: Red, Metal: Selen,
        // Vegetables: Cucumber, Tomato
    }
}
