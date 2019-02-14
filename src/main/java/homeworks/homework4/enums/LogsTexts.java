package homeworks.homework4.enums;

public enum LogsTexts {

    CHECBOX_LOG(": condition changed to "),
    RADIOBUTTON_LOG("metal: value changed to "),
    DROPDOWN_LOG("Colors: value changed to ");

    public String text;

    LogsTexts(String text) {
        this.text = text;
    }
}
