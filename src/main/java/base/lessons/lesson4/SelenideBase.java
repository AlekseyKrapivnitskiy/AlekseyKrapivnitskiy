package base.lessons.lesson4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public abstract class SelenideBase {

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }
}
