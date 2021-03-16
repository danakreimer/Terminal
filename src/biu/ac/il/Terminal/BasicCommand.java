package biu.ac.il.Terminal;

abstract class BasicCommand extends Command {
    String[] args;

    public BasicCommand(String[] args) {
        super();
        this.args = args;
    }
}
