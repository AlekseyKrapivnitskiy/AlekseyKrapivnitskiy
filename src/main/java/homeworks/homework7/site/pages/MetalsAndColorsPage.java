package homeworks.homework7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homeworks.homework7.entities.MetalsAndColors;
import homeworks.homework7.enums.*;
import homeworks.homework7.site.forms.MetalsAndColorsForm;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static homeworks.homework7.enums.Summary.getSummary;
import static org.testng.Assert.assertTrue;

public class MetalsAndColorsPage extends WebPage {

    /*
    TODO All of this elements should be inside of the form,
         in the other words, form should consist of this elements.
    TODO This is not make sense to create a section with one particular element... -- fixed
     */
    private MetalsAndColorsForm metalsAndColorsForm;

    public void fillMetalsAndColorsForm(MetalsAndColors metalsAndColors) {

        for(int i = 0; i < metalsAndColors.summary.size(); i++) {
            if (metalsAndColors.summary.get(i) % 2 == 0) {
                metalsAndColorsForm.odd.select(getSummary(i));
            } else {
                metalsAndColorsForm.even.select(getSummary(i));
            }
        }
    }

    public void selectElement(Elements elementsList) {
        metalsAndColorsForm.elements.select(elementsList.label);
    }

    public void selectColor(Colors color) {
        metalsAndColorsForm.colorsDropdown.select(color.label);
    }

    public void selectMetal(Metals metal) {
        metalsAndColorsForm.metalsDropdown.select(metal.label);
    }

    public void selectVegetable(Vegetables vegetable) {
        metalsAndColorsForm.vegetablesDropdown.select(vegetable.label);
    }

    public void submitMetalsAndColorsForm() {
        metalsAndColorsForm.submit.click();
    }

    public void checkResults(Results resultsList, String resultValue) {
        // TODO Take a look on stream::map method
        List<String> resultContent = new ArrayList<>();
        for (WebElement element : metalsAndColorsForm.resultSection) {
            resultContent.add(element.getText());
        }
        assertTrue(resultContent.contains(resultsList.label + resultValue));
    }
}
