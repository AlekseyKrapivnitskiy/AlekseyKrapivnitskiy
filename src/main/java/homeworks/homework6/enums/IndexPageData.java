package homeworks.homework6.enums;

public enum IndexPageData {

    INDEX_PAGE_DATA("https://epam.github.io/JDI/", "Home Page");

    public String url;
    public String title;

    IndexPageData(String url, String title) {
        this.url = url;
        this.title = title;
    }
}
