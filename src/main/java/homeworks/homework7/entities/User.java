package homeworks.homework7.entities;

public class User {

    public static User PITER_CHAILOVSKII = new User("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String username;

    User(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
