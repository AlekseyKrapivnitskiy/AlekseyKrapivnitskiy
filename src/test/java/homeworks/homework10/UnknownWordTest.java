package homeworks.homework10;

import homeworks.homework10.enums.Language;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static homeworks.homework10.requests.CheckTexts.checkTexts;


public class UnknownWordTest {

    @Test
    public void unknownWordTest() {

        QueryParamBuilder queryParams = new QueryParamBuilder();

        Response response = checkTexts(queryParams.language(Language.EN));

       /* List<List> code = response.getBody().jsonPath().getList("code");

        Assert.assertEquals(code.get(0).get(0), 1);*/
    }
}
