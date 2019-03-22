package homeworks.homework10.enums;

public enum  Endpoints {

    CHECK_TEXT("/checkText"),
    CHECK_TEXTS("/checkTexts");

    public String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }
}
