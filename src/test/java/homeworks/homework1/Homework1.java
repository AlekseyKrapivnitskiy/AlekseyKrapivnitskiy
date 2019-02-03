package homeworks.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework1 {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void indexPageTest() {
        //1.Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2.Assert Browser title
        String homePageTitle = "Home Page";
        assertEquals(driver.getTitle(), homePageTitle);

        //3.Perform login
        driver.findElement(By.cssSelector("#user-icon")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
        driver.findElement(By.cssSelector("#login-button")).click();

        //4.Assert User name in the left-top side of screen that user is logged in
        String username = "PITER CHAILOVSKII";
        assertEquals(driver.findElement(By.cssSelector("#user-name")).getText(), username);

        //5.Assert Browser title
        assertEquals(driver.getTitle(), homePageTitle);

        //6.Assert that there are 4 items on the header section are displayed and they have proper texts
        assertEquals(driver.findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(1)")).getText(), "HOME");
        assertEquals(driver.findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(2)")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(3)")).getText(), "SERVICE");
        assertEquals(driver.findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4)")).getText(), "METALS & COLORS");

        //7.Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(1) > div > div")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(2) > div > div")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(3) > div > div")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(4) > div > div")).isDisplayed());

        //8.Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(1) > div > span")).getText(), "To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        assertEquals(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(2) > div > span")).getText(), "To be flexible and\n" + "customizable");
        assertEquals(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(3) > div > span")).getText(), "To be multiplatform");
        assertEquals(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(4) > div > span")).getText(), "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

        //9.Assert a text of the main headers
        assertEquals(driver.findElement(By.cssSelector("h3.main-title.text-center")).getText(), "EPAM FRAMEWORK WISHES…");

        //10.Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("#iframe")).isDisplayed());

        //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("#iframe")));
        assertTrue(driver.findElement(By.cssSelector("#epam_logo")).isDisplayed());

        //12.Switch to original window back
        driver.switchTo().defaultContent();

        //13.Assert a text of the sub header
        assertEquals(driver.findElement(By.cssSelector("h3:nth-child(3)")).getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver.findElement(By.cssSelector("h3:nth-child(3) > a")).getAttribute("href"), "https://github.com/epam/JDI");

        // 15.Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("#mCSB_1")).isDisplayed());

        //16.Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());

        //17.Close Browser
        driver.close();
    }
}

