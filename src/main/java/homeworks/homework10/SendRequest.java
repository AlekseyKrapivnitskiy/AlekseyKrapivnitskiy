package homeworks.homework10;

import homeworks.homework10.enums.Language;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.stream.IntStream;

import static homeworks.homework10.enums.QueryParams.*;
import static homeworks.homework10.TestProperties.getTestProperty;

public class SendRequest {

    RequestAndResponseSpec requestAndResponseSpec;

    SendRequest(RequestAndResponseSpec spec) {
        requestAndResponseSpec = spec;
    }

    public SendRequest texts(String text) {
        requestAndResponseSpec.params.put(TEXT.value, text);
        return this;
    }

    public SendRequest options(int... options) {
        requestAndResponseSpec.params.put(OPTIONS.value, Integer.toString(IntStream.of(options).sum()));
        return this;
    }

    public SendRequest language(Language language) {
        requestAndResponseSpec.params.put(LANG.value, language.value);
        return this;
    }

    public Response getCheckTexts() {
        return RestAssured.with()
                .queryParams(requestAndResponseSpec.params)
                .log().all()
                .get(getTestProperty("baseUrl")).prettyPeek();
    }

    public Response getCheckText() {
        return RestAssured.with()
                .queryParams(requestAndResponseSpec.params)
                .log().all()
                .get(getTestProperty("baseUrl")).prettyPeek();
    }
}
