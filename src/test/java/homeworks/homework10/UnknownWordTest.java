package homeworks.homework10;

import homeworks.homework10.queryParamBuilder.RequestBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static homeworks.homework10.queryParamBuilder.enums.QueryParams.TEXT;
import static homeworks.homework10.requests.CheckTextRequest.checkText;

public class UnknownWordTest {

    @Test
    public void unknownWordTest() {
        RequestBuilder requestBuilder = new RequestBuilder();

        Response response = checkText(requestBuilder.setParam(TEXT, "марковь"));

        System.out.println(response.getBody().jsonPath().getList("[1]"));

        Assert.assertEquals(response.getBody().jsonPath().getInt(".code"), 1);
    }
}
