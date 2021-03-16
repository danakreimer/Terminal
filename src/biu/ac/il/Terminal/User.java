package biu.ac.il.Terminal;

import java.util.Arrays;

public class User {
    private Role[] roles;

    public User(Role[] roles) {
        super();
        this.roles = roles;
    }

    public boolean canRunCommand(String command) {
        return Arrays.stream(roles).anyMatch(role ->
                Arrays.asList(role.getAllowedCommands()).contains(command));
    }
}
