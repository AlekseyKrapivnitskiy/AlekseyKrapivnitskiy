package base.lessons.lesson3;

import org.testng.annotations.BeforeSuite;

public abstract class SeleniumBase {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }
}
