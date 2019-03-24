package homeworks.homework10;

import homeworks.homework10.bodies.SpellerResponse;
import homeworks.homework10.queryParamBuilder.QueryParamBuilder;
import org.testng.annotations.Test;

import static homeworks.homework10.assertions.AssertSpellerResponse.assertSpellerResponse;
import static homeworks.homework10.enums.Errors.ERROR_UNKNOWN_WORD;
import static homeworks.homework10.enums.Language.RU;
import static homeworks.homework10.requests.CheckTexts.checkTexts;
import static homeworks.homework10.testResources.ExpectedSpellerResponse.setExpectedSpellerResponse;
import static homeworks.homework10.testResources.TestData.CHECK_TEXTS_TEST_RU_CORRECT_WORD;
import static homeworks.homework10.testResources.TestData.CHECK_TEXTS_TEST_RU_WRONG_WORD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckTextsTest {

    @Test
    public void checkTextsTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(RU).texts(CHECK_TEXTS_TEST_RU_WRONG_WORD.word);

        //send request
        SpellerResponse[][] spellerResponse = checkTexts(queryParams).body().as(SpellerResponse[][].class);

        //assertion of response attributes
        assertSpellerResponse(spellerResponse, setExpectedSpellerResponse(ERROR_UNKNOWN_WORD.code,
                CHECK_TEXTS_TEST_RU_WRONG_WORD.word));
        assertThat(spellerResponse[0][0].getS().get(0), equalTo(CHECK_TEXTS_TEST_RU_CORRECT_WORD.word));
    }
}
