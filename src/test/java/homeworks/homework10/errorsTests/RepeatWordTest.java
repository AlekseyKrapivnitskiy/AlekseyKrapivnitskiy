package homeworks.homework10.errorsTests;

import homeworks.homework10.queryParamBuilder.QueryParamBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static homeworks.homework10.enums.Errors.ERROR_UNKNOWN_WORD;
import static homeworks.homework10.enums.Language.*;
import static homeworks.homework10.requests.CheckTexts.checkTexts;
import static homeworks.homework10.testResources.TestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RepeatWordTest {

    @Test
    public void repeatWordRuTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(RU).options(8).texts(REPEAT_WORD_TEST_RU.word);

        //send request
        Response response = checkTexts(queryParams);

        //get data from response
        List<List> code = response.getBody().jsonPath().getList("code");

        //assertions
        assertThat(code.get(0).get(0), equalTo(ERROR_UNKNOWN_WORD.code));
    }

    @Test
    public void repeatWordEnTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(EN).options(8).texts(REPEAT_WORD_TEST_EN.word);

        //send request
        Response response = checkTexts(queryParams);

        //get data from response
        List<List> code = response.getBody().jsonPath().getList("code");

        //assertions
        assertThat(code.get(0).get(0), equalTo(ERROR_UNKNOWN_WORD.code));
    }

    @Test
    public void repeatWordUkTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(UK).options(8).texts(REPEAT_WORD_TEST_UK.word);

        //send request
        Response response = checkTexts(queryParams);

        //get data from response
        List<List> code = response.getBody().jsonPath().getList("code");

        //assertions
        assertThat(code.get(0).get(0), equalTo(ERROR_UNKNOWN_WORD.code));
    }
}
