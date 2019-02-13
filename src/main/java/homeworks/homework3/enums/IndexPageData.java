package homeworks.homework3.enums;

public enum IndexPageData {

    // TODO I guess you could combine this and IndexPageData enum into one -- fixed
    INDEX_PAGE_DATA("https://epam.github.io/JDI/index.html", "Home Page"),
    JDI_GITHUB("https://github.com/epam/JDI","JDI GITHUB");

    public String url;
    public String title;

    IndexPageData(String url, String title) {
        this.url = url;
        this.title = title;
    }
}
