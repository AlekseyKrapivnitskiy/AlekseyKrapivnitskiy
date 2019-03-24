package homeworks.homework10;

import homeworks.homework10.bodies.SpellerResponse;
import homeworks.homework10.queryParamBuilder.QueryParamBuilder;
import org.testng.annotations.Test;

import static homeworks.homework10.assertions.AssertSpellerResponse.assertSpellerResponse;
import static homeworks.homework10.testResources.ExpectedSpellerResponse.setExpectedSpellerResponse;
import static homeworks.homework10.enums.Errors.ERROR_UNKNOWN_WORD;
import static homeworks.homework10.enums.Language.*;
import static homeworks.homework10.requests.CheckTexts.checkTexts;
import static homeworks.homework10.testResources.TestData.*;

public class RepeatWordTest {

    @Test
    public void repeatWordRuTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(RU).options(8).texts(PHRASE_WITH_REPEAT_WORD_TEST_RU.word);

        //send request and assert response
        assertSpellerResponse(checkTexts(queryParams).body().as(SpellerResponse[][].class),
                setExpectedSpellerResponse(ERROR_UNKNOWN_WORD.code, REPEAT_WORD_TEST_RU.word));
    }

    @Test
    public void repeatWordEnTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(EN).options(8).texts(PHRASE_WITH_REPEAT_WORD_TEST_EN.word);

        //send request and assert response
        assertSpellerResponse(checkTexts(queryParams).body().as(SpellerResponse[][].class),
                setExpectedSpellerResponse(ERROR_UNKNOWN_WORD.code, REPEAT_WORD_TEST_EN.word));
    }

    @Test
    public void repeatWordUkTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(UK).options(8).texts(PHRASE_WITH_REPEAT_WORD_TEST_UK.word);

        //send request and assert response
        assertSpellerResponse(checkTexts(queryParams).body().as(SpellerResponse[][].class),
                setExpectedSpellerResponse(ERROR_UNKNOWN_WORD.code, REPEAT_WORD_TEST_UK.word));
    }
}
