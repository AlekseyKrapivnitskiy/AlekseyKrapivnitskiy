package homeworks.homework7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homeworks.homework7.enums.*;
import homeworks.homework7.site.forms.MetalsAndColorsForm;
import homeworks.homework7.site.sections.*;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class MetalsAndColorsPage extends WebPage {

    /*
    TODO All of this elements should be inside of the form,
         in the other words, form should consist of this elements.
    TODO This is not make sense to create a section with one particular element...
     */
    private Summary summary;
    private Elements element;
    private Colors colors;
    private Metals metals;
    private Vegetables vegetables;
    private Result result;

    private MetalsAndColorsForm metalsAndColorsForm;

    public void selectSummary(SummaryRadiobuttons summaryRadiobuttons) {
        if(summaryRadiobuttons.value % 2 == 0) {
            summary.odd.select(summaryRadiobuttons.label);
        }
        else {
            summary.even.select(summaryRadiobuttons.label);
        }
    }

    public void selectElement(ElementsList elementsList) {
        element.elements.select(elementsList.label);
    }

    public void selectColor(ColorsList color) {
        colors.colorsDropdown.select(color.label);
    }

    public void selectMetal(MetalsList metal) {
        metals.metalDropdown.select(metal.label);
    }

    public void selectVegetable(VegetablesList vegetable) {
        vegetables.vegetablesDropdown.select(vegetable.label);
    }

    public void submitMetalsAndColorsForm() {
        metalsAndColorsForm.submit.click();
    }

    public void checkResults(ResultsList resultsList, String resultValue) {
        // TODO Take a look on stream::map method
        List<String> resultContent = new ArrayList<>();
        for (WebElement element : result.resultSection) {
            resultContent.add(element.getText());
        }
        assertTrue(resultContent.contains(resultsList.label + resultValue));
    }
}
