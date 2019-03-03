package homeworks.homework7.enums;

public enum VegetablesList {

    CUCUMBER(0, "Cucumber"),
    TOMATO(1, "Tomato"),
    VEGETABLES(2, "VegetablesList"),
    ONION(3, "Onion");

    public int index;
    public String label;

    VegetablesList(int index, String label) {
        this.index = index;
        this.label = label;
    }
}
