package biu.ac.il.Terminal;

import java.util.Arrays;
import java.util.stream.Stream;

public class Admin extends Guest implements Role {
    @Override
    public String[] getAllowedCommands() {
        String[] parentCommand = super.getAllowedCommands();
        String[] adminCommands = new String[] { "osinfo" };

        return Stream.concat(Arrays.stream(parentCommand), Arrays.stream(adminCommands))
                .toArray(String[]::new);
    }
}
