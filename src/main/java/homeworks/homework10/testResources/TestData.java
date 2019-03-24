package homeworks.homework10.testResources;

public enum TestData {

    UNKNOWN_WORD_TEST_RU("марковь"),
    UNKNOWN_WORD_TEST_EN("tamoto"),
    UNKNOWN_WORD_TEST_UK("превіт"),

    PHRASE_WITH_REPEAT_WORD_TEST_RU("я полетел на на Кипр"),
    REPEAT_WORD_TEST_RU("на"),
    PHRASE_WITH_REPEAT_WORD_TEST_EN("lets go go to the north"),
    REPEAT_WORD_TEST_EN("go"),
    PHRASE_WITH_REPEAT_WORD_TEST_UK("Привіт як як справи"),
    REPEAT_WORD_TEST_UK("як"),

    CAPITALIZATION_TEST_RU("санкт-петербург"),
    CAPITALIZATION_TEST_EN("saint petersburg"),
    CAPITALIZATION_TEST_UK("санкт-петербург"),

    CHECK_TEXTS_TEST_RU_WRONG_WORD("памидор"),
    CHECK_TEXTS_TEST_RU_CORRECT_WORD("помидор");

    public String word;

    TestData(String word) {
        this.word = word;
    }
}
