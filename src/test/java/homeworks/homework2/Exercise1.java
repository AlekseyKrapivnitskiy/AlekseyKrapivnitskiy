package homeworks.homework2;

import base.lessons.lesson3.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

// TODO Why this class extends from the Selenide? --fixed
public class Exercise1 extends SeleniumBase {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // TODO Do you try set annotation @BeforeMethod? -- changed to @BeforeMethod and @AfterMethod
    @BeforeMethod
    public void beforeMethod() {
        // TODO Why you set this property twice? -- fixed
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        driver.set(webDriver);
    }

    public WebDriver driver() {
        return driver.get();
    }

    @DataProvider(parallel = true)
    private Object[][] dataProvider() {
        return new Object[][]{
                {0, "To include good practices\n" + "and ideas from successful\n" + "EPAM project"},
                {1, "To be flexible and\n" + "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }

    @AfterMethod
    public void afterMethod() {
        driver().close();
    }

    @Test(dataProvider = "dataProvider")
    // TODO It better indexOfElement instead of id -- renamed to indexOfElement
    // TODO missing space ){ -- fixed
    public void indexPageBenefitTextTest(int indexOfElement, String text) {
        //1.Open test site by URL
        driver().navigate().to("https://epam.github.io/JDI/index.html");

        //2.Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver().findElements(By.cssSelector(".benefit-txt")).get(indexOfElement).getText(), text);
    }
}