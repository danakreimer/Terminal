package biu.ac.il.Terminal;

public class LsCommand extends BasicCommand {
    public LsCommand(String[] args) {
        super(args);
    }

    @Override
    public String getCommand() {
        return "dir";
    }
}
