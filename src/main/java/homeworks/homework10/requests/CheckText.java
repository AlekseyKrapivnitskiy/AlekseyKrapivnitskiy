package homeworks.homework10.requests;

import homeworks.homework10.queryParamBuilder.QueryParamBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static homeworks.homework10.enums.Endpoints.CHECK_TEXT;
import static homeworks.homework10.specifications.RequestSpec.requestSpec;
import static homeworks.homework10.specifications.ResponseSpec.successResponseSpec;
import static homeworks.homework10.testResources.TestProperties.getTestProperty;

public class CheckText {

    public static Response checkText(QueryParamBuilder queryParamBuilder) {
        return RestAssured
                .given()
                .queryParams(queryParamBuilder.params)
                .spec(requestSpec())
                .when()
                .get(getTestProperty("baseUrl") + CHECK_TEXT.endpoint).prettyPeek()
                .then()
                .spec(successResponseSpec())
                .extract()
                .response();
    }
}
