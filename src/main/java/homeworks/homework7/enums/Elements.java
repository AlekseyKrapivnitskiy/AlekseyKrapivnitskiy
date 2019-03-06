package homeworks.homework7.enums;

public enum Elements {

    WATER(0, "Water"),
    EARTH(1, "Earth"),
    WIND(2, "Wind"),
    FIRE(3, "Fire");

    public int index;
    public String label;

    Elements(int index, String label) {
        this.index = index;
        this.label = label;
    }

    public static String getElementLabel(String element) {
        for (Elements elementName : Elements.values()) {
            if (elementName.label.equals(element)) {
                return elementName.label;
            }
        }
        return null;
    }
}
