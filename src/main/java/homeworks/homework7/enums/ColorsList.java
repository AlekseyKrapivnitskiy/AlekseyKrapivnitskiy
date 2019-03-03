package homeworks.homework7.enums;

public enum ColorsList {

    COLORS(0, "Colors"),
    RED(1, "Red"),
    GREEN(2, "Green"),
    BLUE(3, "Blue"),
    YELLOW(4, "Yellow");

    public int index;
    public String label;

    ColorsList(int index, String label) {
        this.index = index;
        this.label = label;
    }
}
