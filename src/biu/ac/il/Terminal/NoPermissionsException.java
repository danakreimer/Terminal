package biu.ac.il.Terminal;

public class NoPermissionsException extends Throwable {
    private String command;

    public NoPermissionsException(String command) {
        super();
        this.command = command;
    }

    @Override
    public String getMessage() {
        return "Error: This user cannot run the command " + command;
    }
}
