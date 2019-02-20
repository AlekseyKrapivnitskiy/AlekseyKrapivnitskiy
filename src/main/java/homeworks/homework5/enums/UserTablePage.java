package homeworks.homework5.enums;

import base.homeworks.homework5.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static homeworks.homework5.enums.LogsMessages.VIP_CHECKBOX_LOG;

public class UserTablePage extends BasePage {

    @FindBy(css = "select")
    private ElementsCollection dropdown;

    @FindBy(css = "td a")
    private ElementsCollection usernames;

    @FindBy(css = "td img")
    private ElementsCollection userImages;

    @FindBy(css = ".user-descr")
    private ElementsCollection userDescriptions;

    @FindBy(css = "td input")
    private ElementsCollection checkboxes;

    @FindBy(css = ".panel-body-list.logs")
    private SelenideElement logsPanel;

    public UserTablePage() {
        page(this);
    }

    public void checkAmountOfDropdowns() {
        dropdown.shouldHaveSize(6);
    }

    public void checkAmountOfUsernames() {
        usernames.shouldHaveSize(6);
    }

    public void checkAmountOfUserImages() {
        userImages.shouldHaveSize(6);
    }

    public void checkAmountOfUserDescriptions() {
        userDescriptions.shouldHaveSize(6);
    }

    public void checkAmountOfCheckboxes() {
        checkboxes.shouldHaveSize(6);
    }

    public void selectCheckbox(UsersInTable usersInTable) {
        checkboxes.get(usersInTable.index).click();
    }

    public void checkLogs(LogsMessages logsMessages, String status) {
        logsPanel.shouldHave(text(VIP_CHECKBOX_LOG.text + status));
    }
}
