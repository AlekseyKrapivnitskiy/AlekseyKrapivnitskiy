package homeworks.homework7.site.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.html.complex.Menu;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends Section {

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    public Menu headerMenu;
}
