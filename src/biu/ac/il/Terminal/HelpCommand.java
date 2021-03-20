package biu.ac.il.Terminal;

public class HelpCommand extends AdvancedCommand {

    public HelpCommand(String[] args) {
        super(args);
    }

    @Override
    public String execute() {
        String[] availableCommands = UserManager.getInsance().getUser().getAvailableCommands();

        return "Available Commands: \n" + String.join("\n", availableCommands);
    }
}
