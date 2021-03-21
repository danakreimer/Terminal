package biu.ac.il.Terminal;

public class CommandRunnerProxy implements CommandExecutor {
    private CommandExecutor executor;

    public CommandRunnerProxy() {
        executor = new CommandRunner();
    }

    // Execute the command only if the current user has the suitable permissions
    public void runCommand(String cmd, String[] args) throws UnknownCommandException, NoPermissionsException,
            CommandExecutionException {
        if (!UserManager.getInstance().getUser().canRunCommand(cmd)) {
            throw new NoPermissionsException(cmd);
        }

        executor.runCommand(cmd, args);
    }
}
