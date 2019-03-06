package homeworks.homework7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homeworks.homework7.entities.MetalsAndColors;
import homeworks.homework7.enums.*;
import homeworks.homework7.site.forms.MetalsAndColorsForm;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static homeworks.homework7.enums.Elements.getElementLabel;
import static homeworks.homework7.enums.Summary.getSummaryLabel;
import static homeworks.homework7.enums.Vegetables.VEGETABLE;
import static homeworks.homework7.enums.Vegetables.getVegetableLabel;
import static org.testng.Assert.assertTrue;

public class MetalsAndColorsPage extends WebPage {

    /*
    TODO All of this elements should be inside of the form,
         in the other words, form should consist of this elements.
    TODO This is not make sense to create a section with one particular element... -- fixed
     */
    private MetalsAndColorsForm metalsAndColorsForm;

    public void fillMetalsAndColorsForm(MetalsAndColors metalsAndColors) {
        //select summary
        for(int i = 0; i < metalsAndColors.summary.size(); i++) {
            if (metalsAndColors.summary.get(i) % 2 == 0) {
                metalsAndColorsForm.odd.select(getSummaryLabel(metalsAndColors.summary.get(i)));
            } else {
                metalsAndColorsForm.even.select(getSummaryLabel(metalsAndColors.summary.get(i)));
            }
        }

        //select elements
        for(int i = 0; i < metalsAndColors.elements.size(); i++) {
            metalsAndColorsForm.elements.select(getElementLabel(metalsAndColors.elements.get(i)));
        }

        //select color
        metalsAndColorsForm.colorsDropdown.select(metalsAndColors.color);

        //select metal
        metalsAndColorsForm.metalsDropdown.select(metalsAndColors.metal);

        //unselect 'Vegetables'
        metalsAndColorsForm.vegetablesDropdown.select(VEGETABLE.label);

        //select vegetables
        for(int i = 0; i < metalsAndColors.vegetables.size(); i++) {
            metalsAndColorsForm.vegetablesDropdown.select(getVegetableLabel(metalsAndColors.vegetables.get(i)));
        }
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
