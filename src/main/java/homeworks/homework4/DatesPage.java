package homeworks.homework4;

import static com.codeborne.selenide.Selenide.*;

public class DatesPage {

    public void openDatesPage() {
        $(".dropdown").click();
        $(".dropdown-menu > li:nth-child(2)").click();
    }

    public void setRangeMaxLeftAndMaxRitght() {
        actions().dragAndDropBy($("ui-slider-handle.ui-state-default.ui-corner-all"), 20, 0);
        actions().dragAndDropBy($("ui-slider-handle ui-state-default ui-corner-all ui-state-hover"), 100, 100);
    }

    public void setRangeMaxLeftForBothSliders() {
        actions().dragAndDrop($("ui-slider-handle.ui-state-default.ui-corner-all"), $("ui-slider-handle ui-state-default ui-corner-all ui-state-hover"));
        actions().dragAndDropBy($("ui-slider-handle ui-state-default ui-corner-all ui-state-hover"), 100, 0);
        screenshot("screenshot.jpg");
    }
}
