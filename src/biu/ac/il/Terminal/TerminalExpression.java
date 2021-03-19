package biu.ac.il.Terminal;

public class TerminalExpression implements Expression {
    private String expression;

    public TerminalExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret() {
        String command;
        String[] args;

        // Separate the command from the arguments
        String arr[] = expression.split(" ", 2);

        command = arr[0];   //the
        String theRest = arr.length > 1 ? arr[1] : "";

        // Place the arguments in a string array
        args = theRest.split(" ");

        CommandExecutor commandExecutor = new CommandRunnerProxy();
        try {
            commandExecutor.runCommand(command, args);
        } catch (UnknownCommandException | NoPermissionsException | CommandExecutionException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
