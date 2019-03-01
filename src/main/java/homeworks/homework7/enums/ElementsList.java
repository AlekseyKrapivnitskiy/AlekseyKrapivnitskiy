package homeworks.homework7.enums;

public enum ElementsList {

    WATER(0, "Water"),
    EARTH(1, "Earth"),
    WIND(2, "Wind"),
    FIRE(3, "Fire");

    public int index;
    public String label;

    ElementsList(int index, String label) {
        this.index = index;
        this.label = label;
    }
}
