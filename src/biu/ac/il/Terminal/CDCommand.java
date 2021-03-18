package biu.ac.il.Terminal;

public class CDCommand extends BasicCommand {
    public CDCommand(String[] args) {
        super(args);
    }

    @Override
    public String getCommand() {
        return "cd";
    }

}
