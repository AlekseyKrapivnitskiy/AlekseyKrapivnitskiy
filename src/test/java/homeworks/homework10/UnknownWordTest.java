package homeworks.homework10;

import homeworks.homework10.queryParamBuilder.SendRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static homeworks.homework10.queryParamBuilder.enums.QueryParams.*;
import static homeworks.homework10.requests.CheckTextRequest.checkText;

public class UnknownWordTest {

    @Test
    public void unknownWordTest() {
        SendRequest requestBuilder = new SendRequest();

        Response response = checkText(requestBuilder.setParam(TEXT, "марковь, вадарасла, москва").setParam(OPTIONS, "2")
                );

        List<List> code = response.getBody().jsonPath().getList("code");

        Assert.assertEquals(code.get(0).get(0), 1);
    }
}
