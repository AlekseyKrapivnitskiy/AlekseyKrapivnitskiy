package homeworks.homework5;

import base.homeworks.homework5.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework5.enums.Sliders;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
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
        actions.clickAndHold(slider.get(sliders.index)).moveToElement(sliderLine,  ((sliderLine.getSize().width) * (value)/100 ),
                0).release().build().perform();
    }

    public void checkSliderLogs(String direction, Integer value) {
        logsPanel.shouldHave(text("Range 2(" + direction + "):" + value + " link clicked"));
    }
}
