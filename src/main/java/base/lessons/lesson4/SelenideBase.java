package base.lessons.lesson4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public abstract class SelenideBase {

    @BeforeSuite
    public void beforeSuite() {
        // TODO Why you set this property??? -- fixed
        Configuration.startMaximized = true;
    }
}
