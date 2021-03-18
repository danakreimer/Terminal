package biu.ac.il.Terminal;

public interface CommandExecutor {
    void runCommand(String cmd, String[] args) throws UnknownCommandException, NoPermissionsException, CommandExecutionException;
}
