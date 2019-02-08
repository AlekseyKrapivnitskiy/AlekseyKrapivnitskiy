package homeworks.homework3.enums;

public enum IndexPageData {

    INDEX_PAGE_URL("https://epam.github.io/JDI/index.html"),
    INDEX_PAGE_TITLE("Home Page");

    public String text;

    IndexPageData(String text) {
        this.text = text;
    }
}
