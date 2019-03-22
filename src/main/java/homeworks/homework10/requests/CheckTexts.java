package homeworks.homework10.requests;

import homeworks.homework10.QueryParamBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

import static homeworks.homework10.TestProperties.getTestProperty;
import static homeworks.homework10.specifications.RequestSpec.requestSpec;
import static homeworks.homework10.specifications.ResponseSpec.successResponseSpec;

public class CheckTexts {

    public static Response checkTexts(QueryParamBuilder queryParamBuilder) {
        return RestAssured
                .given()
                        .queryParams(queryParamBuilder.params)
                        .spec(requestSpec())
                .when()
                        .get(getTestProperty("baseUrl")).prettyPeek()
                .then()
                        .spec(successResponseSpec())
                        .extract()
                        .response();
    }
}
