package homeworks.homework10.testResources;

import homeworks.homework10.bodies.SpellerResponse;

public class ExpectedSpellerResponse {

    public static SpellerResponse setExpectedSpellerResponse(int errorCode, String word) {
        SpellerResponse expectedSpellerResponse = new SpellerResponse();
        expectedSpellerResponse.setCode(errorCode);
        expectedSpellerResponse.setPos(0);
        expectedSpellerResponse.setRow(0);
        expectedSpellerResponse.setCol(0);
        expectedSpellerResponse.setLen(word.length());
        expectedSpellerResponse.setWord(word);

        return expectedSpellerResponse;
    }
}
