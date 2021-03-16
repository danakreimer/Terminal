package biu.ac.il.Terminal;

public class UnknownCommandException extends Throwable {
    private String command;

    public UnknownCommandException(String command) {
        super();
        this.command = command;
    }

    @Override
    public String getMessage() {
        return this.command + " is an unknown command";
    }
}
