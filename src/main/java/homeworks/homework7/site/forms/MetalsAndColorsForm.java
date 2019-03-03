package homeworks.homework7.site.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import org.openqa.selenium.support.FindBy;

public class MetalsAndColorsForm extends Form {

    @FindBy(css = "#submit-button")
    public Button submit;
}
