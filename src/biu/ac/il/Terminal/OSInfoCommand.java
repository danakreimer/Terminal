package biu.ac.il.Terminal;

public class OSInfoCommand extends BasicCommand {
    public OSInfoCommand(String[] args) {
        super(args);
    }

    @Override
    public String getCommand() {
        return "systeminfo";
    }
}
