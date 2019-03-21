package homeworks.homework10;

import homeworks.homework10.queryParamBuilder.RequestBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static homeworks.homework10.queryParamBuilder.enums.QueryParams.TEXT;
import static homeworks.homework10.requests.CheckTextRequest.checkText;

public class UnknownWordTest {

    @Test
    public void unknownWordTest() {
        RequestBuilder requestBuilder = new RequestBuilder();

        Response response = checkText(requestBuilder.setParam(TEXT, "марковь"));

        List<List> code = response.getBody().jsonPath().getList("code");

        Assert.assertEquals(code.get(0).get(0), 1);
    }
}
