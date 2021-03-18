package biu.ac.il.Terminal;

abstract class Command {
    public abstract String execute();

    public boolean canExecute() {
        return true;
    }
}
