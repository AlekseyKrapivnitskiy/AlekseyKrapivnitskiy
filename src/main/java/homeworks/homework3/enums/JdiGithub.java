package homeworks.homework3.enums;

public enum JdiGithub {

    // TODO I guess you could combine this and IndexPageData enum into one
    JDI_GITHUB("JDI GITHUB", "https://github.com/epam/JDI");

    public String title;
    public String link;

    JdiGithub(String title, String link) {
        this.title = title;
        this.link = link;
    }
}
