package lessons.lesson4;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideSimpleTest {


    @Test
    public void simpleTest() {
        //1
        open("https://epam.github.io/JDI/index.html");

        //2
        Assert.assertEquals(getWebDriver().getTitle(), "Home Page");

        //3
        $("[id='user-icon']").click();
        $("[id='name']").sendKeys("epam");
        $("[id='password']").sendKeys("1234");
        $("[id='login-button']").click();

        //4
        $("").shouldHave(text(""));
    }
}
