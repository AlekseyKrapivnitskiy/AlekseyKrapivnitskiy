package homeworks.homework10;

import homeworks.homework10.bodies.SpellerResponse;
import homeworks.homework10.queryParamBuilder.QueryParamBuilder;
import org.testng.annotations.Test;

import static homeworks.homework10.enums.Errors.ERROR_UNKNOWN_WORD;
import static homeworks.homework10.enums.Language.EN;
import static homeworks.homework10.requests.CheckText.checkText;
import static homeworks.homework10.testResources.TestData.UNKNOWN_WORD_TEST_RU;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class CheckTextTest {

    @Test
    public void checkTextTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(EN).texts(UNKNOWN_WORD_TEST_RU.word);

        //send request
        SpellerResponse[] spellerResponses = checkText(queryParams).body().as(SpellerResponse[].class);

        //assertions
        assertThat(spellerResponses[0].getCode(), equalTo(ERROR_UNKNOWN_WORD.code));
        assertThat(spellerResponses[0].getWord(), equalTo(UNKNOWN_WORD_TEST_RU.word));
        assertThat(spellerResponses[0].getS().get(0), equalTo("морковь"));
    }
}
