package base.lessons.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {

    private WebElement userIcon;
    private WebElement userField;
    private WebElement passwordField;
    private WebElement submitButton;

    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String name, String password) {
        userIcon = driver.findElement(By.cssSelector("[id='user-icon']"));
        userIcon.click();
        userField = driver.findElement(By.cssSelector("[id='name']"));
        userField.sendKeys(name);
        passwordField = driver.findElement(By.cssSelector("[id='password']"));
        passwordField.sendKeys(password);
        submitButton = driver.findElement(By.cssSelector("[id='login-button']"));
        submitButton.click();
    }

    public void open() {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }
}
