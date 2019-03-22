package homeworks.homework10.requests;

import homeworks.homework10.queryParamBuilder.QueryParamBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static homeworks.homework10.enums.Endpoints.CHECK_TEXTS;
import static homeworks.homework10.testResources.TestProperties.getTestProperty;
import static homeworks.homework10.specifications.RequestSpec.requestSpec;
import static homeworks.homework10.specifications.ResponseSpec.successResponseSpec;

public class CheckTexts {

    public static Response checkTexts(QueryParamBuilder queryParamBuilder) {
        return RestAssured
                .given()
                        .queryParams(queryParamBuilder.params)
                        .spec(requestSpec())
                .when()
                        .get(getTestProperty("baseUrl") + CHECK_TEXTS.endpoint).prettyPeek()
                .then()
                        .spec(successResponseSpec())
                        .extract()
                        .response();
    }
}
