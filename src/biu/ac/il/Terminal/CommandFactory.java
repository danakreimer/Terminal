package biu.ac.il.Terminal;

public class CommandFactory extends Factory<Command> {
    @Override
    protected Command create(String command, String[] args) throws UnknownCommandException {
        switch (command) {
            case "ls":
                return new LsCommand(args);
            case "cd":
                return new CDCommand(args);
            case "jobs":
                return new JobsCommand(args);
            case "history":
                return new HistoryCommand(args);
            default:
                throw new UnknownCommandException(command);
        }
    }
}
