package homeworks.homework8.enums;

public enum Results {

    SUMMARY("Summary: "),
    ELEMENTS("Elements: "),
    COLOR("Color: "),
    METAL("Metal: "),
    VEGETABLES("Vegetables: ");

    public String label;

    Results(String label) {
        this.label = label;
    }
}
