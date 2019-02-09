package homeworks.homework4.enums;

public enum Service {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLES_WITH_PAGE("Tables With Pages"),
    DIFFERENT_ELEMENTS("Different Elements");

    public String text;

    Service(String text) {
        this.text = text;
    }
}
