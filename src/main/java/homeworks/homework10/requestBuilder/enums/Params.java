package homeworks.homework10.requestBuilder.enums;

public enum  Params {

    TEXT("text"),
    LANG("lang"),
    OPTIONS("options");

    public String param;

    Params(String param) {
        this.param = param;
    }
}
