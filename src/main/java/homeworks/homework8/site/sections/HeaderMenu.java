package homeworks.homework8.site.sections;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends Section {

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    public Menu headerMenu;
}
