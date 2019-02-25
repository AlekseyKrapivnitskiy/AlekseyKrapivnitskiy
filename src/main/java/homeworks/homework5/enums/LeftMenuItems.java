package homeworks.homework5.enums;

import java.util.ArrayList;
import java.util.List;

public enum LeftMenuItems {

    HOME(0, "Home"),
    CONTACT_FORM(1, "Contact form"),
    SERVICE(2, "Service"),
    METALS_AND_COLORS(3, "Metals & Colors"),
    ELEMENTS_PACKS(4, "Elements packs");

    public int index;
    public String label;

    LeftMenuItems(int index, String label) {
        this.index = index;
        this.label = label;
    }

    public static List<String> getItemsInLeftMenu() {
        List<String> listOfItemsInLeftMenu = new ArrayList<>();

        for (LeftMenuItems leftMenuItem : LeftMenuItems.values()) {
            listOfItemsInLeftMenu.add(leftMenuItem.label);
        }
        return listOfItemsInLeftMenu;
    }

    public static LeftMenuItems getItemInLeftMenu(String itemName) {
        for (LeftMenuItems leftMenuItem : LeftMenuItems.values()) {
            if (leftMenuItem.label.equals(itemName)) {
                return leftMenuItem;
            }
        }
        return null;
    }
}
