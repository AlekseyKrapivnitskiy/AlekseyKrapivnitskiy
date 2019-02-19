package homeworks.homework6.enums;

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
}
