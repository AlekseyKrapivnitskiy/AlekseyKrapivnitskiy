package homeworks.homework4.enums;

public enum Radiobuttons {

    GOLD(0, "Gold"),
    SILVER(1, "Silver"),
    BRONZE(2, "BRONZE"),
    SELEN(3, "Selen");

    public int index;
    public String label;

    Radiobuttons(int index, String label) {
        this.index = index;
        this.label = label;
    }
}
