package homeworks.homework5;

import base.homeworks.homework5.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.homework5.enums.Sliders;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage extends BasePage {

    @FindBy(css = "a.ui-slider-handle")
    private ElementsCollection slider;

    @FindBy(css = ".uui-slider")
    private SelenideElement sliderLine;

    @FindBy(css = ".panel-body-list.logs")
    private SelenideElement logsPanel;

    private Actions actions = new Actions(getWebDriver());

    @Step("6.Using drag-and-drop set Range sliders:{sliders} {value}")
    public void moveSlider(Sliders sliders, int value) {
        actions.clickAndHold(slider.get(sliders.index)).moveToElement(sliderLine,  ((sliderLine.getSize().width) * (value)/100 ),
                0).release().build().perform();
    }

    @Step("11.Assert that for \"From\" and \"To\" sliders there are logs rows with corresponding values")
    public void checkSliderLogs(String direction, Integer value) {
        logsPanel.shouldHave(text("Range 2(" + direction + "):" + value + " link clicked"));
    }
}
