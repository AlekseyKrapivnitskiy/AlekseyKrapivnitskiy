package homeworks.homework10.apiBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

import static homeworks.homework10.testResources.TestProperties.getTestProperty;

public class SendRequest {

    public Response sendGetRequest(HashMap<String, String> params) {
        return RestAssured.with()
                .queryParams(params)
                .log().all()
                .get(getTestProperty("baseUrl")).prettyPeek();
    }
}
