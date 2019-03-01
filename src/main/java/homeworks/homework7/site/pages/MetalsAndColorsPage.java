package homeworks.homework7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homeworks.homework7.site.sections.Summary;

public class MetalsAndColorsPage extends WebPage {

    private Summary summary;

    public void selectSummary(int index) {
        if(index % 2 == 0) {
            summary.odd.select(index);
        }
        else {
            summary.even.select(index);
        }
    }
}
