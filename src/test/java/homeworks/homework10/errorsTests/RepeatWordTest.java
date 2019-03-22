package homeworks.homework10.errorsTests;

import homeworks.homework10.queryParamBuilder.QueryParamBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static homeworks.homework10.enums.Errors.ERROR_UNKNOWN_WORD;
import static homeworks.homework10.enums.Language.RU;
import static homeworks.homework10.requests.CheckTexts.checkTexts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RepeatWordTest {

    @Test
    public void repeatWordRuTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        String wordInRequest = "я полетел на на Кипр";
        queryParams.language(RU).options(8).texts(wordInRequest);

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
