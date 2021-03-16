package biu.ac.il.Terminal;

public class Guest implements Role {
    @Override
    public String[] getAllowedCommands() {
        return new String[]{ "ls", "cd", "history" };
    }
}
