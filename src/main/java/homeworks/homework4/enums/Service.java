package homeworks.homework4.enums;

import java.util.ArrayList;
import java.util.List;

public enum Service {

    SUPPORT(1, "Support"),
    DATES(2, "Dates"),
    COMPLEX_TABLE(3,"Complex Table"),
    SIMPLE_TABLE(4,"Simple Table"),
    TABLES_WITH_PAGE(5,"Tables With Pages"),
    DIFFERENT_ELEMENTS(6,"Different Elements"),
    PERFORMANCE(7,"Performance");

    public int index;
    public String label;

    Service(int index, String text) {
        this.index = index;
        this.label = text;
    }

    public static List<String> getServiceDropdownList() {
        List<String> listServiceDropdownTexts = new ArrayList<>();

        for (Service service : Service.values()) {
            listServiceDropdownTexts.add(service.label);
        }
        return listServiceDropdownTexts;
    }
}
