package homeworks.homework8.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homeworks.homework8.data.TestData;
import homeworks.homework8.site.forms.MetalsAndColorsForm;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static homeworks.homework8.enums.Elements.getElementLabel;
import static homeworks.homework8.enums.Results.*;
import static homeworks.homework8.enums.Summary.getSummaryLabel;
import static homeworks.homework8.enums.Vegetables.VEGETABLE;
import static homeworks.homework8.enums.Vegetables.getVegetableLabel;
import static org.testng.Assert.assertTrue;

public class MetalsAndColorsPage extends WebPage {

    private MetalsAndColorsForm metalsAndColorsForm;

    public void fillMetalsAndColorsForm(TestData metalsAndColors) {
        //select summary
        for(int i = 0; i < metalsAndColors.getSummary().size(); i++) {
            if (metalsAndColors.getSummary().get(i) % 2 == 0) {
                metalsAndColorsForm.odd.select(getSummaryLabel(metalsAndColors.getSummary().get(i)));
            } else {
                metalsAndColorsForm.even.select(getSummaryLabel(metalsAndColors.getSummary().get(i)));
            }
        }

        //select elements
        for(int i = 0; i < metalsAndColors.elements.size(); i++) {
            metalsAndColorsForm.elements.select(getElementLabel(metalsAndColors.getElements().get(i)));
        }

        //select color
        metalsAndColorsForm.colorsDropdown.select(metalsAndColors.getColor());

        //select metal
        metalsAndColorsForm.metalsDropdown.select(metalsAndColors.getMetals());

        //unselect 'Vegetables'
        metalsAndColorsForm.vegetablesDropdown.select(VEGETABLE.label);

        //select vegetables
        for(int i = 0; i < metalsAndColors.getVegetables().size(); i++) {
            metalsAndColorsForm.vegetablesDropdown.select(getVegetableLabel(metalsAndColors.getVegetables().get(i)));
        }
    }

    public void submitMetalsAndColorsForm() {
        metalsAndColorsForm.submit.click();
    }

    public void checkResults(TestData metalsAndColors) {
        List<String> resultContent = metalsAndColorsForm.resultSection.stream().map(WebElement::getText).collect(Collectors.toList());

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
        assertTrue(resultContent.contains(METAL.label + metalsAndColors.getMetals()));

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
