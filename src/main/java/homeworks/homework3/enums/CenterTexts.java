package homeworks.homework3.enums;

public enum CenterTexts {

    // TODO It will be better if each text have separate enum value -- fixed
    TITLE("EPAM FRAMEWORK WISHES…"),
    MAIN_TEXT("LOREM IPSUM DOLOR SIT AMET, " +
            "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
            "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA " +
            "COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE " +
            "EU FUGIAT NULLA PARIATUR.");

    public String text;

    CenterTexts(String text) {
        this.text = text;
    }
}
