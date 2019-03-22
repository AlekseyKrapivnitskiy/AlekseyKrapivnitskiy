package homeworks.homework10.queryParamBuilder;

import homeworks.homework10.enums.Language;

import java.util.HashMap;

import static homeworks.homework10.enums.QueryParams.*;

public class QueryParamBuilder {

    public HashMap<String, Object> params = new HashMap<>();

    public QueryParamBuilder texts(String text) {
        params.put(TEXT.value, text);
        return this;
    }

    public QueryParamBuilder options(int option) {
        params.put(OPTIONS.value, option);
        return this;
    }

    public QueryParamBuilder language(Language language) {
        params.put(LANG.value, language.value);
        return this;
    }
}
