package biu.ac.il.Terminal;

public class Guest implements Role {
    @Override
    public String[] getAllowedCommands() {
        return new String[]{ "help", "ls", "cd", "history", "print", "calc", "login", "movie" };
    }
}
