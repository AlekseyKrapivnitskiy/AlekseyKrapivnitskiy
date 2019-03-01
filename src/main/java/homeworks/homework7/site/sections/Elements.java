package homeworks.homework7.site.sections;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class Elements extends Section {

    @FindBy(css = "#elements-checklist > p")
    public WebList elements;
}
