package homeworks.homework8.site.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import homeworks.homework8.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {

    @FindBy(css = "#name")
    private TextField login;

    @FindBy(css = "#password")
    private TextField password;

    @FindBy(css = "#login-button")
    private Button submit;
}
