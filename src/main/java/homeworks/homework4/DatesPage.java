package homeworks.homework4;

import base.homeworks.homework4.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework4.enums.Sliders;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage extends BasePage {

    @FindBy(css = "a.ui-slider-handle")
    private ElementsCollection slider;

    @FindBy(css = ".uui-slider")
    public SelenideElement sliderLine;

    @FindBy(css = ".panel-body-list.logs")
    private SelenideElement logsPanel;

    private Actions actions = new Actions(getWebDriver());

    public void moveSlider(Sliders sliders, int value) {
        // TODO Please try to avoid code duplication -- fixed
        actions.clickAndHold(slider.get(sliders.index)).moveToElement(sliderLine,  ((sliderLine.getSize().width) * (value)/100 ),
                0).release().build().perform();
    }

    public void checkLogs(String direction, Integer value) {
        logsPanel.shouldHave(text("Range 2(" + direction + "):" + value + " link clicked"));
    }
}
