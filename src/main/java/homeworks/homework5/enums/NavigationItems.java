package homeworks.homework5.enums;

import java.util.ArrayList;
import java.util.List;

public enum NavigationItems {

    HOME(0, "HOME"),
    CONTACT_FORM(1, "CONTACT FORM"),
    SERVICE(2, "SERVICE"),
    METALS_AND_COLORS(3, "METALS & COLORS");

    public int index;
    public String label;

    NavigationItems(int index, String label) {
        this.index = index;
        this.label = label;
    }

    public static List<String> getHeaderItemsList() {
        List<String> listOfNavigationItems = new ArrayList<>();

        for (NavigationItems navigationItems : NavigationItems.values()) {
            listOfNavigationItems.add(navigationItems.label);
        }
        return listOfNavigationItems;
    }

    public static NavigationItems getNavigationItem(String itemName) {
        for (NavigationItems navigationItems : NavigationItems.values()) {
            if (navigationItems.label.equals(itemName)) {
                return navigationItems;
            }
        }
        return null;
    }
}
