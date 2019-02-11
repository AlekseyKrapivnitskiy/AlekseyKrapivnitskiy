package homeworks.homework3.enums;

public enum HeaderItems {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    public String text;

    HeaderItems(String text) {
        this.text = text;
    }
}
