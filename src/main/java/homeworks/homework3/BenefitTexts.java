package homeworks.homework3;


// TODO I suggest move all enums to separate package
public enum BenefitTexts {

    // TODO It will be better if each text have separate enum value
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