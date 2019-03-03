package homeworks.homework7.enums;

public enum ResultsList {

    SUMMARY("Summary: "),
    COLOR("Color: "),
    METAL("Metal: "),
    VEGETABLES("Vegetables: ");

    public String label;

    ResultsList(String label) {
        this.label = label;
    }
}
