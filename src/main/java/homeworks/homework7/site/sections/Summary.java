package homeworks.homework7.site.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import org.openqa.selenium.support.FindBy;

public class Summary extends Section {

    @FindBy(css = "#odds-selector")
    public RadioButtons odd;

    @FindBy(css = "#even-selector")
    public RadioButtons even;

    @FindBy(css = "#calculate-button")
    public Button calculate;
}
