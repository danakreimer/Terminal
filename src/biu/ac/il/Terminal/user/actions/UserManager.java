package biu.ac.il.Terminal.user.actions;

import biu.ac.il.Terminal.interfaces.Role;
import biu.ac.il.Terminal.model.Admin;
import biu.ac.il.Terminal.model.Guest;
import biu.ac.il.Terminal.model.User;

import java.util.HashMap;

public class UserManager {
    private static UserManager instance = null;
    private User user;
    private HashMap<String, User> users = new HashMap<String, User>();

    private UserManager() {
        super();
        Role[] adminRoles = { new Admin() };
        Role[] guestRoles = { new Guest() };
        users.put("admin", new User(adminRoles));
        users.put("guest", new User(guestRoles));
    }

    public static UserManager getInsance() {
        if (instance == null) {
            instance = new UserManager();
            instance.login("guest");
        }

        return instance;
    }

    public User getUser() {
        return this.user;
    }

    public User login(String key) {
        User u = users.get(key);
        this.user = u;

        return u;
    }
}
