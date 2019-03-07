package homeworks.homework8.entities;

import static homeworks.homework8.enums.Users.PITER_CHAILOVSKII;

public class User {

    public static User piterChailovskii = new User(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password,
            PITER_CHAILOVSKII.username);

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
