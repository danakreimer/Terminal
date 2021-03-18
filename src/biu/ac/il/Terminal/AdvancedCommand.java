package biu.ac.il.Terminal;

abstract class AdvancedCommand extends Command {
    String[] args;

    public AdvancedCommand(String[] args) {
        super();
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }
}
