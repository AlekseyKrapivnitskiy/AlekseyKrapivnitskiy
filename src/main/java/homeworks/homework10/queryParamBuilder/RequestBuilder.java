package homeworks.homework10.queryParamBuilder;

import homeworks.homework10.queryParamBuilder.enums.QueryParams;

import java.util.HashMap;

public class RequestBuilder {

    public HashMap<String, String> params = new HashMap<>();

    public RequestBuilder setParam(QueryParams param, String text) {
        params.put(param.queryParam, text);
        return this;
    }
}
