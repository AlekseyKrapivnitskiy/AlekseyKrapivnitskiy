package homeworks.homework10.queryParamBuilder;

import homeworks.homework10.queryParamBuilder.enums.Language;
import homeworks.homework10.specifications.RequestAndResponseSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.stream.IntStream;

import static homeworks.homework10.queryParamBuilder.enums.QueryParams.*;
import static homeworks.homework10.testResources.TestProperties.getTestProperty;

public class SendRequest {

    RequestAndResponseSpec requestAndResponseSpec;

    public SendRequest(RequestAndResponseSpec gcApi) {
        requestAndResponseSpec = gcApi;
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
