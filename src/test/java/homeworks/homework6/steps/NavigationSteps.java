package homeworks.homework6.steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;
import static homeworks.homework5.enums.IndexPageData.INDEX_PAGE_DATA;

public class NavigationSteps {

    @Given("^I am on \"Home Page\"$")
    public void iAmOnHomePage() {
        open(INDEX_PAGE_DATA.url);
    }
}
