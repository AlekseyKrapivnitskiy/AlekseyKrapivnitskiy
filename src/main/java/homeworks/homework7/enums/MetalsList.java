package homeworks.homework7.enums;

public enum MetalsList {

    METALS(0, "Metals"),
    GOLD(1, "Gold"),
    SILVER(2,"Silver"),
    BRONZE(3, "Bronze"),
    SELEN(4, "Selen");

    public int index;
    public String label;

    MetalsList(int index, String label) {
        this.index = index;
        this.label = label;
    }
}
