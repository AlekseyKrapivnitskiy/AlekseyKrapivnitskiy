package homeworks.homework3.enums;

import java.util.ArrayList;
import java.util.List;

public enum HeaderItems {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    public String text;

    HeaderItems(String text) {
        this.text = text;
    }

    public static List<String> getHeaderItemsList() {
        List<String> listOfHeaderItems = new ArrayList<>();

        for (HeaderItems headerItems : HeaderItems.values()) {
            listOfHeaderItems.add(headerItems.text);
        }
        return listOfHeaderItems;
    }
}
