package biu.ac.il.Terminal;

public class CommandFactory extends Factory<Command> {
    @Override
    protected Command create(String command, String[] args) throws UnknownCommandException {
        switch (command) {
            case "ls":
                return new LsCommand(args);
            default:
                throw new UnknownCommandException(command);
        }
    }
}
