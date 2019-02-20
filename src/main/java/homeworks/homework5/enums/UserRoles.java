package homeworks.homework5.enums;

import java.util.ArrayList;
import java.util.List;

public enum UserRoles {

    ADMIN(0, "Admin"),
    USER(1, "User"),
    MANAGER(2,"Manager");

    public int index;
    public String label;

    UserRoles(int index, String label) {
        this.index = index;
        this.label = label;
    }

    public static List<String> getUserRoles() {
        List<String> listOfUsersRoles = new ArrayList<>();

        for (UserRoles userRoles : UserRoles.values()) {
            listOfUsersRoles.add(userRoles.label);
        }
        return listOfUsersRoles;
    }

    public static UserRoles getUserRole(String userRole) {
        for (UserRoles userRoleName : UserRoles.values()) {
            if (userRoleName.label.equals(userRole)) {
                return userRoleName;
            }
        }
        return null;
    }
}
