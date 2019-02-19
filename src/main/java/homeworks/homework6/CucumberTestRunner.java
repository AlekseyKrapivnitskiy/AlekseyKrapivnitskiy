package homeworks.homework6;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;

@CucumberOptions(
        features = "src/test/resources/homework6",
        glue = "src/main/homeworks/homework6"
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @BeforeMethod()
    public void driverSetUp() {
        Configuration.startMaximized = true;
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }
}
