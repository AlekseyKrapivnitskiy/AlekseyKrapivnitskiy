package homeworks.homework7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import homeworks.homework7.entities.User;
import homeworks.homework7.site.forms.LoginForm;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class HomePage extends WebPage {

    LoginForm loginForm;

    @FindBy(css = "#user-icon")
    private Icon userIcon;

    @FindBy(css = "#user-name")
    private Button usernameLabel;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public void checkUsername(User user) {
        assertEquals(usernameLabel.getText(), user.getUsername());
    }
}
