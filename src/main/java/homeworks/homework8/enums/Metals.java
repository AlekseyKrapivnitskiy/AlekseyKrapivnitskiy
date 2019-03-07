package homeworks.homework8.enums;

public enum Metals {

    METALS(0, "Metals"),
    GOLD(1, "Gold"),
    SILVER(2,"Silver"),
    BRONZE(3, "Bronze"),
    SELEN(4, "Selen");

    public int index;
    public String label;

    Metals(int index, String label) {
        this.index = index;
        this.label = label;
    }
}
