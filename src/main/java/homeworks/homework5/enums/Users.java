package homeworks.homework5.enums;

public enum Users {

    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String username;

    Users(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;
    }

    public static Users getUser(String username) {
        for (Users user : Users.values()) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }
}
