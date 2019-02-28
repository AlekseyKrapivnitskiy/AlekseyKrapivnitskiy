package homeworks.homework7.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import homeworks.homework7.enums.Users;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<Users> {

    @FindBy(css = "#name")
    public TextField userField;

    @FindBy(css = "#password")
    public TextField passwordField;

    @FindBy(css = "#login-button")
    private Button submitButton;
}
