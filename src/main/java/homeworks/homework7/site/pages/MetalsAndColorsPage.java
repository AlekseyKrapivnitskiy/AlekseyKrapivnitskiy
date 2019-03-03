package homeworks.homework7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homeworks.homework7.enums.ElementsList;
import homeworks.homework7.enums.MetalsList;
import homeworks.homework7.enums.SummaryRadiobuttons;
import homeworks.homework7.enums.VegetablesList;
import homeworks.homework7.site.sections.Elements;
import homeworks.homework7.site.sections.Metals;
import homeworks.homework7.site.sections.Summary;
import homeworks.homework7.site.sections.Vegetables;

public class MetalsAndColorsPage extends WebPage {

    private Summary summary;
    private Elements element;
    private Metals metals;
    private Vegetables vegetables;

    public void selectSummary(SummaryRadiobuttons summaryRadiobuttons) {
        if(summaryRadiobuttons.index % 2 == 0) {
            summary.odd.select(summaryRadiobuttons.label);
        }
        else {
            summary.even.select(summaryRadiobuttons.label);
        }
    }

    public void selectElement(ElementsList elementsList) {
        element.elements.select(elementsList.label);
    }

    public void selectMetal(MetalsList metal) {
        metals.metalDropdown.select(metal.label);
    }

    public void selectVegetable(VegetablesList vegetable) {
        vegetables.vegetablesDropdown.select(vegetable.label);
    }
}
