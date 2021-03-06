package homeworks.homework6;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;

@CucumberOptions(features = "classpath:homework6", glue = "classpath:homeworks.homework6.steps")
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void beforeMethod() {
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }
}