package homeworks.homework7.site.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import org.openqa.selenium.support.FindBy;

public class MetalsAndColorsForm extends Form {

    @FindBy(css = "#odds-selector")
    public RadioButtons odd;

    @FindBy(css = "#even-selector")
    public RadioButtons even;

    @FindBy(css = "#elements-checklist > p")
    public WebList elements;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    public Droplist colorsDropdown;

    @JDropdown(root = "div[ui=combobox]", value = "input", list = "li", expand = ".caret")
    public Droplist metalsDropdown;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    public Droplist vegetablesDropdown;

    @FindBy(css = "#submit-button")
    public Button submit;

    @FindBy(css = ".panel-body-list.results")
    public WebList resultSection;
}
