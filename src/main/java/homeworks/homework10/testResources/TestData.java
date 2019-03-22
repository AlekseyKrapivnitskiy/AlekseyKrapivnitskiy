package homeworks.homework10.testResources;

public enum TestData {

    UNKNOWN_WORD_TEST_RU("марковь"),
    UNKNOWN_WORD_TEST_EN("tamoto"),
    UNKNOWN_WORD_TEST_UK("превіт"),

    REPEAT_WORD_TEST_RU("я полетел на на Кипр"),
    REPEAT_WORD_TEST_EN("lets go go to the north"),
    REPEAT_WORD_TEST_UK("Привіт як як справи"),

    CAPITALIZATION_TEST_RU("санкт-петербург"),
    CAPITALIZATION_TEST_EN("saint petersburg"),
    CAPITALIZATION_TEST_UK("санкт-петербург");

    public String word;

    TestData(String word) {
        this.word = word;
    }
}
