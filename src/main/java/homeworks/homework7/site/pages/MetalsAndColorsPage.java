package homeworks.homework7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homeworks.homework7.enums.SummaryRadiobuttons;
import homeworks.homework7.site.sections.Summary;

public class MetalsAndColorsPage extends WebPage {

    private Summary summary;

    public void selectSummary(SummaryRadiobuttons summaryRadiobuttons) {
        if(summaryRadiobuttons.index % 2 == 0) {
            summary.odd.select(summaryRadiobuttons.label);
        }
        else {
            summary.even.select(summaryRadiobuttons.label);
        }
    }
}
