package biu.ac.il.Terminal;

public class CommandRunnerProxy implements CommandExecutor {
    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandRunnerProxy() {
        executor = new CommandRunner();
    }

    public void runCommand(String cmd, String[] args) throws UnknownCommandException, NoPermissionsException, CommandExecutionException {
        if (!UserManager.getInsance().getUser().canRunCommand(cmd)) {
            throw new NoPermissionsException(cmd);
        }

        executor.runCommand(cmd, args);
    }
}
