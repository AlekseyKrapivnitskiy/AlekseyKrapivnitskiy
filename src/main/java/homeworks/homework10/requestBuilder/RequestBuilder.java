package homeworks.homework10.requestBuilder;

import homeworks.homework10.requestBuilder.enums.Language;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

import static homeworks.homework10.requestBuilder.enums.Params.*;
import static homeworks.homework10.testResources.TestProperties.getTestProperty;

public class RequestBuilder {

    private HashMap<String, String> params = new HashMap<String, String>();
    private RequestBuilder requestBuilder;

    public RequestBuilder text(String text) {
        requestBuilder.params.put(TEXT.param, text);
        return this;
    }

    public RequestBuilder options(String options) {
        requestBuilder.params.put(OPTIONS.param, options);
        return this;
    }

    public RequestBuilder language(Language language) {
        requestBuilder.params.put(LANG.param, language.value);
        return this;
    }

    public Response sendGetRequest() {
        return RestAssured.with()
                .queryParams(requestBuilder.params)
                .log().all()
                .get(getTestProperty("baseUrl")).prettyPeek();
    }
}
