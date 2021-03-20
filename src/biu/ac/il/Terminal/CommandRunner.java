package biu.ac.il.Terminal;

public class CommandRunner implements CommandExecutor {
    @Override
    public void runCommand(String cmd, String[] args) throws UnknownCommandException, CommandExecutionException {
        Factory<Command> factory = new CommandFactoryExternalDecorator(new CommandFactory());
        Command command = factory.create(cmd, args);
        String result = command.execute();

        if (result == null) {
            throw new CommandExecutionException(cmd);
        }

        System.out.println(result);
    }
}
