package homeworks.homework7.site.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import homeworks.homework7.entities.MetalsAndColors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static homeworks.homework7.enums.Elements.getElementLabel;
import static homeworks.homework7.enums.Summary.getSummaryLabel;
import static homeworks.homework7.enums.Vegetables.VEGETABLE;
import static homeworks.homework7.enums.Vegetables.getVegetableLabel;
import static org.testng.Assert.assertEquals;

public class MetalsAndColorsForm extends Form {

    @FindBy(css = "#odds-selector")
    private RadioButtons odd;

    @FindBy(css = "#even-selector")
    private RadioButtons even;

    @FindBy(css = "#elements-checklist > p")
    private WebList elements;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown colorsDropdown;

    @JDropdown(root = "div[ui=combobox]", value = "input", list = "li", expand = ".caret")
    private Dropdown metalsDropdown;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private Dropdown vegetablesDropdown;

    @FindBy(css = "#submit-button")
    private Button submit;

    @FindBy(css = ".panel-body-list.results")
    private WebList resultSection;

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
        //unselect 'Vegetables'
        vegetablesDropdown.select(VEGETABLE.label);
        //select vegetables
        for (String s : metalsAndColors.vegetables) {
            vegetablesDropdown.select(getVegetableLabel(s));
        }
    }

    public void submitForm() {
        submit.click();
    }

    public void checkResultPanel(MetalsAndColors metalsAndColors) {
        List<String> resultsFromSection = resultSection.stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> metalsAndColorsResults = new ArrayList<>();
        metalsAndColorsResults.add("Summary: " + (metalsAndColors.summary.get(0) + metalsAndColors.summary.get(1)));
        metalsAndColorsResults.add("Elements: " + String.join(", ", metalsAndColors.elements));
        metalsAndColorsResults.add("Color: " + metalsAndColors.color);
        metalsAndColorsResults.add("Metal: " + metalsAndColors.metal);
        metalsAndColorsResults.add("Vegetables: " + String.join(", ", metalsAndColors.vegetables));

        assertEquals(metalsAndColorsResults, resultsFromSection);
    }
}
