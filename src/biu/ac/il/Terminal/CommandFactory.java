package biu.ac.il.Terminal;

public class CommandFactory extends Factory<Command> {
    @Override
    protected Command create(String command, String[] args) throws UnknownCommandException {
        switch (command) {
            case "help":
                return new HelpCommand(args);
            case "ls":
                return new LsCommand(args);
            case "history":
                return new HistoryCommand(args);
            case "cd":
                return new CDCommand(args);
            case "login":
                return new LogInCommand(args);
            case "osinfo":
                return new OSInfoCommand(args);
            case "print":
                return new PrintCommand(args);
            case "calc":
                return new CalcCommand(args);
            case "movie":
                return new IMDBCommand(args);
            default:
                throw new UnknownCommandException(command);
        }
    }
}
