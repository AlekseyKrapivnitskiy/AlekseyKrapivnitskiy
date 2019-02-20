package homeworks.homework6.steps;

import cucumber.api.java.en.When;
import homeworks.homework5.IndexPage;
import homeworks.homework5.enums.Users;

public class ActionSteps {

    @When("^I login as user '([^\"]*)' with password '([^\"]*)'$")
    public void iLoginAs() {
        new IndexPage().login(Users.PITER_CHAILOVSKII);
    }
}
