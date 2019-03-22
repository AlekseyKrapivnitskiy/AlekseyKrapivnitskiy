package homeworks.homework10;

import homeworks.homework10.enums.Language;

import java.util.HashMap;
import java.util.stream.IntStream;

import static homeworks.homework10.enums.QueryParams.*;

public class QueryParamBuilder {

    public HashMap<String, Object> params = new HashMap<>();

    public QueryParamBuilder texts(String text) {
        params.put(TEXT.value, text);
        return this;
    }

    public QueryParamBuilder options(int... options) {
        params.put(OPTIONS.value, Integer.toString(IntStream.of(options).sum()));
        return this;
    }

    public QueryParamBuilder language(Language language) {
        params.put(LANG.value, language.value);
        return this;
    }
}
