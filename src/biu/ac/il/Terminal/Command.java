package biu.ac.il.Terminal;

public abstract class Command {
    public abstract String execute();

    public boolean canExecute() {
        return true;
    }
}
