package homeworks.homework5.enums;

public enum IndexPageData {

    INDEX_PAGE_DATA("https://epam.github.io/JDI/", "Home Page");

    public String url;
    public String title;

    IndexPageData(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public static IndexPageData getIndexPageDataByTtitle(String indexPageDataName) {
        for (IndexPageData indexPageData : IndexPageData.values()) {
            if (indexPageData.title.equals(indexPageDataName)) {
                return indexPageData;
            }
        }
        return null;
    }
}
