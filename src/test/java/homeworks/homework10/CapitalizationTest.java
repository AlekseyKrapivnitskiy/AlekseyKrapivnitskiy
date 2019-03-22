package homeworks.homework10;

import homeworks.homework10.queryParamBuilder.QueryParamBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static homeworks.homework10.enums.Errors.ERROR_CAPITALIZATION;
import static homeworks.homework10.enums.Language.*;
import static homeworks.homework10.requests.CheckTexts.checkTexts;
import static homeworks.homework10.testResources.TestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CapitalizationTest {

    @Test
    public void capitalizationRuTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(RU).texts(CAPITALIZATION_TEST_RU.word);

        //send request
        Response response = checkTexts(queryParams);

        //get data from response
        List<List> code = response.getBody().jsonPath().getList("code");
        List<List> word = response.getBody().jsonPath().getList("word");

        //assertions
        assertThat(code.get(0).get(0), equalTo(ERROR_CAPITALIZATION.code));
        assertThat(word.get(0).get(0), equalTo(CAPITALIZATION_TEST_RU.word));
    }

    @Test
    public void capitalizationEnTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(EN).texts(CAPITALIZATION_TEST_EN.word);

        //send request
        Response response = checkTexts(queryParams);

        //get data from response
        List<List> code = response.getBody().jsonPath().getList("code");
        List<List> word = response.getBody().jsonPath().getList("word");

        //assertions
        assertThat(code.get(0).get(0), equalTo(ERROR_CAPITALIZATION.code));
        assertThat(word.get(0).get(0), equalTo(CAPITALIZATION_TEST_EN.word));
    }

    @Test
    public void capitalizationUkTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(UK).texts(CAPITALIZATION_TEST_UK.word);

        //send request
        Response response = checkTexts(queryParams);

        //get data from response
        List<List> code = response.getBody().jsonPath().getList("code");
        List<List> word = response.getBody().jsonPath().getList("word");

        //assertions
        assertThat(code.get(0).get(0), equalTo(ERROR_CAPITALIZATION.code));
        assertThat(word.get(0).get(0), equalTo(CAPITALIZATION_TEST_UK.word));
    }
}
