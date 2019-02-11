package homeworks.homework3.enums;

public enum JdiGithub {

    // TODO I guess you could combine this and IndexPageData enum into one -- fixed
    // TODO What is fixed???
    JDI_GITHUB("JDI GITHUB", "https://github.com/epam/JDI");

    public String title;
    public String url;

    JdiGithub(String title, String url) {
        this.title = title;
        this.url = url;
    }
}
