package homeworks.homework4.enums;

public enum Colors {

    RED(0, "Red"),
    GREEN(1, "Green"),
    BLUE(2, "Blue"),
    YELLOW(3, "Yellow");

    public int index;
    public String label;

    Colors(int index, String label) {
        this.index = index;
        this.label = label;
    }
}
