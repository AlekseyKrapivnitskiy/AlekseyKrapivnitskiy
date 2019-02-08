package homeworks.homework3.enums;

public enum HeaderItems {

    // TODO It will be better if each text have separate enum value -- fixed
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    public String text;

    HeaderItems(String text) {
        this.text = text;
    }
}
