package biu.ac.il.Terminal;

import java.util.Arrays;
import java.util.stream.Stream;

public class Admin extends Guest implements Role {
    @Override
    public String[] getAllowedCommands() {
        String[] parentCommand = super.getAllowedCommands();
        String[] adminCommands = new String[] { "calc" };
        Stream adminStream = Arrays.stream(adminCommands);
        Stream parentStream =  Arrays.stream(parentCommand);

        return (String[]) Stream.concat(adminStream, parentStream).toArray();
    }
}
