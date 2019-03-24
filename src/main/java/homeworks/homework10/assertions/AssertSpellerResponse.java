package homeworks.homework10.assertions;

import homeworks.homework10.bodies.SpellerResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AssertSpellerResponse {

    public static void assertSpellerResponse(SpellerResponse[][] spellerResponse, SpellerResponse expectedSpellerResponse) {
        assertThat(spellerResponse[0][0].getCode(), equalTo(expectedSpellerResponse.getCode()));
        assertThat(spellerResponse[0][0].getPos(), equalTo(expectedSpellerResponse.getPos()));
        assertThat(spellerResponse[0][0].getRow(), equalTo(expectedSpellerResponse.getRow()));
        assertThat(spellerResponse[0][0].getCol(), equalTo(expectedSpellerResponse.getCol()));
        assertThat(spellerResponse[0][0].getLen(), equalTo(expectedSpellerResponse.getLen()));
        assertThat(spellerResponse[0][0].getWord(), equalTo(expectedSpellerResponse.getWord()));
    }
}
