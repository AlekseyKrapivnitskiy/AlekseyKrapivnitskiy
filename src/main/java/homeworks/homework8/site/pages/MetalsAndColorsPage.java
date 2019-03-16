package homeworks.homework8.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homeworks.homework8.data.TestData;
import homeworks.homework8.site.forms.MetalsAndColorsForm;

public class MetalsAndColorsPage extends WebPage {

    private MetalsAndColorsForm metalsAndColorsForm;

    public void fillMetalsAndColorsForm(TestData metalsAndColors) {
        metalsAndColorsForm.fillForm(metalsAndColors);
    }

    public void submitMetalsAndColorsForm() {
        metalsAndColorsForm.submitForm();
    }

    public void checkResults(TestData metalsAndColors) {
        metalsAndColorsForm.checkResultPanel(metalsAndColors);
    }
}
