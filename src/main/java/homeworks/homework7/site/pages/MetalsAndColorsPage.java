package homeworks.homework7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homeworks.homework7.entities.MetalsAndColors;
import homeworks.homework7.site.forms.MetalsAndColorsForm;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static homeworks.homework7.enums.Elements.*;
import static homeworks.homework7.enums.Results.*;
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

    public void checkResults(MetalsAndColors metalsAndColors) {
        // TODO Take a look on stream::map method
        List<String> resultContent = new ArrayList<>();
        for (WebElement element : metalsAndColorsForm.resultSection) {
            resultContent.add(element.getText());
        }

        //assert summary result
        int summaryResult = 0;

        if (metalsAndColors.summary.size() > 1) {
            for (int i = 0; i < metalsAndColors.summary.size(); i++) {
                summaryResult += metalsAndColors.summary.get(i);
            }
        } else {
            summaryResult = metalsAndColors.summary.get(0);
        }

        assertTrue(resultContent.contains(SUMMARY.label + summaryResult));

        //assert elements result
        String elementsResult = "";

        int elementsSelected = metalsAndColors.elements.size();

        switch (elementsSelected) {

            case 1: elementsResult = getElementLabel(metalsAndColors.elements.get(0));
            break;

            case 2: elementsResult = getElementLabel(metalsAndColors.elements.get(0)) + ", " +
                    getElementLabel(metalsAndColors.elements.get(1));
            break;

            case 3: elementsResult = getElementLabel(metalsAndColors.elements.get(0)) + ", " +
                    getElementLabel(metalsAndColors.elements.get(1)) + ", " +
                    getElementLabel(metalsAndColors.elements.get(2));
            break;

            case 4:  elementsResult = getElementLabel(metalsAndColors.elements.get(0)) + ", " +
                    getElementLabel(metalsAndColors.elements.get(1)) + ", " +
                    getElementLabel(metalsAndColors.elements.get(2)) + ", " +
                    getElementLabel(metalsAndColors.elements.get(3));
            break;
        }

        assertTrue(resultContent.contains(ELEMENTS.label + elementsResult));

        //assert color result
        assertTrue(resultContent.contains(COLOR.label + metalsAndColors.color));

        //assert metal result
        assertTrue(resultContent.contains(METAL.label + metalsAndColors.metal));

        //assert vegetables result
        String vegetablesResult = "";

        int vegetablesSelected = metalsAndColors.vegetables.size();

        switch (vegetablesSelected) {

            case 1: vegetablesResult = getVegetableLabel(metalsAndColors.vegetables.get(0));
            break;

            case 2: vegetablesResult = getVegetableLabel(metalsAndColors.vegetables.get(0)) + ", " +
                    getVegetableLabel(metalsAndColors.vegetables.get(1));
            break;

            case 3: vegetablesResult = getVegetableLabel(metalsAndColors.vegetables.get(0)) + ", " +
                    getVegetableLabel(metalsAndColors.vegetables.get(1)) + ", " +
                    getVegetableLabel(metalsAndColors.vegetables.get(2));
            break;

            case 4: vegetablesResult = getVegetableLabel(metalsAndColors.vegetables.get(0)) + ", " +
                    getVegetableLabel(metalsAndColors.vegetables.get(1)) + ", " +
                    getVegetableLabel(metalsAndColors.vegetables.get(2)) + ", " +
                    getVegetableLabel(metalsAndColors.vegetables.get(3));
            break;
        }

        assertTrue(resultContent.contains(VEGETABLES.label + vegetablesResult));
    }
}
