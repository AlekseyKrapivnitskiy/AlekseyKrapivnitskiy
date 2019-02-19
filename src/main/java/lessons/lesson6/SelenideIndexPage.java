package lessons.lesson6;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homeworks.homework5.enums.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class SelenideIndexPage {

    @FindBy(css = "#user-icon")
    private SelenideElement userIcon;

    @FindBy(css = "#name")
    private SelenideElement userField;

    @FindBy(css = "#password")
    private SelenideElement passwordField;

    @FindBy(css = "#login-button")
    private SelenideElement submitButton;

    @FindBy(css = "#user-name")
    private SelenideElement usernameLabel;

    @When("I login as user 'epam' with password '1234'")
    public void login(String name, String password) {
        userIcon.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    @Given("I open EPAM JDI site")
    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Then("User name should be 'PITER CHAILOVSKII'")
    public void checkUsername(Users users) {
        usernameLabel.shouldHave(text(users.username));
    }
}
