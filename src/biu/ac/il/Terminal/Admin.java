package biu.ac.il.Terminal;

import java.util.Arrays;
import java.util.stream.Stream;

public class Admin extends Guest implements Role {
    @Override
    public String[] getAllowedCommands() {
        // Get all the Guest's commands
        String[] parentCommand = super.getAllowedCommands();
        // Add the Admin new commands
        String[] adminCommands = new String[] { "osinfo" };

        // Combine all the Admin's commands into one array
        return Stream.concat(Arrays.stream(parentCommand), Arrays.stream(adminCommands))
                .toArray(String[]::new);
    }
}
