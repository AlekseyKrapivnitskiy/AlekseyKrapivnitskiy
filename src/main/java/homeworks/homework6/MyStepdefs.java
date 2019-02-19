package homeworks.homework6;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("^I am on (.*)$")
    public void iAmOnHttpsEpamGithubIoJDI(String url) {
        open(url);
    }
}
