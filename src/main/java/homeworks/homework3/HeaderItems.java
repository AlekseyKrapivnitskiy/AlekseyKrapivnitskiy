package homeworks.homework3;

public enum HeaderItems {

    // TODO It will be better if each text have separate enum value
    HEADER_ITEMS("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    public String home;
    public String contactForm;
    public String service;
    public String metalsAndColors;

    HeaderItems(String home, String contactForm, String service, String metalsAndColors) {
        this.home = home;
        this.contactForm = contactForm;
        this.service = service;
        this.metalsAndColors = metalsAndColors;
    }
}