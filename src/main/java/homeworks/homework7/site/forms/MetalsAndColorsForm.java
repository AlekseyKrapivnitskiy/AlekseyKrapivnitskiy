package homeworks.homework7.site.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homeworks.homework7.entities.MetalsAndColors;
import org.openqa.selenium.support.FindBy;

import static homeworks.homework7.enums.Elements.getElementLabel;
import static homeworks.homework7.enums.Summary.getSummaryLabel;
import static homeworks.homework7.enums.Vegetables.VEGETABLE;
import static homeworks.homework7.enums.Vegetables.getVegetableLabel;

public class MetalsAndColorsForm extends Form {

    @FindBy(css = "#odds-selector")
    private RadioButtons odd;

    @FindBy(css = "#even-selector")
    private RadioButtons even;

    @FindBy(css = "#elements-checklist > p")
    private WebList elements;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    private Droplist colorsDropdown;

    @JDropdown(root = "div[ui=combobox]", value = "input", list = "li", expand = ".caret")
    private Droplist metalsDropdown;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private Droplist vegetablesDropdown;

    @FindBy(css = "#submit-button")
    private Button submit;

    @FindBy(css = ".panel-body-list.results")
    public WebList resultSection;

    public void fillForm(MetalsAndColors metalsAndColors) {
        //select summary
        for (Integer integer : metalsAndColors.summary) {
            if (integer % 2 == 0) {
                odd.select(getSummaryLabel(integer));
            } else {
                even.select(getSummaryLabel(integer));
            }
        }
        //select elements
        for (String s : metalsAndColors.elements) {
            elements.select(getElementLabel(s));
        }
        //select color
        colorsDropdown.select(metalsAndColors.color);
        //select metal
        metalsDropdown.select(metalsAndColors.metal);
        //select vegetables
        vegetablesDropdown.select(VEGETABLE.label);
        for (String s : metalsAndColors.vegetables) {
            vegetablesDropdown.select(getVegetableLabel(s));
        }
    }

    public void submitMetalsAndColorsForm() {
        submit.click();
    }
}
