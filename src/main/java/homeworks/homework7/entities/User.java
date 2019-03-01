package homeworks.homework7.entities;


public class User{

    private String login;
    private String password;
    private String username;

    private User(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;
    }

    public static User PITER_CHAILOVSKII = new User("epam", "1234", "PITER CHAILOVSKII");

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
