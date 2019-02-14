package homeworks.homework3.enums;


import java.util.ArrayList;
import java.util.List;

public enum BenefitTexts {

    PRACTISE("To include good practices\n" + "and ideas from successful\n" + "EPAM project"),
    CUSTOMIZE("To be flexible and\n" + "customizable"),
    MULTIPLATFORM("To be multiplatform"),
    BASE("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

    public String text;

    BenefitTexts(String  text) {
        this.text = text;
    }

    public static List<String> getBenefitTextsList() {
        List<String> listOfBenefitTexts = new ArrayList<>();

        for (BenefitTexts benefitTexts : BenefitTexts.values()) {
            listOfBenefitTexts.add(benefitTexts.text);
        }
        return listOfBenefitTexts;
    }
}