package homeworks.homework7.site.sections;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class Result extends Section {

    @FindBy(css = "panel-body-list.results > li")
    public WebList result;
}
