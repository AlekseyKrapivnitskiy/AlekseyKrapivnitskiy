package homeworks.homework10.errorsTests;

import homeworks.homework10.QueryParamBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static homeworks.homework10.enums.Errors.ERROR_UNKNOWN_WORD;
import static homeworks.homework10.enums.Language.*;
import static homeworks.homework10.requests.CheckTexts.checkTexts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class UnknownWordTest {

    @Test
    public void unknownWordRuTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        String wordInRequest = "марковь";
        queryParams.language(RU).texts(wordInRequest);

        //send request
        Response response = checkTexts(queryParams);

        //get data from response
        List<List> code = response.getBody().jsonPath().getList("code");
        List<List> word = response.getBody().jsonPath().getList("word");

        //assertions
        assertThat(code.get(0).get(0), equalTo(ERROR_UNKNOWN_WORD.code));
        assertThat(word.get(0).get(0), equalTo(wordInRequest));
    }

    @Test
    public void unknownWordEnTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        String wordInRequest = "tamoto";
        queryParams.language(EN).texts(wordInRequest);

        //send request
        Response response = checkTexts(queryParams);

        //get data from response
        List<List> code = response.getBody().jsonPath().getList("code");
        List<List> word = response.getBody().jsonPath().getList("word");

        //assertions
        assertThat(code.get(0).get(0), equalTo(ERROR_UNKNOWN_WORD.code));
        assertThat(word.get(0).get(0), equalTo(wordInRequest));
    }

    @Test
    public void unknownWordUkTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        String wordInRequest = "превіт";
        queryParams.language(UK).texts(wordInRequest);

        //send request
        Response response = checkTexts(queryParams);

        //get data from response
        List<List> code = response.getBody().jsonPath().getList("code");
        List<List> word = response.getBody().jsonPath().getList("word");

        //assertions
        assertThat(code.get(0).get(0), equalTo(ERROR_UNKNOWN_WORD.code));
        assertThat(word.get(0).get(0), equalTo(wordInRequest));
    }
}
