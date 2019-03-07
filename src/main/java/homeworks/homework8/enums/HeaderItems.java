package homeworks.homework8.enums;

public enum HeaderItems {

    HOME(0, "HOME"),
    CONTACT_FORM(1, "CONTACT FORM"),
    SERVICE(2, "SERVICE"),
    METALS_AND_COLORS(3, "METALS & COLORS");

    public int index;
    public String label;

    HeaderItems(int index, String label) {
        this.index = index;
        this.label = label;
    }

    public static HeaderItems getHeaderItem(String itemName) {
        for (HeaderItems headerItems : HeaderItems.values()) {
            if (headerItems.label.equals(itemName)) {
                return headerItems;
            }
        }
        return null;
    }
}
