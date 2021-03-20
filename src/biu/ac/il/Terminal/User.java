package biu.ac.il.Terminal;

import java.util.Arrays;
import java.util.stream.Stream;

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

    public String[] getAvailableCommands() {
        String[] commandsList = null;
        for (Role role : roles) {
            if (commandsList == null) {
                commandsList = role.getAllowedCommands();
            } else {
                commandsList = Stream.concat(Arrays.stream(commandsList), Arrays.stream(role.getAllowedCommands()))
                        .toArray(String[]::new);
            }
        }

        return commandsList;
    }
}
