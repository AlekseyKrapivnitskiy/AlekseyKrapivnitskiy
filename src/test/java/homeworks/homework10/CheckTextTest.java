package homeworks.homework10;

import homeworks.homework10.bodies.SpellerResponse;
import homeworks.homework10.queryParamBuilder.QueryParamBuilder;
import org.testng.annotations.Test;

import static homeworks.homework10.enums.Errors.ERROR_UNKNOWN_WORD;
import static homeworks.homework10.enums.Language.EN;
import static homeworks.homework10.requests.CheckText.checkText;
import static homeworks.homework10.testResources.TestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckTextTest {

    @Test
    public void checkTextTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(EN).texts(CHECK_TEXT_TEST_RU_WRONG_WORD.word);

        //send request
        SpellerResponse[] spellerResponse = checkText(queryParams).body().as(SpellerResponse[].class);

        //assertions
        assertThat(spellerResponse[0].getCode(), equalTo(ERROR_UNKNOWN_WORD.code));
        assertThat(spellerResponse[0].getPos(), equalTo(0));
        assertThat(spellerResponse[0].getRow(), equalTo(0));
        assertThat(spellerResponse[0].getCol(), equalTo(0));
        assertThat(spellerResponse[0].getWord(), equalTo(CHECK_TEXT_TEST_RU_WRONG_WORD.word));
        assertThat(spellerResponse[0].getS().get(0), equalTo(CHECK_TEXT_TEST_RU_CORRECT_WORD.word));
    }
}
