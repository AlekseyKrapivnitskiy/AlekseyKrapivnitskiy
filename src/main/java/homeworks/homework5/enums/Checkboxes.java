package homeworks.homework5.enums;

public enum Checkboxes {

    WATER(0, "Water"),
    EARTH(1, "Earth"),
    WIND(2, "Wind"),
    FIRE(3,"Fire");

    public int index;
    public String label;

    Checkboxes(int index, String label) {
        this.index = index;
        this.label = label;
    }

    public static Checkboxes getCheckbox(String checkbox) {
        for (Checkboxes checkboxItem : Checkboxes.values()) {
            if (checkboxItem.label.equals(checkbox)) {
                return checkboxItem;
            }
        }
        return null;
    }
}
