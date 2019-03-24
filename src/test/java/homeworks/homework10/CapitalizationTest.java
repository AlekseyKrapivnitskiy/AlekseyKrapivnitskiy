package homeworks.homework10;

import static homeworks.homework10.enums.Errors.ERROR_CAPITALIZATION;
import static homeworks.homework10.enums.Language.EN;
import static homeworks.homework10.enums.Language.RU;
import static homeworks.homework10.enums.Language.UK;
import static homeworks.homework10.requests.CheckTexts.checkTexts;
import static homeworks.homework10.testResources.TestData.CAPITALIZATION_TEST_EN;
import static homeworks.homework10.testResources.TestData.CAPITALIZATION_TEST_RU;
import static homeworks.homework10.testResources.TestData.CAPITALIZATION_TEST_UK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import homeworks.homework10.bodies.SpellerResponse;
import homeworks.homework10.queryParamBuilder.QueryParamBuilder;
import org.testng.annotations.Test;

//todo все хорошо за исключением главного - нет pojo класса
// 1. добавить pojo класс -- поправил
//2. построить часть проверок на сравнении дессериализованного объекта из ответа сервиса и expected сущности, заданной в тесте
//-- поправил
public class CapitalizationTest {

    @Test
    public void capitalizationRuTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(RU).texts(CAPITALIZATION_TEST_RU.word);

        //send request
        SpellerResponse[][] spellerResponse = checkTexts(queryParams).body().as(SpellerResponse[][].class);

        //assertions
        assertThat(spellerResponse[0][0].getCode(), equalTo(ERROR_CAPITALIZATION.code));
        assertThat(spellerResponse[0][0].getPos(), equalTo(0));
        assertThat(spellerResponse[0][0].getRow(), equalTo(0));
        assertThat(spellerResponse[0][0].getCol(), equalTo(0));
        assertThat(spellerResponse[0][0].getLen(), equalTo(CAPITALIZATION_TEST_RU.word.length()));
        assertThat(spellerResponse[0][0].getWord(), equalTo(CAPITALIZATION_TEST_RU.word));
    }

    @Test
    public void capitalizationEnTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(EN).texts(CAPITALIZATION_TEST_EN.word);

        //send request
        SpellerResponse[][] spellerResponse = checkTexts(queryParams).body().as(SpellerResponse[][].class);

        //assertions
        //todo очень много однотипный проверок. приведи все к одной проверки 
        //assertThat(spellerReponse[0][0], equalTo(expectedSpellerResonse)), где expectedSpellerResonse инициализируй предварительно
        //ну или свой асершен, например, assertSpellerResponce(checkTexts(queryParams).body(), expectedSpellerResonse) (ну как вариант)
        assertThat(spellerResponse[0][0].getCode(), equalTo(ERROR_CAPITALIZATION.code));
        assertThat(spellerResponse[0][0].getPos(), equalTo(0));
        assertThat(spellerResponse[0][0].getRow(), equalTo(0));
        assertThat(spellerResponse[0][0].getCol(), equalTo(0));
        assertThat(spellerResponse[0][0].getLen(), equalTo(CAPITALIZATION_TEST_EN.word.length()));
        assertThat(spellerResponse[0][0].getWord(), equalTo(CAPITALIZATION_TEST_EN.word));
    }

    @Test
    public void capitalizationUkTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(UK).texts(CAPITALIZATION_TEST_UK.word);

        //send request
        SpellerResponse[][] spellerResponse = checkTexts(queryParams).body().as(SpellerResponse[][].class);

        //assertions
        assertThat(spellerResponse[0][0].getCode(), equalTo(ERROR_CAPITALIZATION.code));
        assertThat(spellerResponse[0][0].getPos(), equalTo(0));
        assertThat(spellerResponse[0][0].getRow(), equalTo(0));
        assertThat(spellerResponse[0][0].getCol(), equalTo(0));
        assertThat(spellerResponse[0][0].getLen(), equalTo(CAPITALIZATION_TEST_UK.word.length()));
        assertThat(spellerResponse[0][0].getWord(), equalTo(CAPITALIZATION_TEST_UK.word));
    }
}
