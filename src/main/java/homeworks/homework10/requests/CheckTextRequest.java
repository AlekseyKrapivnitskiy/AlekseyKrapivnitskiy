package homeworks.homework10.requests;

import homeworks.homework10.queryParamBuilder.RequestBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static homeworks.homework10.testResources.TestProperties.getTestProperty;

public class CheckTextRequest {

    public static Response checkText(RequestBuilder requestBuilder) {
        return RestAssured.with()
                .queryParams(requestBuilder.params)
                .log().all()
                .get(getTestProperty("baseUrl")).prettyPeek();
    }
}
