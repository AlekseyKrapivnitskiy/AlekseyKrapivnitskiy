package homeworks.homework7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import homeworks.homework7.enums.Users;
import homeworks.homework7.site.sections.LoginForm;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebPage {

    private static LoginForm loginForm;

    @FindBy(css = "#user-icon")
    private static Icon userIcon;

    public static void login(Users users) {
        userIcon.click();
        loginForm.loginAs(users);
    }
}
