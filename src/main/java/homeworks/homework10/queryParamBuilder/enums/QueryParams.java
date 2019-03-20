package homeworks.homework10.queryParamBuilder.enums;

public enum QueryParams {

    TEXT("text"),
    LANG("lang"),
    OPTIONS("options");

    public String value;

    QueryParams(String value) {
        this.value = value;
    }
}
