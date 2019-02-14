package homeworks.homework4.enums;

import java.util.ArrayList;
import java.util.List;

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

    public static List<String> getServiceDopdownList() {
        List<String> listServiceDropdownTexts = new ArrayList<>();

        for (Service service : Service.values()) {
            listServiceDropdownTexts.add(service.text);
        }
        return listServiceDropdownTexts;
    }
}
