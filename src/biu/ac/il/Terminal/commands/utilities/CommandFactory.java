package biu.ac.il.Terminal.commands.utilities;


import biu.ac.il.Terminal.abcstracs.Command;
import biu.ac.il.Terminal.abcstracs.Factory;
import biu.ac.il.Terminal.commands.LsCommand;
import biu.ac.il.Terminal.exceptions.UnknownCommandException;

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
