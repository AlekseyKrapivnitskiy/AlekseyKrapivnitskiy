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

    private WebDriver driver;

    // TODO Do you try set annotation @BeforeMethod?
    @BeforeTest
    public void beforeTest() {
        // TODO Why you set this property twice? -- fixed
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    @AfterTest
    public void afterTest() {
        driver.close();
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

    @Test(dataProvider = "dataProvider")
    // TODO It better indexOfElement instead of id -- renamed to indexOfElement
    // TODO missing space ){ -- fixed
    public void indexPageBenefitTextTest(int indexOfElement, String text) {
        //1.Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2.Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver.findElements(By.cssSelector(".benefit-txt")).get(indexOfElement).getText(), text);
    }
}