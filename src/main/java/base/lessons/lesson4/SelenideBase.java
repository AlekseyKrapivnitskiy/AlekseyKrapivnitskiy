package base.lessons.lesson4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class SelenideBase {

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }
}
