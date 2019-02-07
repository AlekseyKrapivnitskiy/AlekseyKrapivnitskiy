package homeworks.homework3;

public enum BenefitTexts {

    BENEFIT_TEXTS("To include good practices\n" + "and ideas from successful\n" + "EPAM project",
            "To be flexible and\n" + "customizable", "To be multiplatform", "Already have good base\n" +
            "(about 20 internal and\n" + "some external projects),\n" +
            "wish to get more…");

    public String practise;
    public String custom;
    public String multiplatform;
    public String base;

    BenefitTexts(String practise, String custom, String multiplatform, String base) {
        this.practise = practise;
        this.custom = custom;
        this.multiplatform = multiplatform;
        this.base = base;
    }
}