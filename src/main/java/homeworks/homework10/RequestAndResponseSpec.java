package homeworks.homework10;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.HashMap;

import static homeworks.homework10.TestProperties.getTestProperty;

public class RequestAndResponseSpec {

    public HashMap<String, Object> params = new HashMap<>();

    public static RequestSpecification requestSpec(){
        return new RequestSpecBuilder()
                .setAccept(ContentType.XML)
                .setBaseUri(getTestProperty("baseUrl"))
                .build();
    }

    public static ResponseSpecification successResponseSpec() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static SendRequest with() {
        RequestAndResponseSpec request = new RequestAndResponseSpec();
        return new SendRequest(request);
    }
}
