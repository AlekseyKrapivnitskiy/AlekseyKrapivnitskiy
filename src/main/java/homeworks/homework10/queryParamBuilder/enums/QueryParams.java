package homeworks.homework10.queryParamBuilder.enums;

public enum QueryParams {

    TEXT("text"),
    LANG("lang"),
    OPTIONS("options");

    public String queryParam;

    QueryParams(String queryParam) {
        this.queryParam = queryParam;
    }
}
