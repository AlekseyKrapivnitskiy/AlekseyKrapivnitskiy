package homeworks.homework3.enums;

public enum JdiGithub {

    // TODO I guess you could combine this and IndexPageData enum into one -- fixed
    JDI_GITHUB_TITLE("JDI GITHUB"),
    JDI_GITHUB_LINK("https://github.com/epam/JDI");

    public String text;

    JdiGithub(String text) {
        this.text = text;
    }
}
