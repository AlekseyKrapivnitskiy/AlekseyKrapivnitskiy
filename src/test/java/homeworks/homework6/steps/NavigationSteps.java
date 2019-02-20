package homeworks.homework6.steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {
    @Given("^I am on (.*)$")
    public void iAmOnHttpsEpamGithubIoJDI(String url) {
        open(url);
    }
}
