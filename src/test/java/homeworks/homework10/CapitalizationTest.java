package homeworks.homework10;

import static homeworks.homework10.assertions.AssertSpellerResponse.assertSpellerResponse;
import static homeworks.homework10.enums.Errors.ERROR_CAPITALIZATION;
import static homeworks.homework10.enums.Language.EN;
import static homeworks.homework10.enums.Language.RU;
import static homeworks.homework10.enums.Language.UK;
import static homeworks.homework10.requests.CheckTexts.checkTexts;
import static homeworks.homework10.testResources.ExpectedSpellerResponse.setExpectedSpellerResponse;
import static homeworks.homework10.testResources.TestData.*;

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

        //send request and assert response
        assertSpellerResponse(checkTexts(queryParams).body().as(SpellerResponse[][].class),
                setExpectedSpellerResponse(ERROR_CAPITALIZATION.code, CAPITALIZATION_TEST_RU.word));
    }

    @Test
    public void capitalizationEnTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(EN).texts(CAPITALIZATION_TEST_EN.word);

        //todo очень много однотипный проверок. приведи все к одной проверки  -- поправил
        //assertThat(spellerReponse[0][0], equalTo(expectedSpellerResonse)), где expectedSpellerResonse инициализируй предварительно
        //ну или свой асершен, например, assertSpellerResponce(checkTexts(queryParams).body(), expectedSpellerResonse) (ну как вариант)

        //send request and assert response
        assertSpellerResponse(checkTexts(queryParams).body().as(SpellerResponse[][].class),
                setExpectedSpellerResponse(ERROR_CAPITALIZATION.code, CAPITALIZATION_TEST_EN.word));
    }

    @Test
    public void capitalizationUkTest() {
        //make query params
        QueryParamBuilder queryParams = new QueryParamBuilder();
        queryParams.language(UK).texts(CAPITALIZATION_TEST_UK.word);

        //send request and assert response
        assertSpellerResponse(checkTexts(queryParams).body().as(SpellerResponse[][].class),
                setExpectedSpellerResponse(ERROR_CAPITALIZATION.code, CAPITALIZATION_TEST_UK.word));
    }
}
