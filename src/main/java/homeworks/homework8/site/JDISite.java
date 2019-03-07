package homeworks.homework8.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import homeworks.homework8.site.pages.HomePage;
import homeworks.homework8.site.pages.MetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JDISite {

    @Url("index.html")
    public static HomePage homePage;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;
}
