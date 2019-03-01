package homeworks.homework7;

import homeworks.homework7.site.JDISite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.close;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static homeworks.homework7.entities.User.PITER_CHAILOVSKII;
import static homeworks.homework7.site.JDISite.homePage;
import static homeworks.homework7.site.pages.HomePage.login;

public class MetalsAndColorsPageTest {

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
        homePage.open();
        homePage.checkOpened();
        login(PITER_CHAILOVSKII);
        homePage.checkUsername(PITER_CHAILOVSKII);
    }
}
