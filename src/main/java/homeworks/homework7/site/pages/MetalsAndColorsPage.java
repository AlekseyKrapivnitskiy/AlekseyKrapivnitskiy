package homeworks.homework7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homeworks.homework7.entities.MetalsAndColors;
import homeworks.homework7.site.forms.MetalsAndColorsForm;

// TODO Code convention !
public class MetalsAndColorsPage extends WebPage {

    private MetalsAndColorsForm metalsAndColorsForm;

    // TODO -- fixed
    // This method works with the elements from another class.
    // What is the reason of your decision to put it here ?
    public void fillMetalsAndColorsForm(MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.fillForm(metalsAndColors);
    }

    // TODO Same story -- fixed
    public void submitMetalsAndColorsForm() {
        metalsAndColorsForm.submitMetalsAndColorsForm();
    }

    /* TODO Oh my... -- fixed
    It is completely prohibited to wright algorithm like this.
    It is quite difficult to realise what's going on here, especially because of 'switch' structures...
    I told you that it will be better to compare two lists of strings -
        1. List that based on MetalsAndColors instance
        1. List that based on log rows
    */
    public void checkResults(MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.checkResult(metalsAndColors);
    }
}
