package homeworks.homework10.testResources;

public enum TestData {

    UNKNOWN_WORD_TEST_RU("марковь"),
    UNKNOWN_WORD_TEST_EN("tamoto"),
    UNKNOWN_WORD_TEST_UK("превіт"),
/*
    REPEAT_WORD_TEST_RU(),
    REPEAT_WORD_TEST_EN(),
    REPEAT_WORD_TEST_UK()*/;

    public String word;

    TestData(String word) {
        this.word = word;
    }
}
