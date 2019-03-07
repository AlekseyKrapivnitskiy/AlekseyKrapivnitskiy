package homeworks.homework8.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import homeworks.homework8.entities.User;
import homeworks.homework8.enums.HeaderItems;
import homeworks.homework8.site.forms.LoginForm;
import homeworks.homework8.site.sections.HeaderMenu;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class HomePage extends WebPage {

    private LoginForm loginForm;
    private HeaderMenu headerMenu;

    @FindBy(css = "#user-icon")
    private Icon userIcon;

    @FindBy(css = "#user-name")
    private Button usernameLabel;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
        checkUsername(user);
    }

    public void checkUsername(User user) {
        assertEquals(usernameLabel.getText(), user.getUsername());
    }

    public void clickOnItemInHeader(HeaderItems headerItems) {
        headerMenu.headerMenu.select(headerItems.label);
    }
}
