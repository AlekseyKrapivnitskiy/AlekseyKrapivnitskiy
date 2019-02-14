package homeworks.homework3.enums;

import java.util.ArrayList;
import java.util.Arrays;
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

        for (int i = 0; i < HeaderItems.values().length; i++) {
            listOfHeaderItems.add(Arrays.asList(HeaderItems.values()).get(i).text);
        }
        return listOfHeaderItems;
    }
}
