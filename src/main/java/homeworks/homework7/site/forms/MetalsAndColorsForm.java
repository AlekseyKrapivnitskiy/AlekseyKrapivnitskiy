package homeworks.homework7.site.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    public void selectSummary(List<Integer> summary) {
        for (Integer integer : summary) {
            if (integer % 2 == 0) {
                odd.select(getSummaryLabel(integer));
            } else {
                even.select(getSummaryLabel(integer));
            }
        }
    }

    public void selectElements(List<String> elementsList) {
        for (String s : elementsList) {
            elements.select(getElementLabel(s));
        }
    }

    public void selectColor(String color) {
        colorsDropdown.select(color);
    }

    public void selectMetal(String metal) {
        metalsDropdown.select(metal);
    }

    public void selectVegetables(List<String> vegetablesList) {
        vegetablesDropdown.select(VEGETABLE.label);
        for (String s : vegetablesList) {
            vegetablesDropdown.select(getVegetableLabel(s));
        }
    }

    public void submitMetlsAndColorsForm() {
        submit.click();
    }
}
