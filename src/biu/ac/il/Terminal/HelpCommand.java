package biu.ac.il.Terminal;

public class HelpCommand extends AdvancedCommand {

    public HelpCommand(String[] args) {
        super(args);
    }

    @Override
    // Print all the user's allowed commands
    public String execute() {
        String[] availableCommands = UserManager.getInstance().getUser().getAvailableCommands();

        return "Available Commands: \n" + String.join("\n", availableCommands);
    }
}
