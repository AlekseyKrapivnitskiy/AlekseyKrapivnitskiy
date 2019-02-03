package homeworks.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class Exercise1 {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @DataProvider(parallel = true)
    private Object[][] dataProvider() {
        return new Object[][]{
                {0, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {1, "To be flexible and\n" +
                        "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void indexPageBenefitTextTest(int i, String s){
        //1.Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2.Perform login
        driver.findElement(By.cssSelector("#user-icon")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
        driver.findElement(By.cssSelector("#login-button")).click();

        //3.Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver.findElements(By.cssSelector(".benefit-txt")).get(i).getText(),s);
    }
}
