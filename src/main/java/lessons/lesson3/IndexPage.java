package lessons.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {

    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String name, String password) {
        WebElement userIcon = driver.findElement(By.cssSelector("[id='user-icon']"));
        userIcon.click();
        WebElement userField = driver.findElement(By.cssSelector("[id='name']"));
        userField.sendKeys(name);
        WebElement passwordField = driver.findElement(By.cssSelector("[id='password']"));
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.cssSelector("[id='login-button']"));
        submitButton.click();
    }

    public void open() {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }
}
