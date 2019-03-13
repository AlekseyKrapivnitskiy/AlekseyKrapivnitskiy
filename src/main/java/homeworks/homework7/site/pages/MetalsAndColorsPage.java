package homeworks.homework7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homeworks.homework7.entities.MetalsAndColors;
import homeworks.homework7.site.forms.MetalsAndColorsForm;
import org.openqa.selenium.WebElement;

import java.util.List;

import static homeworks.homework7.enums.Elements.*;
import static homeworks.homework7.enums.Results.*;
import static homeworks.homework7.enums.Vegetables.getVegetableLabel;
import static java.util.stream.Collectors.*;
import static org.testng.Assert.assertTrue;

// TODO Code convention !
public class MetalsAndColorsPage extends WebPage {

    private MetalsAndColorsForm metalsAndColorsForm;

    // TODO -- fixed
    // This method works with the elements from another class.
    // What is the reason of your decision to put it here ?
    public void fillMetalsAndColorsForm(MetalsAndColors metalsAndColors) {
        //select summary
        metalsAndColorsForm.selectSummary(metalsAndColors.summary);

        //select elements
        metalsAndColorsForm.selectElements(metalsAndColors.elements);

        //select color
        metalsAndColorsForm.selectColor(metalsAndColors.color);

        //select metal
        metalsAndColorsForm.selectMetal(metalsAndColors.metal);

        //select vegetables
        metalsAndColorsForm.selectVegetables(metalsAndColors.vegetables);
    }

    // TODO Same story -- fixed
    public void submitMetalsAndColorsForm() {
        metalsAndColorsForm.submitMetlsAndColorsForm();
    }

    /* TODO Oh my...
    It is completely prohibited to wright algorithm like this.
    It is quite difficult to realise what's going on here, especially because of 'switch' structures...
    I told you that it will be better to compare two lists of strings -
        1. List that based on MetalsAndColors instance
        1. List that based on log rows
    */
    public void checkResults(MetalsAndColors metalsAndColors) {
        List<String> resultContent = metalsAndColorsForm.resultSection.stream()
                .map(WebElement::getText)
                .collect(toList());

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
