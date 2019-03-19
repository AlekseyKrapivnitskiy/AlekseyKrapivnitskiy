package homeworks.homework10.specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static homeworks.homework10.testResources.TestProperties.getTestProperty;

public class RequestSpec {

    public static RequestSpecification baseRequestConfiguration(){
        return new RequestSpecBuilder()
                .setAccept(ContentType.XML)
                .setBaseUri(getTestProperty("baseUrl"))
                .build();
    }
}
