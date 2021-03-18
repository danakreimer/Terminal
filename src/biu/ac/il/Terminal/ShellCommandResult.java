package biu.ac.il.Terminal;

public class ShellCommandResult {

    private boolean success;
    private String output;

    public ShellCommandResult(boolean success, String output) {
        this.success = success;
        this.output = output;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public String getOutput() {
        return this.output;
    }
}
