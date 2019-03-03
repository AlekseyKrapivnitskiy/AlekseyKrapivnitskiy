package homeworks.homework7.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import homeworks.homework7.site.pages.HomePage;
import homeworks.homework7.site.pages.MetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JDISite {

    @Url("index.html")
    public static HomePage homePage;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;
}
