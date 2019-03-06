package homeworks.homework7.enums;

public enum Summary {

    ONE(1, "1"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8");

    public int value;
    public String label;

    Summary(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public static Summary getSummary(int summary) {
        for (Summary summaryValue : Summary.values()) {
            if (summaryValue.value == summary) {
                return summaryValue;
            }
        }
        return null;
    }
}
