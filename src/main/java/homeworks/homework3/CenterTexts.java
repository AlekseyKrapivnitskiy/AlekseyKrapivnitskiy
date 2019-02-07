package homeworks.homework3;

public enum CenterTexts {

    CENTER_TEXTS("EPAM FRAMEWORK WISHES…", "LOREM IPSUM DOLOR SIT AMET, " +
            "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
            "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA " +
            "COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE " +
            "EU FUGIAT NULLA PARIATUR.");

    public String title;
    public String text;

    CenterTexts(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
