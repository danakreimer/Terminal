package biu.ac.il.Terminal;

public class CommandRunner implements CommandExecutor {
    @Override
    public void runCommand(String cmd, String[] args) throws UnknownCommandException, CommandExecutionException {
        // Create the command factory and wrap it in an external command decorator because it might be an external command
        Factory<Command> factory = new CommandFactoryExternalDecorator(new CommandFactory());
        Command command = factory.create(cmd, args);
        String result = command.execute();

        if (result == null) {
            throw new CommandExecutionException(cmd);
        }

        System.out.println(result);
    }
}
