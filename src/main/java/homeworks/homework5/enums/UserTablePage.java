package homeworks.homework5.enums;

import base.homeworks.homework5.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.DataTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class UserTablePage extends BasePage {

    @FindBy(css = "tr > td:nth-child(1)")
    private ElementsCollection numbers;

    @FindBy(css = "select")
    private ElementsCollection dropdown;

    @FindBy(css = "td  a")
    private ElementsCollection usernames;

    @FindBy(css = "td  img")
    private ElementsCollection userImages;

    @FindBy(css = ".user-descr")
    private ElementsCollection userDescriptions;

    @FindBy(css = "td input")
    private ElementsCollection checkboxes;

    @FindBy(css = ".panel-body-list.logs")
    private SelenideElement logsPanel;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logs;

    @FindBy(css = "tbody > tr:nth-child(2) option")
    private ElementsCollection itemsInUserRolesDropdown;

    public UserTablePage() {
        page(this);
    }

    public void checkAmountOfDropdowns(int amount) {
        dropdown.shouldHaveSize(amount);
    }

    public void checkAmountOfUsernames(int amount) {
        usernames.shouldHaveSize(amount);
    }

    public void checkAmountOfUserImages(int amount) {
        userImages.shouldHaveSize(amount);
    }

    public void checkAmountOfUserDescriptions(int amount) {
        userDescriptions.shouldHaveSize(amount);
    }

    public void checkAmountOfCheckboxes(int amount) {
        checkboxes.shouldHaveSize(amount);
    }

    public void checkUsersTable(DataTable userTable) {
        List<Map<String, String>> table = userTable.asMaps(String.class, String.class);

        for (int i = 0; i < table.size(); i++) {
            // TODO Where is the Number? -- fixed
            numbers.get(i).should(text(table.get(i).get("Number")));
            usernames.get(i).should(text(table.get(i).get("User")));
            userDescriptions.get(i).should(text(table.get(i).get("Description")));
        }
    }

    public void selectCheckbox(UsersInTable usersInTable) {
        checkboxes.get(usersInTable.index).click();
    }

    public void checkLogs(LogsMessages logsMessages, String status, int amount) {
        logsPanel.shouldHave(text(logsMessages.text + status));
        logs.shouldHaveSize(amount);
    }

    public void openDropdownList(UsersInTable usersInTable) {
        dropdown.get(usersInTable.index).click();
    }

    public void checkUserRolesInDropdown(List<String> userRoles) {
        for (int i = 0; i < itemsInUserRolesDropdown.size(); i++) {
            itemsInUserRolesDropdown.get(i).shouldHave(text(userRoles.get(i)));
        }
    }
}
