package biu.ac.il.Terminal;

public class CommandExecutionException extends Throwable {
    private String command;

    public CommandExecutionException(String command) {
        super();
        this.command = command;
    }

    @Override
    public String getMessage() {
        return "Error: running command " + this.command + " failed.";
    }
}
