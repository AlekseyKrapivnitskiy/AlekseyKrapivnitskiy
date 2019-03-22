package homeworks.homework10.specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static homeworks.homework10.TestProperties.getTestProperty;

public class RequestSpec {

    public static RequestSpecification requestSpec(){
        return new RequestSpecBuilder()
                .setAccept(ContentType.XML)
                .setBaseUri(getTestProperty("baseUrl"))
                .log(LogDetail.ALL)
                .build();
    }
}
