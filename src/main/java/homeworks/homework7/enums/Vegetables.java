package homeworks.homework7.enums;

public enum Vegetables {

    CUCUMBER(0, "Cucumber"),
    TOMATO(1, "Tomato"),
    VEGETABLE(2, "Vegetables"),
    ONION(3, "Onion");

    public int index;
    public String label;

    Vegetables(int index, String label) {
        this.index = index;
        this.label = label;
    }
}
