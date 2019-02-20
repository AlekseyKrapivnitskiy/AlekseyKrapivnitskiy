package homeworks.homework6.steps;

import cucumber.api.java.en.When;
import homeworks.homework5.IndexPage;
import homeworks.homework5.enums.Users;

public class ActionSteps {

    @When("^I login as user epam with password 1234$")
    public void iLoginAs() {
        new IndexPage().login(Users.PITER_CHAILOVSKII);
    }

    @When("^I click on \"Service\" subcategory in the header$")
    public void iClickOnSubcategoryInTheHeader() {
        new IndexPage().clickOnServiceDropdownInHeader();
    }

    @When("^I click on \"Service\" subcategory in the left menu$")
    public void iClickOnSubcategoryInTheLeftMenu() {
        new IndexPage().clickOnServiceDropdownInLeftMenu();
    }
}