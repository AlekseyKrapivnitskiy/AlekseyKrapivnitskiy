package homeworks.homework3.enums;


// TODO I suggest move all enums to separate package -- fixed
public enum BenefitTexts {

    // TODO It will be better if each text have separate enum value -- fixed
    PRACTISE("To include good practices\n" + "and ideas from successful\n" + "EPAM project"),
    CUSTOMIZE("To be flexible and\n" + "customizable"),
    MULTIPLATFORM("To be multiplatform"),
    BASE("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

    public String text;

    BenefitTexts(String  text) {
        this.text = text;
    }
}